import React, {useState, useEffect} from "react";
import Header from "../components/shared/Header";
import Navbar from "../components/shared/Navbar";
import "../css/resultSchedule.css";
import megaphone from "../assets/megaphone.png";
import { FaBus, FaTrain } from 'react-icons/fa';
import { useLocation } from 'react-router-dom';
import axios from "axios";

const ResultSearchSchedule = () => {
    const [travelData, setTravelData] = useState([]);
    const location = useLocation();
    const { departure, arrival, departureDate } = location.state || {}; 

    useEffect(() => {
        const fetchTravelData = async () => {
            try {
                const response = await axios.get('https://jsonplaceholder.typicode.com/posts?_limit=3');
                const simulatedTravelData = response.data.map((item, index) => ({
                    id: item.id,
                    departureIn: `${Math.floor(Math.random() * 60)} minutes`,  
                    arrivalTime: `${9 + index}h${8 + index * 10}`,  
                    duration: `${Math.floor(Math.random() * 6)}h${Math.floor(Math.random() * 60)} minutes` 
                }));
                setTravelData(simulatedTravelData);
            } catch (error) {
                console.error("Erreur lors de la récupération des résultats de trajet :", error);
            }
        };

        fetchTravelData();
    }, []);
    return (
        <>
        <Header/>
        <Navbar/>
        <div className="result-schedule">
        <h2>Résultats pour le trajet {departure} ➜ {arrival} le {departureDate}</h2>
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
            {travelData.map((travel) => (
                <div className="travel-card" key={travel.id}>
                    <div className="left-section">
                        <p>Départ dans : <span>{travel.departureIn}</span></p>
                        <div className="icons">
                            <FaBus className="icon" />
                            <FaTrain className="icon" />
                        </div>
                    </div>
                    <div className="right-section">
                        <p>Heure d'arrivée : <span>{travel.arrivalTime}</span></p>
                        <p>Durée trajet : <span>{travel.duration}</span></p>
                    </div>
                </div>
            ))}

        </div>
        </>
    )
}

export default ResultSearchSchedule;