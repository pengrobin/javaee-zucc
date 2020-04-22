package cn.edu.zucc.pb.springview.formbean;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-07 23:07
 */
@XmlRootElement
public class QuestionXml {
    private int sid;
    private String title;
    private Date createDate;
    private int creator;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }
}
