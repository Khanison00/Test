<template>
  <div>
    <HelloWorld />
    <div class="space"></div>
    <div class="container">
      <div class="row">
        <div class="col">ประเภท</div>
        <div class="col">
          <select
            v-model="form.empTypeId"
            class="browser-default custom-select"
          >
            <option disabled value="-1">เลือก</option>
            <option v-for="t in emptypename" :key="t.id" :value="t.id">
              {{ t.emptypename }}
            </option>
          </select>
        </div>
      </div>
      <div class="space"></div>
      <div class="row">
        <div class="col">ชื่อ</div>
        <div class="col">
          <div class="input-group mb-3">
            <input
              type="text"
              class="form-control"
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-default"
              v-model="form.firstname"
            />
          </div>
        </div>
      </div>
      <div class="space"></div>
      <div class="row">
        <div class="col">นามสกุล</div>
        <div class="col">
          <div class="input-group mb-3">
            <input
              type="text"
              class="form-control"
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-default"
              v-model="form.lastname"
            />
          </div>
        </div>
      </div>
      <div class="space"></div>
      <div class="row">
        <div class="col">อัตราเงินเดือน</div>
        <div class="col">
          <div class="input-group mb-3">
            <input
              type="text"
              class="form-control"
              aria-label="Sizing example input"
              aria-describedby="inputGroup-sizing-default"
              v-model="salary"
            />
          </div>
        </div>
      </div>
    </div>
    <button type="button" class="btn btn-primary" v-on="saveEmp()">Primary</button>
  </div>
</template>


<script>
//   import axios from "../../src/api/http_request";
import HelloWorld from "../components/HelloWorld";
import http from "../http-common";
export default {
  name: "Addemp",
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
        .get("http://localhost:9000/api/emptype")
        .then((type) => {
          console.log(type);
          this.emptypename = type.data;
        })
        .catch((e) => {
          console.log(e);
        });
    },
    saveEmp() {
      if (this.empTypeId == 1) {
        http
          .post(
            "http://localhost:9000/api/adds-on/" +
              this.form.firstname +
              "/" +
              this.form.lastname +
              "/" +
              this.form.emptypename +
              "/" +
              this.form.salary +
              "/" +
              this.form.compent
          )
          .catch((e) => {
            console.log(e);
            //  alert("บันทึกข้อมูลล้มเหลว");
            this.fall = true;
          });
      }
      else if (this.empTypeId == 2) {
        http
          .post(
            "http://localhost:9000/api/adds-on/" +
              this.form.firstname +
              "/" +
              this.form.lastname +
              "/" +
              this.form.emptypename +
              "/" +
              this.form.compent +
              "/" +
              this.form.salary
          )
          .catch((e) => {
            console.log(e);
            //  alert("บันทึกข้อมูลล้มเหลว");
            this.fall = true;
          });
      }
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