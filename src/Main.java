public class Main {

    public static void main(String[] args) {

        Quiz q = new Quiz();

        if (q.loadQuestions("Q&A.txt")) {
            q.startTest();
        }
    }
}