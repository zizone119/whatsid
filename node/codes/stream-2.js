const fs = require('fs');

const readStream = fs.createReadStream('../files/readme.txt');
const writeSream = fs.createWriteStream('../files/writeMe.txt');

readStream.on('data',(chunk)=>{
    console.log('new chunk received');
    writeSream.write(chunk);

})

