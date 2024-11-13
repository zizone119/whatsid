import { createStore } from "redux";

const SET = "counter/SET_DIFF";
const INC = "counter/INCREASE";
const DEC = "counter/DECREASE";

export const setDiff = (diff) => ({ type: SET, diff });
export const increase = () => ({ type: INC });
export const decrease = () => ({ type: DEC });

const initialState = {
  number: 0,
  diff: 1,
};

const counter = (state = initialState, action) => {
  switch (action.type) {
    case SET:
      return {
        ...state,
        diff: action.diff,
      };
    case INC:
      return {
        ...state,
        number: state.number + state.diff,
      };
    case DEC:
      return {
        ...state,
        number: state.number - state.diff,
      };

    default:
      return state;
  }
};

export default counter;
