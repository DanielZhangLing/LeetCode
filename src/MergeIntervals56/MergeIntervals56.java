package MergeIntervals56;

public class MergeIntervals56 {
	
	/*
	 * The idea is to sort the intervals by their starting points. 
	 * Then, we take the first interval and compare its end with 
	 * the next intervals starts. As long as they overlap, we update 
	 * the end to be the max end of the overlapping intervals. 
	 * Once we find a non overlapping interval, 
	 * we can add the previous "extended" interval and start over.

Sorting takes O(n log(n)) and merging the intervals takes O(n).
 So, the resulting algorithm takes O(n log(n)).
	 */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals==null||intervals.size()==0)
            return result;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start-b.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals==null||intervals.size()==0)
            return res;
        PriorityQueue<Interval> q = new PriorityQueue<Interval>(intervals.size()*2, (a,b)->a.start==b.start?a.end-b.end:a.start-b.start);
        for(Interval i: intervals){
            q.add(new Interval(i.start,0));
            q.add(new Interval(i.end,1));
        }
        while(!q.isEmpty()){
            int l = q.poll().start;
            int r = l;
            int cap = 1;
            while(cap!=0){
                Interval cur = q.poll();
                if(cur.end==0)
                    cap++;
                if(cur.end==1){
                    cap--;
                    r = cur.start;
                }
            }
            res.add(new Interval(l,r));
        }
        return res;
    }
}
