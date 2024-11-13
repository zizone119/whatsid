const fs = require('fs');

let content=`\nadded text2`;

fs.writeFileSync('../files/text-2.txt',content,{flag:"w"});
