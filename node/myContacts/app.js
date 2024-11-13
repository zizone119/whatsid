
const express = require('express');
const path = require('path');
const errorhandler = require('./routes/contractRoutes');
const app = express();
const port = 3000;
/*const logger = (req,res,next)=>{
    console.log('User logged');
    next();
}
app.use(logger);*/
app.use(express.json());
app.use(express.urlencoded({extended:true}));
app.use('/',require('./routes/contractRoutes'));

const requestTime = (req,res,next)=>{
    let today =  new Date();
    let now = today.toLocaleTimeString();
    req.requestTime = now;
    next();
}
app.use(requestTime);

app.route('/').get((req,res)=>{
    const responseText = `Hello node \n Time : ${req.requestTime}`;
    res.setHeader('Content-Type','text/plain');
    res.send(responseText);
})

app.get('/test',(req,res,next)=>{
    const error = new Error('test error');
    error.status = 401;
    next(Error('test error').status(401));
})

app.listen(port,()=>{
    console.log(`Port ${port} is running`);
})


