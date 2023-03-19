package linkedlist;

/* The class LinkedList with its operations: create, isEmpty, getHead, setHead,
 * addHead, addTail, addInPlace, insert, deleteHead, delete, print, search, 
 * countNodes, clear, equals, reverse, copy, and mergeSorted.
 */

public class LinkedList 
{
   private Node head; // a reference to the beginning of the list
    
    // This constructor creates an empty linked list
    public LinkedList()
    {
        head=null;    
    }

    // This method returns a reference (link) to the head node of the list
    public Node getHead() {
        return head;
    }
    
        
    //This method checks if a list is empty or not. 
    public boolean isEmpty()
    {
        return(head==null);
    } 

    // This method outputs the values in all of the nodes of a list
    public void print()
    {
        Node curr = head;
        if (isEmpty())
        {
            System.out.println("The list is empty.");
            System.out.println("head --> |||");
        }
        else
        {
            System.out.println("The elements of the list are:");
            System.out.print("head --> ");
            while(curr != null)
            {
                System.out.print(curr.data.value + " --> ");
                curr = curr.next;
            }
            System.out.println("|||");
        }//end else

    } // end print
    
    // This method searches for a value in the list
    public boolean search(NodeData item)
    {
        Node curr = head;
        while(curr != null)
        {
            if(curr.data.compareTo(item) == 0)
                return true;
            curr = curr.next;
        }//end while
        return false;

    } // end Search

    // This method counts the number of nodes in a list
    public int countNodes()
    {
        int count = 0;
        Node curr = head;
        while(curr != null)
        {
             count++;
             curr = curr.next;
        }//end while
        return count;

    } // end countNodes
      
    // This method adds a node at the beginning of the list
    public void addHead(NodeData item)
    {
	  Node newNode = new Node(item);         
        if (isEmpty()) // empty list
            head = newNode;
        else  
       {
           newNode.next = head;
           head = newNode;
        }

    } // end addHead
    
    // This method adds a node at the end of the list
    public void addTail(NodeData item)
    {
        Node newNode = new Node(item);
        if (isEmpty()) // empty list
            head = newNode;
        else
        {
            Node curr = head;
            while (curr.next != null)
                curr = curr.next;
            curr.next = newNode;
        }

    } // end addTail

    // This method inserts a node at a given position in the list
    public void insert(NodeData item, int position)
    {
        Node newNode, // to refer to the new node that will contain value
             pred; // to refer to the predecessor of the node at position
        if (position <= 0 || position > countNodes()+1)
            System.out.println("Invalid position. Insert operation failed.");
        else if (isEmpty()) // Inserting into an empty list
            head = new Node(item); 
        else if(position == 1) // Inserting at the beginning
            addHead(item);
        else // Inserting in the middle or at the end
        {
            newNode = new Node(item);
            pred = head;
            for (int i=1; i <= position - 2; i++)
                pred = pred.next;
            newNode.next = pred.next;
            pred.next = newNode;
        }//end else
            
    } // end insert
  
    // This method deletes all nodes in the list (It empties the list)
    public void clear()
    {
        head = null;
    } 

// This method deletes the head node
    public void deleteHead()
    {
        if (head != null) // if not empty
           head = head.next;
    } 

    // This method deletes a node from a list at a given position 
    public void delete(int position)
    {
        Node pred, // to refer to the predecessor of the node at position
             curr; // to refer to the node that should be deleted
        if (isEmpty()) // Attempting to delete from an empty list
            System.out.println("Empty list. Delete operation failed."); 
        else if (position <=0 || position>countNodes())
            System.out.println("Invalid position. Delete operation failed.");
        else if(position == 1) // Deleting at the beginning
            deleteHead();
        else // Deleting in the middle or at the end
        {
            pred = head;
            for (int i=1; i <= position - 2; i++)
                pred = pred.next;
            curr = pred.next;
            pred.next = curr.next;
        }//end else
        
    } // end delete
    
      // This method adds an element to the linked list at the appropriate 
    // place while keeping the list sorted
    public void addInPlace(NodeData nd)
    {
        Node newNode, prev, curr;
        newNode = new Node(nd);
        curr = head;
        prev = null;
        // repeat as long as we did not reach the end of the list and we did
        // not reach a node with data greater than the new element
        while (curr!= null && nd.compareTo(curr.data) > 0) 
        {
            prev = curr; // prev is the node that precedes the current node
            curr = curr.next; // move to the next node
        } // end while
        if (prev == null) // inserting at the beginning
        {
            newNode.next = curr;
            head = newNode; // the head refer to the new node 
        }
           
        else  // prev != null - inserting in the middle or end
        {
            newNode.next = curr; // link the new node to the current node
            prev.next = newNode; // link the previous node to the new node
        } // end else        
  
    } // end addInPlace

  // This method checks if two LinkedList are equal 
    public boolean equals(LinkedList secondList)
    {
        if (countNodes() != secondList.countNodes()) // Different number of nodes
            return false;
        // If the two lists are of equal length, start from the head of each list 
        Node curr1 = head, curr2= secondList.head;
        while (curr1 != null)  // or curr2 != null 
        {
           // node in list1 has different data than corresponding node in list 2?
            if (curr1.data.compareTo(curr2.data)!=0)
                return false;
            curr1 = curr1.next; // go to the next node in list 1
            curr2 = curr2.next; // go to the next node in list 2
        } // end while        
        return true;

    } // end equals

