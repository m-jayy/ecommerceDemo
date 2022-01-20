package com.example.ecommercedemo.DataBase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.ecommercedemo.DAO.ProductCartDAO;
import com.example.ecommercedemo.Models.apiCallProductsDetailResponse;



@androidx.room.Database(entities = {apiCallProductsDetailResponse.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static final String DATABASE_NAME="EcomDatabase";

    public abstract ProductCartDAO productCartDAO();

    private static volatile Database INSTANCE;


    public static Database getInstance(Context context){
        if(INSTANCE == null)
        {
            synchronized (Database.class){
                if(INSTANCE == null)
                {
                    INSTANCE= Room.databaseBuilder(context, Database.class,
                            DATABASE_NAME)
                            .addCallback(callback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
//            new PopulateAsynTask(INSTANCE);
        }
    };


    static class PopulateAsynTask extends AsyncTask<Void,Void,Void>
    {
        private ProductCartDAO productCartDAO;
        PopulateAsynTask(Database database)
        {
            productCartDAO= database.productCartDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            productCartDAO.deleteAll();
            return null;
        }
    }
}
