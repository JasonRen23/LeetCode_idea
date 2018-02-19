package LeetCode_idea.dataStructure;



public class SegmentTreeNode {
    public int start, end;
    public SegmentTreeNode left, right;
    public int sum;

    public SegmentTreeNode(int start, int end){
        this.start = start;
        this.end = end;
        this.left = null;
        this.right = null;
        this.sum = 0;
    }
}
