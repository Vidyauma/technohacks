import java.util.Scanner;

public class  Arraymanipulation {
    // Merge Sort implementation
    public static void mergeSort(int[] array, int left, int right, boolean ascending) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively divide the array
            mergeSort(array, left, mid, ascending);
            mergeSort(array, mid + 1, right, ascending);

            // Merge the divided parts
            merge(array, left, mid, right, ascending);
        }
    }

    private static void merge(int[] array, int left, int mid, int right, boolean ascending) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data into temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (ascending ? leftArray[i] <= rightArray[j] : leftArray[i] >= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray and rightArray, if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Binary Search implementation
    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid] == target) {
                return mid; // Target found
            } else if (array[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean restart = true;

        while (restart) {
            // Input: Create an array of integers
            System.out.print("Enter the number of elements in the array: ");
            int n = scanner.nextInt();
            int[] array = new int[n];

            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            // Choose sorting order
            System.out.print("Enter sorting order (1 for Ascending, 2 for Descending): ");
            int sortChoice = scanner.nextInt();
            boolean ascending = (sortChoice == 1);

            // Sort the array using Merge Sort
            mergeSort(array, 0, array.length - 1, ascending);

            // Display the sorted array
            System.out.println("Sorted Array:");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Search for multiple elements
            System.out.print("Enter the number of elements to search: ");
            int searchCount = scanner.nextInt();

            for (int i = 0; i < searchCount; i++) {
                System.out.print("Enter the element to search: ");
                int target = scanner.nextInt();
                int result = binarySearch(array, target);

                // Display search result
                if (result != -1) {
                    System.out.println("Element " + target + " found at index: " + result);
                } else {
                    System.out.println("Element " + target + " not found in the array.");
                }
            }

            // Restart or Exit
            System.out.print("Do you want to restart the program? (yes/no): ");
            String response = scanner.next();
            restart = response.equalsIgnoreCase("yes");
        }

        System.out.println("Program exited. Thank you!");
        scanner.close();
    }
}
