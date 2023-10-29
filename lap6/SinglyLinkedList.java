package lap6;

public class SinglyLinkedList<E> {
	 private Node<E> head = null;
	    private Node<E> tail = null;
	    private int size;

	    public SinglyLinkedList() {
	        super();
	    }

	    public int size() {
	        return size;
	    }

	    public boolean isEmpty() {
	        return size == 0;
	    }

	    public E first() {
	        if (isEmpty()) {
	            return null;
	        }
	        return head.getData();
	    }

	    public E last() {
	        if (isEmpty()) {
	            return null;
	        }
	        return tail.getData();
	    }

	    public void addFirst(E e) {
	        Node<E> newNode = new Node<>(e, head);
	        head = newNode;
	        if (isEmpty()) {
	            tail = newNode;
	        }
	        size++;
	    }

	    public void addLast(E e) {
	        Node<E> newNode = new Node<>(e);
	        if (isEmpty()) {
	            head = newNode;
	        } else {
	            tail.setNext(newNode);
	        }
	        tail = newNode;
	        size++;
	    }

	    public E removeFirst() {
	        if (isEmpty()) {
	            return null;
	        }
	        E removedElement = head.getData();
	        head = head.getNext();
	        size--;
	        if (isEmpty()) {
	            tail = null;
	        }
	        return removedElement;
	    }

	    public E removeLast() {
	        if (isEmpty()) {
	            return null;
	        }
	        E removedElement = tail.getData();
	        if (size == 1) {
	            head = null;
	            tail = null;
	        } else {
	            Node<E> currentNode = head;
	            while (currentNode.getNext() != tail) {
	                currentNode = currentNode.getNext();
	            }
	            currentNode.setNext(null);
	            tail = currentNode;
	        }
	        size--;
	        return removedElement;
	    }public static void main(String[] args) {
	        // Create a new SinglyLinkedList instance
	        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();

	        // Add elements to the list
	        myList.addFirst(10);
	        myList.addLast(20);
	        myList.addFirst(5);

	        // Print the size of the list
	        System.out.println("Size of the list: " + myList.size());

	        // Check if the list is empty
	        System.out.println("Is the list empty? " + myList.isEmpty());

	        // Get the first element
	        int firstElement = myList.first();
	        System.out.println("First element: " + firstElement);

	        // Get the last element
	        int lastElement = myList.last();
	        System.out.println("Last element: " + lastElement);

	        // Remove the first element
	        int removedElement = myList.removeFirst();
	        System.out.println("Removed element: " + removedElement);

	        // Print the size of the list after removal
	        System.out.println("Size of the list after removal: " + myList.size());

	        // Remove the last element
	        int removedLastElement = myList.removeLast();
	        System.out.println("Removed last element: " + removedLastElement);

	        // Check if the list is empty after removal
	        System.out.println("Is the list empty after removal? " + myList.isEmpty());
	    }
}
