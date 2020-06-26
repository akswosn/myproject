// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import '@babel/polyfill'
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import VueSimpleAlert from "vue-simple-alert"
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
// import VeeValidate from 'vee-validate'
import 'jquery/dist/jquery.js'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.js'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import 'bootstrap-vue/dist/bootstrap-vue.js'

Vue.config.productionTip = false
Vue.prototype.$http = axios;
Vue.use(VueSimpleAlert);
// Install BootstrapVue
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)

//
Vue.prototype.ROOT_URL = "";
Vue.prototype.ROOT_URL = "http://localhost:8080";


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
