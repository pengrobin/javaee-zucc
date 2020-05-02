package cn.edu.zucc.pb.boot;

import cn.edu.zucc.pb.boot.db.QuestionEntity;
import cn.edu.zucc.pb.boot.db.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-28 20:12
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public MyConfig myConfig(){
        MyConfig ret = new MyConfig();
        ret.setConfig("config value from Application");
        return ret;
    }

    @Autowired
    private MyService service;

    @Autowired
    private QuestionRepository repository;

    @Override
    public void run(String... args) throws Exception {
        service.doSomething();

        List<QuestionEntity> questionEntityList = repository.findAll();
        questionEntityList.stream().
                forEach(item->System.out.println(item.getTitle()));
    }
}
