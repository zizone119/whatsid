import React from "react";
const CreateUser=({username,email,onChange,onCreate,focusRef})=>{
    return(
        <div>
            <input
                name="username"
                placeholder="계정명"
                onChange={onChange}
                value={username}
                ref={focusRef}
            />
            <input
                name="email"
                placeholder="이메일"
                onChange={onChange}
                value={email}
            />
            <button onClick={onCreate}>등록</button>
        </div>
    )
}

export default React.memo(CreateUser);