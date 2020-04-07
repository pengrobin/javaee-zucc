package cn.edu.zucc.pb.qa.controller;

import cn.edu.zucc.pb.qa.entity.QuestionEntity;
import cn.edu.zucc.pb.qa.formbean.Question;
import cn.edu.zucc.pb.qa.repositories.QuestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-07 23:04
 */
@RestController
public class QuestionController {

    private final QuestionRepository repository;
    QuestionController(QuestionRepository repository){
        this.repository = repository;
    }

    @GetMapping("/question/{id}")
    Question one(@PathVariable Long id) {
        return new Question();
    }

    @PostMapping("/question")
    Question saveOrUpdate(@RequestBody Question newQuestion) {
        QuestionEntity entity = new QuestionEntity();
        BeanUtils.copyProperties(newQuestion, entity);
        QuestionEntity retEntity = repository.save(entity);

        Question ret = new Question();
        BeanUtils.copyProperties(retEntity, ret);
        return ret;
    }

    //这里直接返回数据库对象是不规范的，仅仅示例用
    @PostMapping("/find_question_bytitle")
    List<QuestionEntity> findByTitle(@RequestBody Question queryExample) {
        return repository.findByTitle(queryExample.getTitle());
    }

}
