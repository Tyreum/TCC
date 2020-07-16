import React from 'react'
import './LoginCard.css'
import key from './old-key.png'

export default function LoginCard(){
    return(
        <div className='Card'>
            <img className='icon' src={key}/>
            <br/>
            <div className='input'>
                <label className='text'>USERNAME</label>
                <br/>
                <input type='text' className='form-control'></input>
            </div>
            <div className='input'>
                <label className='text'>PASSWORD</label>
                <br/>
                <input type='password' className='form-control'></input>
            </div>
            <div className='btnposition'>
                <button>LOGIN</button>
            </div>
        </div>
    );
}