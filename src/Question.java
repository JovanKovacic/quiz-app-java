import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {

    private String text;
    private List<Answer> answers;

    public Question(String text) {
        this.text = text;
        this.answers = new ArrayList<>();
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void shuffleAnswers() {
        Collections.shuffle(answers);
    }

    public String toString() {

        String answersText = "";
        int index = 1;

        for (Answer a : answers) {
            answersText += index + "->" + a.getText() + "\n";
            index++;
        }

        return text + "\n" + answersText;
    }
}