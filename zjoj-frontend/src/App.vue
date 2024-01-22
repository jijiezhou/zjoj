<template>
  <div id="app">
    <BasicLayout />
  </div>
</template>

<style>
#app {
}
</style>

<script setup lang="ts">
import BasicLayout from "@/layouts/BasicLayout.vue";
import { useRouter } from "vue-router";
import store from "@/store";
import { onMounted } from "vue";

/**
 * Global Entry function, code that only call once
 */
const doInit = () => {
  console.log("This is entry for whole project");
};

onMounted(() => {
  doInit();
});

const router = useRouter();

router.beforeEach((to, from, next) => {
  //If the page we want to go only for admin
  if (to.meta?.access === "canAdmin") {
    if (store.state.user.loginUser?.role !== "admin") {
      next("/noAuth");
      return;
    }
  }
  next();
});
</script>
