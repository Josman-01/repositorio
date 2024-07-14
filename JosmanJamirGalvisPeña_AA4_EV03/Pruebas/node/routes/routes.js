import express from 'express'
import { getAllProductos, getProducto, createProducto, updateProducto, deleteProducto } from '../controllers/ProductoController.js'
const router = express.Router()

router.get('/', getAllProductos)
router.get('/:id', getProducto)
router.post('/', createProducto)
router.put('/:id', updateProducto)
router.delete('/:id', deleteProducto)

export default router
