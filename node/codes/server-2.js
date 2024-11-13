const http = require('http');

const server = http.createServer((req,res)=>{
    console.log('request occurred');
    res.setHeader('Content-Type','text/plain');
    res.write('Hello Node');
    res.end();
})

server.listen(3000,()=>{
    console.log('connected');
})