       // This method copies the content of list 1 to list 2
    public LinkedList copy()
    {
        LinkedList list2 = new LinkedList(); // list 2 is empty     
        Node curr1 = head;
        while (curr1 != null)   
        {
            list2.addTail(curr1.data); //add at the end of list 2
            curr1 = curr1.next;
        } // end while
        return list2;

    } // end copy
    
    // This method reverses the elements of list 1 in list 2
    public LinkedList reverse() // This is the method explained in class
    {
        LinkedList list2 = new LinkedList(); // list 2 is empty
        if (isEmpty()) // if list 1 is empty
                return list2;  // list 2 is also empty      
         Node curr1 = head;
         while (curr1 != null)   
         {
            list2.addHead(curr1.data); //add at the head of list 2
            curr1 = curr1.next;
        } // end while
        return list2;

    } // end reverse
    
      // This method reverses the list elements (without creating a new list)
    public void reverse2() // This is the method explained in your textbook
    {
        Node link1, link2, link3;
        
         // if the list is empty or contains only one node
        if (isEmpty() || countNodes()==1)
                return;  // already reversed
        
         link1 = head;
         link2 = link1.next;
         link1.next = null;
         while (link2 != null)   
         {
           link3 = link2.next;
           link2.next = link1;
           link1 = link2;
           link2 = link3;
        } // end while
        head = link1;
        
    } // end reverse2
    
     // This method merges two sorted lists. The new list is sorted too. 
    public LinkedList mergeSorted(LinkedList secondList)
    {
        LinkedList mergedList = new LinkedList();
        Node curr1 = head, curr2 = secondList.head;
        while (curr1 != null && curr2 != null) 
        {
            if(curr1.data.compareTo(curr2.data) < 0)
            {
                mergedList.addTail(curr1.data);
                curr1 = curr1.next;
            }
            else 
            {
                mergedList.addTail(curr2.data);
                curr2 = curr2.next;
            }
        } // end while
        
        // In case the first list is longer (it still has nodes)
        while (curr1 != null) 
        {
             mergedList.addTail(curr1.data);
             curr1 = curr1.next;
        }
        
          // In case the second list is longer (it still has nodes)
        while (curr2 != null) 
        {
             mergedList.addTail(curr2.data);
             curr2 = curr2.next;
        }
        return mergedList;
    } // end mergeSorted
    
    /**
     * @param list1
     * @param list2
     * @return
     * mergeUnsortedLists takes two unsorted linked lists and returns a sorted linked list
     */
    public static LinkedList mergeUnsortedLists(LinkedList list1, LinkedList list2)
    {
        LinkedList mergedList = new LinkedList();
        Node curr1 = list1.head;
        Node curr2 = list2.head;

        while(curr1 != null && curr2 != null) //loop to go through both lists
        {
            mergedList.addInPlace(curr1.data);//using addInPlace method we add each node in its place in the new list
            curr1 = curr1.next;
            mergedList.addInPlace(curr2.data);
            curr2 = curr2.next;
        }
        while(curr1 != null) //in case list 1 is longer
        {
            mergedList.addInPlace(curr1.data);
            curr1 = curr1.next;
        }
        while(curr2 != null)//in case list 2 is longer
        {
            mergedList.addInPlace(curr2.data);
            curr2 = curr2.next;
        }
        return mergedList;
        
    }

    public static LinkedList multiply(LinkedList list1)
    {
        LinkedList list2 = new LinkedList();
        Node curr1 = list1.head;
        int mult = 1;
        //Declare the datafields

        for(int i = 0; i < list1.countNodes(); i++)
        {
            mult = mult * curr1.data.value;
            list2.addTail(new NodeData(mult));
            curr1 = curr1.next;
        }
        return list2;
    }

    /**
     * @param a
     * @param b
     * @return true if linkedlist b is a subset of the linkedlist a
     */
    public static boolean isSubset(LinkedList a, LinkedList b)
    {
        Node curr = a.head;
        int counter = 0;

        while(curr != null)
        {
            Node curr2 = b.head;//curr 2 is initialized inside the outer loop so it resets with each eteration of the inner loop
            while(curr2 != null)
            {
               if(curr.data.value == curr2.data.value)
               counter++; //the counter will be incremented if the element from list b is found in list a
               curr2 = curr2.next;
            }

            curr = curr.next;
        }
        if(counter == b.countNodes())
            return true;
        return false;

    }

    public void swap(int i, int j)
    {
        Node curr1 = head;
        Node curr2 = head;
        Node temp = head;

        for(int l = 0; l < i; i++)
        {
            curr1 = curr1.next;
        }

        for(int l2 = 0; l2 < j; l2++)
        {
            curr2 = curr2.next;
        }

        temp = curr1;
        curr1 = curr2;
        curr2 = temp;
    }

} // end LinkedList
