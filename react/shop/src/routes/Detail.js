import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Nav } from "react-bootstrap";
import { useDispatch, useSelector } from "react-redux";
import { addItem, changeCount } from "../store";
function Tab({ tab }) {
  const [fade, setFade] = useState("");

  useEffect(() => {
    const to = setTimeout(() => {
      setFade("end");
    }, 100);
    return () => {
      clearTimeout(to);
      setFade("");
    };
  }, [tab]);

  return (
    <div className={`start ${fade}`}>
      {[<div>내용0</div>, <div>내용1</div>, <div>내용2</div>][tab]}
    </div>
  );
}

const Detail = ({ shoes }) => {
  const state = useSelector((state) => state);
  const dispatch = useDispatch();
  const { id } = useParams();

  const shoe = shoes.filter((shoe) => shoe.id === Number(id));
  const [event, setEvent] = useState(true);
  const [tab, setTab] = useState(0);

  useEffect(() => {
    const to = setTimeout(() => {
      setEvent(false);
    }, 20000);
    return () => {
      clearTimeout(to);
    };
  }, []);

  if (shoe.length === 0) {
    return (
      <div>
        <h3>해당 상품은 존재하지 않습니다.</h3>
      </div>
    );
  } else {
    return (
      <>
        {event === true ? (
          <div className="alert alert-warning">20초 이내 구매시 할인</div>
        ) : null}
        <div className="container">
          <div className="row">
            <div className="col-md-6">
              <img
                src={`https://codingapple1.github.io/shop/shoes${
                  Number(id) + 1
                }.jpg`}
                width="100%"
                alt=""
              />
            </div>
            <div className="col-md-6">
              <h4 className="pt-5">{shoe[0].title}</h4>
              <p>{shoe[0].content}</p>
              <p>{shoe[0].price}</p>
              <button className="btn btn-danger">주문하기</button>
              &nbsp;&nbsp;
              <button
                className="btn btn-danger"
                onClick={() => {
                  const index = state.cart.findIndex(
                    (pd) => pd.id === shoe[0].id
                  );
                  if (index < 0) {
                    dispatch(addItem(shoe[0]));
                  } else {
                    dispatch(changeCount(shoe[0].id));
                  }
                }}
              >
                장바구니
              </button>
            </div>
            <Nav variant="tabs" defaultActiveKey="link1">
              <Nav.Item>
                <Nav.Link
                  eventKey="link1"
                  onClick={() => {
                    setTab(0);
                  }}
                >
                  1
                </Nav.Link>
              </Nav.Item>
              <Nav.Item>
                <Nav.Link
                  eventKey="link2"
                  onClick={() => {
                    setTab(1);
                  }}
                >
                  2
                </Nav.Link>
              </Nav.Item>
              <Nav.Item>
                <Nav.Link
                  eventKey="link3"
                  onClick={() => {
                    setTab(2);
                  }}
                >
                  3
                </Nav.Link>
              </Nav.Item>
            </Nav>
          </div>
          <Tab tab={tab} />
        </div>
      </>
    );
  }
};

export default Detail;
