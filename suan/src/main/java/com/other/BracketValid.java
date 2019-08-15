/*
 * Copyright (c) 2019.
 */

package com.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 判断括号有效性
 *
 * 关于有效括号表达式的一个有趣属性是有效表达式的子表达式也应该是有效表达式。（不是每个子表达式）
 *
 * 算法
 * 初始化栈 S。
 * 一次处理表达式的每个括号。
 * 如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
 * 如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
 * 如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
 *
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/you-xiao-de-gua-hao-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author liuruizhi
 * @since 2019/8/5
 */
public class BracketValid {

    private Map<Character, Character> map = new HashMap<>();

    public BracketValid() {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public boolean isValid(String str) {
        if (null == str || str.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                Character top = stack.isEmpty() ? '#' : stack.pop();
                if (top != map.get(str.charAt(i))) {
                    return false;
                }

            } else {
                stack.push(str.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
