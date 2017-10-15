package SimplifyPath71;

public class SimplifyPath71 {
	/*
	 * use stack to maintain root and split get every thing and end from front
	 */
    public String simplifyPath(String path) {
        if(path.equals("/"))
            return path;
        StringBuffer res = new StringBuffer();
        Stack<String> stack = new Stack<String>();
        String[] temp = path.split("/");
        for(String str: temp){
            if(str.equals("")||str.equals("."))
                continue;
            else if(str.equals("..")){
                if(stack.isEmpty())
                    continue;
                stack.pop();    
            }
            else
                stack.push(str);
        }
        while(!stack.isEmpty()){
            res.insert(0,stack.pop()).insert(0,"/");
        }
        String result = res.toString();
        return result.equals("")? "/":result;
    }
}
