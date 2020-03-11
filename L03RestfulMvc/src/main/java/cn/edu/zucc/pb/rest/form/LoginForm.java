package cn.edu.zucc.pb.rest.form;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-11 18:01
 */
public class LoginForm {
    private String loginName;
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
