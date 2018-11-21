package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame implements ActionListener {
//okno zawiera dwa buttony i labela

    private QuestionGenerator questionGenerator;
    public QuestionGenerator getQuestionGenerator() {
        return questionGenerator;
    }

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        this.questionGenerator = questionGenerator;
    }

    private int currentQuestion;
    private int score = 0;
    private List<Question> questionList = new ArrayList<>();


    public Main(){
        setQuestionGenerator(new QuestionFileGenerator());
        questionList = questionGenerator.generateQuestions();
        setSize(500,500);// ustawia wielkość okna
        // metoda setSize() znajduje się w JFRAME
        setTitle("Millionaires");

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //zamykanie okna metoda set DefoultCloseOperation
        //WindowsConstants.EXIT_ON_CLOSE
        //jest zmienna która jest w lkasie WindowsConstans
        //i ma wartosc 3
        //JButton taki konstruktor
        JButton yesButton = new JButton("Tak");
        yesButton.addActionListener(this);
        JButton noButton = new JButton("Nie");
        noButton.addActionListener(this);
        label = new JLabel(questionList.get(currentQuestion).getContent(),0); //0 wycentrowanie
        //3 rzedy, 1 kolumna
        setLayout(new GridLayout(3,1));

        //dodanie do okna przycisku o rzedzi numerz 1
        add(label);
        //dodanie do okna przycisku o rzedzie numerz 2
        add(yesButton);
        //dodanie do okna przycisku o rzedzie numerz 3
        add(noButton);

    }
    private JLabel label;

    public static void main(String[] args) {
	// write your code here
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Main main = new Main();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        System.out.println("Wybrano: " + button.getText());
//        currentQuestion++;
//        label.setText(questionList.get(currentQuestion).getContent());
//        System.out.println("Kliknięto mnie");

        if (button.getText().equals("Tak")){
            if (questionList.get(currentQuestion).isCorrect()){
                System.out.println("poprawna odpowiedz");
                //   a++;
                //score.add("point");
                score++;
                System.out.println("Liczba punktow: "+ score);
            } else {
                System.out.println("zla odpowiedz");
                System.out.println("Liczba punktow: "+ score);
            }
        } else {
            if (!questionList.get(currentQuestion).isCorrect()){
                System.out.println("poprawna odpowiedz");
                //score.add("point");
                score++;
                System.out.println("Liczba punktow: "+ score);
            } else {
                System.out.println("zla odpowiedz");
                System.out.println("Liczba punktow: "+ score);
            }
        }

        if (questionList.size() > currentQuestion+1){
            currentQuestion++;
            label.setText(questionList.get(currentQuestion).getContent());
        } else {
//            button.setVisible(false);
//            setLayout(new GridLayout());
//            label.setText("Koncowy wynik: " + score +"/"+questionList.size());
//            add(label);
            JOptionPane.showMessageDialog(this,"Koncowy wynik: " + score +"/"+questionList.size());
        }
    }
}
