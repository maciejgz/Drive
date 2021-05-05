const WebSocket = require('ws')
const url = 'ws://192.168.99.102:8081'
const connection = new WebSocket(url)

connection.onopen = () => {
    connection.send('Ping From Client')
    connection.close();
}

connection.onerror = (error) => {
    console.log(`WebSocket error: ${error.message}`)
}

connection.onmessage = (e) => {
    console.log(e.data)
}