package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Рекурсия для мат. выражения
*/

public class Solution1 {
    public static void main(String[] args) {
        Solution1 Solution1 = new Solution1();
        Solution1.recurse("tan(45)", 0);
//        System.out.println("!1 1 - expected output");
//        Solution1.recurse("tan(-45)", 0);  System.out.println("!-1 2 - expected output");
//        Solution1.recurse("0.305", 0);  System.out.println("!0.3 0 - expected output");
//        Solution1.recurse("0.3051", 0);  System.out.println("!0.31 - expected output");
//        Solution1.recurse("(0.3051)", 0);  System.out.println("!0.31 - expected output");
//        Solution1.recurse("1+(1+(1+1)*(1+1))*(1+1)+1", 0);
//        System.out.println("!12 8 - expected output");
//        Solution1.recurse("tan(44+sin(89-cos(180)^2))", 0);  System.out.println("!1 6 - expected output");
//        Solution1.recurse("-2+(-2+(-2)-2*(2+2))", 0);  System.out.println("!-14 8 - expected output");
//        Solution1.recurse("sin(80+(2+(1+1))*(1+1)+2)", 0);  System.out.println("!1 7 - expected output");
//        Solution1.recurse("1+4/2/2+2^2+2*2-2^(2-1+1)", 0);  System.out.println("!6 11 - expected output");
//        Solution1.recurse("10-2^(2-1+1)", 0);  System.out.println("!6 4 - expected output");
//        Solution1.recurse("2^10+2^(5+5)", 0);  System.out.println("!2048 4 - expected output");
//        Solution1.recurse("1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1", 0);  System.out.println("!72.96 8 - expected output");
//        Solution1.recurse("0.000025+0.000012", 0);  System.out.println("!0 1 - expected output");
//        Solution1.recurse("-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)", 0);  System.out.println("-3 16 - expected output");
//        Solution1.recurse("cos(3 + 19*3)", 0);  System.out.println("!0.5 3 - expected output");
    }

    public void recurse(final String expression, int countOperation) {
        String temp = expression;
        int newCount = countOperation;
        Pattern p = Pattern.compile("\\([^\\(]+?\\)");
        Matcher m = p.matcher(expression);
        if (m.find()) {
            temp = expression.substring(m.start() + 1, m.end() - 1);
        }
        if (temp.startsWith("-")) newCount++;
//--------------------------    SIN   COS   TAN    -------------------------------

        Pattern p01 = Pattern.compile("sin[-]?[\\d.]*");
        Matcher m01 = p01.matcher(temp);
        String temp01;
        while (m01.find()) {
            temp01 = temp.substring(m01.start(), m01.end());
            double sin = Math.sin(Math.toRadians(Double.parseDouble(temp01.split("sin")[1])));
            temp = temp.replace(temp01, Double.toString(sin));
            newCount++;
        }
        Pattern p02 = Pattern.compile("cos[-]?[\\d.]*");
        Matcher m02 = p02.matcher(temp);
        String temp02;
        while (m02.find()) {
            temp02 = temp.substring(m02.start(), m02.end());
            String degree = temp02.split("cos")[1];
            double cos = Math.cos(Math.toRadians(Double.parseDouble(degree)));
            temp = temp.replace(temp02, Double.toString(cos));
            newCount++;
        }
        Pattern p03 = Pattern.compile("tan[-]?[\\d.]*");
        Matcher m03 = p03.matcher(temp);
        String temp03;
        while (m03.find()) {
            temp03 = temp.substring(m03.start(), m03.end());
            double tan = Math.tan(Math.toRadians(Double.parseDouble(temp03.split("tan")[1])));
            temp = temp.replace(temp03, Double.toString(tan));
            newCount++;
        }


//-------------------------- ВОЗВЕДЕНИЕ В СТЕПЕНЬ -------------------------------
        while (temp.contains("^")) {

                Pattern p1 = Pattern.compile("[-]?[\\d]*[.]?[\\^][-]?[\\d]*[.]?");
                Matcher m1 = p1.matcher(temp);
                String temp1;
                if (m1.find()) {
                    temp1 = temp.substring(m1.start(), m1.end());
                    double pow = Math.pow(Double.parseDouble(temp1.split("\\^")[0]), Double.parseDouble(temp1.split("\\^")[1]));
                    temp = temp.replace(temp1, Double.toString(pow));
                    newCount++;
                }

        }
//-------------------------- УМНОЖЕНИЕ и ДЕЛЕНИЕ -------------------------------
        while (temp.contains("/") || temp.contains("*")) {
            outer:
            {
                Pattern p2 = Pattern.compile("[-]?[\\d.]*[*/][-]?[\\d.]*");
                Matcher m2 = p2.matcher(temp);
                String temp2;
                while (m2.find()) {
                    temp2 = temp.substring(m2.start(), m2.end());
                    if (temp2.contains("*")) {
                        double multiply = Double.parseDouble(temp2.split("[*]")[0]) * Double.parseDouble(temp2.split("[*]")[1]);
                        temp = temp.replace(temp2, Double.toString(multiply));
                        newCount++;
                        break outer;
                    } else {
                        double dividing = Double.parseDouble(temp2.split("[/]")[0]) / Double.parseDouble(temp2.split("[/]")[1]);
                        temp = temp.replace(temp2, Double.toString(dividing));
                        newCount++;
                        break outer;
                    }
                }
            }
        }
//-------------------------- СЛОЖЕНИЕ и ВЫЧИТАНИЕ -------------------------------
        while (temp.substring(1).contains("-") || temp.contains("+")) {
            Pattern p3 = Pattern.compile("[-]?[\\d.\\d]*[+-][-]?[\\d.\\d]*");
            Matcher m3 = p3.matcher(temp);
            String temp3;
            if (m3.find()) {
                temp3 = temp.substring(m3.start(), m3.end());
                if (temp3.contains("+")) {
                    double multiply = Double.parseDouble(temp3.split("[+]")[0]) + Double.parseDouble(temp3.split("[+]")[1]);
                    temp = temp.replace(temp3, Double.toString(multiply));
                    newCount++;
                } else if(temp3.substring(1).contains("-")){
                    double dividing = Double.parseDouble(temp3.split("[-]")[0]) - Double.parseDouble(temp3.split("[-]")[1]);
                    temp = temp.replace(temp3, Double.toString(dividing));
                    newCount++;
                }

            }
        }
//------------------------- СКОБКИ С МАКСИМАЛЬНЫМ ВЛОЖЕНИЕ ПОСЧИТАНЫ, ДЕЛАЕМ РЕКУРСИЮ, ЗАМЕНЯЯ ИХ--------------------------------
        if (temp.contains("--")){
            temp.replaceAll("[-][-]", "-");
        }
        if (expression.contains("(")) {
            String newExpression = expression.substring(0, m.start()) + temp + expression.substring(m.end());
            recurse(newExpression, newCount);
        } else System.out.printf("%.2f %d",Double.parseDouble(temp),newCount);

//-------------------------------------------------------------------------------------------------------------------------------

    }

    public boolean isDouble(String string) {
        try {
            double res = Double.parseDouble(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Solution1() {
        //don't delete
    }
}
