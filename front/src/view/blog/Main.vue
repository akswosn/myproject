<template>
    <section class="page-section">
        <div class="container">
            <div class="text-center">
                <h2 class="section-heading text-uppercase">KS Blog (퍼플리싱)</h2>
                <h3 class="section-subheading text-muted">최근 등록순</h3>
            </div>
        </div>
        <div class="row">

            <div class="col-md-4 container">
                <!-- Search Widget -->
                <div class="card my-4">
                <h5 class="card-header">Search</h5>
                <div class="card-body">
                    <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-append">
                        <button class="btn btn-secondary" type="button">Go!</button>
                    </span>
                    </div>
                </div>
                </div>

                <!-- Categories Widget -->
                <div class="card my-4 category">
                    <h5 class="card-header">Categories</h5>
                    <div class="card-body">
                        <div class="row">
                        <div class="col-lg-6">
                            <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#">Web Design</a>
                            </li>
                            <li>
                                <a href="#">HTML</a>
                            </li>
                            <li>
                                <a href="#">Freebies</a>
                            </li>
                            </ul>
                        </div>
                        <div class="col-lg-6">
                            <ul class="list-unstyled mb-0">
                            <li>
                                <a href="#">JavaScript</a>
                            </li>
                            <li>
                                <a href="#">CSS</a>
                            </li>
                            <li>
                                <a href="#">Tutorials</a>
                            </li>
                            </ul>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-8 container">
                

                <div class="row" id="portfolio">
                    <div class="col-lg-4 col-sm-6 mb-4">
                        <div class="portfolio-item">
                            <router-link to="blog/view/1" class="portfolio-link" >
                                
                                <img class="img-fluid" src="@/assets/img/portfolio/01-thumbnail.jpg" alt="" />
                            </router-link>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">Blog1</div>
                                <div class="portfolio-caption-subheading text-muted">Blog1...</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 mb-4">
                        <div class="portfolio-item">
                            <router-link to="blog/view/1" class="portfolio-link" >
                                
                                <img class="img-fluid" src="@/assets/img/portfolio/02-thumbnail.jpg" alt="" />
                            </router-link>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">Blog2</div>
                                <div class="portfolio-caption-subheading text-muted">Blog2 ...</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 mb-4" >
                        <div class="portfolio-item">
                            <router-link to="blog/view/1" class="portfolio-link" >
                                
                                <img class="img-fluid" src="@/assets/img/portfolio/03-thumbnail.jpg" alt="" />
                            </router-link>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">Blog3</div>
                                <div class="portfolio-caption-subheading text-muted">Blog3....</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 mb-4 mb-lg-0" >
                        <div class="portfolio-item">
                            <router-link to="blog/view/1" class="portfolio-link" >
                                
                                <img class="img-fluid" src="@/assets/img/portfolio/04-thumbnail.jpg" alt="" />
                            </router-link>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">Blog4</div>
                                <div class="portfolio-caption-subheading text-muted">Blog4....</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 mb-4 mb-sm-0">
                        <div class="portfolio-item">
                            <router-link to="blog/view/1" class="portfolio-link" >
                                
                                <img class="img-fluid" src="@/assets/img/portfolio/05-thumbnail.jpg" alt="" />
                            </router-link>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">Blog5</div>
                                <div class="portfolio-caption-subheading text-muted">Blog5....</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6">
                        <div class="portfolio-item">
                            <router-link to="blog/view/1" class="portfolio-link" >
                                
                                <img class="img-fluid" src="@/assets/img/portfolio/06-thumbnail.jpg" alt="" />
                            </router-link>
                            <div class="portfolio-caption">
                                <div class="portfolio-caption-heading">Blog6</div>
                                <div class="portfolio-caption-subheading text-muted">Blog6....</div>
                            </div>
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
.category a {
    color : black;
}
</style>