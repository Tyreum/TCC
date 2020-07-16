import React from 'react';
import LoginCard from './components/CardLogin'
import { findAllByDisplayValue } from '@testing-library/react';
import './App.css'

function App() {
  return (
    <div className="App">
      <div className='lala'>
        <LoginCard/>
      </div>
    </div>
  );
}

export default App;
