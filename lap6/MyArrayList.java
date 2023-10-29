package lap6;


	import java.util.Arrays;
	import java.util.Comparator;

	public class MyArrayList<E> {
	    public static final int DEFAULT_CAPACITY = 10;
	    private E[] elements;
	    private int size;
	    
	    public MyArrayList() {
	        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	    }
	    
	    public MyArrayList(int capacity) {
	        this.elements = (E[]) new Object[capacity];
	    }
	    
	    public void growSize() {
	        int newCapacity = elements.length * 2;
	        elements = Arrays.copyOf(elements, newCapacity);
	    }
	    
	    public int size() {
	        return size;
	    }
	    
	    public boolean isEmpty() {
	        return size == 0;
	    }
	    
	    public E get(int i) throws IndexOutOfBoundsException {
	        if (i < 0 || i >= size) {
	            throw new IndexOutOfBoundsException();
	        }
	        return elements[i];
	    }
	    
	    public E set(int i, E e) throws IndexOutOfBoundsException {
	        if (i < 0 || i >= size) {
	            throw new IndexOutOfBoundsException();
	        }
	        E replacedElement = elements[i];
	        elements[i] = e;
	        return replacedElement;
	    }
	    
	    public boolean add(E e) {
	        if (size == elements.length) {
	            growSize();
	        }
	        elements[size] = e;
	        size++;
	        return true;
	    }
	    
	    public void add(int i, E e) throws IndexOutOfBoundsException {
	        if (i < 0 || i > size) {
	            throw new IndexOutOfBoundsException();
	        }
	        if (size == elements.length) {
	            growSize();
	        }
	        for (int j = size; j > i; j--) {
	            elements[j] = elements[j - 1];
	        }
	        elements[i] = e;
	        size++;
	    }
	    
	    public E remove(int i) throws IndexOutOfBoundsException {
	        if (i < 0 || i >= size) {
	            throw new IndexOutOfBoundsException();
	        }
	        E removedElement = elements[i];
	        for (int j = i; j < size - 1; j++) {
	            elements[j] = elements[j + 1];
	        }
	        elements[size - 1] = null;
	        size--;
	        return removedElement;
	    }
	    
	    public void clear() {
	        Arrays.fill(elements, null);
	        size = 0;
	    }
	    
	    public int lastIndexOf(Object o) {
	        for (int i = size - 1; i >= 0; i--) {
	            if (o == null ? elements[i] == null : o.equals(elements[i])) {
	                return i;
	            }
	        }
	        return -1;
	    }
	    
	    public E[] toArray() {
	        return Arrays.copyOf(elements, size);
	    }
	    
	    public MyArrayList<E> clone() {
	        MyArrayList<E> cloneList = new MyArrayList<>(size);
	        cloneList.elements = Arrays.copyOf(elements, size);
	        cloneList.size = size;
	        return cloneList;
	    }
	    
	    public boolean contains(E o) {
	        return indexOf(o) != -1;
	    }
	    
	    public int indexOf(E o) {
	        for (int i = 0; i < size; i++) {
	            if (o == null ? elements[i] == null : o.equals(elements[i])) {
	                return i;
	            }
	        }
	        return -1;
	    }
	    
	    public boolean remove(E e) {
	        int index = indexOf(e);
	        if (index != -1) {
	            remove(index);
	            return true;
	        }
	        return false;
	    }
	    
	    public void sort(Comparator<E> c) {
	        Arrays.sort(elements, 0, size, c);
	    }
	    public static void main(String[] args) {
	        
	        MyArrayList<Integer> myList = new MyArrayList<>();

	       
	        myList.add(5);
	        myList.add(10);
	        myList.add(15);
	        myList.add(20);

	       
	        System.out.println("Size of the list: " + myList.size());

	        
	        System.out.println("Is the list empty? " + myList.isEmpty());

	        
	        int element = myList.get(2);
	        System.out.println("Element at index 2: " + element);

	        
	        int replacedElement = myList.set(1, 25);
	        System.out.println("Replaced element: " + replacedElement);

	     
	        int removedElement = myList.remove(0);
	        System.out.println("Removed element: " + removedElement);

	       
	        System.out.println("Does the list contain 10? " + myList.contains(10));

	     
	        int index = myList.indexOf(15);
	        System.out.println("Index of element 15: " + index);

	        
	        myList.clear();
	        System.out.println("Size of the list after clearing: " + myList.size());
	    }
	}

