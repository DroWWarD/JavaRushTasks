package com.javarush.task.task19.task1903;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {

        String ukraine = "Ukraine";
        String ua = "UA";
        String russia = "Russia";
        String ru = "RU";
        String canada = "Canada";
        String ca = "CA";

        countries.put(ua, ukraine);
        countries.put(ru, russia);
        countries.put(ca, canada);

    }
    public static void main(String[] args) {

        IncomeDataAdapter adapter= new IncomeDataAdapter(new IncomeData() {
            @Override
            public String getCountryCode() {
                return "UA";
            }

            @Override
            public String getCompany() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName() {
                return "Ivan";
            }

            @Override
            public String getContactLastName() {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 38;
            }

            @Override
            public int getPhoneNumber() {
                return 71112233;
            }
        });
        System.out.println(adapter.getPhoneNumber());

    }

    public static class IncomeDataAdapter implements Contact, Customer{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", "+ data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            Integer phone = data.getPhoneNumber();
            Integer countryCode = data.getCountryPhoneCode();
            char[] listCode = countryCode.toString().toCharArray();
            char[] listChar = phone.toString().toCharArray();
            ArrayList<Character> list = new ArrayList<>();
            for (int i = 0; i < listChar.length; i++) {
                list.add(listChar[i]);
            }
            while (list.size()<10){
                list.add(0, '0');
            }
            for (int i = listCode.length-1; i >=0 ; i--) {
                list.add(0, listCode[i]);
            }
            list.add(list.size()-2, '-');
            list.add(list.size()-5, '-');
            list.add(list.size()-9, ')');
            list.add(list.size()-13, '(');
            list.add(0, '+');

            char[] res = new char[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            String result = new String(res);
            return result;
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}