import java.util.Random;
//@author Ben Stumpf
/**
 * This class was writen to provide evedence that the Insertion Sort algorithm runs in Order n squared time.
 */
class InsertionSort {
    /**
     * This main method runs a rapper method of the algorithm and prints the
     * @param String[] args [description]
     */
    public static void main(String[] args) {
        int numberOfRuns = 1000;
        int maxNumberOfElementsFactor = 100000;
        System.out.println("Number of Elements              Number of Average Operations per Element");
        for (int numberOfElementsFactor = 2; numberOfElementsFactor <= maxNumberOfElementsFactor; numberOfElementsFactor += 100){
          averageRunning(numberOfRuns, numberOfElementsFactor);
        }
    }
/**
 * function made to automate the gathering of data about the sort algorithm
 * @param int numberOfRuns allows for data collection to change with other algorithms
 * @param int sizeOfArray  need to be able the size of the array to test complexity
 */
    public static void averageRunning(int numberOfRuns, int sizeOfArray) {
        double totalOperations = 0;
        for (int i = 1; numberOfRuns >= i; i++) {
            int[] array = new int[sizeOfArray];
            array = createRandomIntArray(sizeOfArray);
            int runOpperations = Sort(array);
            //System.out.println("Run Opperations " + runOpperations);
            totalOperations = totalOperations + runOpperations;
        }
        System.out.print(sizeOfArray+",");
        //System.out.println("Total Opperations " + totalOperations);
        //System.out.println("Number of Runs " + numberOfRuns);
        //System.out.println("Average Opperations " + (totalOperations / numberOfRuns));
        System.out.println((int)((totalOperations / numberOfRuns)/sizeOfArray));
    }
/**
 * Insertion sort funtion, named in order to allow code reuse
 * @param  int[] valuetoSort   execpts an array in order to be sorted
 * @return       returns the number of operations counted though the algorithm
 */
    public static int Sort(int[] valuetoSort) {
        int operationCount = 0;
        for (int sortingIndex = 2; sortingIndex < valuetoSort.length; sortingIndex++) {
            operationCount++;
            int valueStore = valuetoSort[sortingIndex];
            operationCount++;
            int travelingIndex = sortingIndex - 1;
            operationCount++;
            while (travelingIndex > 0 && valuetoSort[travelingIndex] > valueStore) {
                operationCount++;
                valuetoSort[travelingIndex + 1] = valuetoSort[travelingIndex];
                operationCount++;
                travelingIndex = travelingIndex - 1;
                operationCount++;
            }
        }
        printArray(valuetoSort);
        System.out.println();
        return operationCount;
    }
/**
 * Funtion given by prof in order to create random sets of values in arrays
 * @param  int size          execpts a value for in order to know what to create
 * @return     Returns the array created
 */
    public static int[] createRandomIntArray(int size) {
        int[] answer = new int[size];
        Random generator = new Random();
        for (int index = 0; index < answer.length; index++) {
            answer[index] = generator.nextInt(100) + 1;
        }
        return answer;
    }
/**
 * A function to print arrays, toString was not working
 * @param int[] anArray     execepts an array to print the elements of
 */
    public static void printArray(int[] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(anArray[i]);
        }
    }
}
