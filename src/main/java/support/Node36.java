package support;

public class Node36 extends Tree<Node36> {
    public Node36() {}

    public Node36(int _val) {
        val = _val;
    }

    public Node36(int _val, Node36 _left, Node36 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
