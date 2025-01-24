import React from "react";
import { Link } from "react-router-dom";

const Home = () => {
  return (
    <div>
      <h1>홈</h1>
      <p>Home, 가장 먼저 보이는 페이지</p>
      <ul>
        <li>
          <Link to="/about">소개</Link>
        </li>
        <li>
            <Link to='/profiles/velopert'>velopert의 프로필</Link>
        </li>
        <li>
            <Link to='/profiles/gildong'>gildong의 프로필</Link>
        </li>
        <li>
            <Link to='/profiles/void'>존재하지 않는 프로필입니다.</Link>
        </li>
      </ul>
    </div>
  );
};

export default Home;
