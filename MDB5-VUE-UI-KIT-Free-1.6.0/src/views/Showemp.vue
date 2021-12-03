<template>
  <div>
    <HelloWorld />
    <div class="space"></div>
    123
  </div>
</template>


<script>
//   import axios from "../../src/api/http_request";
import HelloWorld from "../components/HelloWorld";
import http from "../http-common";
export default {
  name: "Showemp",
  components: {
    HelloWorld,
  },

  data: () => ({
    emptypename: [],

    form: {
      firstname: "",
      lastname: "",
      salary: "",
      compent: 0,
      empTypeId: -1,
    },
  }),

  methods: {
    getEmptypename() {
      http
        .get("http://localhost:9000/api/employee")
        .then((type) => {
          console.log(type);
          this.emptypename = type.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
  },

  mounted() {
    console.log(1234), this.getEmptypename();
  },
};
</script>
<style scoped>
.space {
  margin-top: 100px;
}
</style>