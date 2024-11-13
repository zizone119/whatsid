const fs = require('fs');

const readStream = fs.createReadStream('../files/readme.txt');

readStream.on('data',(chunk)=>{
    console.log('\n\n\nnew chunck received:');
    console.log(chunk.length);
})
readStream.on('end',()=>{
    console.log('finished reading data');
})
readStream.on('error',(err)=>{
    console.log(`errer occurred at ${err}`);
})