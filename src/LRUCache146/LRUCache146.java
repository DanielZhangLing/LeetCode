package LRUCache146;

public class LRUCache146 {
	/*
	 * 
	 */
    HashMap<Integer,Integer> map;
    Queue<Integer> q;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<Integer,Integer>();
        q = new LinkedList<Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(map.get(key)==null)
            return -1;
        q.remove(key);
        q.add(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if(map.get(key)!=null){
            map.put(key, value);
            q.remove(key);
            q.add(key);
        }else{
            if(q.size()==capacity){
                int temp = q.poll();
                map.remove(temp);
            }
            map.put(key,value);
		q.add(key);
        }
    }
}
