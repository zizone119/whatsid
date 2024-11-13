/*const express = require('express');
const router = express.Router();
router
    .route('/')
    .get((req,res)=>{
        res.sendStatus(200).send('Contracts pase');
    })
    .post((req,res)=>{
        console.log(req.body);
        const {name,email,phone}=req.body;
        if(!name||!email||!phone){
            return res.status(400).send('params missing');
        }
        return res.status(200).send('Create contracts');
    });
    module.exports=router;

router
    .route('/contacts')
    .get((req,res)=>{
        res.status(200).send('Contacts page');
    })
    .post((req,res)=>{
        res.status(201).send('Create Contacts page');
    });

router
    .route('/contacts/:id')
    .get((req,res)=>{
        res.status(200).send(`View contact id: ${req.params.id}`);
    })
    .put((req,res)=>{
        res.status(200).send(`Update contact id: ${req.params.id}`);
    })
    .delete((req,res)=>{
        res.status(200).send(`Delete contact id: ${req.params.id}`);
    });
*/
const express = require("express")
const router = express.Router();

router  
  .route("/")
  .get((req, res) => {
    res.status(200).send("Contacts pase");
  })
  .post((req, res) => {
    console.log(req.body);
    const{name, email, phone} = req.body;
    if(!name || !email || !phone) {
      return res.status(400).send("필수값이 입력되지 않았습니다.");
    }
    res.status(201).send("Create Contacts");
  })

  module.exports = router;

  