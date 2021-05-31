package type.test;

import geektime.advanced._01_array.ListNode;

import java.util.*;

public class Test {

    public static void main(String[] args) {
//        ListNode ln = new ListNode(2);
//        ln.setNext(new ListNode(3));
//        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.reversePrint(ln)));
//
//        Stack stack = new Stack<ListNode>();
//        stack.isEmpty();
//        stack.size();
//        Object pop = stack.pop();
//        ArrayList list = new ArrayList<Integer>();
//        list.get(0)

        Test test = new Test();
        int[] array = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(test.majorityElement(array));

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        q.poll();
        int[] ints1 = new int[10];
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        map.size();
        Map.Entry<Integer, Integer> integerIntegerEntry = map.lastEntry();
        integerIntegerEntry.getKey();
//        integerIntegerEntry.setValue()
//        map.remove(integerIntegerEntry);
        map.pollLastEntry();
    }

    public int majorityElement(int[] nums) {
        int votes = 0;
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) x = nums[i];
            votes += nums[i] == x ? +1 : -1;
        }
        return x;
    }

    static class Solution {
        ArrayList<Integer> tmp = new ArrayList<Integer>();

        public int[] reversePrint(ListNode head) {
            recur(head);
            int[] res = new int[tmp.size()];
            for (int i = 0; i < res.length; i++)
                res[i] = tmp.get(i);
            return res;
        }

        void recur(ListNode head) {
            if (head == null) return;
            recur(head.getNext());
            tmp.add(head.getVal());
        }
    }

}


