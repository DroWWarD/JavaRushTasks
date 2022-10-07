package com.javarush.task.pro.task13.task1313;

public class StringsLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        if(first.next == null) {
            Node node = new Node();
            first.next = node;
            node.value = value;
            last.prev = node;
            node.prev = first;
            node.next = last;
        }
        else{
            Node node  = new Node();
            node.value = value;
            node.prev = last.prev;
            last.prev = node;
            node.next = last;
            node.prev.next = node;
        }
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}
