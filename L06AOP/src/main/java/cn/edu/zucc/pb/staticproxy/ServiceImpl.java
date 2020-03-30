package cn.edu.zucc.pb.staticproxy;

public class ServiceImpl implements IService {
    public void doA() {
        System.out.println("doA");
    }

    public void doB() {
        System.out.println("doB");
    }
}
