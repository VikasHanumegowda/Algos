import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sridharyadav on 10/18/17.
 */
public class Problem85 {
    static class Domain {
        String name;
        int frequency;

        Domain(String name, int frequency) {
            this.name = name;
            this.frequency = frequency;
        }
    }

    public static ArrayList<Domain> findTopKDomains(ArrayList<Domain> domains, int k) {
        ArrayList<Domain> topKDomains = new ArrayList<>();
        PriorityQueue<Domain> priorityQueue = new PriorityQueue(new Comparator<Domain>() {
            @Override
            public int compare(Domain o1, Domain o2) {
                if (o1.frequency > o2.frequency) {
                    return 1;
                } else if (o1.frequency < o2.frequency) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (int i = 0; i < k; i++) {
            priorityQueue.add(domains.get(i));
        }
        for (int i = k; i < domains.size(); i++) {
            Domain root = priorityQueue.peek();
            if (domains.get(i).frequency > root.frequency) {
                Domain temp = priorityQueue.poll();
                priorityQueue.add(domains.get(i));
                domains.set(i, temp);
            }
        }
        for (int i = 0; i < k; i++) {
            topKDomains.add(priorityQueue.poll());
        }
        return topKDomains;
    }

    public static void main(String args[]) {
        ArrayList<Domain> domains = new ArrayList<>();
        domains.add(new Domain("google", 1000));
        domains.add(new Domain("yahoo", 50));
        domains.add(new Domain("facebook", 800));
        domains.add(new Domain("microsoft", 70));
        domains.add(new Domain("amazon", 200));
        ArrayList<Domain> topKDomains = findTopKDomains(domains, 2);
        for (Domain domain : topKDomains) {
            System.out.println("Name : " + domain.name + " Frequency : " + domain.frequency);
        }
    }
}
