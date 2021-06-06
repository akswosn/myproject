<template>
    <section class="page-section">
        <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Resume List</h2>
                    <h3 class="section-subheading text-muted">이력서 목록</h3>
                </div>
                <div class="container text-right">
                    <router-link to="/resume/regist">등록</router-link>
                </div>
                <hr/>
                <div class="row" v-if="resumeList.length > 0">
                    <!--
                    <div v-for="resume in resumeList" class="col-lg-4 col-sm-6 mb-4" >
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
                        </div>
                    </div>
                    -->
                   
                </div>
                <div class="text-center font-italic" v-else>
                    등록된 이력서가 존재하지 않습니다.
                </div>
            </div>
    </section>
</template>

<script>
export default {
  name: 'resume-view',
  data() {
      return {
          defaultResumNo : 1,
          resumeList : [],
          page : 1,
          listCount : 6,
          sort : "no"
      }
    },
    methods: {
        //resume 목록조회
        getResumeList(){
            let param = {
                page : this.page,
                listCount : this.listCount,
                sort : this.sort
            };

            this.$http.get(this.ROOT_URL+`/api/resume`,{crossDomain: true, params:param})
            .then((result) => {
                console.log(result)
                this.resumeList = result.data;

            }).catch(function (error) {
                console.log('error', error);
            })
        }
    },
    mounted(){
        if(this.$storage.getItem('userNo') == null){
            this.$router.push('/resume/view/'+this.defaultResumNo);
        }

        //resume list 조회
        this.getResumeList();
    }
 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>