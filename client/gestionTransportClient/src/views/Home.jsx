import React, { useState } from "react";
import Header from "../components/shared/Header";
import Navbar from "../components/shared/Navbar";
import "../css/home.css";
import megaphone from "../assets/megaphone.png";
import train from "../assets/icon-train.png";
import metro from "../assets/icon-metro.png";
import tram from "../assets/icon-tram.png";
import bus from "../assets/icon-bus.png";
import { useNavigate } from 'react-router-dom';
import axios from "axios";


const Home = () => {
  const [formData, setFormData] = useState({
    departure: '',
    arrival: '',
    departureDate: ''
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    
    navigate(`/result`, { state: formData });
  };
  return (
    <>
      <Header />
      <Navbar />
      <div className="home-container">
        <div className="search-box">
          <form className="search-form" onSubmit={handleSubmit}>
            <div className="form-group">
              <label htmlFor="departure">📍 Point de départ :</label>
              <input
                type="text"
                id="departure"
                name="departure"
                value={formData.departure} 
                onChange={handleChange}
                placeholder="Entrer le point de départ"
                required
              />
            </div>

            <div className="form-group">
              <label htmlFor="arrival">📍 Point d'arrivée :</label>
              <input
                type="text"
                id="arrival"
                name="arrival"
                value={formData.arrival} 
                onChange={handleChange}
                placeholder="Entrer le point d'arrivée"
                required
              />
            </div>

            <div className="form-group">
              <label htmlFor="departureDate">📅 Date de départ :</label>
              <input
                type="date"
                id="departureDate"
                name="departureDate"
                value={formData.departureDate}
                onChange={handleChange}
                required
              />
            </div>

            <button type="submit" className="search-button">
              Rechercher
            </button>
          </form>
        </div>
      </div>
      <div className="bottom-section">
        <div className="title-group">
          <div className="megaphone">
            <img src={megaphone} alt="un mégaphone" />
          </div>
          <div className="text-megaphone">
            <h2>Information Trafic</h2>
          </div>
        </div>
        <div className="icon-group">
          <div className="transport-container">
            <div className="transport-card">
              <img src={bus} alt="Bus" />
              <p>Changement d'itinéraire vers <span>Lille centre</span></p>
            </div>
            <div className="transport-card">
              <img src={train} alt="Train" />
              <p>Retard de <span>62 minutes</span></p>
            </div>
            <div className="transport-card">
              <img src={metro} alt="Métro" />
              <p>Pas de pertubation en cours ...</p>
            </div>
            <div className="transport-card">
              <img src={tram} alt="Tram" />
              <p>Pas de pertubation en cours ...</p>
            </div>
          </div>
        </div>
      </div>
    
    </>
  );
};

export default Home;
