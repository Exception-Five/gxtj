import Vue from 'vue'
import App from './App'
import router from './router'
import VueMeta from 'vue-meta'
import Notify from 'vue2-notify'
import VueNotifications from 'vue-notifications'
import Noty from 'noty'
import './assets/css/noty.css'
import vueCropper from './components/cropper/vueCropper.vue'
Vue.use(VueMeta)
Vue.config.productionTip = false

// Use Notify
Vue.use(Notify)

//Use Notification

function toast ({title, message, type, timeout, cb}) {
  if (type === VueNotifications.types.warn) type = 'warning'
  return new Noty({text: message, timeout, type}).show()
}
const options = {
  success: toast,
  error: toast,
  info: toast,
  warn: toast
}

Vue.use(VueNotifications, options)


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
