package examples.recursive;

import java.util.Stack;

public class ReverseStackUsingRecursive {

    public static  void main(String[] args){
        Stack<Integer> test=new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);

        reverse(test);

        while (!test.isEmpty()){
            System.out.println(test.pop());
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty())
            return;
        int i=getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result=stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last=getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
}
