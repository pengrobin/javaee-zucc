package cn.edu.zucc.pb.boot;

import org.springframework.stereotype.Component;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-05-02 17:47
 */
@Component
public class MyService {
    private String configValue;

    public MyService(MyConfig config){
        this.configValue = config.getConfig();
    }

    public void doSomething(){
        System.out.printf("do task with config of %s\n", configValue);
    }

}
