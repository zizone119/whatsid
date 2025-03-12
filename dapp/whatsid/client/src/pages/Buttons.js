import { useNavigate } from "react-router-dom";
import "../css/buttons.css"; // CSS 파일 가져오기

export function ChatBTN({ nickName }) {
  return (
    <div className="flo-btn-chat">
      <form action="http://192.168.0.90:8000" method="POST">
        <input type="hidden" name="user" value={nickName} />
        <button className="flo flo-chat" type="submit"></button>
      </form>
    </div>
  );
}

export function HelpBTN() {
  const navigate = useNavigate();

  const handleClick = () => {
    navigate("/help");
  };

  return (
    <div className="flo-btn-help">
      <button className="flo flo-help" onClick={handleClick}></button>
    </div>
  );
}
