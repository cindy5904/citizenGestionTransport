import { createBrowserRouter } from "react-router-dom";
import Login from "../components/Login";
import Schedule from "../views/Schedule";
import Home from "../views/Home";

const router = createBrowserRouter([
    {
        path :"/",
        element : <Home />,
    },
    {
        path :"/login",
        element : <Login />,

    },
    {
        path : "/horaires",
        element : <Schedule />
    }
        
    
    
])

export default router