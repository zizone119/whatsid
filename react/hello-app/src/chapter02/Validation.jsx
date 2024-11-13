import React, {Component} from 'react';
import './Validation.css';
class Validation extends Component{
    state={
        password:'',
        clicked:false,
        validated:false
    };
    handleChange=e=>{
        this.setState({
            password:e.target.value
        });
    };
    handleButtonClick=e=>{
        this.setState({
            clicked:true,
            validated:this.state.password==='0000'
        });
        this.input.focus();
    }
    handleKeyPress=e=>{
        if(e.key==='Enter'){
            this.handleButtonClick();
        }
    }
    render(){
        return(
            <div>
                <input
                ref={(ref)=>this.input=ref}
                type='password'
                value={this.state.password}
                onChange={this.handleChange}
                className={this.state.clicked?(this.state.validated?'success':'failure'):''}
                onKeyPress={this.handleKeyPress}
                autoFocus
                >
                </input>
                <button onClick={this.handleButtonClick}>
                    검증하기
                </button>
            </div>
        )
    }
}
export default Validation;