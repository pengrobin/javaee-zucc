package cn.edu.zucc.pb.qa.m8.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-14 16:03
 */
@Entity
@Table(name = "qa_answer", schema = "zuccqa", catalog = "")
public class QaAnswerEntity {
    private int sid;
    private String content;
    private int creator;
    private Timestamp createDate;
    private Timestamp updateDate;

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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "creator")
    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    @Basic
    @Column(name = "create_date")
    @CreationTimestamp
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "update_date")
    @UpdateTimestamp
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QaAnswerEntity that = (QaAnswerEntity) o;
        return sid == that.sid &&
                Objects.equals(content, that.content) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, content, creator, createDate, updateDate);
    }

}
