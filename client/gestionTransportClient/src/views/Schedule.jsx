import React from "react";
import Header from "../components/shared/Header";
import Navbar from "../components/shared/Navbar";
import "../css/schedule.css";
import bus from "../assets/icon-bus.png";
import train from "../assets/icon-train.png";
import tram from "../assets/icon-tram.png";
import metro from "../assets/icon-metro.png";



const Schedule = () => {
    return (
        <>
        <Header/>
        <Navbar/>
        <div className="schedule-container">
            <div className="title-container">
                <h1>Horaires</h1>
            </div>
        </div>
        <div className="select-transport">
            <div>
                <a href="" className="icon-link"><img src={bus} alt="icône bus" /></a>
            </div>
            <div>
                <a href="" className="icon-link"><img src={tram} alt="Icône tram" /></a>
            </div>
            <div>
                <a href="" className="icon-link"><img src={train} alt="Icône train" /></a>
            </div>
            <div>
                <a href="" className="icon-link"><img src={metro} alt="Icône métro" /></a>
            </div>
        </div>
        </>
    )
}

export default Schedule;