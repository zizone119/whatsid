const path = require("path");

const fullPath = path.join('some','work', 'ex.txt');

// 절대경로
console.log(`${__filename}`);

// 경로 추출하기
const dir = path.dirname(__filename);
console.log(`${dir}`);
console.log(`${__dirname}`);


// 파일 이름 추출하기
const fn = path.basename(__filename);
console.log(`${fn}`);

const fn2 = path.basename(__filename,'.js');
console.log(`${fn2}`);

// 확장자 추출하기
const ext = path.extname(__filename);
console.log(`${ext}`);

console.log(path.basename(__filename, ext));

// 경로 분해하기
const parsedPath = path.parse(__filename);
console.log(parsedPath.ext);