<template>
  <b-row v-if="products">
    <Product v-for="product in products" :key="product.id" :product="product" />
  </b-row>
</template>

<script>
import Product from '@/components/Product.vue'
import {mapGetters} from 'vuex'

export default {
  name: 'Products',
  components: {
    Product
  },
  computed: mapGetters({
    products: 'product/products'
  }),
  mounted() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.$store.dispatch('product/fetchProducts')
    }
  }
}
</script>
