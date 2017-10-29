import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by sridharyadav on 2/5/16.
 */
public class unix {
    static class process{
        String username;
        int memory;
        public process(String username, int memory){
            this.username = username;
            this.memory = memory;
        }
    }
    public ArrayList<process> sortProcess(ArrayList<process> processes){
        Collections.sort(processes, new Comparator<process>() {
            @Override
            public int compare(process o1, process o2) {
                if(!o1.username.equals(o2.username))
                return o1.username.compareTo(o2.username);
                if(o1.memory > o2.memory){
                    return 1;
                }
                return -1;
            }
        });
        return processes;
    }
    public static void main(String args[]){
        unix u = new unix();
        ArrayList<process> processes = new ArrayList<>();
        process p1 = new process("Dubbuk", 30);
        process p2 = new process("Meg", 60);
        process p3 = new process("Cutie", 40);
        process p4 = new process("Puppy", 50);
        process p5 = new process("Sri", 30);
        process p6 = new process("Sri", 60);
        process p7 = new process("Baby", 40);
        process p8 = new process("Meg", 50);
        processes.add(p1);
        processes.add(p2);
        processes.add(p3);
        processes.add(p4);
        processes.add(p5);
        processes.add(p6);
        processes.add(p7);
        processes.add(p8);
        u.sortProcess(processes);
        for(process p:processes){
            System.out.println(p.username + " " + p.memory);
        }
    }
}
