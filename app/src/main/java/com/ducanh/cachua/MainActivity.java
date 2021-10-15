package com.ducanh.cachua;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ducanh.Options.FileUp;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hanks.htextview.rainbow.RainbowTextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity  {
    private BottomNavigationView mNavigationView;
    private ViewPager2 mViewpager;
    RainbowTextView rainbowTextView;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance ("https://ca-chua-it-default-rtdb.firebaseio.com/").getReference ();
    private TextView titleToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar);
        Init ();
        setupViewpager ();
        rainbowTextView.setColorSpeed (40);
        rainbowTextView.setColors (Color.RED,Color.YELLOW);
        mNavigationView.setOnNavigationItemSelectedListener (new BottomNavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId ()){
                    case R.id.actiom_dowload:
                        titleToolbar.setText ("Download");
                        mViewpager.setCurrentItem (0);
                        break;
                    case R.id.actiom_upload:
                        titleToolbar.setText ("Upload");
                        mViewpager.setCurrentItem (1);
                        break;
                    case R.id.action_profile:
                        titleToolbar.setText ("Profile");
                        mViewpager.setCurrentItem (2);
                        break;
                }
                return true;
            }
        });
    }
    private void setupViewpager(){
      ViewpagerAdapter viewpagerAdapter =  new ViewpagerAdapter (getSupportFragmentManager (),getLifecycle ());
      mViewpager.setAdapter (viewpagerAdapter);
      mViewpager.registerOnPageChangeCallback (new ViewPager2.OnPageChangeCallback () {
          @Override
          public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
              super.onPageScrolled (position, positionOffset, positionOffsetPixels);
          }

          @Override
          public void onPageSelected(int position) {
              super.onPageSelected (position);
              switch (position){
                  case 0:
                      titleToolbar.setText ("Download");
                      mNavigationView.getMenu ().findItem (R.id.actiom_dowload).setChecked (true);
                        break;
                  case 1:
                      titleToolbar.setText ("Upload");
                      mNavigationView.getMenu ().findItem (R.id.actiom_upload).setChecked (true);
                      break;
                  case 2:
                      titleToolbar.setText ("Profile");
                      mNavigationView.getMenu ().findItem (R.id.action_profile).setChecked (true);
                      break;
              }
          }

          @Override
          public void onPageScrollStateChanged(int state) {
              super.onPageScrollStateChanged (state);
          }
      });
    }
    private void Init(){
        rainbowTextView = getSupportActionBar ().getCustomView ().findViewById (R.id.tvTitle);
        titleToolbar = getSupportActionBar ().getCustomView ().findViewById (R.id.tvTitle);
        mViewpager = findViewById (R.id.viewpager);
        mNavigationView = findViewById (R.id.bottom_nav);
    }
}
