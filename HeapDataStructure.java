import java.nio.channels.ServerSocketChannel;
import java.util.Scanner;

/**
 * Created by TITASH MANDAL on 9/3/2017.
 */

//Time complexity for Building a Binary Heap is O(n).
// HeapSort takes O(nlog(n))
public class HeapDataStructure {
    protected int[] heap;
    protected int HeapSize;
    protected int  CurrentCapacity;
    public HeapDataStructure(int HeapSize){
        this.HeapSize=HeapSize;
        this.heap=new int[HeapSize];
        this.CurrentCapacity=0;
    }

    // to get index of parent of node at index i
    protected int returnParent(int i){
        return (i-1)/2;
    }

    // to get index of left child of node at index i
    protected int returnLeft(int i){
        return ((i*2)+1);
    }

    // to get index of left child of node at index i
    protected int returnRight(int i){
        return ((i*2)+2);
    }

    //From an arbitrary list build a heap
    protected void Build_Heap_from_list(int[] array,int size){
        //Rewriting the Current Capacity and the Heap array of the object
        CurrentCapacity=size;
        int i;
        for(i=0;i<size;i++){
            heap[i]=array[i];
        }
        for(int j=i;j<HeapSize;j++){
            heap[j]=0;
        }
        for(i=(size/2);i>=0;i--){
            Heapify(i);
        }
        print();
        HeapSort();
    }
     protected void HeapSort(){
         System.out.println("Sorting the heap: ");
         int count=0;
         for(int i=CurrentCapacity-1;i>=0;i--){
             System.out.print(" "+ heap[count]);
             count++;
             int temp=heap[i];
             CurrentCapacity=CurrentCapacity-1;
             heap[i]=heap[0];
             heap[0]=temp;
             Heapify(0);
         }
         System.out.println();

     }

    //After returning or removing a value maintain heap structure
    protected void Heapify(int i){
        //get the left and right indices
        int left=returnLeft(i);
        int right=returnRight(i);
        int smallest=i;
        //check which is smallest the left side, the right or the node itself
        if(left<CurrentCapacity && heap[left]<heap[smallest]){
            smallest=left;
        }
        if(right<CurrentCapacity && heap[right]<heap[smallest]){
            smallest=right;
        }
        if(smallest!=i){
            int temp=heap[smallest];
            heap[smallest]=heap[i];
            heap[i]=temp;
            Heapify(smallest);
        }
    }

    //Insert a new value in the heap
    protected void InsertKey(int value){

        //Check if the heap is already filled or not
        if(CurrentCapacity==HeapSize){
            System.out.println("MAXIMUM CAPACITY REACHED");
        }
        //Increase the current Capacity and place the value

        else {

            heap[CurrentCapacity]=value;
            CurrentCapacity++;

        }
        int i=CurrentCapacity-1;
        int temp;
        //Now try to maintain the heap Invariant as the parent should be smaller than the child nodes
        while(i!=0 && heap[i]<heap[returnParent(i)]){
            temp=heap[returnParent(i)];
            heap[returnParent(i)]=heap[i];
            heap[i]=temp;
            i=returnParent(i);
        }
    }

    //Print all elements of the heap
    protected void print(){
        for(int i=0;i<CurrentCapacity;i++){
            System.out.print(" "+heap[i]);

        }
        System.out.println();
    }

    //extract the minimum value and print
    protected int extractMin(){
        int root;

        if(CurrentCapacity==0){
            return 0;
        }

        else{
            root=heap[0];
            heap[0]=heap[CurrentCapacity-1];
            CurrentCapacity--;
            Heapify(0);
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println("The Min Heap is ");
        HeapDataStructure minHeap = new HeapDataStructure(15);
        minHeap.InsertKey(10);
        minHeap.InsertKey(30);
        minHeap.InsertKey(50);
        minHeap.InsertKey(35);
        minHeap.InsertKey(38);
        minHeap.InsertKey(60);
        minHeap.InsertKey(69);
        minHeap.InsertKey(50);
        minHeap.print();
            System.out.println("Min heap Value is " + minHeap.extractMin());
            minHeap.print();



        Scanner sc=new Scanner(System.in);
        System.out.println("Enter value to insert in the Heap: ");
        int value=sc.nextInt();
        minHeap.InsertKey(value);
        minHeap.print();
        int[] array=new int[]{4,10,3,5,1};
        System.out.println("Converting any list to a MinHeap");
        int sizeArray=array.length;
        minHeap.Build_Heap_from_list(array,sizeArray);
        minHeap.print();



    }
}
