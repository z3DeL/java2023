package education;

public class Task {
    private String subject;
    private String type;
    private String taskPoint;

    public Task(String subject, String type, String taskPoint) {
        this.subject = subject;
        this.type = type;
        this.taskPoint = taskPoint;
    }

    public String getSubject() {
        return subject;
    }

    public String getType() {
        return type;
    }


    public String getTaskPoint() {
        return taskPoint;
    }

    public void taskMailing(Student[] students){
        for (Student student: students){
            student.addTask(this);}
    }
}

