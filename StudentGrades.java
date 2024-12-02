import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        String input;
        
        // Input loop for grades
        do {
            System.out.print("Enter a student's grade(in numbers) then type 'done' to finish(to calculate the scores): ");
            input = scanner.nextLine();
            
            if (!input.equalsIgnoreCase("done")) {
                try {
                    double grade = Double.parseDouble(input);
                    grades.add(grade);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        } while (!input.equalsIgnoreCase("done"));
        
        // Calculate statistics
        if (grades.size() > 0) {
            double sum = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);
            
            for (double grade : grades) {
                sum += grade;
                if (grade > highest) {
                    highest = grade;
                }
                if (grade < lowest) {
                    lowest = grade;
                }
            }
            
            double average = sum / grades.size();
            
            // Output results
            System.out.println("Total number of grades entered: " + grades.size());
            System.out.println("Average grade: " + average);
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
        } else {
            System.out.println("No grades were entered.");
        }
        
        scanner.close();
    }
}