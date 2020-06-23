<template>
    <section class="page-section">
        <div class="login_wrap">
            
                <div class="form_wrap">
                <form @submit="onSubmit"  >
                   
                    
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">User ID:</span>
                        </div>
                        <input type="text" v-model="form.userid" class="form-control" placeholder="ID 를 입력하세요" aria-label="userid" >
                    </div>

                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="basic-addon1">Password:</span>
                        </div>
                        <input type="text" v-model="form.password" class="form-control" placeholder="********" aria-label="password" >
                    </div>

                    <div class="text-right">
                        <button type="submit" variant="primary" class="btn btn-primary">Login</button>
                    </div>
                   
                </form>
                </div>
          
        </div>
      </section>
</template>

<script>
export default {
  name: 'Login',
  data() {
      return {
          form: {
              userId: '',
              password : ''
          }
      }
    },
    methods: {
      onSubmit(evt) {
        evt.preventDefault()
        alert(JSON.stringify(this.form))
      },
    }
    /*
    computed: {
      validation() {
        return this.userId.length > 4 && this.userId.length < 13
      }
    }*/
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
    .form_wrap {
        width: 80%;
        margin :auto;
        padding:5% 3%;
    }
</style>