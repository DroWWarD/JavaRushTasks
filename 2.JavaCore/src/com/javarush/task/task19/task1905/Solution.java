package com.javarush.task.task19.task1905;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        String ua = "UA";
        String ru = "RU";
        String ca = "CA";
        String ukraine = "Ukraine";
        String russia = "Russia";
        String canada = "Canada";
        countries.put(ua, ukraine);
        countries.put(ru, russia);
        countries.put(ca, canada);
    }
    public static void main(String[] args) {
        DataAdapter dataAdapter = new DataAdapter(new Customer() {
            @Override
            public String getCompanyName() {
                return "JavaRush Ltd.";
            }

            @Override
            public String getCountryName() {
                return "Ukraine";
            }
        }, new Contact() {
            @Override
            public String getName() {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() {
                return "+38(050)123-45-67";
            }
        });

        System.out.println(dataAdapter.getDialString());

    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryCode = "null";
            for (String key: countries.keySet()) {
                if (countries.get(key).equals(customer.getCountryName())) countryCode = key;
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(", ")[1];
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }

        @Override
        public String getDialString() {
            char[] formatNumber = contact.getPhoneNumber().toCharArray();
            ArrayList<Character> number = new ArrayList<>();
            for (int i = 0; i < formatNumber.length; i++) {
                if (formatNumber[i] == '+' || formatNumber [i] == '6' ||
                    formatNumber [i] == '1' ||formatNumber [i] == '7' ||
                    formatNumber [i] == '2' ||formatNumber [i] == '8' ||
                    formatNumber [i] == '3' ||formatNumber [i] == '9' ||
                    formatNumber [i] == '4' ||formatNumber [i] == '0' ||
                    formatNumber [i] == '5'){
                    number.add(formatNumber[i]);
                }
            }
            char[] phoneNumber = new char[number.size()];
            for (int i = 0; i < phoneNumber.length; i++) {
                phoneNumber[i] = number.get(i);
            }
            String result = new String(phoneNumber);
            return "callto://" + result;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}