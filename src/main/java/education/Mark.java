package education;


import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.AccessLevel;

import java.util.ArrayList;
@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class Mark {
    private int markStudent;
    private String feedback;
    private Task task;

    public java.util.List<Student> getStudentsWithMark(java.util.List<Student> students){
        ArrayList<Student> studentList = new ArrayList<>();
        for (Student student: students){
            for (Mark hisMark: student.getMarks()){
                if (hisMark.getTask() == this.task && hisMark.getMarkStudent() == this.markStudent){
                    studentList.add(student);
                }
            }
        }
        return studentList;
    }
}
