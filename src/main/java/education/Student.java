package education;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor

public class Student {
    private String name;
    private List<Mark> marks;
    private List<Task> tasksToCheck;
    static final Random random = new Random();

    public List<Mark> getMarks() {
        return marks;
    }


    public List<Task> getTasksToCheck() {
        return tasksToCheck;
    }

    private static double getRandomIntegerBetweenRange(double min, double max){
        return (int)(random.nextInt()*((max-min)+1))+min;
    }
    private static String generateRandomWords(int numberOfWords)
    {
        String[] randomStrings = new String[numberOfWords];

        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }

        StringBuilder bld = new StringBuilder();
        for (int i = 0; i < randomStrings.length; ++i) {
            bld.append(randomStrings[i]);
        }
        return bld.toString();
    }

    public void checkTask(){
        if (!tasksToCheck.isEmpty()){
            Mark mark = new Mark((int)getRandomIntegerBetweenRange(1,10),
            generateRandomWords(random.nextInt()),tasksToCheck.get(tasksToCheck.size() -1));
            tasksToCheck.remove(tasksToCheck.size()-1);
            marks.add(mark);
        }
    }
    public double averageMark(){
        int sum = 0;
        for (Mark m: marks){
            sum += m.getMarkStudent();
        }
        return (double)sum / marks.size();
    }
    public void addTask(Task task){
        tasksToCheck.add(task);
    }
}
