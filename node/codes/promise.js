let likePizza = false;

const pizza = new Promise((resolve, reject) => {
  if (likePizza) resolve("Order");
  else reject("Cancel");
});

pizza
.then((result) => console.log(result))
.catch((err) => console.log(err));

