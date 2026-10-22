
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) {
        List<Sale> sales = new ArrayList<>();

        // Read sales from the CSV file
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("sales.csv"))) {

            String line;
            boolean header = true;

            while ((line = reader.readLine()) != null) {
                if (header) {
                    header = false;
                    continue;
                }

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] fields = line.trim().split("\\s+");

                if (fields.length < 5) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                try {
                    int saleId = Integer.parseInt(fields[0]);
                    double amount = Double.parseDouble(
                            fields[fields.length - 1]);

                    String region = fields[fields.length - 2];

                    StringBuilder employeeName = new StringBuilder();
                    for (int i = 1; i < fields.length - 2; i++) {
                        if (i > 1) {
                            employeeName.append(" ");
                        }
                        employeeName.append(fields[i]);
                    }

                    sales.add(new Sale(
                            saleId,
                            employeeName.toString(),
                            region,
                            amount
                    ));

                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid row: " + line);
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading sales.csv: " + e.getMessage());
            return;
        }

        if (sales.isEmpty()) {
            System.out.println("No sales records were loaded.");
            return;
        }

        System.out.println("Sales Data Stream Analyzer");
        System.out.println("--------------------------");

        System.out.println("\nAll Sales:");
        sales.stream().forEach(System.out::println);

        System.out.println("\nSales Over $500:");
        sales.stream()
                .filter(sale -> sale.getAmount() > 500)
                .forEach(System.out::println);

        long salesOver1000 = sales.stream()
                .filter(sale -> sale.getAmount() > 1000)
                .count();

        System.out.println("\nNumber of Sales Over $1,000: "
                + salesOver1000);

        double totalSales = sales.stream()
                .mapToDouble(Sale::getAmount)
                .sum();

        System.out.printf("%nTotal Sales: $%.2f%n", totalSales);

        OptionalDouble averageSale = sales.stream()
                .mapToDouble(Sale::getAmount)
                .average();

        if (averageSale.isPresent()) {
            System.out.printf("Average Sale: $%.2f%n",
                    averageSale.getAsDouble());
        }

        sales.stream()
                .max((sale1, sale2) ->
                        Double.compare(
                                sale1.getAmount(),
                                sale2.getAmount()))
                .ifPresent(sale -> {
                    System.out.println("\nHighest Sale:");
                    System.out.println(sale);
                });

        sales.stream()
                .min((sale1, sale2) ->
                        Double.compare(
                                sale1.getAmount(),
                                sale2.getAmount()))
                .ifPresent(sale -> {
                    System.out.println("\nLowest Sale:");
                    System.out.println(sale);
                });

        System.out.println("\nSales from North Region:");
        sales.stream()
                .filter(sale -> sale.getRegion().equalsIgnoreCase("North"))
                .forEach(System.out::println);

        System.out.println("\nEmployee Names:");
        sales.stream()
                .map(Sale::getEmployeeName)
                .distinct()
                .forEach(System.out::println);
    }
}
