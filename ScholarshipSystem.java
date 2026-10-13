import java.util.Scanner;

class Student {
    private String name;
    private int rollNo;
    private double marks;
    private double attendance;
    private double income;

    Student(String name, int rollNo, double marks,
            double attendance, double income) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        this.attendance = attendance;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public double getMarks() {
        return marks;
    }

    public double getAttendance() {
        return attendance;
    }

    public double getIncome() {
        return income;
    }

    public boolean isValidData() {
        return marks >= 0 && marks <= 100
            && attendance >= 0 && attendance <= 100
            && income >= 0;
    }

    public String checkEligibility() {
        if (!isValidData())
            return "Invalid Data";
        else if (marks >= 85 && attendance >= 90 && income <= 200000)
            return "Eligible - Full Scholarship";
        else if (marks >= 75 && attendance >= 80 && income <= 300000)
            return "Eligible - Partial Scholarship";
        else
            return "Not Eligible";
    }

    public String getRemarks() {
        String remarks = "";
        if (marks < 75)
            remarks += "Marks below 75%; ";
        if (attendance < 80)
            remarks += "Attendance below 80%; ";
        if (income > 300000)
            remarks += "Income above Rs. 3,00,000; ";
        if (remarks.equals(""))
            remarks = "All criteria satisfied";
        return remarks.trim();
    }

    public void display() {
        System.out.println("\n----- Student Details -----");
        System.out.println("Name              : " + name);
        System.out.println("Roll Number       : " + rollNo);
        System.out.printf("Marks             : %.1f%%\n", marks);
        System.out.printf("Attendance        : %.1f%%\n", attendance);
        System.out.printf("Annual Income     : Rs. %.2f\n", income);
        System.out.println("Scholarship Status: " + checkEligibility());
        System.out.println("Remarks           : " + getRemarks());
    }
}

public class ScholarshipSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Roll Number: ");
            int rollNo = sc.nextInt();
            System.out.print("Enter Marks (%): ");
            double marks = sc.nextDouble();
            System.out.print("Enter Attendance (%): ");
            double attendance = sc.nextDouble();
            System.out.print("Enter Annual Income (Rs): ");
            double income = sc.nextDouble();
            sc.nextLine();

            students[i] = new Student(name, rollNo, marks, attendance, income);
        }

        System.out.println("\n===== SCHOLARSHIP ELIGIBILITY REPORT =====");

        int eligible = 0;
        for (int i = 0; i < n; i++) {
            students[i].display();
            if (students[i].checkEligibility().startsWith("Eligible"))
                eligible++;
        }

        System.out.println("\n----- Summary -----");
        System.out.println("Total Students : " + n);
        System.out.println("Eligible       : " + eligible);
        System.out.println("Not Eligible   : " + (n - eligible));

        sc.close();
    }
}
