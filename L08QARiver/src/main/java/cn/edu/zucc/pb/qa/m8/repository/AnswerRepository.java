package cn.edu.zucc.pb.qa.m8.repository;

import cn.edu.zucc.pb.qa.m8.entity.QaAnswerEntity;
import cn.edu.zucc.pb.qa.m8.formbean.AnswerUserView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-07 23:25
 */
public interface AnswerRepository extends JpaRepository<QaAnswerEntity, Integer> {
    @Query(value="select count(*) from qa_answer", nativeQuery = true)
    Long countAll();

    @Query(value="select u.sid as sid, u.loginname as name, count(q.sid) as answerCount " +
            "from qa_answer q, mst_user u where q.creator = u.sid and u.sid = ?1", nativeQuery = true)
    AnswerUserView countAllByUser(int uid);

}
