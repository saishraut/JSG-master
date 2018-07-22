package com.example.android.miwok;

/**
 * Created by User on 05-01-2018.
 */

public class Word {
    public String mMiwStr;
    public String mEngStr;
    public int mImageResourceId;

    public Word(String MiwStr,String EngStr, int ImageResourceId) {
        mImageResourceId=ImageResourceId;
        mEngStr=EngStr;
        mMiwStr=MiwStr;
    }

    public String getmEngStr() {
        return mEngStr;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmMiwStr() {
        return mMiwStr;
    }
}
