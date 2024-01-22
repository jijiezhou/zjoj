// initial state
import { StoreOptions } from "vuex";

export default {
  namespaced: true,
  state: () => ({
    loginUser: {
      userName: "not_login",
    },
  }),
  actions: {
    async getLoginUser({ commit, state }, payload) {
      //console.log("getLoginUser action called with payload:", payload);
      commit("updateUser", payload);
    },
  },
  mutations: {
    updateUser(state, payload) {
      state.loginUser = payload;
    },
  },
} as StoreOptions<any>;
