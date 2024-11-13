const http = require('http');

const server = http.createServer((req,res)=>{
    console.log('It really works');
})

server.listen(3000,()=>{
    console.log('connected');
})