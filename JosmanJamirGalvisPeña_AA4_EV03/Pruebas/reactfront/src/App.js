import logo from './logo.svg';
import './App.css';

//importamos los componentes
import CompShowProducto from './producto/ShowProducto';
import CompCreateProducto from './producto/CreateProducto';
import CompEditProducto from './producto/EditProducto';

//importamos el router
import { BrowserRouter, Route, Routes } from 'react-router-dom';


function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />        
      </header>
      <BrowserRouter>
        <Routes>
            <Route path='/' element={ <CompShowProducto />} />
            <Route path='/create' element={ <CompCreateProducto />} />
            <Route path='/edit/:id' element={ <CompEditProducto />} />
        </Routes>
      </BrowserRouter>
      
    </div>
  );
}

export default App;
