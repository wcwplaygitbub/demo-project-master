package sort.tree;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(10);
        binarySearchTree.insert(6);
        midOrderTraverse(binarySearchTree.getTree());
        System.out.println("--------------");
        midOrderTraverseReverse(binarySearchTree.getTree());
        System.out.println("-------insert--------");
        insert(binarySearchTree.getTree(), 100);
        insert(binarySearchTree.getTree(), 0);
        insert(binarySearchTree.getTree(), 5);
        insert(binarySearchTree.getTree(), 7);
        midOrderTraverse(binarySearchTree.getTree());
        BinarySearchTree.Node node100 = find(binarySearchTree.getTree(), 100);
        BinarySearchTree.Node node11 = find(binarySearchTree.getTree(), 11);
        midOrderTraverse(binarySearchTree.getTree());
        System.out.println("-----------delete---------");
        binarySearchTree.delete(1);
        midOrderTraverse(binarySearchTree.getTree());
    }


    public static void insert(BinarySearchTree.Node node, int data){
        if (node == null){
            node = new BinarySearchTree.Node(data);
        }
        if (data < node.getData()){
            if (node.getLeftNode() == null){
                node.setLeftNode(new BinarySearchTree.Node(data));
            }else {
                insert(node.getLeftNode(), data);
            }
        }else {
            if (node.getRightNode() == null){
                node.setRightNode(new BinarySearchTree.Node(data));
            }else {
                insert(node.getRightNode(), data);
            }
        }
    }

    public static BinarySearchTree.Node find(BinarySearchTree.Node node, int data){
        if (node != null){
            if (data == node.getData()){
                return node;

            }else if (data < node.getData()){
                return find(node.getLeftNode(), data);
            }else {
                return find(node.getRightNode(), data);
            }
        }
        return null;
    }




    /**
     * 小到大
     * @param node
     */

    public static void midOrderTraverse(BinarySearchTree.Node node){
        if (node != null){
            midOrderTraverse(node.getLeftNode());
            System.out.println(node.getData());
            midOrderTraverse(node.getRightNode());
        }
    }

    /**
     * 大到小
     * @param node
     */

    public static void midOrderTraverseReverse(BinarySearchTree.Node node){
        if (node != null){
            midOrderTraverseReverse(node.getRightNode());
            System.out.println(node.getData());
            midOrderTraverseReverse(node.getLeftNode());
        }
    }

    public static void preOrderTraverse(BinarySearchTree.Node node){
        if (node != null){
            System.out.println(node.getData());
            preOrderTraverse(node.getLeftNode());
            preOrderTraverse(node.getRightNode());
        }
    }

    public static void postOrderTraverse(BinarySearchTree.Node node){
        if (node != null){
            postOrderTraverse(node.getLeftNode());
            postOrderTraverse(node.getRightNode());
            System.out.println(node.getData());
        }
    }


}
