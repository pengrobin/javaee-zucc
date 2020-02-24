package cn.edu.zucc.pb.bankdispacher;

import java.util.Date;

/**
 * 代表一个用户要办理的业务事件
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 15:59
 */
public class UserEvent {
    //用户序号
    private int seq;
    //用户到达时间
    private Date arriveTime;
    //用户分类
    private EUserCategory category;

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public EUserCategory getCategory() {
        return category;
    }

    public void setCategory(EUserCategory category) {
        this.category = category;
    }
}
