<template>
    <div class="page_wrap">
        <h1>My Project Main(공사중)</h1>
        <div class="myself">
          <a href="https://github.com/akswosn" target="_BLANK">github : https://github.com/akswosn</a><br/>
          <a href="mailto:email : akswosn@gmail.com" >email : akswosn@gmail.com</a>
        </div>
        <hr>
        
        <router-link to="/test">Go to TestAPI</router-link>
        
        <hr>
        <div class="sub_wrap">
          <ul class="list">
            <li class="list-item"><span>프로젝트 구상 : </span>개인 블로그 및 추후 도메인 연결</li>
            <li class="list-item"><span>환경 : </span>AWS[EC2, RDS], nginx, MariaDB</li>
            <li class="list-item"><span>개발 언어 및 framework : </span>spring-boot, JPA, vuejs</li>
          </ul>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Main',
  data () {
    return {
      
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
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.page_wrap {
  margin : 20px 50px;
}
.myself {
  text-align: right;
}
.sub_wrap .list {
  margin : 20px 240px;
}
.list  li {
  display: block;
  margin : 10px 0;
  text-align: left;
}
.list .list-title {
  font-size: 22px;
  font-weight: bold;
  text-align: center;
}
.list .list-item span{
  display: inline-block;
  text-align: right;
  width:200px;
  font-weight: bold;
}
</style>