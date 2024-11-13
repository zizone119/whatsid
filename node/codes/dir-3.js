const fs=require('fs');

if(fs.existsSync('../files')){
    fs.rm("../files",{recursive:true},(err)=>{
        if(err){
            console.error(err);
        }else{
            console.log('deleted');
        }
    });
}else{
    console.log('folder does not exist');
}