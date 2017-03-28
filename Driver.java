import java.util.Random;
/**
 * The driver class takes the PriorityQueue class and generates a simulation of people waiting in line with priority numbers
 * which are how the customers are being serviced. Each customer is assigned a random number for their priority and their
 * service time. Based off the priority the driver calls the PriorityQueue class to sort the customers in the heap.
 * 
 * @author (Michael Blackley) 
 * @version (2/26/2015)
 */
public class Driver
{
    public static void main(String[] args)
    {
        int time;
        int random;
        int priority;
        int count = 0;
        int maximumLength = 0;
        int customersServiced = 0;
   
        PriorityQueue p = new PriorityQueue();  //create new queue

        for(int i = 0; i < 60; i++)             //beginning of the loop
        {
            random = new Random().nextInt(4) + 1;  //sets up random variable between 1 and 4
                   
              if(random == 1) //25% chance that a new customer is added
             {
                PriorityCustomer x = new PriorityCustomer();  //creates new customer for every iteration
           
                time = x.getServiceTime();//calls customer class and gets a service time
           
                priority = x.getPriority();  //sets priority equal to the new customers randomly generated priority
                  
                count++;                    //counts the amount of times a customer is added
             
                p.add(x);                   //adds the new customer to the queue
                
                System.out.println("New Customer Added!");
                System.out.println("Customers service time: " + time + " minutes");
                System.out.println("Queue length is now " + count);
               }

             
            if(count > maximumLength)
            {
                maximumLength = count;           //calculates the maximum length of the queue
            }

             if(count > 0)   //checks that there is at least one person in the queue
             {
                if(p.getMax().getServiceTime() == 0)   //checks to see if the customers service time is up
                {  
                 
                    count--;   //decrements one from the total number of customers in the queue
                    customersServiced++;  //increments the total amount of customers serviced
                    p.remove();       //removes customers from the list when their service time equals 0       
          
                    System.out.println("Customer serviced and removed from the queue.  Queue length is now " + count); 
                }
              }

                System.out.println("-------------------------------------------");             
        
         if(count > 0)  //checks that there is at least one person in the queue
         { 
            p.getMax().decServiceTime();   //decrements the service time of the first customer in the heap
         }
       
        }
        
        System.out.println(customersServiced + " customers were serviced");  //outputs how many customers were serviced
        System.out.println("Maximum line length: " + maximumLength);         //outputs the maximum length of the queue
    }
}
