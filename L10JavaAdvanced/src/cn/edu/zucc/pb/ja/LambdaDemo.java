package cn.edu.zucc.pb.ja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-23 09:59
 */
public class LambdaDemo {
    @CodeMemo(name = "pb", date = "2020/04/23", intro = "Lambda使用演示")
    public void demo(){
        //使用Function的函数式接口
        //映射String到length
        List<String> listString = Arrays.asList("eews", "", "bc", "zzzd", "badfsdfsfs","w", "liyghjk");
        List<Integer> listLength = convertList(listString, (String s)->s.length());
        listLength.stream().forEach(s->System.out.print(s.toString() + ","));

        System.out.println();
        //映射user到学号
        List<User> listUser = Arrays.asList(
                new User("张三","S0001"),
                new User("李四","S0002"),
                new User("王五","S0003"),
                new User("钱六","S0004")
        );
        List<String> listSno = convertList(listUser, (User u)->u.getSno());
        listSno.stream().forEach(s->System.out.print(s + ","));
        System.out.println();

        //lambda表达式与方法引用
        System.out.println(
                listString.stream()
                        .map(item->item.toUpperCase())
                        .collect(Collectors.joining(","))
        );

        System.out.println(
                listString.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.joining(","))
        );

        //引用作用域内的变量
        User teacher = new User("老师", "T0001");
        listUser.stream().forEach(u->System.out.println(u.getName() + "'s teacher is " + teacher.getName()));
        //compile error
//        int index = 0;
//        listUser.stream().forEach(u->
//                    System.out.println((index++) + u.getName() + "'s teacher is " + teacher.getName()));
    }

    /**
     * 映射转换任何类型列表
     * @param sourceList
     * @param converter
     * @param <T>
     * @param <R>
     * @return
     */
    public <T,R> List<R> convertList(List<T> sourceList, Function<T, R> converter){
        List<R> retList = new ArrayList<>();

        for(T t : sourceList){
            retList.add(converter.apply(t));
        }

        return retList;
    }

    class User{
        private String name;
        private String sno;

        public User(String name, String sno) {
            this.name = name;
            this.sno = sno;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSno() {
            return sno;
        }

        public void setSno(String sno) {
            this.sno = sno;
        }
    }

}
