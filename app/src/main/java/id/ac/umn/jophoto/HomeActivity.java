package id.ac.umn.jophoto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import id.ac.umn.jophoto.HomeSegment.HomePublicFragment;
import id.ac.umn.jophoto.HomeSegment.HomeUserFragment;
import id.ac.umn.jophoto.HomeSegment.HomeViewPagerAdapter;
import id.ac.umn.jophoto.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding bind;

    private final String[] headerSegment = new String[]{"Public", "Private"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

//        setSupportActionBar(findViewById(R.id.include_home_toolbar));
//        ActionBar actionBar = getSupportActionBar();
//        assert actionBar != null;
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        bind.includeHomeToolbar.setNavigationOnClickListener(view -> bind.homeDrawerLayout.openDrawer(GravityCompat.START));

        bind.includeHomeToolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.item_home_add_photo){
                Log.d("Home", "Add Photo");
            }
            return false;
        });

        bind.homeNavigationView.setNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.drawer_menu_profile) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                startActivity(intent);
                Log.d("heroism", "PROFILE");
            }
            if (item.getItemId() == R.id.drawer_menu_credits) {
                Intent intent = new Intent(getApplicationContext(), CreditsActivity.class);
                startActivity(intent);
                Log.d("heroism", "CREDITS");
            }

            bind.homeDrawerLayout.closeDrawers();
            return true;
        });

        ArrayList<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomePublicFragment());
        fragmentList.add(new HomeUserFragment());

        HomeViewPagerAdapter viewPagerAdapter = new HomeViewPagerAdapter(fragmentList, getSupportFragmentManager(), getLifecycle());

        bind.viewPagerHome.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(bind.tabLayoutHome, bind.viewPagerHome, (tab, position) -> tab.setText(headerSegment[position])).attach();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            bind.homeDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}
