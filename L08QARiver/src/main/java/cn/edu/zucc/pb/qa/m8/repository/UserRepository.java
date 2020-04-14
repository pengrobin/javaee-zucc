package cn.edu.zucc.pb.qa.m8.repository;

import cn.edu.zucc.pb.qa.m8.entity.MstUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-07 23:25
 */
public interface UserRepository extends JpaRepository<MstUserEntity, Integer> {
}
