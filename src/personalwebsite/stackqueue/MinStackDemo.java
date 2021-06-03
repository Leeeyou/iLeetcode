package personalwebsite.stackqueue;

import java.util.Stack;

/**
 * Created by LeeeYou on 2016/3/17. 可查询最值的栈练习题
 * <p>
 * [LeetCode 面试题 03.02. 栈的最小值](https://leetcode-cn.com/problems/min-stack-lcci/)
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class MinStackDemo {

    Stack<Integer> stackData;
    Stack<Integer> stackMin;

    public MinStackDemo() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
        stackMin.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stackData.push(x);
        stackMin.push(Math.min(x, stackMin.peek()));
    }

    public void pop() {
        stackMin.pop();
        stackData.pop();
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }

}
