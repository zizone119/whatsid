var readline = require("readline");
var r1 = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});
r1.question("Inout score :", function (score) {
  if (score >= 60 && score <= 100) {
    console.log("pass");
  } else {
    console.log("fail");
  }
  console.log(i);
  r1.close();
});
