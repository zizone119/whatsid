import './TodoList.scss';
import TodoListItem from './TodoListItem';

const TodoList=({todos,onToggle,onRemove,focusRef})=>{
    return(
        <div className='TodoList'>
            {todos.map(todo=>(
                <TodoListItem todo={todo} onToggle={onToggle} onRemove={onRemove} focusRef={focusRef}/>
            ))}
        </div>
    )
}

export default TodoList;