<template>
  <b-row class="py-3 my-2">
    <b-col cols="12" lg="8" offset-lg="2">
      <h3>Checkout</h3>
      <b-form>
        <b-form-row>
          <b-form-group md="5" class="mb-3" label="E-mail Address" label-for="email">
            <b-form-input id="email" :value="orderInfo.emailAddress" required />
          </b-form-group>
          <b-form-group md="5" class="mb-3" label="Street Address" label-for="street_address">
            <b-form-input id="street_address" :value="orderInfo.address.streetAddress" required />
          </b-form-group>
          <b-form-group md="2" class="mb-3" label="Zip Code" label-for="zip_code">
            <b-form-input id="zip_code" :value="orderInfo.address.zipCode" required pattern="\d{4,5}" />
          </b-form-group>
        </b-form-row>

        <b-form-row>
          <b-form-group md="5" class="mb-3" label="City" label-for="city">
            <b-form-input id="city" :value="orderInfo.address.city" required />
          </b-form-group>
          <b-form-group md="2" class="mb-3" label="State" label-for="state">
            <b-form-input id="state" :value="orderInfo.address.state" required />
          </b-form-group>
          <b-form-group md="5" class="mb-3" label="Country" label-for="country">
            <b-form-input id="country" :value="orderInfo.address.country" required placeholder="Country Name" />
          </b-form-group>
        </b-form-row>

        <b-form-row>
          <b-form-group md="6" class="mb-3" label="Credit Card Number" label-for="credit_card_number">
            <b-form-input id="credit_card_number" :value="orderInfo.creditCardInfo.creditCardNumber" required pattern="\d{4}-\d{4}-\d{4}-\d{4}" placeholder="0000-0000-0000-0000"/>
          </b-form-group>
          <b-form-group md="2" class="mb-3" label="Month" label-for="credit_card_expiration_month">
            <b-select name="credit_card_expiration_month" id="credit_card_expiration_month" :value="orderInfo.creditCardInfo.creditCardExpirationMonth">
                <option value="1">January</option>
                <option value="2">February</option>
                <option value="3">March</option>
                <option value="4">April</option>
                <option value="5">May</option>
                <option value="6">June</option>
                <option value="7">July</option>
                <option value="8">August</option>
                <option value="9">September</option>
                <option value="10">October</option>
                <option value="11">November</option>
                <option value="12">December</option>
            </b-select>
          </b-form-group>
          <b-form-group md="2" class="mb-3" label="Year" label-for="credit_card_expiration_year">
            <b-select name="credit_card_expiration_year" id="credit_card_expiration_year" :value="orderInfo.creditCardInfo.creditCardExpirationYear">
                <option value="2020">2020</option>
                <option value="2021">2021</option>
                <option value="2022">2022</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <option value="2025">2025</option>
                <option value="2026">2026</option>
                <option value="2027">2027</option>
                <option value="2028">2028</option>
                <option value="2029">2029</option>
                <option value="2030">2030</option>
            </b-select>
          </b-form-group>
          <b-form-group md="2" class="mb-3" label="CVV" label-for="credit_card_cvv">
            <b-form-input id="credit_card_cvv" type="password" :value="orderInfo.creditCardInfo.cvv" required pattern="\d{3}" autocomplete="off"/>
          </b-form-group>
        </b-form-row>
        <b-form-row>
          <b-button variant="primary" @click="checkout">Place your order &rarr;</b-button>
        </b-form-row>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
import {mapGetters} from 'vuex'

export default {
  name: 'Checkout',
  computed: mapGetters({
    orderInfo: 'cart/orderInfo'
  }),
  methods: {
    checkout() {
      this.$store.dispatch('cart/checkout')
      this.$router.push("/order")
    }
  }
}
</script>