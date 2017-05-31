package MeetingRoomsII253;

/**
 * Created by LingZhang on 5/30/17.
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {
        if(null==intervals||intervals.length==0)
            return 0;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int endItr = 0;
        int size = 1;
        for(int i=1; i<intervals.length; i++){
            if(starts[i]<ends[endItr]){
                size++;
            }
            else
                endItr++;

        }
        return size;
    }
}

//Initially, endsItr points to the first end event, and we move i which is the start event pointer. As we examine the start events, we’ll find the first two start events happen before the end event that endsItr points to, so we need two rooms (we magically created two rooms), as shown by the variable rooms. Then, as i points to the third start event, we’ll find that this event happens after the end event pointed by endsItr, then we increment endsItr so that it points to the next end event. What happens here can be thought of as one of the two previous meetings ended, and we moved the newly started meeting into that vacant room, thus we don’t need to increment rooms at this time and move both of the pointers forward.
//        Next, because endsItr moves to the next end event, we’ll find that the start event pointed by i happens before the end event pointed by endsItr.Thus,now we have 4meetings started but only one ended,so we need one more room.And it goes on as this.
