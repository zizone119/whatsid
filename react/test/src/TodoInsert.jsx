import { useCallback, useState } from 'react';
import './TodoInsert.scss';
import { MdAdd } from 'react-icons/md';
import React from 'react';

const TodoInsert=({onInsert,focusRef})=>{
    const [value, setValue]=useState('');
    
    const onChange=useCallback(e=>{
        setValue(e.target.value);
    },[]);

    const onSubmit=useCallback(e=>{
        onInsert(value);
        setValue('');
        focusRef.current.focus();
        e.preventDefault();
    },[value,onInsert,focusRef]);

    return(
        <form className='TodoInsert' onSubmit={onSubmit}>
            <input
            placeholder='할 일을 입력하세요.'
            value={value}
            onChange={onChange}
            autoFocus
            ref={focusRef}
            ></input>
            <button type='submit'>
                <MdAdd></MdAdd>
            </button>
        </form>
    )
}

export default TodoInsert;