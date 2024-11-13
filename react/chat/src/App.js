import React, { useState } from "react";
import Enter from "./Enter";
import ChatMain from "./ChatMain";

const App = () => {
  const viewSelection = useState(true);
  if(viewSelection===false){
    return (
      <div>
        <ChatMain/>
      </div>
    );
  }
  else{
    return (
      <div>
        <Enter viewSelection={viewSelection}/>
      </div>
    );
    
  }
};

export default App;
