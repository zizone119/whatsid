const express = require('express');
const app = express();
const mysql = require('mysql');

const cors = require("cors");

let corsOption={
    origin:'*',
    credential:true
}

app.use(cors(corsOption));
const db= mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: '1234',
    database: 'chat'
});

app.get('/',(req,res)=>{
    const sqlQuery = "insert into chat(chat_user,chat_content) values('andy','hhh');";
    db.query(sqlQuery,(req,result)=>{
        res.send("success");
    })
})

app.listen(8000,()=>{
    console.log('connected');
})