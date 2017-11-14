package TaskScheduler621;

/**
 * Frame: "AXXXAXXXAXXXA"
insert 'B': "ABXXABXXABXXA" <--- 'B' has higher frequency than the other characters, insert it first.
insert 'E': "ABEXABEXABXXA"
insert 'F': "ABEFABEXABFXA" <--- each time try to fill the k-1 gaps as full or evenly as possible.
insert 'G': "ABEFABEGABFGA"
 * @author Daniel
 *
 */
public class TaskScheduler621 {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length==0)
            return 0;
        int[] map = new int[26];
        int max = Integer.MIN_VALUE;
        int maxTask = 0;
        for(char task: tasks){
            map[task-'A']++;
            max = Math.max(max, map[task-'A']);
        }
        for(int i: map){
            if(i==max)
                maxTask++;
        }
        return Math.max(tasks.length,(max-1)*(n+1) + maxTask);
    }
}
