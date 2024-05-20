
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ApplicationRunner {

    static Scanner readFile;
    static Scanner userInput;
    static ArrayList<String> obj = new ArrayList<>();
    static ArrayList<Trader> calculateSize = new ArrayList<>();
    static HashMap<Integer, Trader> dataSet = new HashMap<>();

    public static void menu() {
        System.out.println("List traders.......1");
        System.out.println("Select trader......2");
        System.out.println("Search locations...3");
        System.out.println("Search services....4");
        System.out.println("Exit...............0");
    }

    public static void main(String[] args) {

        String dataFile = System.getProperty("user.dir") + File.separator + "traders.txt";

        File myInputFile = new File(dataFile);

        try {

            readFile = new Scanner(myInputFile);

        } catch (FileNotFoundException ex) {

            System.out.println(ex.getMessage() + " File is not found, please try again.");
            System.exit(0);

        }

        while (readFile.hasNext()) {
            String line = readFile.nextLine();

            StringTokenizer tokenizer = new StringTokenizer(line, ":");

            while (tokenizer.hasMoreTokens()) {
                String newline = tokenizer.nextToken();
                obj.add(newline);
            }

            String compnayName = obj.get(0);

            String location = obj.get(1);

            String services = obj.get(2);

            String numberOfEmployees = obj.get(3);
            int numEmployees = Integer.parseInt(numberOfEmployees);

            String dailyRateCharge = obj.get(4);
            double dailyRate = Double.parseDouble(dailyRateCharge);

            String description = obj.get(5);

            Trader T1 = new Trader(compnayName, location, services, numEmployees, dailyRate, description);

            calculateSize.add(T1);
            
            int id = calculateSize.size();
            dataSet.put(id, T1);

            obj.clear();
        }
        
        Scanner userChoice = new Scanner(System.in);

        menu();
        System.out.println("");
        System.out.print("Enter choice:> ");

        while (userChoice.hasNextLine()) {

            String input = userChoice.next();

            if (input.equalsIgnoreCase("0")) {
                System.exit(0);
            } else if (input.equalsIgnoreCase("2")) {
                System.out.println("");
                System.out.print("Enter trader ID from list [1 - 25] :> ");
                int choice = userChoice.nextInt();
                System.out.println("");

                if (choice > 25 || choice == 0) {
                    System.out.println("> This Trader ID does not exist.");
                }

                System.out.println(dataSet.get(choice));

                System.out.println("");
                menu();
                System.out.println("");
                System.out.print("Enter choice:> ");
            } else if (input.equalsIgnoreCase("1")) {
                System.out.println("");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID |  Company name           |  Location           |  Services offered                                                       |");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                for (Map.Entry<Integer, Trader> insert : dataSet.entrySet()) {
                    int id = insert.getKey();
                    Trader trader = insert.getValue();
                    System.out.printf("%1s %2s %-2s %-22s %-2s %-18s %-2s %-70s %-20s%n", "|", id, "|", trader.getCompanyName(), "|", trader.getLocation(), "|", trader.getServices(), "|");
                }
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("");
                menu();
                System.out.println("");
                System.out.print("Enter choice:> ");
            } else if (input.equalsIgnoreCase("3")) {
                System.out.println("");
                System.out.print("Enter search text > ");

                String search = userChoice.next();

                System.out.println("");

                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID |  Company name           |  Location           |  Services offered                                                       |");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                for (Map.Entry<Integer, Trader> insert : dataSet.entrySet()) {
                    int id = insert.getKey();
                    Trader trader = insert.getValue();

                    if (trader.getLocation().toLowerCase().contains(search.toLowerCase())) {
                        System.out.printf("%1s %2s %-2s %-22s %-2s %-18s %-2s %-70s %-20s%n", "|", id, "|", trader.getCompanyName(), "|", trader.getLocation(), "|", trader.getServices(), "|");
                    } else if (trader.getLocation().toUpperCase().contains(search.toUpperCase())) {
                        System.out.printf("%1s %2s %-2s %-22s %-2s %-18s %-2s %-70s %-20s%n", "|", id, "|", trader.getCompanyName(), "|", trader.getLocation(), "|", trader.getServices(), "|");
                    }
                }
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("");
                menu();
                System.out.println("");
                System.out.print("Enter choice:> ");
            } else if (input.equalsIgnoreCase("4")) {
                System.out.println("");
                System.out.print("Enter search text > ");

                String search = userChoice.next();

                System.out.println("");

                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("| ID |  Company name           |  Location           |  Services offered                                                       |");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                for (Map.Entry<Integer, Trader> insert : dataSet.entrySet()) {
                    int id = insert.getKey();
                    Trader trader = insert.getValue();

                    if (trader.getServices().toLowerCase().contains(search.toLowerCase())) {
                        System.out.printf("%1s %2s %-2s %-22s %-2s %-18s %-2s %-70s %-20s%n", "|", id, "|", trader.getCompanyName(), "|", trader.getLocation(), "|", trader.getServices(), "|");
                    } else if (trader.getServices().toUpperCase().contains(search.toUpperCase())) {
                        System.out.printf("%1s %2s %-2s %-22s %-2s %-18s %-2s %-70s %-20s%n", "|", id, "|", trader.getCompanyName(), "|", trader.getLocation(), "|", trader.getServices(), "|");
                    }
                }
                System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("");
                menu();
                System.out.println("");
                System.out.print("Enter choice:> ");
            }
        }
    }
}
