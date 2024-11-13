const fs = require('fs');

if(fs.existsSync('./test2/test3/test4')){
    console.log('already exists');
}else{
    fs.mkdir('./test2/test3/test4',{recursive:true},(err)=>{
        if(err){
            console.log(err);
        }else{
            console.log('created');
        }
    })
}
