package cn.edu.zucc.pb.qa.m8.repository;

import cn.edu.zucc.pb.qa.m8.entity.MstCourseEntity;
import cn.edu.zucc.pb.qa.m8.entity.QaQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-07 23:25
 */
public interface CourseRepository extends JpaRepository<MstCourseEntity, Integer> {
}
