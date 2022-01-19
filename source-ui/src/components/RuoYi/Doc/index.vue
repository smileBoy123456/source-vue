<template>
  <div>
    <svg-icon icon-class="question" @click="goto" />
  </div>
</template>

<script>
export default {
  name: "RuoYiDoc",
  data() {
    return {
      url: "8.136.213.245",
    };
  },
  methods: {
    goto() {
      window.open(this.url);
    },
  },
};
</script>
