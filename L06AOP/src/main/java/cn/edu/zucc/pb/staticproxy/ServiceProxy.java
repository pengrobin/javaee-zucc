package cn.edu.zucc.pb.staticproxy;

public class ServiceProxy implements IService {
    private ServiceImpl svcImpl;

    public ServiceProxy(ServiceImpl si){
        this.svcImpl = si;
    }

    public void doA() {
        System.out.println("log:invoke doA;");
        this.svcImpl.doA();
    }

    public void doB() {
        System.out.println("log:invoke doB;");
        this.svcImpl.doB();
    }
}
