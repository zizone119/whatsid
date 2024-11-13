/*const MyComponent = props=>{
    const {name,children}= props;
    return <div>제 이름은 {name}입니다.<br/>
    children 값은 {children}입니다.</div>
}


MyComponent.defaultProps={
    name:'기본이름'
}*/

import { Component } from "react";

class MyComponent extends Component{
    render(){
        const {name, children} = this.props;
        return <div>제 이름은 {name}입니다.<br/>
        children 값은 {children}입니다.</div>
    }
}
MyComponent.defaultProps={
    name:'기본이름'
}
export default MyComponent;