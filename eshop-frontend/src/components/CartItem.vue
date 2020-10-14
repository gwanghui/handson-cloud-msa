<template>
  <b-row class="pt-2 mb-2">
    <b-col class="text-right">
      <router-link :to="{ name: 'ProductDetail', params: { id: item.id}}">
        <img v-if="item.product" class="img-fluid" style="width: auto; max-height: 60px;" :src="item.product.picture" />
      </router-link>
    </b-col>
    <b-col class="align-middle">
      <strong v-if="item.product">{{item.product.name}}</strong><br/>
      <small class="text-muted">SKU: #{{item.id}}</small>
    </b-col>
    <b-col class="text-left">
      Qty: {{item.quantity}}<br/>
      <strong v-if="item.product">
          {{ renderMoney(itemPrice()) }}
      </strong>
    </b-col>
  </b-row>
</template>

<script>
import {mapGetters} from 'vuex'

export default {
  name: 'CartItem',
  props: {
    item: {
      type: Object,
      required: true
    }
  },
  computed: mapGetters({
    renderMoney: 'currency/renderMoney'
  }),
  methods: {
    itemPrice() {
          const priceUsd = this.item.product.priceUsd
          const quantity = this.item.quantity
          var nanos = priceUsd.nanos ? (priceUsd.nanos * quantity) : 0
          var units = priceUsd.units * quantity + Math.floor(nanos / 1000000000)
          nanos = nanos % 1000000000
          return {
            currencyCode: priceUsd.currencyCode,
            units: units,
            nanos: nanos
          }
    }
  }
}
</script>