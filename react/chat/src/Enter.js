import React, { useState } from "react";
import './Enter.css';

const enter=(viewSelection)=>{
    viewSelection=false;
}

const Enter=({viewSelection})=>{
    console.log(viewSelection)
    const userId = useState();
    return(
        <div>
            <p>사용자 이름을 입력하세요</p>
            <input type="text" style={{height:50,fontSize:15}}></input>
            <button type='submit' style={{height:50,marginLeft:30,fontSize:20}} onClick={enter(viewSelection)}>입장</button>
        </div>
    )
}

export default Enter;