package test.p3;

import java.math.BigDecimal;

public class Test1 {
    public static void main(String[] args) {
        String num = "2022.0";
        BigDecimal abc = new BigDecimal(Double.valueOf(num).intValue());
        System.out.println(abc);
    }
}
