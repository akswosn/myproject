<template>
    <div class="page_wrap">
        <div class="login_wrap">
            <span class="title">login</span>
            <b-form  @submit.stop.prevent>
            <label for="user_id">User ID <span>*</span></label>
            <b-input v-model="userId" :state="validation" id="user_id"></b-input>
            <!--
            <b-form-invalid-feedback :state="validation">
                Your user ID must be 5-12 characters long.
            </b-form-invalid-feedback>
            -->

            
            <label for="password">Password <span>*</span></label>
            <b-input v-model="password" :state="validation" id="password"></b-input>
            <!--
            <b-form-invalid-feedback :state="validation">
                Your user ID must be 5-12 characters long.
            </b-form-invalid-feedback>
            -->

            </b-form>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Login',
  data() {
      return {
        userId: '',
        password : ''
      }
    },
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
    .login_wrap {
        text-align: left;
        margin:20% 0;
        margin: auto;
        background-color: darkslategray;
        color: white;
        height: 100%;
        
    }
    .login_wrap .title {
        font-weight: bold; text-align: center;
        font-size: 22px;
        display: block;
        padding: 10px 0;
    }
    .login_wrap input {
        width: 60%;
        display: inline-block;
        border: 0;
    }
    .login_wrap label {
        width: 30%; font-weight: bold;
        display: inline-block;
        border: 0;
    }
</style>