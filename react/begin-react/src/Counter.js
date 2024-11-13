import { useReducer } from "react";

const reducer=(state, action)=>{
    switch(action.type){
        case 'PLUS' : return state+1;
        case 'MINUS' : return state-1;
        default : return state;
    }
}   

const Counter=()=>{
    const [cnt, dispatch]=useReducer(reducer,0);    
    const plus=()=>{
        dispatch({type:'PLUS'});
    }
    const minus=()=>{
        dispatch({type:'MINUS'});
    }
    return(
        <div>
            <h1>{cnt}</h1>
            <button onClick={plus}>+</button>
            <button onClick={minus}>-</button>
        </div>
    )
}

export default Counter;