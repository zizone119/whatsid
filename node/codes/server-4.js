const http = require('http');
const fs = require('fs');
const server = http.createServer((req,res)=>{
    const {method, url} = req;
    res.setHeader('Content-Type','text/html');
    if(method === 'GET' && url === '/home'){
        res.statusCode = 200;
        res.end('<hr>HOME<hr>');
    }else if(method === 'GET' && url === '/about'){
        res.statusCode = 200;
        for(let i=0;i<100;i++){
            for(let j=0;j<100;j++)
            {
                console.log(`${i},${j}`);
            }
        }
        res.write('<h1>ABOUT</h>');
        res.end();
    }else if(method === 'GET' && url === '/index.html'){
        res.statusCode = 200;
        const readStream = fs.createReadStream(__dirname+'/index.html','utf-8');
        readStream.pipe(res);
    }
    else{
        res.statusCode = 404;
        res.write('Not Found');
        res.end();
    }
});

server.listen(3000,()=>{
    console.log('connected');
})