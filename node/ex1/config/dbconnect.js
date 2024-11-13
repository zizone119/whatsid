/*const mongoose = require('mongoose');
require('dotenv').config();

const dbConnect = async ()=>{
    try{
        const connect = await mongoose.connect(process.env.db_connect);
        console.log("DB connected");
    }catch(err){
        console.log(err);
    }
}

module.exports = dbConnect;*/

const mongoose = require('mongoose');
module.exports = async ()=>{
    await mongoose.connect('mongodb+srv://admin:1234@cluster0.5t1vu.mongodb.net/myContacts');
}