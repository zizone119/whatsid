const INC = "INCREASE";
const DEC = "DECREASE";
export const increase = () => ({ type: INC });
export const decrease = () => ({ type: DEC });

const initialState = 0;

const counter = (state = initialState, action) => {
  switch (action.type) {
    case INC:
      return state + 1;
    case DEC:
      return state - 1;
    default:
      return state;
  }
};

export default counter;
