<template>

  <div id="app">
    <!-- Top menu-->
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
                <!--
                <b-dropdown-item href="https://github.com/akswosn" class="link" >github : https://github.com/akswosn</b-dropdown-item>
                <b-dropdown-item href="mailto:email : akswosn@gmail.com" class="link">email : akswosn@gmail.com</b-dropdown-item>
                  -->
                <b-dropdown-item href="/#/login" class="login">login</b-dropdown-item>
              </b-nav-item-dropdown>
            </b-navbar-nav>
          </b-collapse>
        </b-navbar>
         
      </div>
    </header>

    
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
html, body, .page_wrap { height:100%; overflow:hidden }

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0px;height:100%; overflow:hidden;
}
.navbar .navbar-brand{
  font-weight: bold;
}
/**공통 CSS */
.right {
  display: inline-block;float: right;
}
</style>
