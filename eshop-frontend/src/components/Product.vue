<template>
  <b-col md="4">
    <b-card> 
      <router-link :to="{ name: 'ProductDetail', params: { id: product.id}}">
        <b-card-img :src="product.picture" />
      </router-link>
      <b-card-body>
      <b-card-title>{{ product.name }}</b-card-title>
      <div class="d-flex justify-content-between align-items-center">
        <b-button-group>
          <router-link :to="{ name: 'ProductDetail', params: { id: product.id}}">
            <b-button variant="light" class="btn btn-sm btn-outline-secondary">Buy</b-button>
          </router-link>
        </b-button-group>
        <small class="text-muted"> <strong> {{ renderMoney(product.priceUsd) }} </strong> </small>
      </div>
      </b-card-body>
    </b-card>
    <br/>
  </b-col>
</template>

<script>
import {mapGetters} from 'vuex'
export default {
  name: 'Product',
  props: {
    product: {
      type: Object,
      required: true
    }
  },
  computed: mapGetters({
    renderMoney: 'currency/renderMoney'
  })
}
</script>

<style scoped>
</style>
