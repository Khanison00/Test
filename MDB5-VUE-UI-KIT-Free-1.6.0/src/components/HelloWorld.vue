<template>
  <div>
    <nav class="navbar navbar-expand-lg navbar-light bg-dark">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0"></ul>
        <div class="my-2 my-lg-0">
          <a href="http://192.168.1.9:8080/#/addemp" class="a btn text-light">Add employee</a>
          <a href="http://192.168.1.9:8080/#/showemp" class="btn text-light">Show employee</a>  
        </div>

        
      </div>
    </nav>
  </div>
</template>

<script>


export default {
  name: "HelloWorld",
  components: {
  },
  props: {
    msg: String,
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.fw-900 {
  font-weight: 900;
}
</style>
