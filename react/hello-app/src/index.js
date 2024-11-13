import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import reportWebVitals from "./reportWebVitals";

import App from "./App";
import Library from "./chapter01/Library";
import Clock from "./chapter02/Clock";
import CommentList from "./chapter01/CommetList";
import Count from "./chapter01/Count";
import Say from "./chapter01/Say";

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <div>
    <App/>
  </div>
)

/*
setInterval(() => {
  const root = ReactDOM.createRoot(document.getElementById("root"));
  root.render(
    <div>
      <React.StrictMode>
        <Say />
      </React.StrictMode>
    </div>
  );
}, 5000);*/

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
