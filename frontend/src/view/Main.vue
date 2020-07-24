<template>
    <div class="page_wrap">
       
        
        <!-- Masthead-->
        <header class="masthead">
            <div class="container">
                <div class="masthead-heading">Welcome To Keun-su Blog</div>
                <div class="masthead-subheading">
                  <a href="https://github.com/akswosn" class="header-link" target="_blank">Git : https://github.com/akswosn</a>
                </div>
                <div class="masthead-subheading">
                  <a href="mailto:akswosn@gmail.com" class="header-link" target="_blank" >mail : akswosn@gmail.com</a>
                </div>
                <a class="btn btn-primary btn-lg text-uppercase js-scroll-trigger" href="/swagger-ui.html">Go to TestAPI</a>
                <router-link class="btn btn-primary btn-lg text-uppercase js-scroll-trigger" to="/#/resume">Go My Self</router-link>
            </div>
        </header>
         <!-- Portfolio Grid-->
        <section class="page-section bg-light">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">최신 블로그</h2>
                    <h3 class="section-subheading text-muted">최근 등록된 블로그 목록 <a href="#">더보기</a></h3>
                </div>
                <div class="row">
                    <div class="col-lg-4 col-sm-6 mb-4">
                      등록된 블로그가 존재하지 않습니다.
                      <!--
                        <div class="portfolio-item">
                            <a class="portfolio-link" data-toggle="modal" href="#portfolioModal1">
                                <div class="portfolio-hover">
                                    <div class="portfolio-hover-content"><i class="fas fa-plus fa-3x"></i></div>
                                </div>
                                <img class="img-fluid" src="assets/img/portfolio/01-thumbnail.jpg" alt="" />
                            </a>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">Threads</div>
                                <div class="portfolio-caption-subheading text-muted">Illustration</div>
                            </div>
                        </div>-->
                    </div>
                    
                </div>
            </div>
        </section>
      <!-- Summary 
      <section class="page-section">
      <div class="container summary">
        <div class="text-center">
        <span class="title">Summary Info</span>
        <hr>
        <ul class="list">
          <li class="list-item"><span>Git</span> <a href="https://github.com/akswosn" class="link" target="_blank">https://github.com/akswosn</a></li>
          <li class="list-item"><span>Mail</span> <a href="mailto:akswosn@gmail.com" class="link" target="_blank" >akswosn@gmail.com</a></li>
        </ul>
        </div>
      </div>
      </section>-->
      <!-- 대시보드 
      <div class="blog_list">
        <span class="title">최신 블로그</span>
        <span class="right"><a href="#">더보기</a></span>
        <hr>
        <span class="contents">데이터가 존재하지 않습니다.</span>  
      </div>-->
      
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
.header-link {
  color: #f5f5f5;
}
.header-link:hover{
  text-decoration: none;
}
.masthead-heading{
  color: #f5f5f5;
}
</style>