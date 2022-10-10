package com.javarush.task.task36.task3604;

/* 
Разбираемся в красно-черном дереве
*/

public class Solution {
    public static void main(String[] args) {
        final RedBlackTree tree = new RedBlackTree();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        new BinaryTreePrinter(tree.getHeader()).print(System.out);
    }
}
