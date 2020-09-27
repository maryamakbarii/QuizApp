package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button true_button, false_button, next_button;
    TextView tv_quiz;
    private int currentIndex = 0;
    private Quiz[] quizBank = new Quiz[]{
            new Quiz(R.string.quiz_general, false),
            new Quiz(R.string.quiz_general1, false),
            new Quiz(R.string.quiz_general2, false),
            new Quiz(R.string.quiz_general3, true),
            new Quiz(R.string.quiz_general4, false),
            new Quiz(R.string.quiz_general5, false),
            new Quiz(R.string.quiz_general6, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        true_button.setOnClickListener(this);
        false_button.setOnClickListener(this);
        next_button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.true_button:
                checkAnswer(true);
                break;
            case R.id.false_button:
                checkAnswer(false);
                break;
            case R.id.next_button:
                currentIndex = (currentIndex + 1) % quizBank.length;
                updateQuiz();
                break;
        }
    }

    private void updateQuiz() {
        tv_quiz.setText(quizBank[currentIndex].getAnswerID());
    }

    private void checkAnswer(boolean answerIsTrue) {
        boolean userChooseCorrect = quizBank[currentIndex].isAnswerTrue();
        int toastMessageId ;
        if (answerIsTrue == userChooseCorrect) {
            toastMessageId = R.string.is_correct;
        } else {
            toastMessageId = R.string.is_incorrect;
        }
        Toast.makeText(this, toastMessageId, Toast.LENGTH_SHORT).show();
    }

    private void initialize() {
        true_button = findViewById(R.id.true_button);
        false_button = findViewById(R.id.false_button);
        next_button = findViewById(R.id.next_button);
        tv_quiz = findViewById(R.id.tv_quiz);
    }
}