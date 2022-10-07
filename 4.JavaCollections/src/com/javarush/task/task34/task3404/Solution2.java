package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
//        solution.recurse("tan(45)", 0);  System.out.println("!1 1 - expected output");
//        solution.recurse("tan(-45)", 0);  System.out.println("!-1 2 - expected output");
//        solution.recurse("0.305", 0);  System.out.println("!0.3 0 - expected output");
//        solution.recurse("0.3051", 0);  System.out.println("!0.31 - expected output");
//        solution.recurse("(0.3051)", 0);  System.out.println("!0.31 - expected output");
        solution2.recurse("1+(1+(1+2/2-3*2^2)*((1+1)1+1))*(1+1)+1", 0);
        System.out.println("!12 8 - expected output");
//        solution.recurse("tan(44+sin(89-cos(180)^2))", 0);  System.out.println("!1 6 - expected output");
//        solution.recurse("-2+(-2+(-2)-2*(2+2))", 0);  System.out.println("!-14 8 - expected output");
//        solution.recurse("sin(80+(2+(1+1))*(1+1)+2)", 0);  System.out.println("!1 7 - expected output");
//        solution.recurse("1+4/2/2+2^2+2*2-2^(2-1+1)", 0);  System.out.println("!6 11 - expected output");
//        solution.recurse("10-2^(2-1+1)", 0);  System.out.println("!6 4 - expected output");
//        solution.recurse("2^10+2^(5+5)", 0);  System.out.println("!2048 4 - expected output");
//        solution.recurse("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", 0);  System.out.println("!72.96 8 - expected output");
//        solution.recurse("0.000025+0.000012", 0);  System.out.println("!0 1 - expected output");
//        solution.recurse("-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)", 0);  System.out.println("-3 16 - expected output");
//        solution.recurse("cos(3 + 19*3)", 0);  System.out.println("!0.5 3 - expected output");
    }

    public void recurse(final String expression, int countOperation) {
        System.out.println(expression);
        String temp = expression;
        int newCount = countOperation;

        Pattern p = Pattern.compile("\\([^\\(]+?[\\d.-]*[\\^*/+-][\\d.-]*\\)");
        Matcher m = p.matcher(expression);
        while (m.find()) {
            temp = expression.substring(m.start(), m.end());


        }
        System.out.println(temp + " " + newCount);

    }

    public boolean isDouble(String string) {
        try {
            double res = Double.parseDouble(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Solution2() {
        //don't delete
    }
}
