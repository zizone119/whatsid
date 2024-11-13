const express = require("express");
const dbConnect = require("./config/dbConnect");
const methodOverride = require("method-override");

const app = express();
const port = 3000;

app.set("view engine","ejs");
app.set("views","./views");

app.use(methodOverride("_method"));
app.use(express.static("./public"));
app.use(express.urlencoded({extended:true}));
app.use("/", require("./routes/contactRoutes"));
app.use(express.json());


dbConnect();

app.listen(port, ()=>{
  console.log(`${port}번 포트에서 서버 실행중`);
})