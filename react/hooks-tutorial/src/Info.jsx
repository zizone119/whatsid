import { useReducer } from "react";

function reducer(state,action){
    return{
        ...state,
        [action.name]:action.value
    }
}

const Info=()=>{
    const [state,dispatch]=useReducer(reducer,{
        name:'',
        nickname:''
    });
    const {name,nickname} = state;
    const onChange=e=>{
        dispatch(e.target);
    }
    return(
        <div>
            <div>
                <input name='name' value={name} onChange={e=>{dispatch(e.target)}}></input>
                <input name='nickname' value={nickname} onChange={onChange}></input>
            </div>
            <div>
                <b>이름 :</b>{name}
            </div>
            <div>
                <b>닉네임 :</b>{nickname}
            </div>
        </div>
    )
}
export default Info;



/*import { useEffect,useState } from "react";
import React from "react";
const Info=()=>{
    const [name,setName]=useState('');
    const [nickname,setNickname]=useState('');

    useEffect(()=>{
        console.log('effect');
        console.log(name);
        return()=>{
            console.log('cleanup');
            console.log(name);
        }
    });
    const onChangeName=e=>{
        setName(e.target.value);
    }
    const onChangeNickname=e=>{
        setNickname(e.target.value);
    }
    return(
        <div>
            <div>
                <input value={name} onChange={onChangeName}></input>
                <input value={nickname} onChange={onChangeNickname}></input>
            </div>
            <div>
                <b>이름 :</b>{name}
            </div>
            <div>
                <b>닉네임 :</b>{nickname}
            </div>
        </div>
    )
}

export default Info;*/