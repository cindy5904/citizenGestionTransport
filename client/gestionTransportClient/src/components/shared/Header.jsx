import React, {useState} from 'react';
import logo from "../../assets/logo.png";
import avatar from "../../assets/avatar.png";
import { useNavigate } from 'react-router-dom';
import "../../css/header.css";

const Header = () => {
  const [isLoggedIn, setIsLoggedIn] = useState(false); 
  const navigate = useNavigate();

  const handleAccountClick = () => {
    if (!isLoggedIn) {
      
      navigate('/login'); 
    } else {
      
      console.log('Accéder au profil utilisateur'); 
    }
  };

    return (
      <header className="header">
        
        <div className="header-logo">
          <img src={logo} alt="Logo" className="logo" /> 
        </div>
        
        <div className="header-account" onClick={handleAccountClick}>
      {isLoggedIn && ( 
        <img src={avatar} alt="Avatar" className="avatar" />
      )}
      <span className="account-text">
        <a href="#" className="text-link">Mon compte</a>
      </span>
    </div>
      </header>
    );
  };
  
  export default Header;