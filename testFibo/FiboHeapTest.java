package testFibo;

public class FiboHeapTest {

	public static void main(String[] args) {
	        System.out.println("Initial Heap\n");        
	        FiboHeap fh = new FiboHeap();
	      
	        fh.insert(2);
	        fh.insert(5);
	        fh.insert(8);
	        fh.display();
	        fh.find_min(fh.mini);
	        System.out.println("Root list of the heap is:");
	        fh.Fib_heap_Extract_Min();
	        fh.display();
	        fh.Find(fh.mini, 8, 3);
	        fh.display();
	        fh.Deletion(3);
	        fh.display();
	}
}