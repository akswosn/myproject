import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export const UserStore = new Vuex.Store({

    state : {
        userId : '',
        userPwd : ''
    }
});