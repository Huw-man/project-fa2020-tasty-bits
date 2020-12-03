package com.example.tastybits;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{


    public static final String EXTRA_CLEAR_CREDENTIALS = "com.auth0.CLEAR_CREDENTIALS";
    public static final String EXTRA_ACCESS_TOKEN = "com.auth0.ACCESS_TOKEN";
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginManager.init(new LoginManager(this));

        //only after logged in execute the rest
        LoginManager.getInstance().login(new LoginManager.LoginCallback() {
            @Override
            public void onCompleted(String accessToken) {
                runOnUiThread(() -> {

                        NetworkRequest.init(new NetworkRequest(accessToken));

                        // load the categories, and only then setup the fragments since they're dependent on categories
                        NetworkRequest.getInstance().queryCategories(new AsyncCallback() {
                            @Override
                            public void onCompleted(Object result) {

                                runOnUiThread(() -> {
                                    BottomNavigationView navView = findViewById(R.id.nav_view);
                                    // Passing each menu ID as a set of Ids because each
                                    // menu should be considered as top level destinations.
                                    AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                                            R.id.homescreen, R.id.infohub, R.id.questionhub)
                                            .build();
                                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
                                    NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, appBarConfiguration);
                                    NavigationUI.setupWithNavController(navView, navController);
                                });
                            }

                            @Override
                            public void onException(Exception e) {

                            }
                        });

                        Log.i(TAG, "access token: " + accessToken);
                        Toast.makeText(MainActivity.this, "Successfully logged in with accessToken: " + accessToken, Toast.LENGTH_SHORT).show();

                });
            }

            @Override
            public void onDialogException(Dialog dialog) {
                runOnUiThread(() -> {
                    dialog.show();
                });
            }

            @Override
            public void onException(Exception e) {
                runOnUiThread(() -> {
                    Toast.makeText(MainActivity.this, "Login Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });

    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }


}