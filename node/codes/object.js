let user={
    id:'jamsuham',
    pw:'1234',
    name:'submarine',
    age:'23'
};
let {id,pw,...rest}=user;

for(const i in user){
    console.log(user[i]);
}