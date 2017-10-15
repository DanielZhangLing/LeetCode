package Flatten2DVector251;

public class Vector2D implements Iterator<Integer> {
    int listIndex, intIndex;
    List<List<Integer>> vec2d;
    
    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        listIndex = 0;
        intIndex = 0;
    }

    @Override
    public Integer next() {
        return vec2d.get(listIndex).get(intIndex++);
    }

    @Override
    public boolean hasNext() {
        while(listIndex<vec2d.size()){
            if(intIndex<vec2d.get(listIndex).size())
                return true;
            else{
                intIndex = 0;
                listIndex++;
            }
        }
        return false;
    }
}

public class Vector2D {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public int next() {
        hasNext();
        return j.next();
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }
}