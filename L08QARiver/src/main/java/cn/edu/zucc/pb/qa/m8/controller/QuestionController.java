package cn.edu.zucc.pb.qa.m8.controller;

import cn.edu.zucc.pb.qa.m8.entity.QaQuestionEntity;
import cn.edu.zucc.pb.qa.m8.formbean.Question;
import cn.edu.zucc.pb.qa.m8.formbean.QuestionPage;
import cn.edu.zucc.pb.qa.m8.repository.QuestionRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    Question one(@PathVariable Integer id) {
        QaQuestionEntity retEntity = repository.getOne(id);
        Question ret = new Question();
        BeanUtils.copyProperties(retEntity, ret);
        return ret;
    }

    @PostMapping("/question/find_bytitle")
    List<Question> findByTitle(@RequestBody Map<String, String> queryExample) {
        return convert(repository.findByTitleLike(queryExample.get("title")));
    }

    @PostMapping("/question/find_bytitle_orderby")
    List<Question> findByDateBetween(@RequestBody Map<String, String> queryExample) {
        return convert(repository.findByTitleLikeOrderByTitleDesc(queryExample.get("title")));
    }

    @PostMapping("/question/find_all_pagination")
    QuestionPage findPagination() {
        Page<QaQuestionEntity> thisPage = repository.findAll(PageRequest.of(1, 2));
        QuestionPage retPage = new QuestionPage();
        retPage.setPageNum(1);
        retPage.setPageSize(2);
        retPage.setTotalPage(thisPage.getTotalPages());
        retPage.setTotalCount(thisPage.getTotalElements());
        retPage.setQuestionList(convert(thisPage.getContent()));
        return  retPage;
    }

    private List<Question> convert(List<QaQuestionEntity> entityList){
        List<Question> questionList = new ArrayList<>();
        entityList.stream().forEach(item -> {
            Question q = new Question();
            BeanUtils.copyProperties(item, q);
            questionList.add(q);
        });

        return questionList;
    }

}
