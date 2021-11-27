package id.ac.umn.jophoto.GettingStarted;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class StartedViewPagerAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> list;

    public StartedViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public StartedViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public StartedViewPagerAdapter(ArrayList<Fragment> list, @NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return this.list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
