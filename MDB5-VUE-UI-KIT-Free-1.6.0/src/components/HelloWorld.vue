<template>
  <label>ประเภทสัมภาระ</label>
  <select v-model="form.Emptype" class="browser-default custom-select"></select>
</template>

<script>
import http from "../http-common";

export default {
  name: "HelloWorld",

  components: {},
  props: {
    msg: String,
  },
  data: () => ({
    emptypename: [],
    form: {
      Emptype: -1,
    },
  }),

  methods: {
    getEmptypename() {
      http
        .get("http://localhost:9000/api/emptype")
        .then(bag => {
          console.log(bag);
        })
      console.log("123");
      
    },
  },

  mounted() {
    console.log("123");
    this.getEmptypename();
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.fw-900 {
  font-weight: 900;
}
</style>
