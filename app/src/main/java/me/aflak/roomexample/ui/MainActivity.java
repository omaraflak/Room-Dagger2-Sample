package me.aflak.roomexample.ui;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.aflak.roomexample.MyApp;
import me.aflak.roomexample.R;
import me.aflak.roomexample.database.UserDao;
import me.aflak.roomexample.entity.User;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.uid) TextView uid;
    @BindView(R.id.first_name) TextView firstName;
    @BindView(R.id.last_name) TextView lastName;
    @BindView(R.id.age) TextView age;

    @Inject UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        MyApp.app().appComponent().inject(this);

        // Room requests need to be done on a working thread
        new Request().execute();
    }

    private void displayUser(final User user){
        uid.setText(String.format(Locale.getDefault(),"uid : %d", user.getUid()));
        firstName.setText(String.format("first_name : %s", user.getFirstName()));
        lastName.setText(String.format("last_name : %s", user.getLastName()));
        age.setText(String.format(Locale.getDefault(),"age : %d", user.getAge()));
    }

    private class Request extends AsyncTask<Void,Void,User>{
        @Override
        protected User doInBackground(Void... voids) {
            if(userDao.count()==0){
                User user = new User("Omar", "Aflak", 19);
                userDao.insert(user);
                return userDao.all().get(0);
            }
            else{
                return userDao.all().get(0);
            }
        }

        @Override
        protected void onPostExecute(User user) {
            displayUser(user);
        }
    }
}
