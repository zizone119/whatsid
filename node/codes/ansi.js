const c = require("ansi-colors");

function hello(name) {
  console.log("Welcome " + c.green(name));
}

hello("andy");
