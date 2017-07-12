package NumberofAirplanesintheSky;
class Point{
    int time;
    int flag;
    Point(int time, int flag){
        this.time = time;
        this.flag = flag;
    }
    
    public static Comparator<Point> PointComparator = new Comparator<Point>(){
        public int compare(Point a, Point b){
            if(a.time == b.time){
                return a.flag-b.flag;
            }
            else{
                return a.time-b.time;
            }
        }
    };
}
public class NumberofAirplanesintheSky {
    public int countOfAirplanes(List<Interval> airplanes) { 
        int now=0, res = 0;
        ArrayList<Point> list = new ArrayList<Point>(airplanes.size()*2);
        for(int i = 0; i<airplanes.size();i++){
            list.add(new Point(airplanes.get(i).start, 1));
            list.add(new Point(airplanes.get(i).end, 0));
        }
        Collections.sort(list,Point.PointComparator);
        for(Point elm: list){
            if(elm.flag==1){
                now++;
            }
            else{
                now--;
            }
            res = Math.max(now,res);
        }
        return res;
    }
}
