package vinh.plk.vidu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.app.Notification;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import vinh.plk.vidu.fragment.ViewPagerAdapter;
import vinh.plk.vidu.slider.CustomViewPager;

public class Main1Activity extends AppCompatActivity {
    private BottomNavigationView NavigationView;
    private CustomViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        NavigationView  = findViewById(R.id.bottom_nav);
        viewPager    = findViewById(R.id.view_pager);
        viewPager.setPagingEnabled(false);
        setUpViewPager();
        
        NavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        viewPager.setCurrentItem(0);
                        break;

                    case R.id.bell:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.shoppingcart:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.settings:
                        viewPager.setCurrentItem(3);
                        break;

                }
                return false;
            }
        });

    }
    private void setUpViewPager(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);   ;
        viewPager.setAdapter(viewPagerAdapter);

    }
}