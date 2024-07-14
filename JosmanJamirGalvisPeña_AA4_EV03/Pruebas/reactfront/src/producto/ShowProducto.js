import axios from 'axios'
import {useState, useEffect} from 'react'
import {Link} from 'react-router-dom'


const URI = 'http://localhost:8000/blogs/'


const CompShowProducto = () => {
    
    const [blogs, setProductos] = useState([])
    useEffect( ()=>{
        getProductos()
    },[])

    //procedimineto para mostrar todos los blogs
    const getProductos = async () => {
        const res = await axios.get(URI)
        setProductos(res.data)
    }

    //procedimineto para eliminar un blog
    const deleteProducto = async (id) => {
       await axios.delete(`${URI}${id}`)
       getProductos()
    }

    return(
        <div className='container'>
            <div className='row'>
                <div className='col'>
                    <Link to="/create" className='btn btn-primary mt-2 mb-2'><i className="fas fa-plus"></i></Link>
                    <table className='table'>
                        <thead className='tableTheadBg'>
                            <tr>
                                <th>Producto</th>
                                <th>Contenido del producto</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            { blogs.map ( (blog, index) => (
                                <tr key={ index }>
                                    <td> { blog.title } </td>
                                    <td> { blog.content } </td>
                                    <td>
                                        <Link to={`/edit/${blog._id}`} className='btn btn-info'><i className="fas fa-edit"></i></Link>
                                        <button onClick={ ()=>deleteProducto(blog._id) } className='btn btn-danger'><i className="fas fa-trash-alt"></i></button>
                                    </td>
                                </tr>
                            )) }
                        </tbody>
                    </table>
                </div>    
            </div>
        </div>
    )

}

export default CompShowProducto