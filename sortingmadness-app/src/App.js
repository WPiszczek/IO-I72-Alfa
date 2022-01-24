import {BrowserRouter, Routes, Route} from 'react-router-dom';
import InputData from "./components/InputData";
import Result from "./components/Result";
import SortType from './components/SortType';


function App() {

  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<InputData />} exact/>
        <Route path='/sortType' element={<SortType />} exact/>
        <Route path='/result/:sortType' element={<Result />} exact/>
      </Routes>
    </BrowserRouter>
    </>
  );
}

export default App;
