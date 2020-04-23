package cn.edu.zucc.pb.ja;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-23 11:05
 */
public class LastDemo {
    static final double TAX_START = 60000.00D;

    @CodeMemo(name = "pb", date = "2020/04/23", intro = "最后的小练习")
    public void demo(){
        Random random = new Random();
        List<TaxPayer> companyEmployee = Arrays.asList(
                new TaxPayer("张三"
                        , random.doubles(12, 3000, 6000)
                        .boxed().toArray(Double[]::new)),
                new TaxPayer("李四"
                        , random.doubles(12, 3000, 8000)
                        .boxed().toArray(Double[]::new)),
                new TaxPayer("王五"
                        , random.doubles(12, 3000, 10000)
                        .boxed().toArray(Double[]::new)),
                new TaxPayer("钱六"
                        , random.doubles(12, 3000, 12000)
                        .boxed().toArray(Double[]::new))
        );

        Double taxTotal = companyEmployee.stream()
                .filter(item->item.totalIncome() > TAX_START)
                .map(item->logAndMap(item))
                .reduce(0.0, (t1, t2)->t1 + t2 * 0.2);
        System.out.println("Company Total:--> " + taxTotal);
    }

    public Double logAndMap(TaxPayer payer){
        if(isNeedLog(payer)){
            System.out.println("need pay tax:--> "
                    + payer.totalIncome()
                    + "[" + payer.toString() + "]");
        }

        return payer.totalIncome() - TAX_START;
    }

    public boolean isNeedLog(Object obj){
        return obj.getClass().getAnnotation(EntityLog.class) != null;
    }
}
