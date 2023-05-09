package assignment.java;

import java.util.Random;

/*
 * [6, 2, 9, 2, 3, 7, 1, 5]
 */

public class QuickSortExample {

	public static void main(String[] args) {
		
		Random random = new Random();
		int[] nums = new int[10];
		
		// Randomly selecting values in the array
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
	
	private static void quicksort(int[] arr) {
		quicksort(arr, 0, arr.length -1);
	}
	
	private static void quicksort(int[] arr, int lowIndex, int highIndex) {
		
		if(lowIndex >= highIndex) {
			return;
		}
		
		// selecting the pivot randomly and swapping with the highIndex of the array
		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		int pivot = arr[pivotIndex];
		swap(arr, pivotIndex, highIndex);
		
		int leftRef = partition(arr, lowIndex, highIndex, pivot);
		
		quicksort(arr, lowIndex, leftRef-1);
		quicksort(arr, leftRef+1, highIndex);
		
	}

	private static int partition(int[] arr, int lowIndex, int highIndex, int pivot) {
		
		int leftRef = lowIndex;
		int rightRef = highIndex;
		
		while(leftRef < rightRef) {
			
			while(arr[leftRef] <= pivot && leftRef < rightRef) {
				leftRef++;
			}
			
			while(arr[rightRef] >= pivot && leftRef < rightRef) {
				rightRef--;
			}
			
			swap(arr, leftRef, rightRef);
		}
		
		swap(arr, leftRef, highIndex);
		return leftRef;
	}
	
	private static void swap(int[] arr, int index1, int index2) {
		
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
		
	}
	
	private static void printArray(int arr[]) {
			
		for(int i: arr) {
			System.out.println(i);
		}
	}

}
