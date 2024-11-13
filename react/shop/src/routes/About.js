import { Outlet } from "react-router-dom";

const About=()=>{
    return(
        <div>
            <h3>About 페이지</h3>
            <Outlet></Outlet>
        </div>
    )
}
export default About;