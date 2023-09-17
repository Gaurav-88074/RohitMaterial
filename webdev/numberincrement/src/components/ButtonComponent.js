import React from 'react'

const ButtonComponent = (props) => {
    function incrementButtonHandler() {
        props.setValue((prevValue)=>{
            return prevValue+1;
        });
    }
    return (
        <button
            className='btn'
            onClick={incrementButtonHandler}
        >
            increment
        </button>
    )
}

export default ButtonComponent