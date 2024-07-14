//importamos el Modelo
import ProductoModel from "../models/ProductoModel.js";

//** Métodos para el CRUD **/

//Mostrar todos los producto
export const getAllProductos = async (req, res) => {
    try {
        const producto = await ProductoModel.find()
        res.status(200).json(producto)
    } catch (error) {
        res.json( {message: error.message} )
    }
}
//Mostrar un Producto
export const getProducto = async (req, res) => {
        try {
            const id = req.params.id
            await ProductoModel.findById( {_id:id} ).then( (producto) => {
                res.status(200).json(producto)
            })        
        } catch (error) {
            res.json( {message: error.message} )
        }
}
//Crear un producto
export const createProducto = async (req, res) => {
    try {
       await ProductoModel.create(req.body)
       res.status(200).json({
           "message":"¡Producto creado correctamente!"
       })
    } catch (error) {
        res.json( {message: error.message} )
    }
}
//Actualizar un producto
export const updateProducto = async (req, res) => {
    try {
        const id = req.params.id
        await ProductoModel.updateOne({_id: id}, req.body).then( res => {
            console.log(res)
        })
        res.status(200).json({
            "message":"¡Producto actualizado correctamente!"
        })
    } catch (error) {
        res.json( {message: error.message} )
    }
}
//Eliminar un producto
export const deleteProducto = async (req, res) => {
    try {
        const id = req.params.id
        await ProductoModel.deleteOne({ _id : id }).then( res => {
            console.log(res)
        })
        res.status(200).json({
            "message":"¡Producto eliminado correctamente!"
        })
    } catch (error) {
        res.json( {message: error.message} )
    }
}