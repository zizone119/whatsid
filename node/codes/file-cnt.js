const fs = require('fs');
const path = require('path');

fs.readdir('../files',(err,files)=>{
    if(err){
        console.error(err);
    }else{
        let cnt=0;
        files.forEach((file)=>{
            if(path.extname(file)==='.txt'){
                console.log(file);
                cnt++;
            } 
        })
        console.log(cnt+'');
    }
})