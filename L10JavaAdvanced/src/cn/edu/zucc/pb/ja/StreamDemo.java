package cn.edu.zucc.pb.ja;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-22 22:21
 */
public class StreamDemo {
    @CodeMemo(name = "pb", date = "2020/04/22", intro = "Stream使用演示")
    public void demo(){
        //生成100个500以内的随机数
        List<Integer> listValue = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i < 100; i++){
            listValue.add(random.nextInt(500));
        }

        //找出小于50的数,并且排序输出
        listValue.stream().filter(item->item < 50)
                .sorted()
                .forEach(item->System.out.print(item.toString() + ","));
        System.out.println();
        //找出所有小于50的数，并且求平方后,然后构造为字符串后输出
        System.out.println(
                listValue.stream().filter(item->item < 50)
                .map(item->item * item)
                .sorted()
                .map(item->item.toString())
                .collect(Collectors.joining(",")));

        //统计
        IntSummaryStatistics stats
                = listValue.stream().mapToInt((x) ->x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }
}
