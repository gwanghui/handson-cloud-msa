export default {
    namespaced: true,
    state: {
      orderResult: {}
    },
    getters: {
      orderResult: state => state.orderResult
    },
    actions: {
    },
    mutations: {
      setOrder(state, orderResult) {
        state.orderResult = orderResult
      },
    }
}