<template>
  <div class="py-5">
    <b-container class="bg-light py-3 px-lg-5 py-lg-5">
      <template v-if="cartSize === 0">
        <h3>Your shopping cart is empty!</h3>
        <p>Items you add to your shopping cart will appear here.</p>
        <router-link to="/">
          <b-button variant="primary">Browse Products &rarr;</b-button>
        </router-link>
      </template>
      <template v-else>
        <b-row class="mb-3 py-2">
          <b-col>
              <h3>{{ cartSize }} item<template v-if="cartSize > 1">s</template> in your Shopping Cart</h3>
          </b-col>
          <b-col class="text-right">
            <b-form method="POST" action="/cart/empty">
              <b-button variant="secondary" @click="emptyCart">Empty cart</b-button>
              <router-link to="/">
                <b-button variant="info">Browse more products &rarr;</b-button>
              </router-link>
            </b-form>
          </b-col>
        </b-row>
        <hr/>
        <CartItem v-for="item in cartItems" :key="`${item.id}-${item.quantity}`" :item="item" />
        <b-row class="pt-2 my-3">
          <div class="col text-center">
              <p class="text-muted my-0">Shipping Cost: <strong>{{ renderMoney(shippingCost) }}</strong></p>
              Total Cost: <strong>{{ renderMoney(totalCost) }}</strong>
          </div>
        </b-row>
        <hr/>
        <Checkout />
        <hr/>
        <Recommendations/>
      </template>
    </b-container>
  </div>
</template>

<script>
import {mapGetters, mapActions} from 'vuex'
import CartItem from '@/components/CartItem.vue'
import Checkout from '@/components/Checkout.vue'
import Recommendations from '@/components/Recommendations.vue'

export default {
  name: 'Cart',
  components: {
    CartItem,
    Checkout,
    Recommendations
  },
  computed: mapGetters({
    cartItems: 'cart/cartItems',
    cartSize: 'cart/cartSize',
    shippingCost: 'cart/shippingCost',
    totalCost: 'cart/totalCost',
    renderMoney: 'currency/renderMoney'
  }),
  created() {
    this.fetchCartItems()
  },
  methods: {
    ...mapActions('cart', ['emptyCart', 'fetchCartItems', 'fetchShippingCost'])
  },
  watch: {
    'cartItems'() {
      this.fetchShippingCost(this.cartItems)
    }
  }
}
</script>
