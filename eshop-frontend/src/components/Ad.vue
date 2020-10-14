<template>
<b-row v-if="advertisement">
  <b-container>
    <b-alert show variant="dark">
        <strong>Advertisement:</strong>
        <router-link :to="advertisement.redirectUrl" rel="nofollow" target="_blank" class="alert-link">
            {{advertisement.text}}
        </router-link>
    </b-alert>
  </b-container>
</b-row>
</template>

<script>
import {mapGetters} from 'vuex'

export default {
  name: 'Ad',
  computed: mapGetters({
      advertisement: 'ad/ad'
  }),
  props: {
    categories: {
      type: Array
    }
  },
  mounted() {
    this.fetchData()
  },
  watch: {
    '$props.categories'() {
      this.fetchData()
    }
  },
  methods: {
    fetchData() {
      if(this.$props.categories) {
        this.$store.dispatch('ad/fetchAdsByCategories', this.$props.categories)
      } else {
        this.$store.dispatch('ad/fetchAd')
      }
    }
  }
}
</script>
