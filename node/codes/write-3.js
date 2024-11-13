const fs = require('fs');

fs.appendFile('../files/text-2.txt','\n\nnew contents',(err)=>{
    if(err) console.log(err);
    else console.log('success');
})