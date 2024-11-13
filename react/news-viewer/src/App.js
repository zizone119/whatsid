import { useCallback, useState } from 'react';
import NewsList from './components/NewsList';
import Categories from './components/Categories';

const App = () => {
  const [category,setCategory]=useState('all');
  const onSelect=useCallback(category=>setCategory(category),[]);
  return (
    <div>
      <Categories category={category} onSelect={onSelect}></Categories>
      <NewsList category={category}></NewsList>
    </div>
  );
};

export default App;
