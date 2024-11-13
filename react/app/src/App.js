import { Link, Outlet } from "react-router-dom";

const App = () => {
  return (
    <div>
      <h1>BookKeeper</h1>
      <nav style={{borderBottom:'solid 1px',paddingBottom:'1rem'}}>
        <Link to='/invoices' style={{margin:5}}> Invoices </Link>
        <Link to='/expenses' style={{margin:5}}> Expenses </Link>
      </nav>
      <Outlet/>
    </div>
  );
};

export default App;
