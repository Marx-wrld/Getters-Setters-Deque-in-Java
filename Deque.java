// Deque.java

/**
* The class Deque implements a double-ended queue with a doubly linked list.
* The list uses a header and a trailer (dummy) nodes.
*/
public class Deque
{
   /**
   * Default constructor. Sets this object as an empty deque.
   *
   */
   public Deque()
   {
       front = new Node();
       back = new Node();
       front.setNext(back);
       back.setPrev(front);
       count = 0;
   }

   public Deque(boolean b, int info) {
}

/**
   * Adds new element to the back end of the deque. The method takes O(1)
   * time.
   *
   * @param x new element to be added to the deque.
   */
   public void addToBack(int x)
   {
       // create a new node for x
       Node node = new Node();
       node.setInfo(x);
       // set next of node to back
       node.setNext(back);
       // set previous last node's next to node
       back.getPrev().setNext(node);
       // set prev of node to previous last node
       node.setPrev(back.getPrev());
       // set prev of back to node
       back.setPrev(node);
       count++; // increment count
   }
  
   /**
   * Adds new element to the front end of the deque. The method takes O(1)
   * time.
   *
   * @param x new element to be added to the deque.
   */
   public void addToFront(int x)
   {
       // create a new node for x
       Node node = new Node();
       node.setInfo(x);
       // set prev of node to front
       node.setPrev(front);
       // set next of node to previous first node
       node.setNext(front.getNext());
       // set prev of previous first node to node
       node.getNext().setPrev(node);
       // set next of front to node
       front.setNext(node);
       count++; // increment count
   }

   /**
   * Retrieves element on the back end of the deque. The method takes O(1)
   * time.
   *
   * @return operation is successful: valid = true and item = element on the
   * back end; operation is unsuccessful (i.e. empty deque): valid = false and
   * item = dummy value
   */
   public Deque getBack()
   {
       Deque item;
       if(!isEmpty()) // not empty
           item = new Deque(true, back.getPrev().getInfo());
       else // empty
           item = new Deque();
       return item;
   }

   /**
   * Retrieves element on the front end of the deque. The method takes O(1)
   * time.
   *
   * @return operation is successful: valid = true and item = element on the
   * front end; operation is unsuccessful (i.e. empty deque): valid = false and
   * item = dummy value
   */
   public Deque getFront()
   {
       Deque item;
       if(!isEmpty()) // not empty
           item = new Deque(true, front.getNext().getInfo());
       else // empty
           item = new Deque();
       return item;
   }

   /**
   * Determines if deque is empty. The method takes O(1) time.
   *
   * @return true if deque contains no elements, false otherwise.
   */
   public boolean isEmpty()
   {
       return count == 0;
   }

   /**
   * Removes element on the back end of the deque. The method takes O(1) time.
   *
   * @return false if removal cannot be performed (i.e. the deque is empty),
   * true otherwise
   */
   public boolean removeBack()
   {
       if(!isEmpty()) // not empty
       {
           // set prev of back to second last node
           back.setPrev(back.getPrev().getPrev());
           // update next of last node to back
           back.getPrev().setNext(back);
           count--; // decrement count
           return true;
       }
      
       return false;
   }
  
   /**
   * Removes element on the front end of the deque. The method takes O(1)
   * time.
   *
   * @return false if removal cannot be performed (i.e. the deque is empty),
   * true otherwise
   */
   public boolean removeFront()
   {
       if(!isEmpty()) // not empty
       {
           // set next of front to second node
           front.setNext(front.getNext().getNext());
           front.getNext().setPrev(front); // update prev of new first node to front
           count--; // decrement count by 1
           return true;
       }
      
       return false;
   }

   /**
   * Constructs a String description of the deque.
   *
   * @return String containing the deque elements.
   */
   public String toString()
   {
       String str = "";

       Node current = front.getNext();
       for (int i = 0; i < count - 1; i++)
       {
           str += current.getInfo() + ", ";
           current = current.getNext();
       }
      
       if (count != 0)
           return "Deque: [" + str + back.getPrev().getInfo() + "]";
       else
           return "Deque: []";
   }

   private int count; //number of elements in the deque
   private Node back; //points to the item in the back
   private Node front; //points to the item in the front
  
}