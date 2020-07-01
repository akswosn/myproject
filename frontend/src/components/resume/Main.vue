<template>
    <section class="page-section">
        <h3> Resume Page</h3>

        <b-button> 등록 </b-button>
    </section>
</template>

<script>
export default {
  name: 'resume-view',
  data() {
      return {

      }
    },
    methods: {

    },
    mounted(){
        if(this.$storage.getItem('userNo') != null){
            this.$router.push('/resume/view/1');
        }
    }
 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>