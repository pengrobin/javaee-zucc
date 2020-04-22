package cn.edu.zucc.pb.springview.controller;

import cn.edu.zucc.pb.springview.entity.QuestionEntity;
import cn.edu.zucc.pb.springview.repositories.QuestionRepository;
import cn.edu.zucc.pb.springview.view.PdfView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-22 16:04
 */
@Controller
public class PdfQuestionController {

    private final QuestionRepository repository;
    PdfQuestionController(QuestionRepository repository){
        this.repository = repository;
    }

    @GetMapping("/question/pdf/{id}")
    ModelAndView viewPdf(@PathVariable Integer id) {
        QuestionEntity entity = repository.getOne(id);

        View view = new PdfView();
        ModelAndView mv = new ModelAndView();
        //设置视图
        mv.setView(view);
        //加入数据模型
        mv.addObject("question",entity);
        return mv;
    }
}
