package personalwebsite.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by LeeeYou on 2016/3/19. 双栈排序练习题
 * <p>
 * 请编写一个程序，按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers(C++中为vector<int>)，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * 测试样例：
 * [1,2,3,4,5]
 * 返回：[5,4,3,2,1]
 */
public class TwoStackSortDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 1, 2};
        twoStacksSort(nums);
        System.out.println(twoStacksSort(nums));
    }

    public static ArrayList<Integer> twoStacksSort(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        for (int number : numbers) {
            stack.push(number);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (!help.isEmpty()) {
                while (!help.isEmpty() && top > help.peek()) {
                    stack.push(help.pop());
                }
            }
            help.push(top); // help栈逐渐保存最大值
        }
        return new ArrayList<>(help);
    }

}
