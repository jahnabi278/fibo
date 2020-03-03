package testFibo;

public class Node {
	  Node child, left, right, parent;    
	    int element;
	    int degree; 
		 boolean mark=false;
		 String c;
	 	public Node(int element)
	    {
	        this.right = this;
	        this.left = this;
	        this.element = element;
	    }
	 	Node()
	 	{
	 		
	 	}
}
