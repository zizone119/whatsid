import React from "react";
import ReactDOM from "react-dom/client";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App";
import Expenses from "./components/Expenses";
import Invoices from "./components/Invoices";
import Invoice from "./components/Invoice";

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<App />}>
        <Route path="expenses" element={<Expenses />}></Route>
        <Route path="invoices" element={<Invoices />}>
          <Route path=":invoiceId" element={<Invoice/>}></Route>
        </Route>
      </Route>
      <Route path="*" element={<main style={{padding:'1rem'}}><p>There's nothing here!</p></main>}></Route>
    </Routes>
  </BrowserRouter>
);
