package com.tchenssitech.jtchenjiny.tchenstagram;

import static android.view.View.VISIBLE;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.MediaRouteButton;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.tchenssitech.jtchenjiny.tchenstagram.Fragment.ComposeFragment;
import com.tchenssitech.jtchenjiny.tchenstagram.Fragment.FeedFragment;
import com.tchenssitech.jtchenjiny.tchenstagram.Fragment.MyProfileFragment;
import com.tchenssitech.jtchenjiny.tchenstagram.Models.Post;

import java.io.File;
import java.util.List;

    public class MainActivity extends AppCompatActivity {

        public static final String TAG = "MainActivity";
        final FragmentManager fragmentManager = getSupportFragmentManager();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);


        /*ibHome = findViewById(R.id.ibHome);
        ibProfile = findViewById(R.id.ibProfile);*/



       /* ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"Navigating to FeedActivity");
                startActivity(new Intent(MainActivity.this,FeedActivity.class));
            }
        });
        ibProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Sorry, this option is not yet fully implemented", Toast.LENGTH_SHORT).show();
                Log.i(TAG,"Navigating to User");
                startActivity(new Intent(MainActivity.this,User.class));            }
        });
        */
            bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragment = new Fragment();
                    switch (item.getItemId()) {
                        case R.id.action_home:
                            Toast.makeText(MainActivity.this, "Feed", Toast.LENGTH_SHORT).show();
                            fragment = new FeedFragment();
                            break;

                        case R.id.action_compose:
                            // Something Happens
                            Toast.makeText(MainActivity.this, "Compose", Toast.LENGTH_SHORT).show();
                            fragment = new ComposeFragment();
                            break;


                        case R.id.action_profile:
                            Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                            fragment = new MyProfileFragment();
                            break;
                    }
                    fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                    return true;
                }
            });

            //Set default Selection
            bottomNavigationView.setSelectedItemId(R.id.action_home);

        }

    }