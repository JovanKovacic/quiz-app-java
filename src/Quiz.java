import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    private List<Question> questions;
    private double score = 0;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public boolean loadQuestions(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String text;

            while ((text = br.readLine()) != null) {
                Question q = new Question(text);
                text = br.readLine();
                q.addAnswer(new Answer(text, true));
                text = br.readLine();
                q.addAnswer(new Answer(text, false));
                text = br.readLine();
                q.addAnswer(new Answer(text, false));
                text = br.readLine();
                q.addAnswer(new Answer(text, false));

                questions.add(q);
            }

            Collections.shuffle(questions);

            return true;

        } catch (Exception e) {
            System.out.println("Error while loading the file!");
        }

        return false;
    }

    public void startTest() {

        Scanner scanner = new Scanner(System.in);

        for (Question q : questions) {

            q.shuffleAnswers();

            System.out.println(q);

            int answer = -1;
            boolean valid = false;

            while (!valid) {

                System.out.println("Enter your answer:");

                try {
                    answer = Integer.parseInt(scanner.nextLine());

                    if (answer < 1 || answer > q.getAnswers().size()) {
                        System.out.println("Enter a number from 1 to " + q.getAnswers().size() + "!");
                    } else {
                        valid = true;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Enter a whole number!");
                }
            }

            if (q.getAnswers().get(answer - 1).isCorrect()) {
                score++;
            }
        }

        scanner.close();

        System.out.println("THE TEST IS FINISHED!");

        if (questions.size() > 0) {
            System.out.println("Your result is: " + score / questions.size() * 100 + "%");
        } else {
            System.out.println("Your result is: 0%");
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }
}