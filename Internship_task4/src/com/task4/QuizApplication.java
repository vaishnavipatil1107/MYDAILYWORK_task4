package com.task4;

import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

public class QuizApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int score = 0;

        Question[] quiz = {
                new Question(
                        "1. Which language is used for Android development?",
                        new String[]{"1) Python", "2) Java", "3) C++", "4) Swift"},
                        2
                ),
                new Question(
                        "2. What is JVM?",
                        new String[]{"1) Java Virtual Machine", "2) Java Variable Method", "3) Joint Virtual Method", "4) None"},
                        1
                ),
                new Question(
                        "3. Which keyword is used to create object?",
                        new String[]{"1) class", "2) new", "3) object", "4) create"},
                        2
                )
        };

        System.out.println("===== Welcome to Quiz Application =====");

        for (Question q : quiz) {

            System.out.println("\n" + q.question);
            for (String option : q.options) {
                System.out.println(option);
            }

            System.out.println("You have 10 seconds to answer...");

            long startTime = System.currentTimeMillis();

            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();

            long endTime = System.currentTimeMillis();
            long timeTaken = (endTime - startTime) / 1000;

            if (timeTaken > 10) {
                System.out.println("Time is up! Question skipped.");
            } else {
                if (answer == q.correctAnswer) {
                    System.out.println("Correct Answer!");
                    score++;
                } else {
                    System.out.println("Wrong Answer!");
                }
            }
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your Final Score: " + score + "/" + quiz.length);

        sc.close();
    }
}

