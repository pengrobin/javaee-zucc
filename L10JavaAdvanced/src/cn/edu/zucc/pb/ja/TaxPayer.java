package cn.edu.zucc.pb.ja;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-23 11:01
 */
@EntityLog("TaxPayer")
public class TaxPayer {
    private String id;
    private String name;
    private List<Double> incomeOfMonth;

    public TaxPayer(String name, Double[] incomeOfMonth) {
        this.id = UUID.randomUUID().toString().replaceAll("-", "");
        this.name = name;
        this.incomeOfMonth = Arrays.asList(incomeOfMonth);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getIncomeOfMonth() {
        return incomeOfMonth;
    }

    public void setIncomeOfMonth(List<Double> incomeOfMonth) {
        this.incomeOfMonth = incomeOfMonth;
    }

    public Double totalIncome(){
        return this.getIncomeOfMonth().stream()
                .reduce(0.0,(m1,m2)->m1 + m2);
    }

    @Override
    public String toString() {
        return "TaxPayer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", incomeOfMonth=" + incomeOfMonth +
                '}';
    }
}
