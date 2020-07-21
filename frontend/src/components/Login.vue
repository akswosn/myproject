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
                        <label for="userPwd" class="col-sm-2 col-form-label"  v-bind:class="{ 'text-danger' : !isValidUserPwd, 'text-success' : isValidUserPwd}" id="password_label">
                            Password*</label>
                        <div class="col-sm-8">
                            <input type="password" id="userPwd" name="userPwd" v-model="form.userPwd" class="form-control" placeholder="********" 
                            aria-label="password" v-bind:class="{ 'is-invalid' : !isValidUserPwd, 'is-valid' : isValidUserPwd}">
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
        isValidUserPwd : true,
        form: {
            userId: '',
            userPwd : ''
        },
        errors:{
            userId : null,
            userPwd : null,
        },
        class:{
            userId:[],
            userPwd:[]
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
        var self = this;

        if (!this.form.userId) {
            this.isValidUserId = false;
            this.errors.userId = "ID는 필수입니다.";
        }
        else {
            this.isValidUserId = true;
            this.errors.userId = null;
        }

        if (!this.form.userPwd) {
            this.isValidUserPwd = false;
            this.errors.userPwd = "비밀번호는 필수입니다.";
        }
        else {
             this.isValidUserPwd = true;
            this.errors.userPwd = null;
        }

        console.log(this.errors);
 
        if(this.errors.userId !=  null || this.errors.userPwd != null){
            return;
        }

        this.$http({
            method: 'post',
            url: this.ROOT_URL+'/api/login',
            headers: {}, 
            crossDomain: true,
            data: this.form

        }).then((result) => {
            console.log('result', result);
            if(result.data.code == 200){
                self.$storage.setItem("userNo", result.data.data.userNo);
                self.$storage.setItem("token", result.data.data.sessionKey);

                self.$parent.$children[0].loginCheck();
                self.$router.push('/');
            }
            else {
                self.$alert(result.data.message);
            }

        }).catch(function (error) {
            console.log('error', error);
        });

      },
    }, mounted() { 
        console.log("Child mounted");
        //
        this.$storage.clear();
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