import { BrowserRouter, Route, Routes } from "react-router-dom";
import PostMain from "./pages/post/PostMain";
import PostView from "./pages/post/PostView";

const App = () => {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/postView/:no" element={<PostView/>}></Route>
          <Route path="/" element={<PostMain/>}></Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
};

export default App;
