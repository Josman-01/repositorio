import mongoose from "mongoose";
const Schema = mongoose.Schema

const productoSchema = new Schema(
    {
      title: {type:String},       
      content: {type:String}
    },
    {collection: 'blogs'}
)

export default mongoose.model('ProductoModel', productoSchema)