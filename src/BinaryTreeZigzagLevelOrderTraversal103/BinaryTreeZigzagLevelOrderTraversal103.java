package BinaryTreeZigzagLevelOrderTraversal103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTreeInorderTraversal94.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal103 {
	/*
	 * BFS用stack 每层先创建一个size，来跑for循环,list.add(0,xxxx)加到最前面
	 * 用level记录层数，用奇数偶数判断家在前还是后
	 */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(null==root){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> curList = new ArrayList<Integer>();
            for(int i = 0; i<size; i++){
                TreeNode cur = q.poll();
                if(level%2==0){
                    curList.add(cur.val);
                }
                else{
                    curList.add(0,cur.val);
                }
                
                if(null!=cur.left){
                    q.add(cur.left);
                }
                if(null!=cur.right){
                    q.add(cur.right);
                }
            }
            res.add(curList);
            level++;
        }
        return res;
    }
}
