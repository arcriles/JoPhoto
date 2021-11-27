package id.ac.umn.jophoto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import id.ac.umn.jophoto.HomeSegment.HomePublicFragment;
import id.ac.umn.jophoto.HomeSegment.HomeUserFragment;
import id.ac.umn.jophoto.HomeSegment.HomeViewPagerAdapter;
import id.ac.umn.jophoto.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding bind;
    private ArrayList<Fragment> fragmentList;

    private final String[] headerSegment = new String[]{"Public", "Private"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        fragmentList = new ArrayList<>();
        fragmentList.add(new HomePublicFragment());
        fragmentList.add(new HomeUserFragment());

        HomeViewPagerAdapter viewPagerAdapter = new HomeViewPagerAdapter(fragmentList, getSupportFragmentManager(), getLifecycle());

        bind.viewPagerHome.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(bind.tabLayoutHome, bind.viewPagerHome, (tab, position) -> {
            tab.setText(headerSegment[position]);
        }).attach();
    }
}
