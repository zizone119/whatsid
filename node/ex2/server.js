const express = require("express");
const app = express();
const mongoClient = require("mongodb").MongoClient;
const url = "mongodb+srv://admin:1234@cluster0.5t1vu.mongodb.net";
let mydb;
const bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended:true}));
app.use(express.json());
app.set('view engine','ejs');


mongoClient
  .connect(url)
  .then((client) => {
    mydb = client.db("myContacts");
    app.listen(3000, () => {
      console.log("Server is running");
    });
  })
  .catch((err) => {
    console.log(err);
  });

app.get('/enter',(req,res)=>{
  res.render('enter')
})

app.get("/", (req, res) => {
  res.render('index')
});

app.post('/save',(req,res)=>{
  mydb.collection('contacts').insertOne({
    name:req.body.name,
    email:req.body.email,
    phone:req.body.phone
  }).then(result=>{
    console.log('ok');
  })
  res.redirect('/');
});

app.get('/list',(req,res)=>{
  mydb.collection('contacts').find().toArray().then(result=>{
    res.render('list',{data:result});
  })
});

app.post('/delete',(req,res)=>{
  res.redirect('/');
})