package me.aflak.roomexample.module;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.aflak.roomexample.database.MyDatabase;
import me.aflak.roomexample.database.UserDao;

/**
 * Created by root on 17/08/17.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Singleton @Provides
    public Context provideContext(){
        return context;
    }

    @Singleton @Provides
    public MyDatabase provideMyDatabase(Context context){
        return Room.databaseBuilder(context, MyDatabase.class, "my-db").build();
    }

    @Singleton @Provides
    public UserDao provideUserDao(MyDatabase myDatabase){
        return myDatabase.userDao();
    }
}
