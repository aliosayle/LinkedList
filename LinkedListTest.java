public class LinkedListTest {
    public static void main(String[] args) {
        // Create the first LinkedList
        LinkedList list1 = new LinkedList();
        list1.addTail(new NodeData(1));
        list1.addTail(new NodeData(6));
        list1.addTail(new NodeData(87));
        list1.addTail(new NodeData(234));
        list1.addTail(new NodeData(5));

        // Create the second LinkedList
        LinkedList list2 = new LinkedList();
        list2.addTail(new NodeData(6));
        list2.addTail(new NodeData(87));
        list2.addTail(new NodeData(5));
        
        

        LinkedList list3 = LinkedList.mergeUnsortedLists(list1, list2);
        
        list1.print();
        list2.print();

        list3.print();

        LinkedList list4 = LinkedList.multiply(list1);
        list4.print();

        boolean sub = LinkedList.isSubset(list1, list2);
        if(sub)
        System.out.println("is subset");
        else
        System.out.println("is not subset");
    }
}