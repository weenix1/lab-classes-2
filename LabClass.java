import java.util.ArrayList;

/**
 * The LabClass class represents an enrolment list for one lab class. It stores
 * the time, room and participants of the lab, as well as the instructor's name.
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 */
public class LabClass
{
    private String instructor;
    private String room;
    private String timeAndDay;
    private ArrayList<Student> students;  // allows later to add objects of type Student
    // to this ArrayList
    // private int capacity; //not needed when using ArrayList or HashSet

    /**
     * Create a LabClass with a maximum number of enrolments. All other details
     * are set to default values. Deprecated, because ArrayList can grow dynamically
     * once the number of enroled student is increasing.
     * 
     * @param not used because number of the students is not limited
     */
    public LabClass(int maxNumberOfStudents)
    {
        instructor = "unknown";
        room = "unknown";
        timeAndDay = "unknown";
        students = new ArrayList<Student>(); // initialize this students ref.
        // with an empty ArrayList
        // capacity = maxNumberOfStudents; //not needed, see comment in the fields
    }   

    /**
     * LabClass Default Constructor, capacity= 10
     *
     */
    public LabClass()
    {
        this(0); // replaces copied code:
        // instructor = "unknown";
        // room = "unknown";
        // timeAndDay = "unknown";
        // students = new ArrayList<Student>();
        // capacity = 10;
    }

    /**
     * Add a student to this LabClass.
     */
    public void enrollStudent(Student newStudent)
    {
        // not needed, see comment in the fields:
        // if(students.size() == capacity) {
        // System.out.println("The class is full, you cannot enrol.");
        // }
        // else {
        students.add(newStudent);
        // }
    }
    
    /**
     * Method removeStudent at a given position
     *
     * @param the index in the ArrayList, no check if the index is out of bounds
     *
     */
    public void removeStudent(int index){
        students.remove(index);
        // no check about the success of removing, the returned boolean is ignored
    }
    
    /**
     * Method getStudentByName gives access to that Student object!
     *
     * @param name of the student to be searched
     * @return reference to the first student object with that name nn the collection 
     */
    public Student getStudentByName(String name){
        for(Student stud:students){
            //stud.getName() // each student iterated over is asked for its name
            //stud.getName().equals(name) // gives true when we found the student
            if( stud.getName().equals(name) ) return stud;
        }
        // arrive here if we have not found a student with that name!
        return null; // reserved keyword for not referencing an existing object
    }

    /**
     * Return the number of students currently enrolled in this LabClass.
     */
    public int numberOfStudents()
    {
        return students.size(); // calls the size() method to class ArrayList<>
    }

    /**
     * Set the room number for this LabClass.
     */
    public void setRoom(String roomNumber)
    {
        room = roomNumber;
    }

    /**
     * Set the time for this LabClass. The parameter should define the day
     * and the time of day, such as "Friday, 10am".
     */
    public void setTime(String timeAndDayString)
    {
        timeAndDay = timeAndDayString;
    }

    /**
     * Set the name of the instructor for this LabClass.
     */
    public void setInstructor(String instructorName)
    {
        instructor = instructorName;
    }

    /**
     * Print out a class list with other LabClass details to the standard
     * terminal.
     */
    public void printList()
    {
        System.out.println("Lab class " + timeAndDay);
        System.out.println("Instructor: " + instructor + "   Room: " + room);
        System.out.println("Class list:");
        for(Student student : students) { //for-each loop over the ArrayList instance
            // this worksbecause the ArrayList provides an Iterator in the API!
            // student is a local variable inside the for-each block
            // that will assume all values stored in the arraylist,
            // i.e. references to the students
            student.print(); // delegates printing to the student instance
        }
        System.out.println("Number of students: " + numberOfStudents());
    }
}
