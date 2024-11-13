import React from "react";

class S_Props extends React.Component{
    render(){
        let props_val = this.props.props_val;
        props_val += ' from App.js';
        return <div>{props_val} </div>;
    }
}

export default S_Props;