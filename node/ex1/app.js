const express = require('express');
const dbConnect = require('./config/dbconnect');
const methodOverride = require('method-override');

const app = express();
const port = 3000;

app.set('view engine','ejs');
app.set('views','./views');

app.use(methodOverride("_method"));
app.use(express.static('./public'));
app.use(express.urlencoded({extended:true}));
app.use(express.json());
app.use('/',require('./routes/contactRoutes'));

dbConnect();

app.listen(3000,()=>{
    console.log(`${port}번 포트에서 서버 실행중`);
});