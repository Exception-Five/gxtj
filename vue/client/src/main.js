// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import VueMeta from 'vue-meta'
// import './assets/css/activity.css'
// // import './assets/css/bootstrap.min.css'
// import './assets/css/dlzc.css'
// import './assets/css/ground.css'
// import './assets/css/login.css'
// import './assets/css/nanoscroller.css'
// import './assets/css/zzsc.css'
Vue.use(VueMeta)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
