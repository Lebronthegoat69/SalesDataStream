# Sales Data Stream Analyzer

## Project Description

The Sales Data Stream Analyzer is a Java program that reads sales records from an external `sales.csv` file and uses Java Streams to analyze sales information. The program stores each record in a `Sale` object and calculates useful business information, including total sales, average sale amount, highest and lowest sales, and filtered sales results.

## Features

- Reads sales records from `sales.csv`.
- Creates `Sale` objects and stores them in a list.
- Displays all sales records.
- Filters and displays sales over $500.
- Counts sales over $1,000.
- Calculates the total sales amount.
- Calculates the average sale amount.
- Finds the highest and lowest sales.
- Displays sales from the North region.
- Extracts and displays unique employee names.
- Handles file-reading errors and invalid numeric values.

## Files

- `Main.java` — Reads the sales file and analyzes the data using Java Streams.
- `Sale.java` — Defines the Sale class, including its fields, constructor, getter methods, and `toString()` method.
- `sales.csv` — Contains the sales records used by the program.

## CSV File Description

The `sales.csv` file contains sales records with the following information:

- **Sale ID:** Unique identifier for each sale.
- **Employee:** Name of the employee who made the sale.
- **Region:** Region associated with the sale.
- **Amount:** Dollar amount of the sale.

The program skips the header row and converts the sale ID and amount into numeric values before creating Sale objects.

## Technologies Used

- Java
- Java Streams
- Collections (`List` and `ArrayList`)
- File I/O
- Exception handling

## How to Run the Program

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA.
3. Make sure a compatible JDK is configured.
4. Place `sales.csv` in the main project folder, alongside the `src` folder.
5. Open `Main.java`.
6. Run the `main()` method.
7. Review the sales analysis results in the console.

## Sample Output

The program displays all sales, sales over $500, the number of sales over $1,000, total sales, average sale amount, highest sale, lowest sale, sales from the North region, and employee names.

<img width="975" height="118" alt="image" src="https://github.com/user-attachments/assets/7c070923-0f25-4296-a00c-71fa8471b1c7" />

Sam
