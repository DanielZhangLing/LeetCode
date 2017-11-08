package SerializeandDeserializeBST449;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import BinaryTreeInorderTraversal94.TreeNode;

public class SerializeandDeserializeBST {

    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder data = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i <size; i++){
                TreeNode cur = q.poll();
                if(cur!=null){
                    data.append(cur.val);
                    data.append(",");
                    q.add(cur.left);
                    q.add(cur.right);
                }else{
                    data.append("N");
                    data.append(",");                    
                }

            }
        }
        return data.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.isEmpty()||data==""||data==null) return null;
        String[] dataA = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(dataA[0]));
        q.add(root);
        for(int i = 1; i<dataA.length; i++){
            TreeNode parent = q.poll();
            if(!dataA[i].equals("N")){
                parent.left = new TreeNode(Integer.parseInt(dataA[i]));
                q.add(parent.left);
            }
            if (!dataA[++i].equals("N")) {
                parent.right = new TreeNode(Integer.parseInt(dataA[i]));
                q.add(parent.right);
            }

        }
        return root;
    }
    
    
    
    
    // inorder traversal way
    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
