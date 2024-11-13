import React, { useCallback, useMemo, useReducer, useRef } from "react";
import "./App.css";
import UserList from "./UserList";
import CreateUser from "./CreateUser";
import { produce } from "immer";

const countActiveUsers = (users) => {
  return users.filter((user) => user.active).length;
};

const initialState = {
  inputs: {
    username: "",
    email: "",
  },
  users: [],
};

const reducer = (state, action) => {
  switch (action.type) {
    case "CHANGE":
      return {
        ...state,
        inputs: {
          ...state.inputs,
          [action.name]: action.value,
        },
      };
    case "CREATE":
      return produce(state, (draft) => {
        draft.users.push(action.user);
      });
    case "TOGGLE":
      return produce(state, (draft) => {
        const user = draft.users.find((user) => user.id === action.id);
        user.active = !user.active;
      });
    case "REMOVE":
      return produce(state, draft => {
        const index = draft.users.findIndex(user => user.id === action.id);
        draft.users.splice(index, 1);
      });
    default:
      return state;
  }
};

export const UserDispatch = React.createContext(null);

const App = () => {
  const [state, dispatch] = useReducer(reducer, initialState);
  const { users } = state;
  const { username, email } = state.inputs;
  const nextId = useRef(0);
  const cnt = useMemo(() => countActiveUsers(users), [users]);
  const focusRef=useRef();

  const onChange = useCallback((e) => {
    const { name, value } = e.target;
    dispatch({
      type: "CHANGE",
      name,
      value,
    });
  }, []);

  const onCreate = useCallback(
    (e) => {
      const active = false;
      dispatch({
        type: "CREATE",
        user: {
          id: nextId.current,
          username,
          email,
          active,
        },
      });
      nextId.current += 1;
      focusRef.current.focus();
      focusRef.current.value='';
    },
    [username, email]
  );

  return (
    <UserDispatch.Provider value={dispatch}>
      <CreateUser
        username={username}
        email={email}
        onChange={onChange}
        onCreate={onCreate}
        focusRef={focusRef}
      />
      <UserList users={users} />
      <div>활성 사용자 수 : {cnt}</div>
    </UserDispatch.Provider>
  );
};

export default App;
