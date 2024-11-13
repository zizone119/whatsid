import  Axios  from "axios";
import "./ChatMain.css";


const ChatMain = () => {
  return (
    <div>
      <div className="mainView"></div>
      <input id="input" autoFocus value=" 사용자 : "></input>
      <button type="submit" id="submit">
        전송
      </button>
    </div>
  );
};

export default ChatMain;
