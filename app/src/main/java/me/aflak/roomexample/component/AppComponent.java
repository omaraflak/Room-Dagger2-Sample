package me.aflak.roomexample.component;

import javax.inject.Singleton;

import dagger.Component;
import me.aflak.roomexample.module.AppModule;
import me.aflak.roomexample.ui.MainActivity;

/**
 * Created by root on 17/08/17.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
