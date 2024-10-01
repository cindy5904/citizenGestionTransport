import React from 'react';
import logo from "../../assets/logo.png";
import avatar from "../../assets/avatar.png";
import "../../css/header.css";

const Header = () => {
    return (
      <header className="header">
        
        <div className="header-logo">
          <img src={logo} alt="Logo" className="logo" /> 
        </div>
        
        <div className="header-account">
          <img src={avatar} alt="Avatar" className="avatar" /> 
          <span className="account-text"><a href="#" className="text-link">Mon compte</a></span>
        </div>
      </header>
    );
  };
  
  export default Header;