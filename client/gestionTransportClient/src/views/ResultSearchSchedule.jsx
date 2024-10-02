import React from "react";
import Header from "../components/shared/Header";
import Navbar from "../components/shared/Navbar";
import "../css/resultSchedule.css";
import megaphone from "../assets/megaphone.png";
import { FaBus, FaTrain } from 'react-icons/fa';

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
            <div className="travel-card">
            <div className="left-section">
                <p>Départ dans : <span>18 minutes</span></p>
                <div className="icons">
                    <FaBus className="icon" />
                    <FaTrain className="icon" />
                </div>
            </div>
            <div className="right-section">
                <p>Heure d'arrivée : <span>9h08</span></p>
                <p>Durée trajet : <span>3h56</span></p>
            </div>
        </div>
        <div className="travel-card">
            <div className="left-section">
                <p>Départ dans : <span> 7 minutes</span></p>
                <div className="icons">
                    <FaBus className="icon" />
                    <FaTrain className="icon" />
                </div>
            </div>
            <div className="right-section">
                <p>Heure d'arrivée :<span> 18h12</span></p>
                <p>Durée trajet : <span> 1h23</span></p>
            </div>
        </div>
        <div className="travel-card">
            <div className="left-section">
                <p>Départ dans : <span> 48 minutes</span></p>
                <div className="icons">
                    <FaBus className="icon" />
                    <FaTrain className="icon" />
                </div>
            </div>
            <div className="right-section">
                <p>Heure d'arrivée : <span> 15h08</span></p>
                <p>Durée trajet : <span> 5h56</span></p>
            </div>
        </div>
        </div>
        </>
    )
}

export default ResultSearchSchedule;