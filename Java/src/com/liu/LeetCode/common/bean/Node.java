package com.liu.LeetCode.common.bean;

import java.util.ArrayList;
import java.util.List;

public class Node extends BaseNode {
    public int val;
    public List<Node> neighbors;
    public List<Node> children;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
        children = new ArrayList<Node>();
        left = null;
        right = null;
        next = null;
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
        children = new ArrayList<Node>();
        left = null;
        right = null;
        next = null;
    }

    public Node(int _val, List<Node> nodeList) {
        val = _val;
        neighbors = nodeList;
        children = nodeList;
        left = null;
        right = null;
        next = null;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        neighbors = new ArrayList<Node>();
        children = new ArrayList<Node>();
        left = _left;
        right = _right;
        next = _next;
    }
}
