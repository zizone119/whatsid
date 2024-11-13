import { useRef, useState } from "react";

const InputSample = () => {
  const [inputs, setInputs] = useState({
    name: "",
    nickname: "",
  });

  const {name,nickname}=inputs;

  const nameInput = useRef();

  const onChange = (e) => {
    
    setInputs({
      ...inputs,
        [e.target.name]:e.target.value
    });
  };
  const onReset = () => {
    setInputs({
        name:'',
        nickname:''
    })
    nameInput.current.focus();
  };
  return (
    <div>
      <input name='name' placeholder="이름" onChange={onChange} value={name} ref={nameInput}/>
      <input name='nickname' placeholder="닉네임" onChange={onChange} value={nickname}/>
      <button onClick={onReset}>초기화</button>
      <div>
        <b>값 : </b>
        {name} ({nickname})
      </div>
    </div>
  );
};

export default InputSample;
