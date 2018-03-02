package com.liu.LeetApp.test;

import static com.liu.LeetApp.exercise.LA005_AddTwoNumbers.*;

/**
 * Created by liu on 2016/12/1.
 */
public class LA005_AddTwoNumbersTest {
    public static void main(String[] args) {
        Node test1 = new Node(2);
        test1.next = new Node(4);
        test1.next.next = new Node(3);

        Node test2 = new Node(5);
        test2.next = new Node(6);
        test2.next.next = new Node(4);
        test2.next.next.next = new Node(1);


        Node result = addTwoNumbersMy5(test1, test2);
        Node cache = result;
        while (cache != null) {
            System.out.println("addTwoNumbersMy1 " + cache.num);
            cache = cache.next;
        }
    }
}
