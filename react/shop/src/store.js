import { configureStore, createSlice } from "@reduxjs/toolkit";

const user = createSlice({
  name: "user",
  initialState: { name: "kim", age: 21 },
});

const cart = createSlice({
  name: "cart",
  initialState: [],
  reducers: {
    changeCount(state, action) {
      const i = state.findIndex((product) => product.id === action.payload);
      state[i].count += 1;
    },
    addItem(state, action) {
      const pd = {
        id: action.payload.id,
        name: action.payload.title,
        count: 1,
      };
      state.push(pd);
    },
    deleteItem(state, action) {
      const i = state.findIndex((product) => product.id === action.payload);
      state.splice(i, 1);
    },
    dischangeCount(state, action) {
      const i = state.findIndex((product) => product.id === action.payload);
      if (state[i].count > 0) state[i].count -= 1;
    },
  },
});

export const { changeCount, addItem, deleteItem, dischangeCount } =
  cart.actions;

export default configureStore({
  reducer: {
    user: user.reducer,
    cart: cart.reducer,
  },
});
