package testFibo;

public class FiboHeap 
{
	     Node mini =null;
		 int no_of_nodes=0;
	    private void insertInternal(int element)
	    {
	       Node new_node = new Node(element);
	        new_node.element = element;
	        new_node.degree = 0; 
	        new_node.mark = false; 
	        new_node.c = "N"; 
        	new_node.parent=null;
            new_node.child = null; 
            new_node.left = new_node; 
            new_node.right = new_node;
            if(mini==null ) 
            {
            	mini = new_node;
            }
            else
            {
               (mini.left).right = new_node; 
               new_node.right = mini; 
               new_node.left = mini.left; 
               mini.left = new_node;
               if(new_node.element<mini.element) 
            	   mini=new_node;
            }
            no_of_nodes = no_of_nodes+1;
          
	    }  
	    
	    /**
	     * 
	     * @param element
	     * 
	     */
	    public void insert(int element) 
	    {
	    	//Node node=new Node();
	    	insertInternal(element);
	    }
	    
	    /**
	     * 
	     * @param h2
	     * @param h1
	     */
		 public void Fib_Heap_Union(Node h2,Node h1) 
		 {
			 (h2.left).right = h2.right;
			 (h2.right).left = h2.left;
			 if(h1.right == h1) 
			 {
				 mini = h1;
			 }
			 h2.left = h2;
			 h2.right =h2;
			 h2.parent=h1;
			 //concatenate the root of h2 with the root of h1
			 if(h1.child==null) 
			 
				 h1.child =h2;
			 	 h2.right=h1.child;
			 	 h2.left=(h1.child).left;
			 	((h1.child).left).right=h2;
			 	(h1.child).left=h2;
			 	if(h2.element<(h1.child).element)
			 	
			 		h1.child=h2;
			 		h1.degree++;
		 }
		 
		 void Fib_heap_Extract_Min() 
		 { 
		     if (mini == null) 
		         System.out.println("Empty heap "); 
		     else { 
		         Node temp = mini; 
		         Node pntr; 
		         pntr = temp; 
		         Node x = null; 
		         if (temp.child != null) { 
		   
		             x = temp.child; 
		             do { 
		                 pntr = x.right; 
		                 (mini.left).right = x; 
		                 x.right = mini; 
		                 x.left = mini.left; 
		                 mini.left = x; 
		                 if (x.element < mini.element) 
		                     mini = x; 
		                 x.parent = null; 
		                 x = pntr; 
		             } while (pntr != temp.child); 
		         } 
		         (temp.left).right = temp.right; 
		         (temp.right).left = temp.left; 
		         mini = temp.right; 
		         if (temp == temp.right && temp.child == null) 
		             mini = null; 
		         else { 
		             mini = temp.right; 
		             consolidate(); 
		         } 
		         no_of_nodes--; 
		     } 
		 } 

	 	private void consolidate()
		 {
			
			 int temp1; 
			    double temp2 = Math.ceil((Math.log(no_of_nodes)));  
			    Node arr [] = new Node[(int) temp2]; 
			    for (int i = 0; i<temp2; i++) 
			        arr[i] = null; 
			    Node pntr1 = mini; 
			    Node pntr2; 
			    Node pntr3; 
			    Node pntr4 = pntr1; 
			    do { 
			        pntr4 = pntr4.right; 
			        temp1 = pntr1.degree; 
			        while (arr[temp1] != null) { 
			            pntr2 = arr[temp1]; 
			            if (pntr1.element > pntr2.element) { 
			                pntr3 = pntr1; 
			                pntr1 = pntr2; 
			                pntr2 = pntr3; 
			            } 
			            if (pntr2 == mini) 
			                mini = pntr1; 
			            Fib_Heap_Union(pntr2, pntr1); 
			            if (pntr1.right == pntr1) 
			                mini = pntr1; 
			            arr[temp1] = null; 
			            temp1++; 
			        } 
			        arr[temp1] =pntr1; 
			        pntr1 = pntr1.right; 
			    } while (pntr1 != mini); 
			    mini = null; 
			    for (int j = 0; j < temp2; j++) { 
			        if (arr[j] != null) { 
			            arr[j].left = arr[j]; 
			            arr[j].right = arr[j]; 
			            if (mini != null) { 
			                (mini.left).right = arr[j]; 
			                arr[j].right = mini; 
			                arr[j].left = mini.left; 
			                mini.left = arr[j]; 
			                if (arr[j].element < mini.element) 
			                    mini = arr[j]; 
			            } 
			            else { 
			                mini = arr[j]; 
			            } 
			            if (mini == null) 
			                mini = arr[j]; 
			            else if (arr[j].element < mini.element) 
			                mini = arr[j]; 
			        } 
			    } 
		 }	
		
		 void Cut(Node found,Node temp) 
		 { 
		     if (found == found.right) 
		         temp.child = null; 
		   
		     (found.left).right = found.right; 
		     (found.right).left = found.left; 
		     if (found == temp.child) 
		         temp.child = found.right; 
		   
		     temp.degree = temp.degree - 1; 
		     found.right = found; 
		     found.left = found; 
		     (mini.left).right = found; 
		     found.right = mini; 
		     found.left = mini.left; 
		     mini.left = found; 
		     found.parent = null; 
		     found.mark = true; 
		 } 
		 void Cascase_cut(Node temp) 
		 { 
		     Node ptr5 = temp.parent; 
		     if (ptr5 != null) { 
		         if (temp.mark == false) { 
		             temp.mark = true; 
		         } 
		         else { 
		             Cut(temp, ptr5); 
		             Cascase_cut(ptr5); 
		         } 
		     } 
		 } 

		 void Decrease_key(Node found, int val) 
		 { 
		     if (mini == null) 
		    	 System.out.println("Empty Heap");		   
		     if (found == null) 
		        System.out.println("Not Found in the heap");
		   
		     found.element = val; 
		   
		     Node temp = found.parent; 
		     if (temp != null && found.element < temp.element) { 
		         Cut(found, temp); 
		         Cascase_cut(temp); 
		     } 
		     if (found.element < mini.element) 
		         mini = found; 
		 } 
		public void Find(Node mini, int old_val, int val) 
		 { 
		     Node found = null; 
		     Node temp5 = mini; 
		     temp5.c = "Y"; 
		     Node found_ptr = null; 
		     if (temp5.element == old_val) { 
		         found_ptr = temp5; 
		         temp5.c = "N"; 
		         found = found_ptr; 
		         Decrease_key(found, val); 
		     } 
		     if (found_ptr == null) { 
		         if (temp5.child != null) 
		             Find(temp5.child, old_val, val); 
		         if ((temp5.right).c != "Y") 
		             Find(temp5.right, old_val, val); 
		     } 
		     temp5.c = "N"; 
		     found = found_ptr; 
		 } 
		 
		 
		 void Deletion(int val) 
		 { 
		     if (mini == null) 
		        System.out.println("Empty Heap");  
		     else { 
		         Find(mini, val, 0); 
		         Fib_heap_Extract_Min(); 
		         System.out.println("Element Deleted "); 
		     } 
		 } 
		 
		   
		 public void display()
		 {
			Node temp = mini;
			
			if (temp == null) 
			 System.out.print("Empty Heap\n"); 
			  
		    else 
		    {  
			   do { 
			       	System.out.print(temp.element +" "); 
			        temp = temp.right; 
			        if (temp != mini) { 
			               //System.out.println("-->"); 
			        } 
		        }while (temp != mini && temp.right != null); 
			       
			     System.out.println("");
			   } 
		}

	    public void find_min(Node mini) {
	    	System.out.println("Min:"+mini.element);
	    }  
}
