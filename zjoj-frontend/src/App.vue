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
import BasicLayout from "@/layouts/BasicLayout";
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
</script>
