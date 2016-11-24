package com.quizapp.ryan.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.math.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;

    private TextView mQuestionTextView;

    private question[] mQuestionBank = new question[]{
            new question(R.string.question_oceans,true),
            new question(R.string.question_mideast,false),
            new question(R.string.question_africa,false),
            new question(R.string.question_americas,true),
            new question(R.string.question_asia,true)
    };

    private int mCurrentIndex = 0;


    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerisTrue = mQuestionBank[mCurrentIndex].getAnswerTrue();

        int messageResId = 0;

        if(userPressedTrue == answerisTrue)
            messageResId = R.string.correct_toast;

        else
            messageResId = R.string.incorrect_toast;

        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate(Bundle called)");

        if(savedInstanceState!=null)
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);

        setContentView(R.layout.activity_main);

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        mFalseButton    = (Button) findViewById(R.id.false_button);

        mFalseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                checkAnswer(false);

            }
        });

        mTrueButton     = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               checkAnswer(true);
            }
        });



        mNextButton   = (ImageButton) findViewById(R.id.next_button);

        mNextButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mCurrentIndex = (mCurrentIndex+1)% mQuestionBank.length;
                updateQuestion();
            }
        });


        mPreviousButton   = (ImageButton) findViewById(R.id.previous_button);

        mPreviousButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mCurrentIndex = mCurrentIndex-1;
                if(mCurrentIndex<0)
                    mCurrentIndex = -mCurrentIndex;
                mCurrentIndex = mCurrentIndex % mQuestionBank.length;
                updateQuestion();
            }
        });


        mQuestionTextView.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                mCurrentIndex = (mCurrentIndex+1)% mQuestionBank.length;
                updateQuestion();
            }
        });

        updateQuestion();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState((savedInstanceState));
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"onStart() called");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"onPause() called");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"onResume() called");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestory() called");
    }

}
