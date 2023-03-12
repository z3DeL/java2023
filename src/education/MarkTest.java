package education;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class MarkTest {

    @org.junit.jupiter.api.Test
    void getStudentsWithMark()  {
        Task task1 = new Task("math", "homework","aaaaaa");
        Mark mark1 = new Mark(4,"sdgsgds1",task1);
        Task task2 = new Task("math", "homework","aaaaaab");
        Mark mark2 = new Mark(2,"sdgsgds1",task2);
        Task task3 = new Task("math", "homework","aaaaaa");
        Mark mark3 = new Mark(5,"sdgsgds412",task3);
        Task task4 = new Task("math", "homework","aaaaaa");
        Mark mark4 = new Mark(4,"sdgsgds",task4);
        ArrayList<Mark> marks1 = new ArrayList<>(Arrays.asList(mark1,mark2,mark3));
        ArrayList<Mark> marks2 = new ArrayList<>(Arrays.asList(mark1,mark2,mark4));
        Student student1 = new Student("sdgsg", marks1,new ArrayList<>());
        Student student2 = new Student("sdgsg", marks2,new ArrayList<>());
        ArrayList<Student> students1 = new ArrayList<>(Arrays.asList(student1,student2));
        assertEquals(student1,mark2.getStudentsWithMark(students1));
    }

    public static void main(String[] args) {
        Task task1 = new Task("math", "homework","aaaaaa");
        Mark mark1 = new Mark(4,"sdgsgds1",task1);
        Task task2 = new Task("math", "homework","aaaaaab");
        Mark mark2 = new Mark(2,"sdgsgds1",task2);
        Task task3 = new Task("math", "homework","aaaaaa");
        Mark mark3 = new Mark(5,"sdgsgds412",task3);
        Task task4 = new Task("math", "homework","aaaaaa");
        Mark mark4 = new Mark(4,"sdgsgds",task4);
        ArrayList<Mark> marks1 = new ArrayList<>(Arrays.asList(mark1,mark2,mark3));
        ArrayList<Mark> marks2 = new ArrayList<>(Arrays.asList(mark1,mark2,mark4));
        Student student1 = new Student("sdgsg", marks1,new ArrayList<>());
        Student student2 = new Student("sdgsg", marks2,new ArrayList<>());
        ArrayList<Student> students1 = new ArrayList<>(Arrays.asList(student1,student2));
        System.out.println(mark2.getStudentsWithMark(students1));
    }
}
