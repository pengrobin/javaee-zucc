package cn.edu.zucc.pb.bankdispacher;

/**
 * 此类从bank.properties文件加载selector，实现用户选择算法实现的动态加载
 * 重点体会
 * 1）接口约定规范的服务
 * 2）用反射动态获取实现类实现动态性
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 16:18
 */
public class UserSelectorFactory {
    public static IUserSelector getSelector(){
        //TODO 实现从配置文件 bank.properties加载selector配置项
        String selectorName = "实现配置文件加载";

        //TODO 通过反射接口从上面的selectorName进行实现类创建
        IUserSelector selector = null;

        return selector;
    }
}
