import React from 'react';
import "../../css/navbar.css";
import { Link } from 'react-router-dom';

const Navbar = () => {
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
                <Link to="/horaires" className="navbar-link">Horaires</Link>
                <a href="#" className="navbar-link">Plans</a>
                <a href="#" className="navbar-link">Tarifs</a>
            </div>
        </nav>
    );
}

export default Navbar;
