package com.pechatkin.sbt.exampleintent;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class TestModel implements Parcelable {

    private String mFirstString;
    private String mSecondString;
    private List<Integer> mFirstList;
    private List<Integer> mSecondList;

    protected TestModel() {}

    protected TestModel(String mFirstString, String mSecondString, List<Integer> mFirstList, List<Integer> mSecondList) {
        this.mFirstString = mFirstString;
        this.mSecondString = mSecondString;
        this.mFirstList = mFirstList;
        this.mSecondList = mSecondList;
    }

    protected TestModel(Parcel in) {
        mFirstString = in.readString();
        mSecondString = in.readString();
        mFirstList = new ArrayList<>();
        in.readList(mFirstList, mFirstList.getClass().getClassLoader());
        mSecondList = new ArrayList<>();
        in.readList(mFirstList, mSecondList.getClass().getClassLoader());
    }

    public static final Creator<TestModel> CREATOR = new Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel in) {
            return new TestModel(in);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        Log.v("", "writeToParcel..." + i);
        parcel.writeString(mFirstString);
        parcel.writeString(mSecondString);
        parcel.writeList(mFirstList);
        parcel.writeList(mSecondList);
    }

    public String getFirstString() {
        return mFirstString;
    }

    public String getSecondString() {
        return mSecondString;
    }
}
