const http = require('http');

const server = http.createServer((req,res)=>{
    console.log('request occurred');
});

server.listen(3000,'127.0.0.1',()=>{
    console.log('connected');
})