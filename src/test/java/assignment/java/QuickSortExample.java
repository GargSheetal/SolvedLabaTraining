package assignment.java;

import java.util.Random;


public class QuickSortExample {

	public static void main(String[] args) {
		
		Random random = new Random();
		int[] nums = new int[10];
		
		for(int i=0; i<nums.length; i++)
		{
			nums[i] = random.nextInt(100);
		}
		
		System.out.println("Before sorting: ");
		printArray(nums);
		
		quicksort(nums);
		
		System.out.println("\nAfter sorting: ");
		printArray(nums);

	}
	
	public static void quicksort(int[] array) {
		
		quicksort(array, 0, array.length -1);
	}
	
	public static void quicksort(int[] array, int lowIndex, int highIndex) {
		
		if(lowIndex >= highIndex) {
			return;
		}
		
		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		int pivot = array[pivotIndex];
		swap(array, pivotIndex, highIndex);
		
		int leftPointer = partition(array, lowIndex, highIndex, pivot);
		
		quicksort(array, lowIndex, leftPointer-1);
		quicksort(array, leftPointer+1, highIndex);
		
	}

	private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
		
		int leftPointer = lowIndex;
		int rightPointer = highIndex;
		
		while(leftPointer < rightPointer) {
			
			while(array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}
			
			while(array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}
			
			swap(array, leftPointer, rightPointer);
		}
		
		swap(array, leftPointer, highIndex);
		return leftPointer;
	}
	
	public static void swap(int[] array, int index1, int index2) {
		
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		
	}
	
	public static void printArray(int array[]) {
			
		for(int i: array) {
			System.out.println(i);
		}
	}

}
