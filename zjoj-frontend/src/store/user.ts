// initial state
import { StoreOptions } from "vuex";
import { UserControllerService } from "../../generated";
import ACCESS_ENUM from "@/access/accessEnum";

export default {
  namespaced: true,
  state: () => ({
    loginUser: {
      userName: "not_login",
    },
  }),
  actions: {
    async getLoginUser({ commit, state }, payload) {
      //get loginUser from backend
      const res = await UserControllerService.getLoginUserUsingGet();
      //success
      if (res === 0) {
        commit("updateUser", payload);
      } else {
        commit("updateUser", {
          ...state.loginUser,
          userRole: ACCESS_ENUM.NOT_LOGIN,
        });
      }
    },
  },
  mutations: {
    updateUser(state, payload) {
      state.loginUser = payload;
    },
  },
} as StoreOptions<any>;
