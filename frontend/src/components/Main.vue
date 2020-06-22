<template>
    <div class="page_wrap">
        <h3>My Project Main(공사중)</h3>
        <router-link to="/test">Go to TestAPI</router-link>
        
      <!-- Summary -->
      <div class="summary">
        <span class="title">Summary Info</span>
        <hr>
        <ul class="list">
          <li class="list-item"><span>Git</span> <a href="https://github.com/akswosn" class="link" target="_blank">https://github.com/akswosn</a></li>
          <li class="list-item"><span>Mail</span> <a href="mailto:akswosn@gmail.com" class="link" target="_blank" >akswosn@gmail.com</a></li>
          <!--
          <li class="list-item"><span>프로젝트 구상 : </span>개인 블로그 및 추후 도메인 연결</li>
          <li class="list-item"><span>환경 : </span>AWS[EC2, RDS], nginx, MariaDB</li>
          <li class="list-item"><span>개발 언어 및 framework : </span>spring-boot, JPA, vuejs</li>
          -->
        </ul>
      </div>
      
      <!-- 대시보드 -->
      <div class="blog_list">
        <span class="title">최신 블로그</span>
        <span class="right"><a href="#">더보기</a></span>
        <hr>
        <span class="contents">데이터가 존재하지 않습니다.</span>  
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
  font-weight: bold;
}

.blog_list, .summary {
  text-align: left;
  padding: 15px 0;
}
.blog_list .title, .summary .title{
  font-weight: bold;font-style: italic;
}
</style>