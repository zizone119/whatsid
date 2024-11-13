import { Container, Navbar, Nav, Button, NavDropdown } from "react-bootstrap";
import "./App.css";
import data from "./Shoes";
import { useRef, useState } from "react";
import { Routes, Route, useNavigate } from "react-router-dom";
import Detail from "./routes/Detail";
import Home from "./routes/Home";
import About from "./routes/About";
import Cart from "./routes/Cart";
import axios from "axios";

function App() {
  const [shoes, setShoes] = useState(data);
  const navigate = useNavigate();
  return (
    <div className="App">
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand
            onClick={() => {
              navigate("/");
            }}
          >
            My shop
          </Navbar.Brand>
          <Nav className="me-auto">
            <NavDropdown title="About" id="navbarScrollingDropdown">
              <NavDropdown.Item
                onClick={() => {
                  navigate("/about/member");
                }}
              >
                member
              </NavDropdown.Item>
              <NavDropdown.Item
                onClick={() => {
                  navigate("/about/location");
                }}
              >
                location
              </NavDropdown.Item>
            </NavDropdown>
            <Nav.Link
              onClick={() => {
                navigate("/cart");
              }}
            >
              Cart
            </Nav.Link>
          </Nav>
        </Container>
      </Navbar>

      <Routes>
        <Route path="/" element={<Home shoes={shoes} />} />
        <Route path="/detail/:id" element={<Detail shoes={shoes} />} />
        <Route path="/cart" element={<Cart />} />
        <Route path="/about" element={<About />}>
          <Route path="member" element={<div>멤버정보</div>} />
          <Route path="location" element={<div>위치정보</div>} />
        </Route>
        <Route path="*" element={<div>없는 페이지입니다.</div>} />
      </Routes>
      <Button
        onClick={() => {
          axios
            .get("https://codingapple1.github.io/shop/data2.json")
            .then((result) => {
              const data = result.data;
              const newShoes = [...shoes, ...data];
              setShoes(newShoes);
              console.log(newShoes);
            })
            .catch((e) => {
              console.log("failed");
            });
        }}
      >
        더보기
      </Button>
    </div>
  );
}

export default App;
