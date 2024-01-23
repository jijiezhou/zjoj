<template>
  <div id="app">
    <template v-if="route.path.startsWith('/user')">
      <router-view />
    </template>
    <template v-else>
      <BasicLayout />
    </template>
  </div>
</template>

<style>
#app {
}
</style>

<script setup lang="ts">
import BasicLayout from "@/layouts/BasicLayout";
import { useRoute, useRouter } from "vue-router";
import { onMounted } from "vue";

const route = useRoute();

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
