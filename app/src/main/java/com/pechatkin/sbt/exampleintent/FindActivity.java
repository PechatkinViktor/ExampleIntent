package com.pechatkin.sbt.exampleintent;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FindActivity extends AppCompatActivity {

    private static final String SAVED_TEST_MODEL = String.valueOf(R.string.test_model_tag);

    private Random mRandom;
    private StringBuilder mForFirsString;
    private StringBuilder mForSecondString;
    private List<Integer> mForFirstList;
    private List<Integer> mForSecondList;

    private TextView mFirstTextView;
    private TextView mSecondTextView;

    private TestModel testModel3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);

        this.initFields();
        this.generateVal();

        testModel3 = new TestModel(mForFirsString.toString(), mForSecondString.toString(), mForFirstList, mForSecondList);

        mFirstTextView.setText(testModel3.getFirstString());
        mSecondTextView.setText(testModel3.getSecondString());

    }

    private void initFields() {
        mRandom = new Random();
        mForFirsString = new StringBuilder();
        mForSecondString = new StringBuilder();
        mForFirstList = new ArrayList<>();
        mForSecondList= new ArrayList<>();

        mFirstTextView = findViewById(R.id.first_view);
        mSecondTextView = findViewById(R.id.second_view);
    }

    private void generateVal() {
        for (int count = 0; count < mRandom.nextInt(20); count++) {
            mForFirsString.append(mRandom.nextInt(10));
            mForSecondString.append(mRandom.nextInt(15));
            mForFirstList.add(mRandom.nextInt(15));
            mForSecondList.add(mRandom.nextInt(15));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVED_TEST_MODEL, testModel3);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        testModel3 = savedInstanceState.getParcelable(SAVED_TEST_MODEL);
        mFirstTextView.setText(testModel3.getFirstString());
        mSecondTextView.setText(testModel3.getSecondString());
    }
}
