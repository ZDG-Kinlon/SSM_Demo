package cn.test;

import java.math.BigInteger;

public class Demo {

    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("2");
        bigInteger = bigInteger.pow(20_0000);//计算2的20万次方
        System.out.println(bigInteger);
    }

}
