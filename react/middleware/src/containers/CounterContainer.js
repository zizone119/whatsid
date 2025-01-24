import { useDispatch, useSelector } from "react-redux";
import { increase, decrease } from "../modules/counter";
import Counter from "../components/Counter";
const CounterContainer = () => {
  const number = useSelector((state) => state);
  const dispatch = useDispatch();
  const onIncrease = () => {
    dispatch(increase());
  };
  const onDecrease = () => {
    dispatch(decrease());
  };

  return (
    <Counter number={number} onIncrease={onIncrease} onDecrease={onDecrease} />
  );
};

export default CounterContainer;
