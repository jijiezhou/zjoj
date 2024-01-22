<template>
  <div class="admin">
    <a>This is Admin Page</a>
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js + TypeScript App + AdminView" />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import HelloWorld from "@/components/HelloWorld.vue"; // @ is an alias to /src

export default defineComponent({
  name: "AdminView",
  components: {
    HelloWorld,
  },
});
</script>
