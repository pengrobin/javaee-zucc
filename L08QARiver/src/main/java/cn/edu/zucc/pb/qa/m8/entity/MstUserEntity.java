package cn.edu.zucc.pb.qa.m8.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-14 16:03
 */
@Entity
@Table(name = "mst_user", schema = "zuccqa", catalog = "")
public class MstUserEntity {
    private int sid;
    private String loginname;
    private String password;
    private String sno;
    private String name;
    private String userType;
    private String email;
    private String cellPhone;

    @Id
    @Column(name = "sid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "loginname")
    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "sno")
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "cell_phone")
    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MstUserEntity that = (MstUserEntity) o;
        return sid == that.sid &&
                Objects.equals(loginname, that.loginname) &&
                Objects.equals(password, that.password) &&
                Objects.equals(sno, that.sno) &&
                Objects.equals(name, that.name) &&
                Objects.equals(userType, that.userType) &&
                Objects.equals(email, that.email) &&
                Objects.equals(cellPhone, that.cellPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, loginname, password, sno, name, userType, email, cellPhone);
    }
}
