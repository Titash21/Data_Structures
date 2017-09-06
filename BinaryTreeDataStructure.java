/**
 * Created by TITASH MANDAL on 9/3/2017.
 */

class Nodes{
    int value;
    Nodes left;
    Nodes right;
    public Nodes(int value){
        this.value=value;
        this.left=this.right=null;
    }

}
public class BinaryTreeDataStructure {
    Nodes root;
   BinaryTreeDataStructure(){
       root=null;
   }
   public void preorder(Nodes root){
       int[] array=new int[10];
       int i=0;
       if(root!=null){
           array[i]=root.value;
           i++;
       }
       preorder(root.left);
       preorder(root.right);
       for(int j=0;j<i;j++){
           System.out.println(" "+array[i]);
       }
   }

    public static void main(String[] args) {
        BinaryTreeDataStructure binaryTreeDataStructure=new BinaryTreeDataStructure();
        binaryTreeDataStructure.root = new Nodes(1);
        binaryTreeDataStructure.root.left = new Nodes(3);
        binaryTreeDataStructure.root.right = new Nodes(7);
        binaryTreeDataStructure.root.left.left = new Nodes(4);
        binaryTreeDataStructure.root.left.right = new Nodes(5);
        binaryTreeDataStructure.preorder(binaryTreeDataStructure.root);

    }
}
