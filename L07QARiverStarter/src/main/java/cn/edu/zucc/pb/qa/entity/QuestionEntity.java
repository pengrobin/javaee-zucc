package cn.edu.zucc.pb.qa.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-07 23:16
 */

@Entity
@Table(name = "qa_question")
public class QuestionEntity {
    private
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sid;

    private String title;
    private int creator;
    @CreationTimestamp
    @Column(name = "create_date")
    private Date createDate;
    @UpdateTimestamp
    @Column(name = "update_date")
    private Date updateDate;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
