<template>
    <section class="page-section">
        <header class="masthead" 
            :style="{ backgroundImage: 'url(' + require(`@/assets/img/portfolio/06-full.jpg`) + ')'}"
        >
            <div class="overlay"></div>
            <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                <div class="post-heading">
                    <h1>Blog Title</h1>
                    <h2 class="subheading">블로그 sub title</h2>
                    <span class="meta">블로그 summary</span>
                </div>
                </div>
            </div>
            </div>
        </header>
        <div class="container main-content">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <p>
                        블로그 Contents 입니다. <br>
                        등록시 스마트 에디터 이용할 예정이구요<br>
                        이미지도 넣을수 있게 할거구요<br>
                        태그는 당연히 넣을거이구요
                    </p>
                </div>
            </div>

            
        </div>

        <div class="commant_wrap">
            <!-- Comments Form -->
            <div class="card my-4">
                <h5 class="card-header">Leave a Comment:</h5>
                <div class="card-body">
                    <form>
                    <div class="form-group">
                        <textarea class="form-control" rows="3"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>

            <!-- Single Comment -->
            <div class="media mb-4">
                <img class="d-flex mr-3 rounded-circle" src="@/assets/img/50x50.png" alt="">
                <div class="media-body">
                    <h5 class="mt-0">댓글러</h5>
                    댓글입니다.
                </div>
            </div>

            <!-- Comment with nested comments -->
            <div class="media mb-4">
            <img class="d-flex mr-3 rounded-circle" src="@/assets/img/50x50.png" alt="">
                <div class="media-body">
                    <h5 class="mt-0">댓글러</h5>
                    댓글입니다.
                    <div class="media mt-4">
                        <img class="d-flex mr-3 rounded-circle" src="@/assets/img/50x50.png" alt="">
                        <div class="media-body">
                            <h5 class="mt-0">댓글러</h5>
                            댓글입니다.
                        </div>
                    </div>

                    <div class="media mt-4">
                        <img class="d-flex mr-3 rounded-circle" src="@/assets/img/50x50.png" alt="">
                        <div class="media-body">
                            <h5 class="mt-0">댓글러</h5>
                            댓글입니다.
                        </div>
                    </div>
                </div>
            </div>
        </div>

    

        
    </section>
</template>

<script>
export default {
  name: 'blog-main',
  data() {
      return {

      }
    },
    methods: {

    }
 
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.page-section {
    padding : 0;
}
.main-content {
    margin: 40px 0;
}

.commant_wrap {
    margin: 30px auto;
    
}
</style>