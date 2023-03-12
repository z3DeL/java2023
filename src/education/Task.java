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

    private String getSubject() {
        return subject;
    }

    private void setSubject(String subject) {
        this.subject = subject;
    }

    private String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    private String getTaskPoint() {
        return taskPoint;
    }

    private void setTaskPoint(String taskPoint) {
        this.taskPoint = taskPoint;
    }
    public void taskMailing(Student[] students){
        for (Student student: students){
            student.addTask(this);}
    }
}

