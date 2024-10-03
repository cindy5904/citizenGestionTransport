import { createBrowserRouter } from "react-router-dom";
import Login from "../components/Login";
import Schedule from "../views/Schedule";
import Home from "../views/Home";
import Register from "../components/Register";
import ResultSearchSchedule from "../views/ResultSearchSchedule";

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
        path :"/register",
        element : <Register />,

    },
    {
        path : "/horaires",
        element : <Schedule />
    },
    {
        path : "/result",
        element : <ResultSearchSchedule />
    }

        
    
    
])

export default router