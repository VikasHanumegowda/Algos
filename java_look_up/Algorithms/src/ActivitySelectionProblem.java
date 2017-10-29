import java.util.*;

/*
Consider the following 6 activities.
     start[]  =  {1, 3, 0, 5, 8, 5};
     finish[] =  {2, 4, 6, 7, 9, 9};
The maximum set of activities that can be executed
by a single person is {0, 1, 3, 4}
 */

class ActivitySelectionProblem {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int numberOfActivity = scan.nextInt();
        Activity[] activities = new Activity[numberOfActivity];
        for(int i = 0; i < numberOfActivity; i++){
            int startTime = scan.nextInt();
            int finishTime = scan.nextInt();
            activities[i] = new Activity(startTime,finishTime,i);
        }

        ArrayList activitiesList = printMaxActivities(activities, numberOfActivity);
        Iterator itr = activitiesList.iterator();
        while(itr.hasNext())
            System.out.print(itr.next()+" ");
    }
    public static ArrayList printMaxActivities(Activity[] activities, int numberOfActivity){
        //Sort activities according to increasing order of finish time
        Arrays.sort(activities, new Comparator<Activity>(){
            @Override
            public int compare(Activity o1, Activity o2) {
                if(o1.finishTime > o2.finishTime)
                    return 1;
                else
                    return -1;
            }
        });
        ArrayList<Integer> activitiesList = new ArrayList<Integer>();
        int i = 0;
        activitiesList.add(activities[i].activityNumber);// this is very important, some time we add just 'i'
        for(int j = 1; j< numberOfActivity; j++){
            if(activities[j].startTime >= activities[i].finishTime){
                activitiesList.add(activities[j].activityNumber);
                i = j;
            }
        }
        return activitiesList;
    }
}
class Activity{
    int startTime;
    int finishTime;
    int activityNumber;
    Activity(int startTime,int finishTime, int activityNumber){
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.activityNumber = activityNumber;
    }
}