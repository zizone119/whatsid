import './TodoListItem.scss';
import  {MdCheckBox, MdCheckBoxOutlineBlank,MdRemoveCircleOutline}  from 'react-icons/md';
import classNames from 'classnames';

const TodoListItem = ({todo,onToggle,onRemove,focusRef})=>{
    const {id,text,checked}=todo;
    return(
        <div className='TodoListItem'>
            <div className={classNames('checkbox',{checked})} onClick={()=>{
                onToggle(id);
                focusRef.current.focus();
                }}>
                {checked?<MdCheckBox/>: <MdCheckBoxOutlineBlank/>}
                <div className='text'>{text}</div>
            </div>
            <div className='remove' onClick={()=>{
                onRemove(id);
                focusRef.current.focus();
                }}>
                <MdRemoveCircleOutline/>
            </div>
        </div>
    )
}

export default TodoListItem;