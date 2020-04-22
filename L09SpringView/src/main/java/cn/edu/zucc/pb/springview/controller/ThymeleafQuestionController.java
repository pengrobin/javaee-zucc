package cn.edu.zucc.pb.springview.controller;

import cn.edu.zucc.pb.springview.entity.QuestionEntity;
import cn.edu.zucc.pb.springview.formbean.Question;
import cn.edu.zucc.pb.springview.formbean.QuestionXml;
import cn.edu.zucc.pb.springview.repositories.QuestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-21 16:04
 */
@Controller
public class ThymeleafQuestionController {

    private final QuestionRepository repository;
    ThymeleafQuestionController(QuestionRepository repository){
        this.repository = repository;
    }

    @GetMapping("/question/thymeleaf/{id}")
    String viewThymeleaf(Model model, @PathVariable Integer id) {
        QuestionEntity entity = repository.getOne(id);
        model.addAttribute("title", entity.getTitle());
        model.addAttribute("createDate", entity.getCreateDate());
        return "question";
    }

}
