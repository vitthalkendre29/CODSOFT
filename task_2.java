import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int subjects = input.nextInt();
        double[] marks = new double[subjects];
        double totalMarks = 0;

        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter the marks obtained in subject (out of 100) " + (i + 1) + ": ");
            marks[i] = input.nextDouble();
            totalMarks += marks[i];
        }
        double averagePercentage = totalMarks / subjects;

        // Grade Calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'O';
        } else if (averagePercentage >= 80) {
            grade = 'A';
        } else if (averagePercentage >= 70) {
            grade = 'B';
        } else if (averagePercentage >= 60) {
            grade = 'C';
        } else if (averagePercentage >= 50) {
            grade = 'P';
        } else {
            grade = 'F';
        }

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);

        input.close();
    }
}
