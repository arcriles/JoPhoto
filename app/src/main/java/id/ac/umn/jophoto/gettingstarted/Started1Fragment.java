package id.ac.umn.jophoto.gettingstarted;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import id.ac.umn.jophoto.R;
import id.ac.umn.jophoto.databinding.FragmentStarted1Binding;

public class Started1Fragment extends Fragment {

    FragmentStarted1Binding bind;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bind = FragmentStarted1Binding.inflate(inflater, container, false);

        ViewPager2 viewPager = requireActivity().findViewById(R.id.started_view_pager);
        bind.btnStartedNext1.setOnClickListener( v -> {
            viewPager.setCurrentItem(1, true);
        });

        return bind.getRoot();
    }
}