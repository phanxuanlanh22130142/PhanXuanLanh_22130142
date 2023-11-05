package lab7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
    
	
	    public static <T> void delete(Collection<T> coll, Predicate<T> p) {
	        coll.removeIf(p::test);
	    }

	    public static <T> void retain(Collection<T> coll, Predicate<T> p) {
	        coll.removeIf(obj -> !p.test(obj));
	    }

	    public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
	        Set<T> result = new HashSet<>();
	        for (T obj : coll) {
	            if (p.test(obj)) {
	                result.add(obj);
	            }
	        }
	        return result;
	    }

	    public static <T> int find(Collection<T> coll, Predicate<T> p) {
	        int index = 0;
	        for (T obj : coll) {
	            if (p.test(obj)) {
	                return index;
	            }
	            index++;
	        }
	        return -1;
	    }
	
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Predicate<Integer> evenNumberPredicate = number -> number % 2 == 0;

        
        MyPredicates.remove(numbers, evenNumberPredicate);
        System.out.println("Sau khi xóa các số chẵn:");
        System.out.println(numbers);

        
        Predicate<Integer> greaterThanThreePredicate = number -> number > 3;
        MyPredicates.retain(numbers, greaterThanThreePredicate);
        System.out.println("Sau khi giữ lại các số lớn hơn 3:");
        System.out.println(numbers);

       
        Predicate<Integer> nonNegativePredicate = number -> number >= 0;
        List<Integer> nonNegativeNumbers = new ArrayList<>(MyPredicates.collect(numbers, nonNegativePredicate));
        System.out.println("Tập hợp các số không âm:");
        System.out.println(nonNegativeNumbers);

        
        Predicate<Integer> numberFourPredicate = number -> number == 4;
        int index = MyPredicates.find(numbers, numberFourPredicate);
        System.out.println("Chỉ mục của số 4 trong danh sách: " + index);
    }

	private static void remove(List<Integer> numbers, Predicate<Integer> evenNumberPredicate) {
		
		
	}

}

