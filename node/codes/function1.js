const readline = require("readline");
let cnt = 0;

const r1 = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function checkAge(age) {
  cnt++;
  if (cnt === 3) r1.close(); // Close the interface after the third input
  return age > 19; // Check if the age is greater than 19
}

function f() {
  return new Promise((resolve) => {
    r1.question("Input age: ", (age) => {
      if (checkAge(age)) {
        console.log("pass");
      } else {
        console.log("not pass");
      }
      if(cnt<3) resolve(); // Resolve the promise to continue
    });
  });
}

// Function to handle asking for ages in sequence
function main() {
    f().then(main); // Chain the next age input
}

// Start the asking process
main();