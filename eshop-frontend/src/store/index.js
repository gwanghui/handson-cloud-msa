import Vue from 'vue'
import Vuex from 'vuex'
import ad from '@/store/modules/ad'
import cart from '@/store/modules/cart'
import currency from '@/store/modules/currency'
import order from '@/store/modules/order'
import product from '@/store/modules/product'
import recommendation from '@/store/modules/recommendation'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    bannercolor: "light-gray"
  },
  mutations: {
  },
  actions: {
  },
  modules: {
    ad,
    cart,
    currency,
    order,
    product,
    recommendation
  }
})
