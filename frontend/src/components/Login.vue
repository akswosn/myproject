<template>
    <section class="page-section">
        <div class="login_wrap">
                <div class="form_wrap">
                <form @submit="onSubmit"  >
                   
                    
                    <div class="form-group row">
                        
                        <label for="userId" class="col-sm-2 col-form-label" id="userid_label" v-bind:class="{ 'text-danger' : !isValidUserId, 'text-success' : isValidUserId}">
                            User ID*</label>
                        <div class="col-sm-8">
                            <input type="text" id="userId" name="userId" v-model="form.userId" class="form-control" placeholder="ID 를 입력하세요" 
                            aria-label="userId" v-bind:class="{ 'is-invalid' : !isValidUserId, 'is-valid' : isValidUserId}">
                         </div>
                        
                    </div>
                    <p class="text-danger" v-show="errors.userId">
                        {{errors.userId}}
                    </p>
                    <div class="form-group row">
                        <label for="password" class="col-sm-2 col-form-label"  v-bind:class="{ 'text-danger' : !isValidPassword, 'text-success' : isValidPassword}" id="password_label">
                            Password*</label>
                        <div class="col-sm-8">
                            <input type="password" id="password" name="password" v-model="form.password" class="form-control" placeholder="********" 
                            aria-label="password" v-bind:class="{ 'is-invalid' : !isValidPassword, 'is-valid' : isValidPassword}">
                         </div>
                        
                    </div>
                    <p class="text-danger" v-show="errors.password">
                        {{errors.password}}
                    </p>

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
        isValidUserId : true,
        isValidPassword : true,
        form: {
            userId: '',
            password : ''
        },
        errors:{
            userId : null,
            password : null,
        },
        class:{
            userId:[],
            password:[]
        }
      }
    },
    
    methods: {
      onSubmit(evt) {
        // const validForm = await this.$validator.validateAll()
        // if(!validForm) {
        //     return this.$alert("내용을 한번 더 확인해주세요");
        // }

        evt.preventDefault()
        console.log(JSON.stringify(this.form));
        //초기화

        if (!this.form.userId) {
            this.isValidUserId = false;
            this.errors.userId = "ID는 필수입니다.";
        }
        else {
            this.isValidUserId = true;
            this.errors.userId = null;
        }

        if (!this.form.password) {
            this.isValidPassword = false;
            this.errors.password = "비밀번호는 필수입니다.";
        }
        else {
             this.isValidPassword = true;
            this.errors.password = null;
        }


 
        if(this.errors.userId !=  null || this.errors.password != null){
            return;
        }

        this.$http({
            method: 'post',
            url: '/api/login',
            headers: {}, 
            crossDomain: true,
            data: this.form

        }).then((result) => {
            console.log('result', result);

        }).catch(function (error) {
            console.log('error', error);
        });

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