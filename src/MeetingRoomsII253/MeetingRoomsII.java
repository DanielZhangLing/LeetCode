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
        List<Point> list = new ArrayList<>(intervals.length*2);
        for(Interval i : intervals){
          list.add(new Point(i.start, 1));
          list.add(new Point(i.end, 0));
        }
    
        Collections.sort(list,Point.PointComparator );
        int count = 0, ans = 0;
        for(Point p : list){
            if(p.flag == 1) {
                count++;
            }
            else {
                count--;
            }
            ans = Math.max(ans, count);
        }
    
        return ans;
    }

}

//Initially, endsItr points to the first end event, and we move i which is the start event pointer. As we examine the start events, weâ€™ll find the first two start events happen before the end event that endsItr points to, so we need two rooms (we magically created two rooms), as shown by the variable rooms. Then, as i points to the third start event, weâ€™ll find that this event happens after the end event pointed by endsItr, then we increment endsItr so that it points to the next end event. What happens here can be thought of as one of the two previous meetings ended, and we moved the newly started meeting into that vacant room, thus we donâ€™t need to increment rooms at this time and move both of the pointers forward.
//        Next, because endsItr moves to the next end event, weâ€™ll find that the start event pointed by i happens before the end event pointed by endsItr.Thus,now we have 4meetings started but only one ended,so we need one more room.And it goes on as this.
