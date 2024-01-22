import ACCESS_ENUM from "@/access/accessEnum";

/**
 * checkAccess: check if current user has permission or not
 * @param loginUser: current login user
 * @param needAccess: permission need
 * @return boolean
 */
const checkAccess = (loginUser: any, needAccess = ACCESS_ENUM.NOT_LOGIN) => {
  //get permission of current user(no loginUser -> not login)
  const loginUserAccess = loginUser?.userRole ?? ACCESS_ENUM.NOT_LOGIN;
  //if don't need any permission
  if (needAccess === ACCESS_ENUM.NOT_LOGIN) {
    return true;
  }
  //just need user to login
  if (needAccess === ACCESS_ENUM.USER) {
    //if user not login
    if (loginUserAccess === ACCESS_ENUM.NOT_LOGIN) return false;
  }

  //need admin permission
  if (needAccess === ACCESS_ENUM.ADMIN) {
    //if current user not admin
    if (loginUserAccess !== ACCESS_ENUM.ADMIN) return false;
  }
  return true;
};

export default checkAccess;
