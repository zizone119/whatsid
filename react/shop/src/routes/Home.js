import Shoe from "../Shoe";

const Home = (props) => {
  return (
    <>
      <div className="main-bg"></div>
      <Shoe shoes={props.shoes}></Shoe>
    </>
  );
};

export default Home;
