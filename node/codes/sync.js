function displayA(){
    console.log('A');
}
function displayB(callback){
    setTimeout(()=>{
        console.log('B');
        callback();
    },3000);
}
function displayC(){
    console.log('C');
}

displayA();
displayB(displayC);