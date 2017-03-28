
/**
 * The PriorityQueue class is used to create the heap and organize the heap depending on the priority of the individual customer.
 * The program will decide where to place each customer based off of their priority compared to the priorities of the customers
 * surrounding them. Customer with the highest priority is moved to the top of the heap with the higher priorities following but
 * not surpassing if there priority is higher than the one being currently serviced.
 * 
 * @author (Michael Blackley) 
 * @version (03/25/2015)
 */
public class PriorityQueue
{
    private PriorityCustomer[] heap;  //creation of the heap
    private int size;

    public PriorityQueue()
    {
       
        heap = new PriorityCustomer[100];  //sets the size of the heap
        size = 0;
    }
    
    
        public int getIndex()  //method returns the index of the customer based off of the size of the heap
    {
       PriorityCustomer x;
       x = heap[1];
       int index = size + 1;
       return index;
    }
    
    
    public PriorityCustomer getMax() //method returns the values of the customer at the top of the heap
    {
      return heap[1];
    }
    
    
    public int getSize()  //method returns the size of the heap
    {
      return size;
    }
    
      
    public void add (PriorityCustomer x)  //method adds customers to the heap
    {
        int index = size + 1;
        heap[index] = x;
        
        while (index > 1) //makes sure there is at least one customer in the heap
        {
            int parentIndex = index / 2;
            int rightChildIndex = (index *2) + 1;
            int leftChildIndex = index * 2;
             
            if(heap[parentIndex] == null)  //if the parentIndex is empty it shifts the next index up
            {
                heap[index] = heap[parentIndex];
                heap[parentIndex] = x;
                
                index = parentIndex;
            }
            
            if(parentIndex > 1 && heap[parentIndex].getPriority() < x.getPriority())  //checks if the priority of the parent is less than the priority of the cusomer being added
            {
                heap[index] = heap[parentIndex];
                heap[parentIndex] = x;
                
                index = parentIndex;
            }
            

            else
            {
                break;
            }
        }
        size++;

    }
    
   public PriorityCustomer remove () {
      PriorityCustomer rootValue = heap[1];      //store root value to return at the end
      PriorityCustomer v = heap[size];           //store last value in heap in v
      heap[1] = v;                     //take v and move to root
      heap[size] = null;               //delete node at last position (b/c we moved it to the root)
   
      int index = 1;
      
      while(index * 2 < size){      //is there at least one child at index
         int leftIndex = index * 2;
         int rightIndex = leftIndex + 1;
         
         PriorityCustomer leftValue = heap[leftIndex];
         PriorityCustomer rightValue = null;
         
         if(rightIndex < size){     //there is a right child
            rightValue = heap[rightIndex];
         }
         
         PriorityCustomer maxChild;
         int maxIndex;                  

         if(leftValue == null) //checks if there is a left value
      {
         break;

      }
         else if(rightValue == null) //checks if right value is null
         {
            maxChild = leftValue;
            maxIndex = leftIndex;
         }
         else if(leftValue.getPriority() >= rightValue.getPriority())  //checks if the left priority is greater than or equal to the right priority
         {
            maxChild = leftValue;
            maxIndex = leftIndex;
         }

         else{                          //if all prior conditions fail it assigns max child to right value and max index to the right index
            maxChild = rightValue;
            maxIndex = rightIndex;         
         }
         
         if(v.getPriority() < maxChild.getPriority()){             //value is less than the larger child -> swap
            heap[index] = maxChild;                                //perform swap with larger of two children
            heap[maxIndex] = v;
            index = maxIndex;
         }else{
            break;                     //value is in a valid position -> stop
         }
      }
      
      size --;                      //update size
      
      return rootValue;  
}

}