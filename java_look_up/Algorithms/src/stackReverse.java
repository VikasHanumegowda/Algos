/**
 * Created by sridharyadav on 12/22/15.
 */
import java.util.*;
public class stackReverse {

    public void insertAtBottom(Stack<Integer> stack, int val){
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack,val);
        stack.push(temp);
    }

    public void reverse(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int val = stack.pop();
            reverse(stack);
            insertAtBottom(stack, val);
        }
    }

    public static void main(String[] args){

        stackReverse s = new stackReverse();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.toString());
        s.reverse(stack);
        System.out.println(stack.toString());
    }
}

/*import java.util.*;

public class Test
{
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();
        stack.push("Bottom");
        stack.push("Middle");
        stack.push("Top");

        List<String> list = new ArrayList<String>(stack);

        for (String x : list)
        {
            System.out.println(x);
        }
    }
}*/