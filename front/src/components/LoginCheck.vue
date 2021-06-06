<template>
  <div></div>
</template>

<script>
//로그인 체크 컴포넌트
export default {
  name: 'LoginCheck',
  data () {
    return {
      session : {
        userNo : 0,
        sessionKey : null
      }
    }
  },
  methods : {
    loginCheck : function(){
        var self = this;
        
        console.log('loginCheck', self.$storage.getItem('userNo'));
        console.log('loginCheck', self.$storage.getItem('token')); 

       if(this.$storage.getItem('userNo') != null && this.$storage.getItem('token') != null){
            this.session.userNo = this.$storage.getItem('userNo');
            this.session.sessionKey = ''+this.$storage.getItem('token');

            console.log('this.session', this.session);

            this.$http({
                method: 'post',
                url: this.ROOT_URL+'/api/login/check',
                crossDomain: true,
                data: this.session

            }).then((result) => {
                console.log(result);

                if(result.data.code != 200){
                    self.$storage.clear();
                    self.$parent.hasLogin = false;
                }
                else { console.log(self.$parent);
                    self.$parent.hasLogin =true;
                }
                
            }).catch(function (error) {
                console.log(error)
            });
       }
       else {
           this.$storage.clear();
       }
    }
  },
  mounted(){
    this.loginCheck();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>