const fs = require('fs');


fs.readFile('../files/example.txt','utf-8',(err,data)=>{
    if(err){
        console.log(err);
        return;
    }
    fs.writeFile('../files/example.txt',data,(err)=>{
        if(err){
            console.log('file already exists');
        }else console.log('success');
    })
})

