import {useState} from 'react';

const EvnetPractice = ()=>{
    const [username,setUserName]=useState('');
    const [message,setMessage]=useState('');
    const onChangeUserName=e=>setUserName(e.target.value);
    const onChangeMessage=e=>setMessage(e.target.value);
    const onClick=()=>{
        alert(username+':'+message);
        setUserName('');
        setMessage('');
    }
    const onKeyPress=e=>{
        if(e.key==='Enter') onClick();
    }
    return(
        <div>
            <h1>이벤트 연습</h1>
            <input
            type='text'
            name='username'
            placeholder='유저명'
            value={username}
            onChange={onChangeUserName}
            >
            </input>
            <input
            type='text'
            name='message'
            placeholder='아무거나 입력해보세요'
            value={message}
            onChange={onChangeMessage}
            onKeyPress={onKeyPress}
            >
            </input>
            <button onClick={onClick}>confirm</button>
        </div>
    )
}

export default EvnetPractice;

/*import { Component } from "react";

class EvnetPractice extends Component{
    state={
        message:'',
        username:''
    }

    handleChange = (e)=>{
        this.setState({
            [e.target.name]:e.target.value
        })
    }

    handleClick = (e)=>{
        alert(this.state.username + ':' + this.state.message);
        this.setState({
            username:'',
            message:''
        })
        }
    
    handleKeyPress = (e)=>{
        if(e.key === 'Enter'){
            this.handleClick();
        }
    }


    render(){
        return(
            <div>
                <h1>이벤트 연습</h1>
                <input
                type='text'
                name='username'
                placeholder="유저명 입력"
                value={this.state.username}
                onChange={this.handleChange}
                ></input>

                <input
                type='text'
                name='message'
                placeholder="아무거나 입력해보세요"
                value={this.state.message}
                onChange={this.handleChange}
                onKeyPress={this.handleKeyPress}
                ></input>

                <button
                onClick={this.handleClick}
                >
                    확인
                </button>
            </div>
        )
    }
}

export default EvnetPractice;*/