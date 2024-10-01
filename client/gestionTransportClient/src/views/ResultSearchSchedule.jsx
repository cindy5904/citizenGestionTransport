import React from "react";
import Header from "../components/shared/Header";
import Navbar from "../components/shared/Navbar";
import "../css/resultSchedule.css";
import megaphone from "../assets/megaphone.png";

const ResultSearchSchedule = () => {
    return (
        <>
        <Header/>
        <Navbar/>
        <div className="result-schedule">
        </div>
        <div className="sect-bot">
        <div className="title-group">
          <div className="megaphone">
            <img src={megaphone} alt="un mégaphone" />
          </div>
          <div className="text-megaphone">
            <h2>Résultat</h2>
          </div>
        </div>
        </div>
        </>
    )
}

export default ResultSearchSchedule;