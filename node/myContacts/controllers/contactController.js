const asyncHandler = require("express-async-handler");
const Contact = require('../models/contactModel');
//const path = require('path');
// 수정 전
/*
const getAllContacts = async (req, res) => {

    try{
        res.status(200).send("Contacts Page");
    }catch(error){
        res.send(error.message);
    }
}
*/
//수정후 (GET)
const getAllContacts = asyncHandler(async (req, res) => {
    const contacts = await Contact.find();
    res.render('index',{contacts:contacts});
    /*const users = [
        {name: "john", email: "john@aaa.bbb", phone: "123456"},
        {name: "park", email: "park@aaa.bbb", phone: "654321"},
    ]
    res.render("getAll",{heading:"User List", users:users});*/
    //const findPath = path.join(__dirname,'../assets','getAll.html');
    //res.sendFile(findPath);
    //res.status(200).send("<h1 style='color:green'> Contacts Page</h1>");
    //res.status(200).send(contacts);
})

const createContact = asyncHandler(async (req, res) => {
    console.log(req.body);
    const{name, email, phone} = req.body;
    if(!name || !email || !phone) {
      return res.render('redirect');
    }
    const contact = await Contact.create({
        name,
        email,
        phone,
    });
    res.redirect('/');
})

const addContactForm = (req,res)=>{
    res.render('add');
}

const getContact = asyncHandler(async (req, res) => {
    const contact = await Contact.findById(req.params.id);
    res.render("update", { contact: contact });
  });
  


const updateContact = asyncHandler(async (req, res) => {
    const id = req.params.id;
    const { name, email, phone } = req.body;
    const updatedContact = await Contact.findByIdAndUpdate(
      id,
      { name, email, phone },
      { new: true }
    );
    res.redirect("/");
});

const deleteContact = asyncHandler(async(req,res)=>{
    await Contact.findByIdAndDelete(req.params.id);
    res.redirect('/');
})

module.exports = {
    getAllContacts, 
    createContact, 
    getContact, 
    updateContact, 
    deleteContact,
    addContactForm
};
