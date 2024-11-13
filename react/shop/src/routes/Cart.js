import { Table } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { changeCount, dischangeCount, deleteItem } from "../store";

function Cart() {
  const user = useSelector((state) => state.user);
  const cart = useSelector((state) => state.cart);
  const dispatch = useDispatch();

  return (
    <div>
      <h5>{user.name}님의 장바구니</h5>
      <Table responsive="md">
        <thead>
          <tr>
            <th>#</th>
            <th>상품명</th>
            <th>수량</th>
            <th>변경하기</th>
            <th>삭제하기</th>
          </tr>
        </thead>
        <tbody>
          {cart &&
            cart?.map((item, index) => {
              return (
                <tr key={index}>
                  <td>{item.id}</td>
                  <td>{item.name}</td>
                  <td>{item.count}</td>
                  <td>
                    <button
                      onClick={() => {
                        dispatch(changeCount(item.id));
                      }}
                    >
                      +
                    </button>
                    &nbsp;&nbsp;
                    <button
                      onClick={() => {
                        dispatch(dischangeCount(item.id));
                      }}
                    >
                      -
                    </button>
                  </td>
                  <td>
                    <button
                      onClick={() => {
                        dispatch(deleteItem(item.id));
                      }}
                    >
                      x
                    </button>
                  </td>
                </tr>
              );
            })}
        </tbody>
      </Table>
    </div>
  );
}

export default Cart;
