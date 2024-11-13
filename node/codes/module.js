const user=require('./user');
const hello=require('./hello');
const {user1,user2}=require('./user1');
const users=require('./user3');

hello(user1);
hello(user2);

console.log(users.user2);