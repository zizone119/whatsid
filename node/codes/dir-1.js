const fs = require('fs');

if(fs.existsSync('./test')){
    console.log('already exists');
}else{
    fs.mkdir('./test',(err)=>{
        if(err){
            console.log(err);
        }else{
            console.log('created');
        }
    })
}
