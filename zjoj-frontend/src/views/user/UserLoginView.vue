<template>
  <div id="userLoginView">
    <h2 style="margin-bottom: 16px">User Login</h2>
    <a-form
      style="max-width: 480px; margin: 0 auto"
      label-align="left"
      auto-label-width
      :model="form"
      @submit="handleSubmit"
    >
      <a-form-item field="userAccount" label="account">
        <a-input
          v-model="form.userAccount"
          placeholder="please enter account"
        />
      </a-form-item>
      <a-form-item
        field="userPassword"
        tooltip="password digit no less then 8"
        label="password"
      >
        <a-input-password
          v-model="form.userPassword"
          placeholder="please enter password"
        />
      </a-form-item>
      <a-form-item>
        <a-button type="primary" html-type="submit" style="width: 120px">
          Login
        </a-button>
      </a-form-item>
    </a-form>
  </div>
</template>

<script setup lang="ts">
import { reactive } from "vue";
import { UserControllerService, UserLoginRequest } from "../../../generated";
import message from "@arco-design/web-vue/es/message";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

/**
 * form info
 */
const form = reactive({
  userAccount: "",
  userPassword: "",
} as UserLoginRequest);

const router = useRouter();
const store = useStore();

/**
 * submit form
 * @param data
 */
const handleSubmit = async () => {
  const res = await UserControllerService.userLoginUsingPost(form);
  //login success -> redirect to main page + getLoginUserInfo
  if (res.code === 0) {
    await store.dispatch("user/getLoginUser");
    router.push({
      path: "/",
      replace: true,
    });
    message.success("Login success" + res.message);
  } else {
    message.error("Login fail, " + res.message);
  }
};
</script>
