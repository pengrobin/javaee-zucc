package cn.edu.zucc.pb.qa.m8.formbean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-07 23:07
 */
public class QuestionPage implements Serializable {
    private int pageSize;
    private int pageNum;
    private int totalPage;
    private Long totalCount;
    private List<Question> questionList;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
