package com.example.seil.tppracticing.db;

/**
 * Created by seil on 2016-07-10.
 */

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.IOException;

public  class TestAdapter
{
    protected static final String TAG = "DataAdapter";

    private final Context mContext;
    private static SQLiteDatabase mDb, mDbW;
    private DataBaseHelper mDbHelper;
    public Cursor mCur;

    private String chapter;

    public TestAdapter(Context context)
    {
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public TestAdapter(Context context, String chapter)
    {
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
        this.chapter = chapter;
    }

    public void getChapter(String chapter) { this.chapter = chapter;}

    public TestAdapter createDatabase() throws SQLException
    {
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public TestAdapter open() throws SQLException
    {
        try
        {
            mDbHelper.openDataBase();
           // mDbHelper.close();
            mDb = mDbHelper.getWritableDatabase();

        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    // 즐겨찾기 데이터 조회
    public Cursor getMyList() {

        try
        {
            this.open();
            String sql ="SELECT * FROM My_List";
            mCur = mDb.rawQuery(sql, null);

            if (mCur!=null)
            {
                mCur.moveToNext();
            }

            this.close();
            return mCur;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getMyList >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }

    // 즐겨찾기 데이터 추가
    public boolean AddMyList(Long id) {

        try
        {
            this.open();
            String sql = "insert into My_List (Data_Id) values (\"" + id + "\");";
            mDb.execSQL(sql);
            this.close();
            return true;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "AddMyList >>"+ mSQLException.toString());
            return false;
            //throw mSQLException;
        }
    }

    // 즐겨찾기 데이터 삭제
    public boolean DeleteMyList(Long id) {

        try
        {
            this.open();
            String sql = "delete from My_List where Data_Id = \"" + id + "\"";
            System.out.println(sql);
            mDb.execSQL(sql);
            this.close();
            return true;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "DeleteMyList >>"+ mSQLException.toString());
            return false;
            //throw mSQLException;
        }
    }

    public void Insert_List(String question, String answer)
    {
        try
        {
            this.open();
            String Question = question, Answer = answer;
            String sql = "insert into My_List (Question, Answer, State, Chapter) values (\"" + Question + "\",\"" + Answer + "\",'1',\"" + chapter + "\");";
            System.out.println(sql);
            mDb.execSQL(sql);
            this.close();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "Insert_List >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }

    public void Delete_List(String question, String answer, String delchap)
    {
        try
        {
            this.open();
            String Question = question, Answer = answer;
            String sql = "delete from My_List where Question = \"" + Question + "\" and Answer = \"" + Answer + "\"";
            System.out.println(sql);
            mDb.execSQL(sql);

            if(chapter.equals("My_List")) {
                sql = "UPDATE " + delchap + " SET State = 0 WHERE Question = \"" + question + "\" AND Answer = \"" + answer + "\";";
                System.out.println(sql);
                mDb.execSQL(sql);
            }

            this.close();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "Delete_List >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }

    public void changeState(String question, String answer, String state)
    {
        if(state.equals("1"))
            state = "0";
        else
            state = "1";

        try
        {
            this.open();
            String sql ="UPDATE " + chapter + " SET State = " + state + " WHERE Question = \"" + question + "\" AND Answer = \"" + answer + "\";";
            System.out.println(sql);
            mDb.execSQL(sql);

            this.close();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }

    public Cursor getTestData()
    {
        try
        {
            this.open();
            String sql ="SELECT * FROM " + chapter;
            mCur = mDb.rawQuery(sql, null);

            if (mCur!=null)
            {
                mCur.moveToNext();
            }

            this.close();
            return mCur;
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "getTestData >>"+ mSQLException.toString());
            throw mSQLException;
        }
    }
}

