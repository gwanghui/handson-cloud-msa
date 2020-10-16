import axios from 'axios'
// import product from './product'
import router from '@/router/index.js'

export default {
    namespaced: true,
    state: {
      items: [],
      shippingCost: 0,
      orderInfo: {
        emailAddress: "someone@example.com",
        address: {
          streetAddress: "1600 Amphitheatre Parkway",
          zipCode: 94043,
          city: "Mountain View",
          state: "CA",
          country: "United States"
        },
        creditCardInfo: {
          creditCardNumber: "4432-8015-6152-0454",
          creditCardExpirationMonth: 1,
          creditCardExpirationYear: 2020,
          cvv: 672
        }
      }
    },
    getters: {
      cartItems: state => state.items,
      cartSize: state => (state.items).length,
      shippingCost: state => state.shippingCost,
      totalCost: state => {
        var itemPriceNanos = (state.items).map(item => item.product.priceUsd.nanos ? (item.product.priceUsd.nanos * item.quantity) : 0).reduce((acc, cur) => acc + cur, 0)
        var itemPriceUnits = (state.items).map(item => item.product.priceUsd.units * item.quantity).reduce((acc, cur) => acc + cur, 0)

        // shipping cost를 합쳐서 받아올림을 한다.
        var totalNanos = itemPriceNanos + (state.shippingCost.nanos ? state.shippingCost.nanos : 0)
        var totalUnits = itemPriceUnits + (state.shippingCost.units ? state.shippingCost.units : 0) + Math.floor(totalNanos / 1000000000)
        totalNanos = totalNanos % 1000000000

        var totalCost = {
          currencyCode: "USD",
          units: totalUnits,
          nanos: totalNanos
        }
        return totalCost
      },
      orderInfo: state => state.orderInfo
    },
    actions: {
      async emptyCart(context) {
        console.log("emptyCart")
        await axios.post(process.env.VUE_APP_BASE_URL + "/carts" + "/empty")
        context.commit("emptyCart")
      },
      async addToCart(context, cartItem) {
        console.log("addToCart : " + JSON.stringify(cartItem))
        await axios.post(process.env.VUE_APP_BASE_URL + "/carts", cartItem)
        const cartProduct = (await axios.get(process.env.VUE_APP_BASE_URL + "/products/" + cartItem.id)).data
        cartItem.product = cartProduct
        context.commit("addToCart", cartItem)
      },
      async fetchCartItems(context) {
        console.log("fetchCartItems")
        const cartItems = (await axios.get(process.env.VUE_APP_BASE_URL + "/carts")).data
        const cartItemIds = cartItems.map((item) => item.id).join(',')
        const cartProducts = (await axios.get(process.env.VUE_APP_BASE_URL + "/products?ids=" + cartItemIds)).data.products
        cartItems.map(item => item.product = cartProducts.find(product => product.id === item.id))
        await context.commit("setCartItems", cartItems)
      },
      async fetchShippingCost(context, cartItems) {
        console.log("fetchShippingCost")
        console.log(cartItems)
        const shippingCost = (await axios.post(process.env.VUE_APP_BASE_URL + "/checkouts/shippings/cost", 
        cartItems.map(
          item => {
            return { productId: item.id, quantity: item.quantity }
          }))).data
        context.commit("setShippingCost", shippingCost)
      },
      async checkout(context) {
        const orderResult = (await axios.post(process.env.VUE_APP_BASE_URL +"/checkouts/orders", context.state.orderInfo)).data
        context.commit("emptyCart")
        context.commit("order/setOrder", orderResult, {root: true});
      }
    },
    mutations: {
      emptyCart(state) {
        state.items = [] 
      },
      async addToCart(state, cartItem) {
        await state.items.push(cartItem)
        router.push("/cart")
      },
      setCartItems(state, cartItems) {
        cartItems.map(cartItems => cartItems.product.picture = process.env.VUE_APP_BASE_URL + cartItems.product.picture) 
        state.items = cartItems
      },
      setShippingCost(state, shippingCost) {
        state.shippingCost = shippingCost
      }
    }
}