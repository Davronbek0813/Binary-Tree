package tree;

public class BinaryTree {
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    private Node root;
    public void insert(int item){
        if(root==null){
            root=new Node(item);
            return;
        }
        var current=root;

        while (true){

            if(current.value<item){ //right
                if(current.right==null){
                    current.right=new Node(item);
                    break;
                }
                current=current.right;
            }else { //left
                if(current.left==null){
                    current.left=new Node(item);
                    break;
                }
                current=current.left;

            }
        }
    }
    public void preeOrder(){
        preeOrder(root);
    }
    public void preeOrder(Node root){
        if(root==null) return;

        System.out.print(root.value+" ");
        preeOrder(root.left);
        preeOrder(root.right);

    }
    public void inOrder(){
        inOrder(root);
    }
    public void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.value+" ");
        inOrder(root.right);


    }
    public void postOrder(){
        postOrder(root);
    }
    public void postOrder(Node root){
        if(root==null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value+" ");
    }
    public int height(){
        return height(root);
    }
    public int height(Node root){
        if(root==null){
            return 0;
        }

        int lheight=height(root.left);
        int rheight=height(root.right);
        if(lheight>rheight){
            return (lheight+1);
        }else{
            return (rheight+1);
        }
    }
    public void levelOrder(){

        int h=height();
        for(int i=1; i<=h;i++){
            levelOrder(root,i);
        }

    }
    public void levelOrder(Node root,int level){
        if(root==null) return;
        if(level==1){
            System.out.print(root.value+" ");
        }
        else{
            levelOrder(root.left,level-1);
            levelOrder(root.right,level-1);
        }
    }

    public boolean find(int item){
        var current=root;
        while (current!=null){
            if(item>current.value){
                current=current.right;
            }else if(item<current.value){
                current=current.left;
            }else return true;
        }
        return  false;
    }
}
