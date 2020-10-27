const mongoose = require("mongoose");
const data = require("./data/products.json");

// Nodejs의 native Promise 사용
mongoose.Promise = global.Promise;

let Product;

const MoneySchema = new mongoose.Schema({
  currencyCode: String,
  units: Number,
  nanos: Number,
});
const ProductSchema = new mongoose.Schema({
  id: String,
  name: String,
  description: String,
  picture: String,
  categories: [{ type: String }],
  priceUsd: MoneySchema,
});
ProductSchema.statics.initProduct = async (Product) => {
  const count = await Product.countDocuments({});
  if (count == 0) {
    data.products.forEach((product) => {
      Product.create(product);
    });
  }
};

Product = mongoose.model("Product", ProductSchema);
module.exports = Product;
