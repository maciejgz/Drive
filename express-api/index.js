const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {
    res.json([{
        name: 'Bob',
        email: 'bob@gmail.com'
    },
        {
            name: 'Alica',
            email: 'alice@yahoo.com'
        },
        {
            name: 'Jack',
            email: 'jack@gmail.com'
        },
        {
            name: 'Mark',
            email: 'mark@gmail.com'
        }

    ])
})

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
})