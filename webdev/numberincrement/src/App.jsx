
import './style.css'
import React from 'react';
import { useState } from 'react'
import ButtonComponent from './components/ButtonComponent';
import ValueComponent from './components/ValueComponent';
function App() {
  let a = 0;
  const [transValue, setTransValue] = useState(0);
  const [isOpen, setIsOpen] = useState(false);
  function incrementButtonHandler() {
    setTransValue((prevValue) => {
      return 100 - prevValue ;
    });
    setIsOpen((prev)=>{
      return !prev
    })
  }
  return (
    <div className={'display'}>
      <section className={'gate'}>
        <div className="door1" style={{
          transform: `translateX(-${transValue}%)`
        }}>

        </div>
        <div className="door2" style={{
          transform: `translateX(${transValue}%)`
        }}>

        </div>
      </section>
      <button
        className='btn'
        onClick={incrementButtonHandler}
      >
        {isOpen===false? "OPEN" : "CLOSE"}
      </button>
    </div>
  );
}

export default App;
