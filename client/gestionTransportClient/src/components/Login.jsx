import React, { useState } from 'react';
import "../css/login.css"; 
import logo from "../assets/logo.png";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { Link } from 'react-router-dom';

const Login = () => {
  const [formData, setFormData] = useState({
    email: '',
    password: '',
  });

  const navigate = useNavigate();

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log('Login form submitted:', formData);
    try {
      const response = await axios.post('https://jsonplaceholder.typicode.com/posts', {
        email: formData.email,
        password: formData.password,
      });

      console.log('Response:', response.data);
      alert('Connexion réussie !');
      navigate('/'); 
    } catch (error) {
      console.error('Erreur lors de la connexion :', error);
      alert('Une erreur est survenue lors de la connexion.');
    }
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
          <div className="register-link">
            <p>
              Pas encore de compte ? <Link to="/register" className="text-link">Inscrivez-vous</Link>
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
