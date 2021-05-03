const WebSocket = require('ws')

const wss = new WebSocket.Server({ port: 8081 })
console.log('server works');
wss.on('connection', ws => {
    ws.on('message', message => {
        console.log(`Received message => ${message}`)
    })
    ws.send('Hello! Message From Server!!')
})