package PopulatingNextRightPointersinEachNode;

public class PopulatingNextRightPointersinEachNode {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
        Queue<TreeLinkNode> Q = new LinkedList<TreeLinkNode>();
        Q.add(root);
        while(!Q.isEmpty()){
            int size = Q.size();
            for(int i = 0; i<size; i++){
                TreeLinkNode temp = Q.poll();
                if(i != size-1){
                    temp.next = Q.peek();
                }
                    
                if(temp.left!=null){
                    Q.add(temp.left);
                }
                if(temp.right!=null){
                    Q.add(temp.right);
                }
            }       
        }
    }
}
