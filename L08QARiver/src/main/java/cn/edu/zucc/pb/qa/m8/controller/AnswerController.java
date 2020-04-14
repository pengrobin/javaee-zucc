package cn.edu.zucc.pb.qa.m8.controller;

import cn.edu.zucc.pb.qa.m8.entity.QaAnswerEntity;
import cn.edu.zucc.pb.qa.m8.formbean.AnswerUserView;
import cn.edu.zucc.pb.qa.m8.repository.AnswerRepository;
import cn.edu.zucc.pb.qa.m8.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-14 22:04
 */
@RestController
public class AnswerController {

    private final AnswerRepository repository;
    private final UserRepository userRepository;
    AnswerController(AnswerRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository =userRepository;
    }

    @PostMapping("/answer/create")
    String createSomeAnswer(@RequestBody Map<String, String> queryExample) {
        Integer uid = Integer.parseInt(queryExample.get("uid"));
        for(int i = 0; i < 3; i++){
            QaAnswerEntity answerEntity = new QaAnswerEntity();
            answerEntity.setContent("content" + RandomStringUtils.randomAlphabetic(10));
            answerEntity.setCreator(uid);
            repository.save(answerEntity);
        }

        return "done";
    }

    @PostMapping("/answer/query_sql")
    String queryBySql(@RequestBody Map<String, String> queryExample) {
        return repository.countAll().toString();
    }

    @PostMapping("/answer/query_sql_join")
    AnswerUserView queryBySqlJoin(@RequestBody Map<String, String> queryExample) {
        Integer uid = Integer.parseInt(queryExample.get("uid"));
        return repository.countAllByUser(uid);
    }

}
