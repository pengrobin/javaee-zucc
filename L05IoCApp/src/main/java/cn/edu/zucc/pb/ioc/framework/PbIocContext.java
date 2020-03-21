package cn.edu.zucc.pb.ioc.framework;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;

/**
 * 仅仅用于演示IoC工作原理，所以对应的配置文件设计非常简单
 * @author pengbin
 * @version 1.0
 * @date 2020-03-21 15:48
 */
public class PbIocContext {
    private Pbioc iocMapping = null;
    private static PbIocContext instance = new PbIocContext();
    private PbIocContext(){}
    public static PbIocContext getInstance(){
        if(!instance.isbInit()){
            instance.init();
        }
        return instance;
    }

    private boolean bInit = false;

    public boolean isbInit() {
        return bInit;
    }

    private void init(){
        URL url = this.getClass().getClassLoader().getResource("/PbIocContext.xml");
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Pbioc.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            iocMapping = (Pbioc)unmarshaller.unmarshal(new File(url.getPath()));
            bInit = true;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Pbioc getIocMapping() {
        return iocMapping;
    }
}
