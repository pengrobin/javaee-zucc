package cn.edu.zucc.pb.ormapping.view;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-11 18:04
 */
public class LoginResult {
    private boolean isLogin;
    private String token;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
