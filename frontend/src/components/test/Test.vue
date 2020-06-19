<template>
    <div>
        <h1>Test API Page</h1>
        <a v-on:click="goback" href="#">Go to Main</a>
        <hr>
        
        <ul>
          <li>
            <strong>1.[GET] /api/test <a v-on:click="apiGetAll" href="#">action</a>  </strong>
            <hr>
            <div class="result"  v-if="api1Result">

              <div v-for="test in api1_result" v-bind:key="test.id">
                {{test.id}}. {{test}} <br>
              </div>
            </div>

            <div class="error" v-if="api1_err">
              {{api1_err}}
            </div>

          </li>
          <li>
            <strong>2.[GET] /api/test/<input id="api2_id" name="api2_id" v-model="api2_id"/><a v-on:click="apiGetOne" href="#">action</a>  </strong>
            <hr>
            <div class="result"  v-if="api2Result">
                {{api2_result}}
            </div>
            <div class="error" v-if="api2_err">
              {{api2_err}}
            </div>
          </li>
          <li>
            <strong>3.[POST] [등록] /api/test  <a v-on:click="apiPost" href="#">action</a> </strong> 
            <hr>
            이름 : <input type="text" v-model="api3_test.name">
            내용 : <input type="text" v-model="api3_test.contents">
            <div class="result"  v-if="api3Result">
                {{api3_result}}
            </div>
            <div class="error" v-if="api3_er">
              {{api3_err}}
            </div>
          </li>
          <li>
            <strong>4.[PUT] [수정] /api/test/<input id="api4_id" name="api4_id" v-model="api4_id"/> <a v-on:click="apiPut" href="#">action</a> </strong> 
            <hr>
            이름 : <input type="text" v-model="api4_test.name">
            내용 : <input type="text" v-model="api4_test.contents">
            <hr>
            <div class="result"  v-if="api4Result">
                {{api4_result}}
            </div>
            <div class="error" v-if="api4_err">
              {{api4_err}}
            </div>
          </li>
          <li>
            <strong>5.[DELETE] [삭제] /api/test/<input id="api5_id" name="api5_id" v-model="api5_id"/> <a v-on:click="apiDelete" href="#">action</a></strong> 
            <hr>
            <div class="result"  v-if="api5Result">
                DELETE BY DATA = {{api5_result}}
            </div>
            <div class="error" v-if="api5_err">
              {{api5_err}}
            </div>
          </li>
        </ul>

        <hr>
        <div class="summary">
          (개인블로그) Summary (작업작업 ...)<br>
          --------------------------<br>
          <strong>06-18.</strong> <br>
          &nbsp;&nbsp;- AWS[RDS, EC2] 설치 및 설정(인바운드설정 DB, OS 및 보안그룹 설정)<br>
          &nbsp;&nbsp;- nginx proxy  설정 및 spring boot 연동<br>
          <strong> 06-19. </strong>[TEST API] REST CRUD 배포.<br>
          &nbsp;&nbsp;- 트랜젝션 설정 작업 진행중...<br>
          &nbsp;&nbsp;- 외부 yaml 설정 진행중...<br>
          &nbsp;&nbsp;- 인증키(API) 관련.. 작업 진행중..<br>
          <strong>06-20(21). </strong><br>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Test',
  data () {
    return {
      //GET objects
      api1_result:[],
      api2_result:{},
      api2_id: '',
      api3_test : {
        name : '',
        contents:''
      },
      api3_result : {},
      api4_id:'',
      api4_test : {
        name : '',
        contents:''
      },
      api4_result : {},
      api5_id:'',
      api5_result : {},
      //
      api1_err : null,
      api2_err : null,
      api3_err : null,
      api4_err : null,
      api5_err : null,
    }
  },
  methods:{
    goback(){
      this.$router.go(-1)
    },
    apiGetAll(){
      var self = this;
      console.log('apiGetAll');
      this.$http.get(`/api/test`)
      .then((result) => {
        console.log(result)
        this.api1_result = result.data;
        this.api1_err = null
      }).catch(function (error) {
        self.api1_err = error;
      })

    },
    apiGetOne(){
      var self = this;
      if(this.api2_id != ''){
        this.$http.get(`/api/test/`+this.api2_id)
        .then((result) => {
          console.log(result)
          this.api2_result = result.data;
          this.api2_err = null
        }).catch(function (error) {
        self.api2_err = error;
      })
      } else {
        this.$alert("조회할 값이 없어용..");
      }
    },
    apiPost(){
      var self = this;
      console.log('apiPost');
      if(this.api3_test.name == '' ){
        this.$alert("이름 값이 없어용..");
        return;
      }
      if(this.api3_test.contents == '' ){
        this.$alert("내용 값이 없어용..");
        return;
      }

      this.$http({
        method: 'post',
        url: '/api/test',
        headers: {}, 
        data: this.api3_test

      }).then((result) => {
        console.log(result)
        this.api3_result = result.data;
        this.api3_err = null
        this.apiGetAll();
      }).catch(function (error) {
        self.api3_err = error;
      });

    },
    apiPut(){
      console.log('apiPut');
       if(this.api4_test.name == '' ){
        this.$alert("이름 값이 없어용..");
        return;
      }
      if(this.api4_test.contents == '' ){
        this.$alert("내용 값이 없어용..");
        return;
      }
      if(this.api4_id == ''){
        this.$alert("변경할 기본 값이 없어용..");
        return;
      }
      var self = this;
      this.$http({
        method: 'put',
        url: '/api/test/'+this.api4_id,
        headers: {}, 
        data: this.api4_test
      }).then((result) => {
        console.log(result)
        this.api4_result = result.data;
        this.api4_err = null
        this.apiGetAll();
      }).catch(function (error) {
        self.api4_err = error;
      });
    },
    apiDelete(){
      console.log('delete');
      if(this.api5_id == ''){
        this.$alert("삭제할 기본 값이 없어용..");
        return;
      }
      var self = this;
      this.$http({
        method: 'delete',
        url: '/api/test/'+this.api5_id,
        headers: {}, 
      }).then((result) => {
        console.log(result)
        this.api5_result = result.data;
        this.api5_err = null
        this.apiGetAll();
      })
      .catch(function (error) {
        self.api5_err = error;
      })
    }
  },
  //life cycle
  computed: {
    api1Result: function () {
      return this.api1_result.length > 0
    },
    api2Result: function() {
      return Object.keys(this.api2_result).length !== 0
    },
    api3Result: function() {
      return Object.keys(this.api3_result).length !== 0
    },
    api4Result: function() {
      return Object.keys(this.api4_result).length !== 0
    },
    api5Result: function() {
      return Object.keys(this.api5_result).length !== 0
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
  margin: 0% 5%;
}
li {
  display: block;
  margin: 20px 10px;
  text-align: left;
}
a {
  color: #42b983;
}
.summary {
  text-align: left;
}
.result {
  background-color: beige;
}
.error {
  background-color : #efb1b1;
}
</style>