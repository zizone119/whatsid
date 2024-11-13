import React, { useCallback, useRef, useState } from "react";
import TodoTemplate from './TodoTemplate';
import TodoList from './TodoList';
import TodoInsert from './TodoInsert';

const App = () => {
  const [todos, setTodos] = useState([]);
  const nextId = useRef(0);
  const focusRef = useRef();
  const onInsert = useCallback(
    (text) => {
      if (text === '') return;
      const todo = {
        id: nextId.current,
        text,
        checked: false,
      };
      setTodos(todos.concat(todo));
      nextId.current += 1;
    },
    [todos],
  );

  const onRemove = useCallback(
    (id) => {
      setTodos(todos.filter((todo) => todo.id !== id));
    },
    [todos],
  );

  const onToggle = useCallback(
    (id) => {
      setTodos(
        todos.map((todo) =>
          todo.id === id ? { ...todo, checked: !todo.checked  } : todo,
        ),
      );
    },
    [todos],
  );

  return (
    <TodoTemplate>
      <TodoInsert onInsert={onInsert} focusRef={focusRef}/>
      <TodoList todos={todos} onRemove={onRemove} onToggle={onToggle} focusRef={focusRef}/>
    </TodoTemplate>
  );
};

export default App;
