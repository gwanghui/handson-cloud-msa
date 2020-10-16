import axios from 'axios'

export default {
    namespaced: true,
    state: {
      currencies: {},
      userCurrency: "USD"
    },
    getters: {
      currencies: state => Object.keys(state.currencies),
      userCurrency: state => state.userCurrency,
      renderMoney: state => (money) => {
        if(!money || !money.units ) return state.userCurrency + " 0.0"

        var convertedUnits = Math.round(money.units / state.currencies[money.currencyCode] * state.currencies[state.userCurrency])
        if(money.nanos) {
          var convertedNanos = Math.round(money.nanos / state.currencies[money.currencyCode] * state.currencies[state.userCurrency])
          return state.userCurrency + " " + convertedUnits + "." + (convertedNanos / 1000000).toString().substr(0,2)
        } 
        return state.userCurrency + " " + convertedUnits
      }
    },
    actions: {
      setUserCurrency(context, userCurrency) {
        context.commit("setUserCurrency", userCurrency)
      }, 
      async fetchCurrencies(context) {
        console.log("fetchCurrencies")
        const currencies = (await axios.get(process.env.VUE_APP_BASE_URL + "/currencies")).data
        context.commit("setCurrencies", currencies)
      }
    },
    mutations: {
      setUserCurrency(state, userCurrency) {
        state.userCurrency = userCurrency
      },
      setCurrencies(state, currencies) {
        state.currencies = currencies
      }
    }
}