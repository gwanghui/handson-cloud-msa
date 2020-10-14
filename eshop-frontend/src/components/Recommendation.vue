<template>
  <b-col sm="6" md="4" lg="3">
    <b-card class="box-shadow"> 
      <router-link :to="{ name: 'ProductDetail', params: { id: recommendation.id}}">
        <b-card-img :src="recommendation.picture" class="border=bottom" style="width: 100%; height: auto;" />
      </router-link>
      <b-card-body>
        <b-card-title class="py-2 text-center"><small class="text-muted">{{ recommendation.name }}</small></b-card-title>
      </b-card-body>
    </b-card>
    <br/>
  </b-col>
</template>

<script>
export default {
  name: 'Recommendation',
  props: {
    recommendation: {
      type: Object,
      required: true
    }
  }
}
</script>

<style scoped>
</style>
