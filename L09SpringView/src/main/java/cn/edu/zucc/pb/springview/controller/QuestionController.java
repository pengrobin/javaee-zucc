package cn.edu.zucc.pb.springview.controller;

import cn.edu.zucc.pb.springview.entity.QuestionEntity;
import cn.edu.zucc.pb.springview.formbean.Question;
import cn.edu.zucc.pb.springview.formbean.QuestionXml;
import cn.edu.zucc.pb.springview.repositories.QuestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
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

    @GetMapping("/question/json/{id}")
    Question viewJson(@PathVariable Integer id) {
        QuestionEntity entity = repository.getOne(id);
        Question ret = new Question();
        BeanUtils.copyProperties(entity,ret);
        return ret;
    }

    @GetMapping("/question/xml/{id}")
    QuestionXml viewXml(@PathVariable Integer id) {
        QuestionEntity entity = repository.getOne(id);
        QuestionXml ret = new QuestionXml();
        BeanUtils.copyProperties(entity,ret);
        return ret;
    }
}
