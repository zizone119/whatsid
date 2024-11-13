const http = require('http');

const server = http.createServer((req,res)=>{
    const{method,url} = req;
    res.setHeader=('Conten-Type','text/plain');
    
    if(method==='GET' && url === '/home'){
        res.statusCode=200;
        res.end('Home');
    }else if(method==='GET' && url === '/about'){
        res.statusCode=200;
        res.end('ABOUT');
    }else{
        res.statusCode=404;
        res.end('Not Found');
    }
})

server.listen(3000,()=>{
    console.log('Connected');
})