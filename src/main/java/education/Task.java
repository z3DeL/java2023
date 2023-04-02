package education;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
public class Task {
    private String subject;
    private String type;
    private String taskPoint;

    public void taskMailing(Student[] students){
        for (Student student: students){
            student.addTask(this);}
    }
}

