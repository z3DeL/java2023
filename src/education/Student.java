package education;


import java.util.ArrayList;
import java.util.Random;

public class Student {
    private String name;
    private ArrayList<Mark> marks;
    private ArrayList<Task> tasksToCheck;

    public Student(String name, ArrayList<Mark> marks, ArrayList<Task> tasksToCheck) {
        this.name = name;
        this.marks = marks;
        this.tasksToCheck = tasksToCheck;
    }

    public String getName() {
        return name;
    }


    public ArrayList<Mark> getMarks() {
        return marks;
    }


    public ArrayList<Task> getTasksToCheck() {
        return tasksToCheck;
    }

    private static double getRandomIntegerBetweenRange(double min, double max){
        return (int)(java.lang.Math.random()*((max-min)+1))+min;
    }
    private static String generateRandomWords(int numberOfWords)
    {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }
        String res = "";
        for (String s: randomStrings){
            res += s;
        }
        return res;
    }

    public void checkTask(){
        if (!tasksToCheck.isEmpty()){
            Mark mark = new Mark((int)getRandomIntegerBetweenRange(1,10),
            generateRandomWords((int)java.lang.Math.random()),tasksToCheck.get(tasksToCheck.size() -1));
            tasksToCheck.remove(tasksToCheck.size()-1);
            marks.add(mark);
        }
    }
    public double averageMark(){
        int sum = 0;
        for (Mark m: marks){
            sum += m.getMark();
        }
        return (double)sum / marks.size();
    }
    public void addTask(Task task){
        tasksToCheck.add(task);
    }
}
