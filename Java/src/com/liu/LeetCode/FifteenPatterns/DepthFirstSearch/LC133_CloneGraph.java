package com.liu.LeetCode.FifteenPatterns.DepthFirstSearch;

import com.liu.LeetCode.common.bean.Node;
import com.liu.LeetCode.common.factory.NodeCreator;

import java.util.HashMap;
import java.util.Map;

public class LC133_CloneGraph {

    private static Node cloneGraphMy1(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        deepFirstCloneGraph(node, map);
        if (!map.isEmpty()) {
            return map.get(1);
        }
        return null;
    }

    // Error 遍历方法没错，但首个创建应该在遍历前，遍历里面在发现不存在的时候进行创建和链接
    private static void deepFirstCloneGraph(Node node, Map<Integer, Node> map) {
        Node newNode;
        if (!map.containsKey(node.val)) {
            newNode = new Node();
            newNode.val = node.val;
            map.put(newNode.val, newNode);
        } else {
            newNode = map.get(node.val);
        }
        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor.val)) {
                Node newNeighbor = map.get(neighbor.val);
                if (newNode.neighbors.isEmpty() || !newNode.neighbors.contains(newNeighbor)) {
                    newNode.neighbors.add(newNeighbor);
                }
            } else {
                deepFirstCloneGraph(neighbor, map);
            }
        }
    }

    private static Node cloneGraphAnswer1(Node node) {
        if (node == null) {
            return null;
        }
        Node copy = new Node(node.val);
        Map<Integer, Node> visitedMap = new HashMap<>();
        deepFirstCloneGraph(node, copy, visitedMap);
        return copy;
    }

    private static void deepFirstCloneGraph(Node node, Node copy, Map<Integer, Node> visitedMap) {
        visitedMap.put(copy.val, copy);
        for (Node neighbor : node.neighbors) {
            if (!visitedMap.containsKey(neighbor.val)) {
                // 确认是否存在
                Node newNode = new Node(neighbor.val);
                copy.neighbors.add(newNode);
                // 对后续未进行处理的Node进行搜索
                deepFirstCloneGraph(neighbor, newNode, visitedMap);
            } else {
                // 如果已经存在，那么就应该加入当前节点的neighbor
                copy.neighbors.add(visitedMap.get(neighbor.val));
            }
        }
    }

    public static void main(String[] args) {
        int[][][] neighborNodeSet = new int[][][]{
                {
                        {2, 4}, {1, 3}, {2, 4}, {1, 3}
                }
        };
        Node result;
        long startTime;
        long endTime;

        for (int i = 0; i < neighborNodeSet.length; i++) {
            startTime = System.currentTimeMillis();
            Node node = NodeCreator.createNormalNode(neighborNodeSet[i]);
            result = cloneGraphMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("cloneGraph My1 result" + i + " " + node + " " + result + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < neighborNodeSet.length; i++) {
            startTime = System.currentTimeMillis();
            Node node = NodeCreator.createNormalNode(neighborNodeSet[i]);
            result = cloneGraphAnswer1(node);
            endTime = System.currentTimeMillis();
            System.out.println("cloneGraph Answer1 result" + i + " " + node + " " + result + " during time " + (endTime - startTime));
        }
    }
}
