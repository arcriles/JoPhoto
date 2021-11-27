package id.ac.umn.jophoto.gettingstarted;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import id.ac.umn.jophoto.databinding.FragmentStartedViewPagerBinding;

public class StartedViewPagerFragment extends Fragment {

    FragmentStartedViewPagerBinding bind;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bind = FragmentStartedViewPagerBinding.inflate(getLayoutInflater(), container, false);
        // Inflate the layout for this fragment
//        View view =  inflater.inflate(R.layout.fragment_view_pager, container, false);

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new Started1Fragment());
        fragmentArrayList.add(new Started2Fragment());

        StartedViewPagerAdapter viewPagerAdapter =
                new StartedViewPagerAdapter(
                        fragmentArrayList,
                        requireActivity().getSupportFragmentManager(),
                        getLifecycle());

        bind.startedViewPager.setAdapter(viewPagerAdapter);

        return bind.getRoot();

    }
}