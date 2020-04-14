package cn.edu.zucc.pb.qa.m8.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-14 16:03
 */
@Entity
@Table(name = "mst_course", schema = "zuccqa", catalog = "")
public class MstCourseEntity {
    private int sid;
    private String name;
    private String teacher;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "teacher")
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MstCourseEntity that = (MstCourseEntity) o;
        return sid == that.sid &&
                Objects.equals(name, that.name) &&
                Objects.equals(teacher, that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, name, teacher);
    }
}
