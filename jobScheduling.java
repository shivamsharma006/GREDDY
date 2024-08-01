import java.util.ArrayList;
import java.util.Collections;

public class jobScheduling {
    char id;
    int deadline,profit;

    public jobScheduling(){}

    public jobScheduling(char id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    void printJobSequence(ArrayList<jobScheduling>arr,int maxDeadline){
        int n = arr.size();
        Collections.sort(arr, (a,b) -> b.profit - a.profit);

        boolean[]res = new boolean[maxDeadline];

        char []job = new char[maxDeadline];
        for(int i=0; i<n; i++){
            for(int j=Math.min(maxDeadline-1,arr.get(i).deadline); j>=0; j--){
                if(res[j]==false){
                    res[j]=true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }

        for(char ch : job){
            System.out.print(ch + " ");
        }
    }
    public static void main(String[] args) {
        ArrayList<jobScheduling> arr = new ArrayList<>();
        arr.add(new jobScheduling('1', 5, 55));
        arr.add(new jobScheduling('2', 2, 65));
        arr.add(new jobScheduling('3', 7, 75));
        arr.add(new jobScheduling('4', 3, 60));
        arr.add(new jobScheduling('5', 2, 70));
        arr.add(new jobScheduling('6', 1, 50));
        arr.add(new jobScheduling('7', 4, 85));
        arr.add(new jobScheduling('8', 5, 68));
        arr.add(new jobScheduling('9', 3, 45));
        System.out.println("Job Sequence order to get the maximum profit is: ");
        jobScheduling job = new jobScheduling();
        job.printJobSequence(arr,7);
    }
}
