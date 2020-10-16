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
        // 이미지 주소에 서버 url을 더하자.
        recommendations.map(recommendations => recommendations.picture = process.env.VUE_APP_BASE_URL + recommendations.picture) 
        state.recommendations = recommendations 
      }
    },
}