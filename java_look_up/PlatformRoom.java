import java.util.ArrayList;
import java.util.Collections;

/**
 * Minimum Number of Platforms Required for a Railway/Bus Station
 * Given arrival and departure times of all trains that reach a railway station,
 * find the minimum number of platforms required for the railway station so that no train waits.
 * We are given two arrays which represent arrival and departure times of trains that stop
 * <p>
 * Examples:
 * <p>
 * Input:  arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
 * dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
 * Output: 3
 * There are at-most three trains at a time (time between 11:00 to 11:20)
 */
public class PlatformRoom {

    class Event implements Comparable<Event> {
        int startTime;
        int finishTime;

        Event(int startTime, int finishTime) {
            this.startTime = startTime;
            this.finishTime = finishTime;
        }

        @Override
        public int compareTo(Event obj) {
            return Integer.compare(this.startTime, obj.startTime);
        }
    }

    ArrayList<Event> events = new ArrayList<>();

    public void fillEventData(int startTime, int finishTime) {
        events.add(new Event(startTime, finishTime));
    }

    public int findMinPlatforms() {
        Collections.sort(events);
        int n = events.size();
        int i = 1, j = 0;
        int minPlatforms = 1, currentPlatforms = 1;
        while (i < n && j < n) {
            if (events.get(i).startTime < events.get(j).finishTime) {
                currentPlatforms++;
                i++;
                minPlatforms = Math.max(minPlatforms, currentPlatforms);
            } else {
                currentPlatforms--;
                j++;
            }
        }
        return minPlatforms;
    }

    public static void main(String args[]) {
        PlatformRoom platformRoom = new PlatformRoom();
        int arr[] = {940, 900, 1100, 950, 1800, 1500};
        int dep[] = {1200, 910, 1130, 1120, 2000, 1900};
        for (int i = 0; i < arr.length; i++) {
            platformRoom.fillEventData(arr[i], dep[i]);
        }
        System.out.println("The Minimum Number of Platforms Required are : " + platformRoom.findMinPlatforms());
    }
}
