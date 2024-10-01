import React from 'react';
import "../../css/navbar.css";

const Navbar = ()=> {
    return (
    <nav className="navbar">
      
      <div className="navbar-search">
        <input
          type="text"
          placeholder="Rechercher..."
          className="search-input"
        />
      </div>

      <div className="navbar-tabs">
        <a href="#" className="navbar-link">Itinéraires</a>
        <a href="#" className="navbar-link">Horaires</a>
        <a href="#" className="navbar-link">Plans</a>
        <a href="#" className="navbar-link">Tarifs</a>
      </div>
    </nav>
    )
}
export default Navbar;