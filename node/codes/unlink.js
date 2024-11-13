const fs = require("fs");

if (!fs.existsSync("../files/example.txt")) {
  console.log("fail");
} else {
  fs.unlink("../files/example.txt",()=>{
  console.log("succeed");
  });
}
