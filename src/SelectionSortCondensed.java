import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelectionSortCondensed {
	public static void main(String[] args) {
		int[] array = { 3, 6, 1, 2, 9, 8, 4, 7, 5 };
		int[] sortedArray = selectionSort5(array);
		System.out.println(Arrays.toString(sortedArray));
	}
	
	public static int[] selectionSort(int[] array) {
		int[] sortedArray = Arrays.copyOf(array, array.length);
        
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < sortedArray.length - 1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min = i; 
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] < sortedArray[min]) {
                    min = j; 
                }
            }
  
            // Swap the found minimum element with the first element 
            int temp = sortedArray[min]; 
            sortedArray[min] = sortedArray[i]; 
            sortedArray[i] = temp; 
        }

        return sortedArray;
	}
	
	public static int[] selectionSort1(int[] array) {
		int[] sortedArray = Arrays.copyOf(array, array.length);
		for (int i = 0; i < sortedArray.length - 1; i++) {
			int[] arraySlice = Arrays.copyOf(sortedArray, sortedArray.length - i);
			int max = Arrays.stream(arraySlice).max().getAsInt();
			int indexOfMax = Arrays.stream(arraySlice).boxed().collect(Collectors.toList()).indexOf(max);
			sortedArray[indexOfMax] = sortedArray[indexOfMax] ^ sortedArray[sortedArray.length - i - 1] ^ (sortedArray[sortedArray.length - i - 1] = sortedArray[indexOfMax]);
		}
		return sortedArray;
	}
	
	public static int[] selectionSort2(int[] array) {
		int[] sortedArray = Arrays.copyOf(array, array.length);
		for (int i = 0; i < sortedArray.length - 1; i++) {
			int[] arraySlice = Arrays.copyOf(sortedArray, sortedArray.length - i);
			int indexOfMax = Arrays.stream(arraySlice).boxed().collect(Collectors.toList()).indexOf(Collections.max(Arrays.stream(arraySlice).boxed().collect(Collectors.toList())));
			sortedArray[indexOfMax] = sortedArray[indexOfMax] ^ sortedArray[sortedArray.length - i - 1] ^ (sortedArray[sortedArray.length - i - 1] = sortedArray[indexOfMax]);
		}
		return sortedArray;
	}
	
	public static int[] selectionSort3(int[] array) {
		int[] sortedArray = Arrays.copyOf(array, array.length);
		for (int i = 0; i < sortedArray.length - 1; i++) {
			int indexOfMax = Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList()).indexOf(Collections.max(Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList())));
			sortedArray[indexOfMax] = sortedArray[indexOfMax] ^ sortedArray[sortedArray.length - i - 1] ^ (sortedArray[sortedArray.length - i - 1] = sortedArray[indexOfMax]);
		}
		return sortedArray;
	}
	
	public static int[] selectionSort4(int[] array) {
		int[] sortedArray = Arrays.copyOf(array, array.length);
		for (int i = 0; i < sortedArray.length - 1; i++) {
			sortedArray[Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList()).indexOf(Collections.max(Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList())))] = sortedArray[Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList()).indexOf(Collections.max(Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList())))] ^ sortedArray[sortedArray.length - i - 1] ^ (sortedArray[sortedArray.length - i - 1] = sortedArray[Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList()).indexOf(Collections.max(Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList())))]);
		}
		return sortedArray;
	}
	
	public static int[] selectionSort5(int[] array) {
		int[] sortedArray = Arrays.copyOf(array, array.length);
		IntStream.rangeClosed(0, sortedArray.length - 1).forEach(i -> sortedArray[Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList()).indexOf(Collections.max(Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList())))] = sortedArray[Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList()).indexOf(Collections.max(Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList())))] ^ sortedArray[sortedArray.length - i - 1] ^ (sortedArray[sortedArray.length - i - 1] = sortedArray[Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList()).indexOf(Collections.max(Arrays.stream(Arrays.copyOf(sortedArray, sortedArray.length - i)).boxed().collect(Collectors.toList())))]));
		return sortedArray;
	}
	
}
