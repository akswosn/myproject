<template>

  <div id="app">
    <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand js-scroll-trigger" href="/">
                  Ks Blog
                </a>
                <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar">
                    Menu
                    <i class="fas fa-bars ml-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbar">
                    <ul class="navbar-nav text-uppercase ml-auto">
                      <!--
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#services">Services</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#portfolio">Portfolio</a></li>
                      -->
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="/#/blog">Blog</a></li>
                        <li class="nav-item"><a class="nav-link js-scroll-trigger" href="/#/resume">Resume</a></li>
                        <li class="nav-item" v-if="!hasLogin"><a class="nav-link js-scroll-trigger" href="/#/login">Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        


    <!-- Top menu
    <header> 
      <div>        
        <b-navbar type="dark" variant="dark">
          <b-navbar-brand href="/">Ks Blog</b-navbar-brand>

          <b-collapse id="nav-collapse" is-nav>
            <b-navbar-nav>
              <b-nav-item href="#">Blog</b-nav-item>
              <b-nav-item href="#">Resume</b-nav-item>
            </b-navbar-nav>
            <b-navbar-nav class="ml-auto">
              <b-nav-item-dropdown right>
                <template v-slot:button-content>
                  <em>Login</em>
                </template>
                
                <b-dropdown-item href="/#/login" class="login">login</b-dropdown-item>
              </b-nav-item-dropdown>
            </b-navbar-nav>
          </b-collapse>
        </b-navbar>
         
      </div>
    </header>-->
    <router-view/>
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <ul class="list-inline text-center">
                        <li class="list-inline-item">
                        <a href="#">
                            <span class="fa-stack fa-lg">
                            <i class="fas fa-circle fa-stack-2x"></i>
                            <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                            </span>
                        </a>
                        </li>
                        <li class="list-inline-item">
                        <a href="#">
                            <span class="fa-stack fa-lg">
                            <i class="fas fa-circle fa-stack-2x"></i>
                            <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                            </span>
                        </a>
                        </li>
                        <li class="list-inline-item">
                        <a href="#">
                            <span class="fa-stack fa-lg">
                            <i class="fas fa-circle fa-stack-2x"></i>
                            <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                            </span>
                        </a>
                        </li>
                    </ul>
                    <p class="copyright text-muted">Copyright &copy; Your Website 2020</p>
                </div>
            </div>
        </div>
    </footer>
    <LoginCheckComponent></LoginCheckComponent>
  </div>
</template>

<script>
import LoginCheckComponent from './components/LoginCheck'


export default {
  name: 'App',
  components: { LoginCheckComponent },
  data() {
      return {
        hasLogin: false
      }
  },
  method:{

  }
}
</script>
<style src="./assets/css/styles.css"></style>
<style>
/** 
html, body, .page_wrap { height:100%; overflow:hidden;  }

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;height:100%; overflow:hidden;overflow-y: scroll;
}
.navbar .navbar-brand{
  font-weight: bold;
}*/
/**공통 CSS */
 .list-inline-item A {
    color: black;
}
</style>
