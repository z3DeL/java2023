package education;

import java.util.ArrayList;

public class Mark {
    private int mark;
    private String feedback;
    private Task task;

    public Mark(int mark, String feedback, Task task) {
        this.mark = mark;
        this.feedback = feedback;
        this.task = task;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getFeedback() {
        return feedback;
    }

    private void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    private Task getTask() {
        return task;
    }

    private void setTask(Task task) {
        this.task = task;
    }
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
