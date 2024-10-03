import React, { useState } from 'react';
import "../css/register.css";
import anthony from "../assets/anthony.jpg"
import logo from "../assets/logo.png";
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Register = () => {
    const [formData, setFormData] = useState({
      prenom: '',
      nom: '',
      email: '',
      password: '',
      confirmPassword: '',
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
      console.log('Form Data:', formData);
      
      try {
          const response = await axios.post('https://jsonplaceholder.typicode.com/posts', {
              title: `${formData.prenom} ${formData.nom}`,
              email: formData.email,
              password: formData.password,
              confirmPassword: formData.confirmPassword,
          });

          console.log('Response:', response.data);
          alert('Compte créé avec succès !');
          navigate('/login');
      } catch (error) {
          console.error('Erreur lors de la création du compte:', error);
          alert('Une erreur est survenue lors de la création du compte.');
      }
  };

    return (
    <div className="register-page">
      <div className="register-form-container">
        <div className="register-form-content">
          <img src={logo} alt="Logo" className="logo" /> 
          <h2>Créer mon compte</h2>
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <input
                type="text"
                id="prenom"
                name="prenom"
                placeholder="Prénom"
                value={formData.prenom}
                onChange={handleChange}
                required
              />
            </div>
            <div className="form-group">
              <input
                type="text"
                id="nom"
                name="nom"
                placeholder="Nom"
                value={formData.nom}
                onChange={handleChange}
                required
              />
            </div>
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
            <button type="submit" className="submit-btn">Créer un compte</button>
          </form>
          <button className="google-btn">Se connecter avec Google</button>
        </div>
      </div>

      
      <div className="register-image-container">
        <img src={anthony} alt="Background" className="background-image" />
      </div>
    </div>
    );
  };
  
  export default Register;

