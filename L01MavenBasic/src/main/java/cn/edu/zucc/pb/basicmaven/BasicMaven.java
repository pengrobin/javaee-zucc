package cn.edu.zucc.pb.basicmaven;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-02-24 12:33
 */
public class BasicMaven {
    public static void main(String[] args) {
        String randomValue = RandomStringUtils.randomAlphabetic(6);
        System.out.println(randomValue);
    }
}
