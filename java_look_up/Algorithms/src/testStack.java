/**
 * Created by sridharyadav on 2/3/16.
 */
import java.util.*;
class StackWithMode extends Stack<Integer> {
    Stack<Integer> s2;
    HashMap<Integer,Integer> hash;
    public StackWithMode(){
        s2 = new Stack<>();
        hash = new HashMap<>();
        hash.put(-1,0);
    }
    public void push(int value){
        if(!hash.containsKey(value)){
            hash.put(value, 1);
        }
        else{
            hash.put(value,hash.get(value) + 1);
        }
        if(hash.get(value) > hash.get(mode())){
            s2.push(value);
        }
        super.push(value);
    }
    public Integer pop(){
        int value = super.pop();
        hash.put(value, hash.get(value) - 1);
        if(value == mode()){
            s2.pop();
        }
        return value;
    }
    public int mode(){
        if(s2.isEmpty()){
            return -1;
        }
        return s2.peek();
    }
}

public class testStack{
    public static void main(String args[]){
        StackWithMode stack = new StackWithMode();
        stack.push(10);
        stack.push(15);
        stack.push(15);
        stack.push(15);
        stack.push(12);
        stack.push(12);
        stack.push(12);
        stack.push(12);
        System.out.println(stack.mode());
    }
}
