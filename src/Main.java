/**
 * Main  (Member 2)
 * Entry point of the whole application. Creates ONE object of each data structure,
 * then passes them to the menu classes so every module shares the same data.
 */
public class Main {

    public static void main(String[] args) {
        // The shared data structures
        ArrayOperations array = new ArrayOperations();
        StackOperations stack = new StackOperations();
        QueueOperations queue = new QueueOperations();
        LinkedListOperations linkedList = new LinkedListOperations();
        Graph graph = new Graph();

        // The menus (each gets the object it works on)
        ArrayMenu arrayMenu = new ArrayMenu(array);
        StackMenu stackMenu = new StackMenu(stack);
        QueueMenu queueMenu = new QueueMenu(queue);
        LinkedListMenu linkedListMenu = new LinkedListMenu(linkedList);
        SearchMenu searchMenu = new SearchMenu(array);          // searches the same array
        GraphMenu graphMenu = new GraphMenu(graph);
        PerformanceMenu performanceMenu = new PerformanceMenu(graph);

        while (true) {
            System.out.println("\n=============================================");
            System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            int choice = InputHelper.readIntInRange("Enter your choice: ", 1, 9);

            switch (choice) {
                case 1:
                    arrayMenu.show();
                    break;
                case 2:
                    stackMenu.show();
                    break;
                case 3:
                    queueMenu.show();
                    break;
                case 4:
                    linkedListMenu.show();
                    break;
                case 5:
                    searchMenu.show();
                    break;
                case 6:
                    graphMenu.show();
                    break;
                case 7:
                    performanceMenu.show();
                    break;
                case 8:
                    displayAllResults(array, stack, queue, linkedList, graph);
                    break;
                case 9:
                    System.out.println("Thank you for using the Data Structure & Graph Analyzer. Goodbye!");
                    return;
            }
        }
    }

    // Shows the current content of every data structure, then all recorded results.
    private static void displayAllResults(ArrayOperations array, StackOperations stack,
                                          QueueOperations queue, LinkedListOperations list, Graph graph) {
        System.out.println("\n================ CURRENT DATA STRUCTURES ================");
        array.display();
        stack.display();
        queue.display();
        list.display();
        graph.display();
        ResultsStore.displayAll();
    }
}
