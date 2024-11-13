import {Component} from "react";
import ScrollBox from "./chapter02/ScrollBox";
import Iteration from "./chapter02/Iteration";

const App =()=>{
  return(
    <div>
      <Iteration></Iteration>
    </div>
  )
}


/*
class App extends Component{
  render(){
    return(
      <div>
        <ScrollBox ref={ref=>this.ScrollBox=ref}></ScrollBox>
        <button onClick={()=>this.ScrollBox.scrollToButtom()}>
          맨 밑으로
        </button><button onClick={()=>this.ScrollBox.scrollToTop()}>
          맨 위로
        </button>
      </div>
    )
  }
}*/
export default App;