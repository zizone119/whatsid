import React,{useState} from "react";
let tmp=0;
const Say = ()=>{
    const [maxNum,setMaxNumber]=useState(tmp);
    const [num,setNumber]=useState(0);
    const [message, setMessage] = useState('입장시작합니다.');
    const [color, setColor] = useState('black');
    const onClickEnter =async ()=>{
        setMessage('안녕하세요.');
        setNumber(num+1);
        if(maxNum<num+1){
            setMaxNumber(num+1);
        }
        if(maxNum<num+1){
            tmp=num+1;
        }
    }
    const onClickLeave = ()=>{
        setMessage('안녕히 가세요.');
        if(num>0)setNumber(num-1);
    }

    return(
        <div>
            <button onClick={onClickEnter}>입장</button>
            <button onClick={onClickLeave}>퇴장</button>
            <button onClick={()=>{tmp=0;setMaxNumber(0);setNumber(0)}}>초기화</button>
            <h3> 최대 입장 인원 : {maxNum}</h3>
            <h3 style={{color}}>{message}</h3>
            <h3>입장인원 : {num} </h3>
            <button style={{color:'red'}} onClick={()=>setColor('red')}>빨간색</button>
            <button style={{color:'green'}} onClick={()=>setColor('green')}>녹색</button>
            <button style={{color:'blue'}} onClick={()=>setColor('blue')}>파란색</button>
        </div>
    );
}
/*
const Say = ()=>{
    const [msg, setMsg]= React.useState(0);
}
*/
export default Say;