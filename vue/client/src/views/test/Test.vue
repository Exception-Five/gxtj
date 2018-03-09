
<template>
  <section>
      <h3>Options of component.</h3>
    <br>
    <label>
    <input type="text" v-model="maxToasts">
    maxToasts
  </label>
    <br>
    <label>
    <input type="text" v-model="position">
    position
  </label>

    <hr>

    <h3>Options of toast.</h3>
    <label>
    <input type="text" v-model="theme">
    theme
  </label>
    <br>
    <label>
    <input type="text" v-model="timeLife">
    timeLife
  </label>
    <br>
    <label>
    <input type="checkbox" v-model="closeBtn">
    closeBtn
  </label>
    <hr>

    <button type="button" name="button" @click="showTime">SHOW TIME</button>
    <button type="button" name="button" @click="closeAll">Close all</button>
    <vue-toast ref='toast'></vue-toast>
  </section>
</template>

<script>
import 'vue-toast/dist/vue-toast.min.css'
import VueToast from 'vue-toast'
export default {
  data() {
    return {
      maxToasts: 6,
        position: 'bottom right',
        theme: 'error',
        timeLife: 3000,
        closeBtn: true,
    }
  },
  watch: {
      'delayOfJumps': 'resetOptions',
      'maxToasts': 'resetOptions',
      'position': 'resetOptions'
   },
   mounted() {
        this.resetOptions()
      },
  methods: {
        resetOptions() {
          this.$refs.toast.setOptions({
            delayOfJumps: this.delayOfJumps,
            maxToasts: this.maxToasts,
            position: this.position
          })
        },
        showTime() {
          this.$refs.toast.showToast(new Date, {
            theme: this.theme,
            timeLife: this.timeLife,
            closeBtn: this.closeBtn
          })
        },
        closeAll() {
          this.$refs.toast.closeAll()
        }
      },
      components: {
        VueToast
      }
}
</script>
