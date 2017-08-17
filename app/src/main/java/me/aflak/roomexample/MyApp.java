package me.aflak.roomexample;

import android.app.Application;

import me.aflak.roomexample.component.AppComponent;
import me.aflak.roomexample.component.DaggerAppComponent;
import me.aflak.roomexample.module.AppModule;

/**
 * Created by root on 17/08/17.
 */

public class MyApp extends Application {
    private static MyApp app;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext())).build();
    }

    public static MyApp app(){
        return app;
    }

    public AppComponent appComponent(){
        return appComponent;
    }
}
