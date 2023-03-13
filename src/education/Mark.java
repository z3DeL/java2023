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
    private int mark;
    private String feedback;
    private Task task;

    public ArrayList<Student> getStudentsWithMark(ArrayList<Student> students){
        ArrayList<Student> studentList = new ArrayList<>();
        for (Student student: students){
            for (Mark hisMark: student.getMarks()){
                if (hisMark.getTask() == this.task && hisMark.getMark() == this.mark){
                    studentList.add(student);
                }
            }
        }
        return studentList;
    }
}
