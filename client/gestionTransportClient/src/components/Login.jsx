import React, { useState } from 'react';
import "../css/login.css"; 
import logo from "../assets/logo.png";

const Login = () => {
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('Login form submitted:', formData);
  };

  return (
    <div className="login-page">
      <div className="login-form-container">
        <div className="login-form-content">
          <img src={logo} alt="Logo" className="logo" /> 
          <h2>Connexion</h2>
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <input
                type="email"
                id="email"
                name="email"
                placeholder="Email"
                value={formData.email}
                onChange={handleChange}
                required
              />
            </div>
            <div className="form-group">
              <input
                type="password"
                id="password"
                name="password"
                placeholder="Mot de passe"
                value={formData.password}
                onChange={handleChange}
                required
              />
            </div>
            <button type="submit" className="submit-btn">Se connecter</button>
          </form>
          <button className="google-btn">Se connecter avec Google</button>
          <div className="login-options">
            <a href="#" className="forgot-password-link">Mot de passe oublié ?</a>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
