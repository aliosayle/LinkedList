package linkedlist;

import java.util.*;

public class Application 
{
    public static void main(String[] args) 
    {
        // Declarations
        NodeData value;
        int position, listSize;
        Scanner scan;
        char option;
        LinkedList list1, list2;
                
        list1 = new LinkedList();
        list2 = new LinkedList();
        
        scan = new Scanner(System.in);
        
        do
        {
            System.out.println("Menu");
            System.out.println("====");
            System.out.println("Enter an option.");
            System.out.println("Enter a to add at the head, A to add at the tail,");
            System.out.println("I to addInPlace, i to insert, d to delete, D to");
            System.out.println(" delete at the Head, p to print, s to search, c");
            System.out.println(" to count nodes, C to create a copy of the list");
            System.out.println(", e to check if two lists are equal, r to reverse");
            System.out.println(", m to merge two sorted lists, and x to exit:");
            option = scan.next().charAt(0);
            if(option == 'a')
            {
                System.out.print("Enter an integer value: ");
                value=new NodeData(scan.nextInt());
                list1.addHead(value);
                System.out.println("Enter p to see the list after the addHead.");
            }
            else if(option == 'A')
            {
                System.out.print("Enter an integer value: ");
                value=new NodeData(scan.nextInt());
                list1.addTail(value);
                System.out.println("Enter p to see the list after the addTail.");
            }
            else if(option == 'I')
            {
                System.out.print("Enter an integer value: ");
                value=new NodeData(scan.nextInt());
                list1.addInPlace(value);
                System.out.println("Enter p to see the list after addInPlace.");
            }
            else if(option == 'i')
            {
                System.out.print("Enter an integer value and a position: ");
                value=new NodeData(scan.nextInt());
                position=scan.nextInt();
                list1.insert(value, position);
                System.out.println("Enter p to see the list after insertion.");
            }
            else if(option == 'd')
            {
                System.out.print("Enter the position of the node to delete: ");
                position=scan.nextInt();
                list1.delete(position);
                System.out.println("Enter p to see the list after deletion.");
            }
            else if(option == 'D')
            {
                list1.deleteHead();
                System.out.println("Enter p to see the list after deleteHead.");
            }
             else if(option == 'p')
                list1.print();
             else if(option == 's')
             {
                System.out.print("Enter the value to search for: ");
                value=new NodeData(scan.nextInt());
                if(list1.search(value))
                    System.out.println(value + " is in the list.");
                else
                    System.out.println(value + " is not in the list.");
             }
             else if(option == 'c')
                    System.out.println("The number of nodes is: "+list1.countNodes());
             else if(option == 'r')
             {
                 list1 = list1.reverse();
                 // or 
                 // list1.reverse2();
                 System.out.println("Done resversing the list.");
                 list1.print();
             }
             else if(option == 'C')
             {
                 list2 = list1.copy();
                 System.out.println("Done copying the list elements to a new list.");
                 list2.print();
             }
             else if(option == 'e')
             {
                 if(list1.equals(list2))
                      System.out.println("The two lists are equal.");
                 else 
                     System.out.println("The two lists are not equal.");
                 System.out.println("First List:");
                 list1.print();
                 System.out.println("Second List:");
                 list2.print();
             }
             else if(option == 'm')
             {
                 list1.clear(); // empty list 1
                 System.out.println("Now building a sorted list 1");
                 System.out.print("Enter the size of the list: ");
                 listSize = scan.nextInt();
                 System.out.print("Enter the elements (in ascending order): "); 
                 for (int i=1; i<=listSize; i++) 
                 {
                    value=new NodeData(scan.nextInt());
                    list1.insert(value, i);
                 }
                 list1.print();
                 list2.clear(); // empty list 2
                 System.out.println("Now building sorted list 2");
                 System.out.print("Enter the size of the list: ");
                 listSize = scan.nextInt();
                 System.out.print("Enter the elements (in ascending order): ");
                 for (int i=1; i<=listSize; i++) 
                 {
                    value=new NodeData(scan.nextInt());
                    list2.insert(value, i);
                 }
                 list2.print();
                 // Now merge list1 and list2. List3 is also sorted
                 LinkedList list3 = list1.mergeSorted(list2);
                 System.out.println("list 3 (merged list)");
                 list3.print();
             }
              
             else if (option!='x')
                 System.out.println("Invalid option.");
    
        }while (option!='x');
        System.out.println("The end.");
     
    }// end main

}
