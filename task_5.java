import java.util.*;

class Course {
    private String code;
    private String title;
    private String desc;
    private int capacity;
    private String schedule;
    private List<Student> regstudents;

    public Course(String code, String title, String desc, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.desc = desc;
        this.capacity = capacity;
        this.schedule = schedule;
        this.regstudents = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getdesc() {
        return desc;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getAvailableSlots() {
        return capacity - regstudents.size();
    }

    public boolean addStudent(Student student) {
        if (regstudents.size() < capacity) {
            regstudents.add(student);
            return true;
        } else {
            System.out.println("Course is full.");
            return false;
        }
    }

    public void removeStudent(Student student) {
        regstudents.remove(student);
    }

    public void displayCourseDetails() {
        System.out.println("Course Code: " + code);
        System.out.println("Title: " + title);
        System.out.println("desc: " + desc);
        System.out.println("Schedule: " + schedule);
        System.out.println("Capacity: " + capacity);
        System.out.println("Available Slots: " + getAvailableSlots());
    }
}

class Student {
    private String studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.addStudent(this)) {
            registeredCourses.add(course);
            System.out.println("Registered successfully in " + course.getTitle());
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.removeStudent(this);
            System.out.println("Dropped course: " + course.getTitle());
        } else {
            System.out.println("You are not registered in this course.");
        }
    }
}

public class task_5 {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeData();

        while (true) {
            System.out.println("\nCourse Management System");
            System.out.println("1. Display Available Courses");
            System.out.println("2. Register Student for a Course");
            System.out.println("3. Remove Student from a Course");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAvailableCourses();
                    break;
                case 2:
                    registerStudentForCourse(scanner);
                    break;
                case 3:
                    removeStudentFromCourse(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void initializeData() {
        courses.add(new Course("101", "Computer Science", "Basic concepts of computer science", 30, "Mon 10:00-11:30"));
        courses.add(new Course("102", "Calculus I", "Introduction to differential and integral calculus", 25, "Tue 12:00-13:30"));
        courses.add(new Course("103", "Physics I", "Basic principles of mechanics", 20, "Wed 14:00-15:30"));

        students.add(new Student("3101056", "Vitthal"));
        students.add(new Student("3101055", "Anand"));
    }

    private static void displayAvailableCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            course.displayCourseDetails();
            System.out.println("-------------------------");
        }
    }

    private static void registerStudentForCourse(Scanner scanner) {
        System.out.print("\nEnter Student ID: ");
        String studentID = scanner.next();
        Student student = findStudentById(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code to Register: ");
        String courseCode = scanner.next();
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        student.registerCourse(course);
    }

    private static void removeStudentFromCourse(Scanner scanner) {
        System.out.print("\nEnter Student ID: ");
        String studentID = scanner.next();
        Student student = findStudentById(studentID);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter Course Code to Drop: ");
        String courseCode = scanner.next();
        Course course = findCourseByCode(courseCode);
        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        student.dropCourse(course);
    }

    private static Student findStudentById(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}