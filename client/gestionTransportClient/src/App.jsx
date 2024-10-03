import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Register from './components/register'
import Login from './components/Login'
import Home from './views/Home'
import ResultSearchSchedule from './views/ResultSearchSchedule'
import { RouterProvider } from 'react-router-dom'

function App() {
  

  return (
    <>
     <div className="App">
            <RouterProvider router={router} />
        </div>
    </>
  )
}

export default App
