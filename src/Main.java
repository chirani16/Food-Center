import java.util.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.Arrays;
public class Main {
    static int tot_burgers = 50;
    static int rem_stock = tot_burgers;

    // Cashier Queues
    static String [] cashierOne={"X","X"};
    static String [] cashierTwo={"X","X","X"};
    static String [] cashierThree={"X","X","X","X","X"};

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Printing menu Options
        while (true) {
            System.out.println("*********************************************************************");
            System.out.println("*                       Foodie Fave Food Center                     *");
            System.out.println("*********************************************************************");
            System.out.println("Menu Options:");
            System.out.println("100 or VFQ: View all Queues");
            System.out.println("101 or VEQ: View all Empty Queues");
            System.out.println("102 or ACQ: Add customer to a Queue");
            System.out.println("103 or RCQ: Remove a customer from a Queue (From a specific location)");
            System.out.println("104 or PCQ: Remove a served customer");
            System.out.println("105 or VCS: View Customers Sorted in alphabetical order");
            System.out.println("106 or SPD: Store Program Data into file");
            System.out.println("107 or LPD: Load Program Data from file");
            System.out.println("108 or STK: View Remaining burgers Stock");
            System.out.println("109 or AFS: Add burgers to Stock");
            System.out.println("999 or EXT: Exit the Program");
            System.out.print("Enter your choice: ");
            String option = input.next();

            switch (option) {
                case "100":
                case "VFQ":
                    viewAllQueues();
                    break;
                case "101":
                case "VEQ":
                    viewAllEmptyQueues();
                    break;
                case "102":
                case "ACQ":
                    addCustomer();
                    break;
                case "103":
                case "RCQ":
                    removeCustomer();
                    break;
                case "104":
                case "PCQ":
                    removeServedCustomer();
                    break;
                case "105":
                case "VCS":
                    viewSortedCustomers();
                    break;
                case "106":
                case "SPD":
                    storeProgramData();
                    break;
                case "107":
                case "LPD":
                    loadProgramData();
                    break;
                case "108":
                case "STK":
                    viewRemainingBurgers();
                    break;
                case "109":
                case "AFS":
                    addBurgers();
                    break;
                case "999":
                case "EXT":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    // Method to view all queues.
    private static void viewAllQueues() {
        System.out.println("**********************");
        System.out.println("*      Cashiers      *");
        System.out.println("**********************");
        //Repeat the process until the longest queue is reached
        for (int i = 0; i < cashierThree.length; i++) {
            try {
                //Checking cashierOne whether there is an element at the current index
                if (cashierOne[i].equals("X"))
                    System.out.print("X         ");// Print 'X' if element is present
                else
                    System.out.print("O         ");// Print 'O' if element is not present
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("          ");
            }
            //Checking cashierTwo whether there is an element at the current index
            try {
                if (cashierTwo[i].equals("X"))
                    System.out.print("X         ");//Print 'X' if element is present
                else
                    System.out.print("O         ");// Print 'O' if element is not present
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("          ");
            }
            //Checking cashierTwo whether there is an element at the current index
            try {
                if (cashierThree[i].equals("X"))
                    System.out.print("X         ");//Print 'X' if element is present
                else
                    System.out.print("O         ");// Print 'O' if element is not present
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("            ");
            }

            System.out.println();
        }
    }
    //Method to view all empty queues.
    private static void viewAllEmptyQueues() {
        // Check for empty queues in cashierOne
        for (int i=0; i<2; i++){
            if (cashierOne[i]==null){
                System.out.println("Cashier one" + cashierOne[i] + "is empty");

            }
        }
        // Check for empty queues in cashierTwo
        for (int i=0; i<3; i++){
            if (cashierTwo[i]==null) {
                System.out.println("Cashier two" + cashierTwo[i] + "is empty");
            }
        }
        // Check for empty queues in cashierTwo
        for (int i=0; i<5; i++) {
            if (cashierThree[i] == null) {
                System.out.println("Cashier three" + cashierThree[i] + "is empty");
            }
        }
    }
    //Method to Add customer to a Queue.
    private static void addCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.print("Name of the customer: ");
        String name = input.next();
        System.out.print("Enter the queue number 1-3");
        int cashier = input.nextInt();
        // Add customer to the selected queue (cashier)
        if (cashier == 1) {
            // Check the first index of cashierOne
            if (cashierOne[0].equals("X")) {
                cashierOne[0] = name;
            // If the first index is occupied, check the second slot of cashierOne
            } else if (cashierOne[1].equals("X")) {
                cashierOne[1] = name;
            }
        }
        else if (cashier == 2) {
            // Check the first index of cashierTwo
            if (cashierTwo[0].equals("X")) {
                cashierTwo[0] = name;
            // If the first index is occupied, check the second slot of cashierTwo
            } else if (cashierTwo[1].equals("X")) {
                cashierTwo[1] = name;
            // If the second index is occupied, check the third slot of cashierTwo
            } else if (cashierTwo[2].equals("X")) {
                cashierTwo[2] = name;
            }
        }
        else if (cashier == 3) {
            // Check the first index of cashierThree
            if (cashierThree[0].equals("X")) {
                cashierThree[0] = name;
            // If the first index is occupied, check the second slot of cashierThree
            } else if (cashierThree[1].equals("X")) {
                cashierThree[1] = name;
            // If the second index is occupied, check the third slot of cashierThree
            } else if (cashierThree[2].equals("X")) {
                cashierThree[2] = name;
            // If the third index is occupied, check the fourth slot of cashierThree
            } else if (cashierThree[3].equals("X")) {
                cashierThree[3] = name;
            // If the fourth index is occupied, check the fifth slot of cashierThree
            } else if (cashierThree[4].equals("X")) {
                cashierThree[4] = name;
            }
        }
    }
    //Method to Remove a customer from a Queue. (From a specific location)
    private static void removeCustomer() {
        System.out.println("Name of the customer to be removed: ");
        String name = input.next();
        //Removing a customer from each queue
        boolean removed = removeElementFromArray(cashierOne, name)
                || removeElementFromArray(cashierTwo, name)
                || removeElementFromArray(cashierThree, name);
        // Check if the customer was successfully removed
        if (removed){
            System.out.println(name + "has been removed from the queue");
        } else {
            System.out.println(name + "is not found in the queue");
        }
    }
    //Method to remove an element from an array.
    private static boolean removeElementFromArray(String[]array,String element){
        for (int i=0; i<array.length;i++){
            // Check if the current element matches the element to be removed
            if (element.equals(array[i])){
                // Set the element to null to remove it
                array[i]=null;
                shiftElements(array,i);
                // Return true to indicate successful removal of customer
                return true;
            }
        // Return false if the element was not found in the array
        } return false;
    }
    private static void shiftElements (String[]array, int index) {
        for (int i = index; i < array.length - 1; i++) {// Shift each element to the left by one position
            // Set the last element of the array to null
            array[array.length - 1] = null;
        }
    }
    //Method to Remove a served customer.
    private static void removeServedCustomer() {
        rem_stock = tot_burgers-5;// Updating remaining stock after subtracting 5 burgers
        int perCustomer = 5;// Number of burgers served per customer
        System.out.println("Name of the to be removed: ");
        String customer = input.next();
        if (removeElementFromArray(cashierOne, customer)){
            System.out.println(customer + "has been served" + perCustomer + "burgers");
        } else if (removeElementFromArray(cashierTwo, customer)){
            System.out.println(customer + "has been served" + perCustomer + "burgers");
        } else if (removeElementFromArray(cashierThree, customer)) {
            System.out.println(customer + "has been served" + perCustomer + "burgers");
        } else {
            System.out.println(customer + "is not found");
        }
        if (rem_stock < 10){
            System.out.println("Warning");
        }
    }
    //Method to View Customers Sorted in alphabetical order.
    private static void  viewSortedCustomers(){
        String[] queueOne= cashierOne.clone();
        Arrays.sort(queueOne);
        System.out.print("queueOne: ");
        for (String s : queueOne) {
            System.out.print(s + " ");
        }
        String[] queueTwo= cashierTwo.clone();
        Arrays.sort(queueTwo);
        System.out.print("queueTwo: ");
        for (String s : queueTwo) {
            System.out.print(s + " ");
        }
        String[] queueThree= cashierThree.clone();
        Arrays.sort(queueThree);
        System.out.print("queueThree: ");
        for (String s : queueThree) {
            System.out.print(s + " ");
        }
    }
    //Method to Store Program Data into file.
    private static void storeProgramData() {
        try {
            FileWriter myWriter = new FileWriter("text.txt");// Creating a FileWriter object to write to a file named "text.txt"
            myWriter.write("Remaining burger stock: " + rem_stock + "\n");// Write the remaining burger stock to the file
            myWriter.close();// Close the FileWriter
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {// Handling any IOException that occurs
            System.out.println("An error occurred.");
            e.printStackTrace();// Print the stack trace of the exception
        }
    }
    //Method to View Remaining burgers Stock.
    private static void viewRemainingBurgers() {
        System.out.println("Remaining burger stock is: " + rem_stock);
    }
    //Method to Add burgers to Stock.
    private static void addBurgers() {
        if (tot_burgers < 10){
            System.out.println("Less no. of burgers in stock");// Print a message if there are less than 10 hamburgers available
        }else if (tot_burgers > 50){
            System.out.println("Cannot exceed 50 burgers");
        }else {
            System.out.println("Burger no = 50");// Print a message stating that there are 50 hamburgers.
        }
    }
    //Method to Load Program Data from file.
    private static void loadProgramData() {
        try{
            File file = new File ("text.txt");// Create a File object with the filename "Text.txt"
            Scanner file_reader = new Scanner(file);// Create a Scanner object to read from the file
            while (file_reader.hasNextLine()){
                String text = file_reader.nextLine();// Read the next line from the file
                System.out.println(text);// Print the line read from the file
            } file_reader.close();// Close the Scanner object
        } catch (IOException e) {
            System.out.println("Error while reading the file");// Handle any IOException that occurs
        }
    }
}