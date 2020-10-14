import _ from 'lodash'
import axios from 'axios'

export default {
    namespaced: true,
    state: {
      ad: {
        redirectUrl: "",
        text: ""
      },
    },
    getters: {
      ad: state => state.ad
    },
    actions: {
      async fetchAd(context) {
        console.log("fetchAd")
        const ads = (await axios.get(process.env.VUE_APP_BASE_URL + "/ads")).data
        context.commit("setAd", _.sample(ads))
      },
      async fetchAdsByCategories(context, categories) {
        console.log("fetchAdsByCategories : " + categories.join())
        const ads = (await axios.get(process.env.VUE_APP_BASE_URL + "/ads" + "/" + categories.join())).data
        context.commit("setAd", _.sample(ads))
      }
    },
    mutations: {
      setAd(state, ad) {
        state.ad = ad
      }
    }
}