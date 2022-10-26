// Node.java

public class Node
{
   private int info;
   private Node next;
   private Node prev;
  
   // default constructor
   public Node()
   {
       info = 0;
       next = null;
       prev = null;
   }
  
   // getters
   public int getInfo()
   {
       return info;
   }
  
   public Node getNext()
   {
       return next;
   }
  
   public Node getPrev()
   {
       return prev;
   }
  
   // setters
   public void setInfo(int i)
   {
       info = i;
   }
  
   public void setNext(Node n)
   {
       next = n;
   }
  
   public void setPrev(Node p)
   {
       prev = p;
   }
}