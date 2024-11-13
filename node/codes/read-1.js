const fs = require('fs');
const txt = fs.readFileSync('../files/example.txt','utf-8');
console.log(txt)

fs.readFile('../files/example.txt','utf-8',(err,data)=>{
    if(err) console.err(err);
    else console.log(data);
})