<template>
  <div class="py-5">
    <b-container class="bg-light py-3 px-lg-5">
      <b-row class="mt-5 py-2">
        <b-col>
          <h3>Your order is complete!</h3>
          <p>
            Order Comfirmation ID: <strong>{{order.orderId}}</strong>
            <br/>
            Shipping Tracking ID: <strong>{{order.shippingTrackingId}}</strong>
          </p>
          <p>
            Shipping Cost: <strong>{{ renderMoney(order.shippingCost)}}</strong>
            <br/>
            Total Paid: <strong>{{ renderMoney(order.totalPaid) }}</strong>
          </p>
          <router-link to="/">
            <b-button variant="primary">Browse other products &rarr;</b-button>
          </router-link>
        </b-col>
      </b-row>
      <hr/>
      <Recommendations/>
    </b-container>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
import Recommendations from '@/components/Recommendations.vue'

export default {
  name: 'Order',
  components: {
    Recommendations
  },
  computed: mapGetters({
    order: 'order/orderResult',
    renderMoney: 'currency/renderMoney'
  })
}
</script>
