package com.yavuzoktay.onlinequizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.yavuzoktay.onlinequizz.Common.Common;
import com.yavuzoktay.onlinequizz.Model.QuesitonScore;

public class Done extends AppCompatActivity {

    Button btnTryAgain ;
    TextView txtResultScore,getTxtResultQuestion ;
    ProgressBar progressBar;

    FirebaseDatabase database ;
    DatabaseReference question_score ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);

        database=FirebaseDatabase.getInstance();
        question_score=database.getReference("Question_Score");

        txtResultScore= (TextView) findViewById(R.id.txtTotalScore);
        getTxtResultQuestion= (TextView) findViewById(R.id.txtTotalQuestion);

        progressBar = (ProgressBar) findViewById(R.id.doneProgressBar);
        btnTryAgain= (Button) findViewById(R.id.btnTryAgain);


        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=  new Intent(Done.this,Home.class);
                startActivity(intent);
                finish();
            }
        });

        Bundle extra = getIntent().getExtras();
        if (extra!=null){
            int score = extra.getInt("SCORE") ;
            int totalQuestion = extra.getInt("TOTAL") ;
            int correctAnswer = extra.getInt("CORRECT") ;

            txtResultScore.setText(String.format("SCORE : %d",score));
            getTxtResultQuestion.setText(String.format("PASSED: %d / %d",correctAnswer,totalQuestion));

            progressBar.setMax(totalQuestion);
            progressBar.setProgress(correctAnswer);

            question_score.child(String.format("%s_%s", Common.currentUser.getUserName(),Common.categoryId)).setValue(new QuesitonScore(String.format("%s_%s", Common.currentUser.getUserName(),Common.categoryId),Common.currentUser.getUserName(),String.valueOf(score)));

        }

    }
}
