package sort.tree;

public class BinarySearchTree {

    private Node tree;
    public Node getTree(){
        return this.tree;
    }

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (data < p.data) {
                p = p.leftNode;
            } else if (data > p.data) {
                p = p.rightNode;
            } else {
                return p;
            }
        }
        return null;
    }

    public Boolean insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return true;
        }
        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                // 插入右节点
                if (p.rightNode == null) {
                    p.rightNode = new Node(data);
                    return true;
                }
                p = p.rightNode;
            } else {
                // 插入 左节点
                if (p.leftNode == null) {
                    p.leftNode = new Node(data);
                    return true;
                }
                p = p.leftNode;
            }
        }
        return false;
    }

    public void delete(int data){
        // 根都没有直接返回
        if (tree == null){
            return;
        }
        // 删除 root 节点 直接=null
        if (tree.data == data){
            tree = null;
        }
        // 找到 要删除的节点
        Node p = tree;
        Node pp = null;
        while (p != null && p.data != data){
            pp = p;
            if (data < p.data){
                p = p.leftNode;
            }else{
                p = p.rightNode;
            }
        }
        // 找到了
        if (p != null){
           // 要删除的节点只有一个子节点，将 父节点指向其子节点
            if (p.leftNode != null && p.rightNode == null){
                if (pp.data > p.data){
                    pp.leftNode = p.leftNode;
                }else {
                    pp.rightNode = p.leftNode;
                }
            }
            if (p.leftNode == null && p.rightNode != null){
                if (pp.data > p.data){
                    pp.leftNode = p.rightNode;
                }else {
                    pp.rightNode = p.rightNode;
                }
            }
            // 叶子节点  父节点指向 null
            if (p.leftNode == null && p.rightNode == null){
                if (pp.data > p.data){
                    pp.leftNode = null;
                }else {
                    pp.rightNode = null;
                }
            }
            // 要删除的节点有两个子节点。
            // 要找到左子树的最大值 用其替换要删除的节点，然后将 左子树的最大值=null
            if (p.leftNode != null && p.rightNode != null){
                // 找到左子树的最大值
                Node leftMax = p.leftNode;
                Node leftMaxParent = p;
                while (leftMax.rightNode != null){
                    leftMaxParent = leftMax;
                    leftMax = leftMax.rightNode;
                }
                p.data = leftMax.data;
                leftMaxParent.rightNode = null;
            }
        }



    }






    static class Node {
        private int data;
        private Node leftNode;
        private Node rightNode;

        public Node(int data) {
            this.data = data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public int getData(){
            return this.data;
        }
        public Node getLeftNode(){
            return this.leftNode;
        }
        public Node getRightNode(){
            return this.rightNode;
        }
    }
}

