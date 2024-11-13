const ADD = "todos/ADD";
const TOGGLE = "todos/TOGGLE";

let nextId = 1;
export const addTodo = (text) => ({
  type: ADD,
  todo: {
    id: nextId++,
    text,
  },
});

export const toggleTodo = (id) => ({
  type: TOGGLE,
  id,
});

const initialState = [
  {
    id: 0,
    text: "예시",
    done: false,
  },
];

const todos = (state = initialState, action) => {
  switch (action.type) {
    case ADD:
      return state.concat(action.todo);
    case TOGGLE:
      return state.map((todo) =>
        todo.id === action.id
          ? {
              ...todo,
              done: !todo.done,
            }
          : todo
      );
    default:
      return state;
  }
};

export default todos;
