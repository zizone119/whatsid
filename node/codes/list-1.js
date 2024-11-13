const fs = require('fs');

// 동기식
let file = fs.readdirSync('./');
console.log(file);

// 비동기식
fs.readdir('./', (err,files) => {
    if(err){
        console.log('error');
        return;
    }
    console.log(files);
});