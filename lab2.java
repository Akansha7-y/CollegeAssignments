
// import java.util.*;

// abstract class PersonClass {
//     protected String name;
//     protected String email;

//     public PersonClass(String name, String email) {
//         this.name = name;
//         this.email = email;
//     }

//     public abstract void displayInfo();
// }

// class StudentClass1 extends PersonClass {
//     private int rollNo;
//     private String course;
//     private double marks;
//     private String grade;

//     public StudentClass1() {
//         super("", "");
//         this.rollNo = 0;
//         this.course = "";
//         this.marks = 0.0;
//         this.grade = "";
//     }

//     public StudentClass1(String name, String email, int rollNo, String course, double marks) {
//         super(name, email);
//         this.rollNo = rollNo;
//         this.course = course;
//         this.marks = marks;
//         this.grade = calculateGrade();
//     }

//     public StudentClass1(String name, String email, int rollNo) {
//         super(name, email);
//         this.rollNo = rollNo;
//         this.course = "";
//         this.marks = 0.0;
//         this.grade = "";
//     }

//     @Override
//     public void displayInfo() {
//         System.out.println("Name: " + name);
//         System.out.println("Email: " + email);
//         System.out.println("Roll No: " + rollNo);
//         System.out.println("Course: " + course);
//         System.out.println("Marks: " + marks);
//         System.out.println("Grade: " + grade);
//     }

//     public void displayInfo(boolean summary) {
//         if (summary) {
//             System.out.println("Roll No: " + rollNo + ", Name: " + name + ", Grade: " + grade);
//         } else {
//             displayInfo();
//         }
//     }

//     private String calculateGrade() {
//         if (marks >= 90) return "A";
//         else if (marks >= 80) return "B";
//         else if (marks >= 70) return "C";
//         else if (marks >= 60) return "D";
//         else return "F";
//     }

//     public int getRollNo() { return rollNo; }
//     public String getName() { return name; }
//     public String getEmail() { return email; }
//     public String getCourse() { return course; }
//     public double getMarks() { return marks; }
//     public String getGrade() { return grade; }

//     public void setCourse(String course) { this.course = course; }
//     public void setMarks(double marks) { this.marks = marks; this.grade = calculateGrade(); }
// }

// interface RecordActions {
//     void addStudent(StudentClass1 student);
//     void deleteStudent(int rollNo);
//     void updateStudent(int rollNo, StudentClass1 updatedStudent);
//     void viewStudent(int rollNo);
//     void viewAllStudents();
// }

// class StudentManager1 implements RecordActions {
//     private List<StudentClass1> studentList;
//     private Map<Integer, StudentClass1> studentMap;

//     public StudentManager1() {
//         studentList = new ArrayList<>();
//         studentMap = new HashMap<>();
//     }

//     @Override
//     public void addStudent(StudentClass1 student) {
//         if (studentMap.containsKey(student.getRollNo())) {
//             System.out.println("Error: Student with Roll No " + student.getRollNo() + " already exists.");
//         } else {
//             studentList.add(student);
//             studentMap.put(student.getRollNo(), student);
//             System.out.println("Student added successfully.");
//         }
//     }

//     @Override
//     public void deleteStudent(int rollNo) {
//         if (studentMap.containsKey(rollNo)) {
//             studentList.removeIf(s -> s.getRollNo() == rollNo);
//             studentMap.remove(rollNo);
//             System.out.println("Student deleted successfully.");
//         } else {
//             System.out.println("Student not found.");
//         }
//     }
//     @Override
//     public void updateStudent(int rollNo, StudentClass1 updatedStudent) {
//         if (studentMap.containsKey(rollNo)) {
//             studentList.removeIf(s -> s.getRollNo() == rollNo);
//             studentList.add(updatedStudent);
//             studentMap.put(rollNo, updatedStudent);
//             System.out.println("Student updated successfully.");
//         } else {
//             System.out.println("Student not found.");
//         }
//     }

//     @Override
//     public void viewStudent(int rollNo) {
//         StudentClass1 student = studentMap.get(rollNo);
//         if (student != null) {
//             student.displayInfo();
//         } else {
//             System.out.println("Student not found.");
//         }
//     }

//     @Override
//     public void viewAllStudents() {
//         if (studentList.isEmpty()) {
//             System.out.println("No students to display.");
//         } else {
//             for (StudentClass1 student : studentList) {
//                 student.displayInfo();
//                 System.out.println("---------------");
//             }
//         }
//     }
// }

// public class lab2 {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         StudentManager1 manager = new StudentManager1();

       
//         StudentClass1 s1 = new StudentClass1("Alice", "alice@example.com", 101, "CS", 85.5);
//         StudentClass1 s2 = new StudentClass1("Bob", "bob@example.com", 102, "IT", 92.0);
//         manager.addStudent(s1);
//         manager.addStudent(s2);

//         PersonClass p = new StudentClass1("Charlie", "charlie@example.com", 103, "Math", 78.0);
//         p.displayInfo();

//         while (true) {
//             System.out.println("\n1. Add Student\n2. View Student\n3. Update Student\n4. Delete Student\n5. View All\n6. Exit");
//             System.out.print("Choose: ");
//             int choice = sc.nextInt();
//             sc.nextLine(); 

//             switch (choice) {
//                 case 1:
//                     System.out.print("Name: ");
//                     String name = sc.nextLine();
//                     System.out.print("Email: ");
//                     String email = sc.nextLine();
//                     System.out.print("Roll No: ");
//                     int rollNo = sc.nextInt();
//                     sc.nextLine();
//                     System.out.print("Course: ");
//                     String course = sc.nextLine();
//                     System.out.print("Marks: ");
//                     double marks = sc.nextDouble();
//                     StudentClass1 newStudent = new StudentClass1(name, email, rollNo, course, marks);
//                     manager.addStudent(newStudent);
//                     break;
//                 case 2:
//                     System.out.print("Roll No: ");
//                     int viewRoll = sc.nextInt();
//                     manager.viewStudent(viewRoll);
//                     break;
//                 case 3:
//                     System.out.print("Roll No to update: ");
//                     int updateRoll = sc.nextInt();
//                     sc.nextLine();
//                     System.out.print("New Name: ");
//                     String newName = sc.nextLine();
//                     System.out.print("New Email: ");
//                     String newEmail = sc.nextLine();
//                     System.out.print("New Course: ");
//                     String newCourse = sc.nextLine();
//                     System.out.print("New Marks: ");
//                     double newMarks = sc.nextDouble();
//                     StudentClass1 updated = new StudentClass1(newName, newEmail, updateRoll, newCourse, newMarks);
//                     manager.updateStudent(updateRoll, updated);
//                     break;
//                 case 4:
//                     System.out.print("Roll No to delete: ");
//                     int deleteRoll = sc.nextInt();
//                     manager.deleteStudent(deleteRoll);
//                     break;
//                 case 5:
//                     manager.viewAllStudents();
//                     break;
//                 case 6:
//                     System.out.println("Exiting...");
//                     sc.close();
//                     return;
//                 default:
//                     System.out.println("Invalid choice.");
//             }
//         }
//     }
// }