package BrickWall554;

public class BrickWall554 {
	/*
	 * using hash map we don't need to calculate all the virtical point in a row
	 * but only point has space in a row
	 * find the vertical line with most space
	 */
    public int leastBricks(List<List<Integer>> wall) {
        int m = wall.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(List<Integer> row : wall){
            int index = 0;
            for(int j = 0; j<row.size()-1; j++){
                index += row.get(j);
                if(map.containsKey(index)){
                    map.put(index,map.get(index)+1);
                }else{
                    map.put(index,1);
                }
            }
        }
        int max = 0;
        for(int key: map.keySet()){
            max = Math.max(max,map.get(key));
        }
        return m-max;
    }
}
