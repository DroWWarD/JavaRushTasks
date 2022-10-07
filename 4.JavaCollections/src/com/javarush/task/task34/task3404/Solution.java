package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Рекурсия для мат. выражения
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.recurse("tan(45)", 0);  System.out.println("!1 1 - expected output");
//        solution.recurse("tan(-45)", 0);  System.out.println("!-1 2 - expected output");
//        solution.recurse("0.305", 0);  System.out.println("!0.3 0 - expected output");
//        solution.recurse("0.3051", 0);  System.out.println("!0.31 - expected output");
//        solution.recurse("(0.3051)", 0);  System.out.println("!0.31 - expected output");
        solution.recurse("1+(1+(1+1)*(1+1))*(1+1)+1", 0);  System.out.println("!12 8 - expected output");
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
        String temp = expression;
        int newCount = countOperation;
        if (expression.toCharArray()[0] == '-') newCount++;

        if (temp.contains("--")) {
            temp = temp.replaceAll("--", "+");
        }

        if (isDouble(expression)) {
            double res = Double.parseDouble(expression);
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            String result = decimalFormat.format(res);
            System.out.print(result + " " + countOperation);
        } else {
            Pattern p = Pattern.compile("\\([^\\(]+?\\)");
            Matcher m = p.matcher(expression);
            while (m.find()) {
                temp = expression.substring(m.start() + 1, m.end() - 1);
                if (temp.toCharArray()[0] == '-') newCount++;
                if (isDouble(temp)) {
                    if (m.start() > 2) {
                        if ((expression.substring(m.start() - 3, m.start())).equals("sin")) {
                            double sin = Math.sin(Math.toRadians(Double.parseDouble(temp)));
                            newCount++;
                            recurse(expression.replace(expression.substring(m.start() - 3, m.end()), Double.toString(sin)), newCount);
                            break;
                        } else if (expression.substring(m.start() - 3, m.start()).equals("cos")) {
                            double cos = Math.cos(Math.toRadians(Double.parseDouble(temp)));
                            newCount++;
                            recurse(expression.replace(expression.substring(m.start() - 3, m.end()), Double.toString(cos)), newCount);
                            break;
                        } else if (expression.substring(m.start() - 3, m.start()).equals("tan")) {
                            double tan = Math.tan(Math.toRadians(Double.parseDouble(temp)));
                            newCount++;
                            recurse(expression.replace(expression.substring(m.start() - 3, m.end()), Double.toString(tan)), newCount);
                            break;
                        } else {
                            recurse(expression.replace(expression.substring(m.start(), m.end()), temp), newCount);
                            break;
                        }
                    }
                }


                while (temp.contains("^")){
                    Pattern p1 = Pattern.compile("[\\d.-]*[\\^][\\d.-]*");
                    Matcher m1 = p1.matcher(temp);
                    String temp1 = "";
                    while (m1.find()) {
                        temp1 = temp.substring(m1.start(), m1.end());
                        double pow = Math.pow(Double.parseDouble(temp1.split("\\^")[0]), Double.parseDouble(temp1.split("\\^")[1]));
                        temp = temp.replace(temp1, Double.toString(pow));
                        newCount++;
                        break;
                    }
                }
                while (temp.contains("/") || temp.contains("*")){
                    Pattern p2 = Pattern.compile("[\\d.-]*[*/][\\d.-]*");
                    Matcher m2 = p2.matcher(temp);
                    String temp2 = "";
                    while (m2.find()) {
                        temp2 = temp.substring(m2.start(), m2.end());
                        if (temp2.contains("*")) {
                            double multiply = Double.parseDouble(temp2.split("[*]")[0]) * Double.parseDouble(temp2.split("[*]")[1]);
                            temp = temp.replace(temp2, Double.toString(multiply));
                            newCount++;
                            break;
                        } else {
                            double dividing = Double.parseDouble(temp2.split("[/]")[0]) / Double.parseDouble(temp2.split("[/]")[1]);
                            temp = temp.replace(temp2, Double.toString(dividing));
                            newCount++;
                            break;
                        }
                    }
                }
                while (temp.substring(1).contains("-") || temp.contains("+")){
                    Pattern p3 = Pattern.compile("[\\d.-]*[+-][\\d.-]*");
                    Matcher m3 = p3.matcher(temp);
                    String temp3 = "";
                    while (m3.find()) {
                        temp3 = temp.substring(m3.start(), m3.end());
                        if (temp3.contains("+")) {
                            double multiply = Double.parseDouble(temp3.split("[+]")[0]) + Double.parseDouble(temp3.split("[+]")[1]);
                            temp = temp.replace(temp3, Double.toString(multiply));
                            newCount++;
                            break;
                        } else {
                            double dividing = Double.parseDouble(temp3.split("[-]")[0]) - Double.parseDouble(temp3.split("[-]")[1]);
                            temp = temp.replace(temp3, Double.toString(dividing));
                            newCount++;
                            break;
                        }
                    }
                }


                if (isDouble(temp)) {
                    if (m.start() > 2) {
                        if ((expression.substring(m.start() - 3, m.start())).equals("sin")) {
                            double sin = Math.sin(Math.toRadians(Double.parseDouble(temp)));
                            newCount++;
                            recurse(expression.replace(expression.substring(m.start() - 3, m.end()), Double.toString(sin)), newCount);
                        } else if (expression.substring(m.start() - 3, m.start()).equals("cos")) {
                            double cos = Math.cos(Math.toRadians(Double.parseDouble(temp)));
                            newCount++;
                            recurse(expression.replace(expression.substring(m.start() - 3, m.end()), Double.toString(cos)), newCount);
                        } else if (expression.substring(m.start() - 3, m.start()).equals("tan")) {
                            double tan = Math.tan(Math.toRadians(Double.parseDouble(temp)));
                            newCount++;
                            recurse(expression.replace(expression.substring(m.start() - 3, m.end()), Double.toString(tan)), newCount);
                        } else recurse(expression.replace(expression.substring(m.start(), m.end()), temp), newCount);
                    }else recurse(expression.replace(expression.substring(m.start(), m.end()), temp), newCount);
                }
            }


            if (!isDouble(temp)) {
                while (temp.contains("^")){
                    Pattern p1 = Pattern.compile("[\\d.-]*[\\^][\\d.-]*");
                    Matcher m1 = p1.matcher(temp);
                    String temp1 = "";
                    while (m1.find()) {
                        temp1 = temp.substring(m1.start(), m1.end());
                        double pow = Math.pow(Double.parseDouble(temp1.split("\\^")[0]), Double.parseDouble(temp1.split("\\^")[1]));
                        temp = temp.replace(temp1, Double.toString(pow));
                        newCount++;
                        break;
                    }
                }
                while (temp.contains("*") || temp.contains("/")){
                    Pattern p2 = Pattern.compile("[\\d.-]*[*/][\\d.-]*");
                    Matcher m2 = p2.matcher(temp);
                    String temp2 = "";
                    while (m2.find()) {
                        temp2 = temp.substring(m2.start(), m2.end());
                        if (temp2.contains("*")) {
                            double multiply = Double.parseDouble(temp2.split("[*]")[0]) * Double.parseDouble(temp2.split("[*]")[1]);
                            temp = temp.replace(temp2, Double.toString(multiply));
                            newCount++;
                            break;
                        } else {
                            double dividing = Double.parseDouble(temp2.split("[/]")[0]) / Double.parseDouble(temp2.split("[/]")[1]);
                            temp = temp.replace(temp2, Double.toString(dividing));
                            newCount++;
                            break;
                        }
                    }
                }

                while (temp.substring(1).contains("-") || temp.contains("+")){
                    Pattern p3 = Pattern.compile("[\\d.-]*[+-][\\d.-]*");
                    Matcher m3 = p3.matcher(temp);
                    String temp3 = "";
                    while (m3.find()) {
                        temp3 = temp.substring(m3.start(), m3.end());
                        if (temp3.contains("+")) {
                            double multiply = Double.parseDouble(temp3.split("[+]")[0]) + Double.parseDouble(temp3.split("[+]")[1]);
                            temp = temp.replace(temp3, Double.toString(multiply));
                            newCount++;
                            break;
                        } else {
                            double dividing = Double.parseDouble(temp3.split("[-]")[0]) - Double.parseDouble(temp3.split("[-]")[1]);
                            temp = temp.replace(temp3, Double.toString(dividing));
                            newCount++;
                            break;
                        }
                    }
                }
            }
        }
    }

    public boolean isDouble(String string) {
        try {
            double res = Double.parseDouble(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Solution() {
        //don't delete
    }
}
