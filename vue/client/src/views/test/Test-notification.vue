<template>
   <section>
      <button @click="showSuccessMsg">showSuccessMsg</button>
      <button @click="showInfoMsg">showInfoMsg</button>
      <button @click="showWarnMsg">showWarnMsg</button>
      <button @click="showErrorMsg">showErrorMsg</button>
   </section>
</template>

<script>
import VueNotifications from 'vue-notifications'
export default {
  name: 'MyComponent',
  data () {
    return {}
  },
  notifications: {
    showSuccessMsg: {
      type: VueNotifications.types.success,
      title: 'Hello there',
      message: 'That\'s the success!'
    },
    showInfoMsg: {
      type: VueNotifications.types.info,
      title: 'Hey you',
      message: 'Here is some info for you'
    },
    showWarnMsg: {
      type: VueNotifications.types.warn,
      title: 'Wow, man',
      message: 'That\'s the kind of warning'
    },
    showErrorMsg: {
      type: VueNotifications.types.error,
      title: 'Wow-wow',
      message: 'That\'s the error'
    }
  }
}
</script>
<style>

</style>
