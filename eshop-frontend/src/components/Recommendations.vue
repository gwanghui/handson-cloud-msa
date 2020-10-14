<template v-if="recommendations">
  <b-container fluid>
    <h5 class="text-muted">Products you might like</h5>
    <b-row class="my-2 py-3">
      <Recommendation v-for="recommendation in recommendations" :key="recommendation.id" :recommendation="recommendation" />
    </b-row>
  </b-container>
</template>

<script>
import Recommendation from '@/components/Recommendation.vue'
import {mapGetters} from 'vuex'

export default {
  name: 'Recommendations',
  components: {
    Recommendation
  },
  computed: mapGetters({
    recommendations: 'recommendation/recommendations'
  }),
  created() {
    this.$store.dispatch('recommendation/fetchRecommendations')
  }
}
</script>