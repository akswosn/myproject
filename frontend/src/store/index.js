import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

import userStore from '@/store/UserStore.js'


const store = new Vuex.Store({
  modules: {
    userStore : userStore
  }
})

export default store