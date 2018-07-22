package com.example.android.miwok;

/**
 * Created by User on 05-01-2018.
 */

public class WordPhr {
    public String mMiwStr;
    public String mEngStr;

    public WordPhr(String MiwStr,String EngStr) {
        mEngStr=EngStr;
        mMiwStr=MiwStr;
    }

    public String getmEngPhr() {
        return mEngStr;
    }

    public String getmMiwPhr() {
        return mMiwStr;
    }
}
