package com.example.quizz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView mtxtquestion;
    private int mquestionIndex;
    private int mquizQues;
    private ProgressBar mProgressBar;
    private TextView mquixStats;
    private int mscore;
    private String score;
    private String INDEX;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;





    private QuizModel[] questioncoll = new QuizModel[]{


            new QuizModel(R.string.q1,"He eats gillyweed" ),
            new QuizModel(R.string.q2,"Weasleys’ Wizard Wheezes"),
            new QuizModel(R.string.q3,"Sectumsempra"),
            new QuizModel(R.string.q4,"Ralph Fiennes"),
            new QuizModel(R.string.q5,"The Fat Lady" ),
            new QuizModel(R.string.q6,"Cornelius Fudge"),
            new QuizModel(R.string.q7,"Squib" ),
            new QuizModel(R.string.q8, "Removes parts of someone’s memory"),
            new QuizModel(R.string.q9, "Moaning Myrtle’s Bathroom"),
            new QuizModel(R.string.q10, "Mischief Managed"),


    };
    public String [] answerb1collection=new String[]{
            "He transfigures into a shark","Weasley Joke Emporium","Cruciatus Curse","Jeremy Irons","The Fat Lady","Cornelius Fudge","Bleaker","Destroys objects","Moaning Myrtle’s Bathroom","Mischief Managed"
    };
    public String [] answerb2collection=new String[]{
            "He kisses a mermaid","Weasleys’ Wizard Wheezes","Sectumsempra","Tom Hiddleston","The Grey Lady","Mad-eye Moody","Squib","Removes parts of someone’s memory","The Hogwarts Kitchen","Nothing to See Here"
    };
    public String [] answerb3collection=new String[]{
            "He eats gillyweed","Fred & George’s Wonder Emporium","AvadaKedavra","Ralph Fiennes","The Fat Friar","Professor Snape","Duddle","Makes objects invisible","The Gryffindor Common Room","Hello Professor"
    };

    int user_prog=(int)Math.ceil(100.0/questioncoll.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(savedInstanceState!=null){
            mscore=savedInstanceState.getInt(score);
            mquestionIndex=savedInstanceState.getInt(INDEX);
        }
        else {
            mscore=0;
            mquestionIndex=0;
        }
        mtxtquestion=findViewById(R.id.txtquestion);
        QuizModel q1 = questioncoll[mquestionIndex];
        mquizQues=q1.getMquestions();
        mtxtquestion.setText(mquizQues);
        mProgressBar=findViewById(R.id.quizpb);
        mquixStats=findViewById(R.id.txtquizStat);
        mquixStats.setText(mscore+"");




        btn1=findViewById(R.id.btn4Wrong);



        btn1.setText(answerb1collection[mquestionIndex]);


        btn2=findViewById(R.id.btn2Wrong);
        btn2.setText(answerb2collection[mquestionIndex]);
        btn3=findViewById(R.id.btn3True);
        btn3.setText(answerb3collection[mquestionIndex]);



        View.OnClickListener mycliListner=new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(view.getId()==R.id.btn4Wrong){
                    Toast.makeText(MainActivity.this,"you have marked TRUE", Toast.LENGTH_LONG).show();
                    evaluateUserAnswer(btn1.getText().toString());
                    Log.i("myt",btn1.getText().toString());


                }
                else if (view.getId()==R.id.btn2Wrong){
                    Toast.makeText(MainActivity.this,"you have marked Wrong", Toast.LENGTH_LONG).show();
                    evaluateUserAnswer(btn2.getText().toString());

                }else if (view.getId()==R.id.btn3True){
                    Toast.makeText(MainActivity.this,"you have marked Wrong", Toast.LENGTH_LONG).show();
                    evaluateUserAnswer(btn3.getText().toString());}


                changeQuestionOnButtonClick();



            }
        };
        btn1.setOnClickListener(mycliListner);
        btn3.setOnClickListener(mycliListner);


        btn2.setOnClickListener(mycliListner);

    }
    private  void changeQuestionOnButtonClick(){
        mquestionIndex=(mquestionIndex+1)%10;


        if(mquestionIndex==0){
            AlertDialog.Builder quizAlert = new AlertDialog.Builder(this);
            quizAlert.setCancelable(false);
            quizAlert.setTitle("Quiz is finish");
            quizAlert.setMessage("your score"+mscore);

            quizAlert.setPositiveButton("finish the quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();


                }
            });
            quizAlert.setNegativeButton("restart", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {



                    mscore=0;

                    onStart();
                }
            });
            quizAlert.show();




        }

        mquizQues=questioncoll[mquestionIndex].getMquestions();
        mtxtquestion.setText(mquizQues);
        btn1.setText(answerb1collection[mquestionIndex]);
        btn2.setText(answerb2collection[mquestionIndex]);
        btn3.setText(answerb3collection[mquestionIndex]);
        mProgressBar.incrementProgressBy(user_prog);
        mquixStats.setText(mscore+"");




    }
    private void evaluateUserAnswer(String userGuess){

        String currentQuestionAnswer=questioncoll[mquestionIndex].isManswer();

        if(currentQuestionAnswer.equals(userGuess)){
            Toast.makeText(getApplicationContext(),R.string.correct_toast_msg,Toast.LENGTH_SHORT).show();
            mscore=mscore+1;

        }
        else{
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast_msg,Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(score,mscore);
        outState.putInt(INDEX,mquestionIndex);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}