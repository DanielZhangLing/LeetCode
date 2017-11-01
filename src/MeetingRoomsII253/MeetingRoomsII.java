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


	/*
	 * 想象一条扫描线，扫过去
	 */

    public int minMeetingRooms(Interval[] intervals) {
        int now = 0, res = 0;
        List<Interval> tmp = new ArrayList<Interval>();
        for(Interval i: intervals){
            tmp.add(new Interval(i.start,1));
            tmp.add(new Interval(i.end, 0));
        }   
        Collections.sort(tmp, (a,b)->a.start==b.start? a.end-b.end:a.start-b.start);
        for(Interval i: tmp){
            if(i.end==0){
                now--;
            }else{
                now++;
                res = Math.max(res, now);
            }
        }
        return res;
    }
	
	
//Initially, endsItr points to the first end event, and we move i which is the start event pointer. As we examine the start events, weâ€™ll find the first two start events happen before the end event that endsItr points to, so we need two rooms (we magically created two rooms), as shown by the variable rooms. Then, as i points to the third start event, weâ€™ll find that this event happens after the end event pointed by endsItr, then we increment endsItr so that it points to the next end event. What happens here can be thought of as one of the two previous meetings ended, and we moved the newly started meeting into that vacant room, thus we donâ€™t need to increment rooms at this time and move both of the pointers forward.
//        Next, because endsItr moves to the next end event, weâ€™ll find that the start event pointed by i happens before the end event pointed by endsItr.Thus,now we have 4meetings started but only one ended,so we need one more room.And it goes on as this.

	public int minMeetingRooms(Interval[] intervals) {
	    if (intervals == null || intervals.length == 0)
	        return 0;
	        
	    // Sort the intervals by start time
	    Arrays.sort(intervals, new Comparator<Interval>() {
	        public int compare(Interval a, Interval b) { return a.start - b.start; }
	    });
	    
	    // Use a min heap to track the minimum end time of merged intervals
	    PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, (a,b)->a.end-b.end);
	    
	    // start with the first meeting, put it to a meeting room
	    heap.offer(intervals[0]);
	    
	    for (int i = 1; i < intervals.length; i++) {
	        // get the meeting room that finishes earliest
	        Interval interval = heap.poll();
	        
	        if (intervals[i].start >= interval.end) {
	            // if the current meeting starts right after 
	            // there's no need for a new room, merge the interval
	            interval.end = intervals[i].end;
	        } else {
	            // otherwise, this meeting needs a new room
	            heap.offer(intervals[i]);
	        }
	        
	        // don't forget to put the meeting room back
	        heap.offer(interval);
	    }
	    
	    return heap.size();
	}
}
