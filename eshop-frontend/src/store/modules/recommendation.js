import axios from 'axios'

export default {
    namespaced: true,
    state: {
      recommendations: []
    },
    getters: {
      recommendations: state => state.recommendations
    },
    actions: {
      async fetchRecommendations(context) {
        const res = await axios.get(process.env.VUE_APP_BASE_URL + "/recommends")
        context.commit("setRecommendations", res.data.recommendations)
      }
    },
    mutations: {
      setRecommendations(state, recommendations) {
        state.recommendations = recommendations 
      }
    },
}