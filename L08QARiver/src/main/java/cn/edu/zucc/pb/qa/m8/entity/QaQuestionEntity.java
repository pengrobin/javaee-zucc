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
@Table(name = "qa_question", schema = "zuccqa", catalog = "")
public class QaQuestionEntity {
    private int sid;
    private String title;
    private Integer creator;
    private Timestamp createDate;
    private Timestamp updateDate;
    private Integer answerSid;
    private Integer courseSid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid")
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "creator")
    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
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

    @Basic
    @Column(name = "answer_sid")
    public Integer getAnswerSid() {
        return answerSid;
    }

    public void setAnswerSid(Integer answerSid) {
        this.answerSid = answerSid;
    }

    @Basic
    @Column(name = "course_sid")
    public Integer getCourseSid() {
        return courseSid;
    }

    public void setCourseSid(Integer courseSid) {
        this.courseSid = courseSid;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QaQuestionEntity that = (QaQuestionEntity) o;
        return sid == that.sid &&
                Objects.equals(title, that.title) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate) &&
                Objects.equals(answerSid, that.answerSid) &&
                Objects.equals(courseSid, that.courseSid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, title, creator, createDate, updateDate, answerSid, courseSid);
    }
}
