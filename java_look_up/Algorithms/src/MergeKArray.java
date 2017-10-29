import java.util.*;

class MergeKArray {
    String arr[][];
    String[] mArray;
    PriorityQueue<queueNode> pq;
    queueNode q;
    queueNode qn;

    private class queueNode{
        String str;
        int i;
        int j;
        queueNode(String str, int i, int j){
            this.str = str;
            this.i = i;
            this.j = j;
        }
    }

    private class Cmpr implements Comparator<queueNode>{
        public int compare(queueNode a, queueNode b){
            return a.str.compareTo(b.str);
        }
    }

    MergeKArray(){

        arr = new String[][] { {"bangalore", "holidays", "iphone", "usc" }, { "apple", "mac"},{"cricket", "football", "la", "sri" } };
        int length = 0;
        for(int i = 0; i < arr.length; i++)
            length += arr[i].length;
        mArray = new String[length];
        Cmpr cmp = new Cmpr();
        pq = new PriorityQueue<queueNode>(arr.length,cmp);
        merge();
    }

    public void merge(){
        for(int i = 0; i < arr.length; i++){
            q = new queueNode(arr[i][0], i, 0);
            pq.add(q);
        }
        int count = 0;
        while(!pq.isEmpty()){
            qn = pq.poll();
            if(qn == null)
                break;
            if(qn.j + 1 < arr[qn.i].length) {
                q = new queueNode(arr[qn.i][qn.j + 1], qn.i, qn.j + 1);
                pq.add(q);
            }
            mArray[count++] = qn.str;
        }
        System.out.println(Arrays.toString(mArray));
    }

    public static void main(String[] args) {
            MergeKArray m = new MergeKArray();
    }
}

