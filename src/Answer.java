public class Answer {

    private String answer;
    private boolean correct;

    public Answer(String answer, boolean correct) {
        this.answer = answer;
        this.correct = correct;
    }

    public String getText() {
        return answer;
    }

    public String toString() {
        return answer;
    }

    public boolean isCorrect() {
        return correct;
    }
}