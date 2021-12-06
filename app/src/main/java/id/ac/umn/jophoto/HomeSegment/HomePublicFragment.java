package id.ac.umn.jophoto.HomeSegment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import id.ac.umn.jophoto.R;
import id.ac.umn.jophoto.databinding.FragmentHomePublicBinding;

public class HomePublicFragment extends Fragment {

    private FragmentHomePublicBinding bind;

    private final ArrayList<Integer> publicList = new ArrayList<>(Arrays.asList(
            R.drawable.fiction_one, R.drawable.fiction_two,
            R.drawable.fiction_three, R.drawable.fiction_four,
            R.drawable.fiction_five, R.drawable.fiction_six,
            R.drawable.fiction_seven, R.drawable.fiction_eight,
            R.drawable.fiction_nine, R.drawable.fiction_ten,

            R.drawable.children_one, R.drawable.children_two,
            R.drawable.children_three, R.drawable.children_four,
            R.drawable.children_five, R.drawable.children_six,
            R.drawable.children_seven, R.drawable.children_eight,
            R.drawable.children_nine, R.drawable.children_ten

//            R.drawable.fiction_one, R.drawable.fiction_two,
//            R.drawable.fiction_three, R.drawable.fiction_four,
//            R.drawable.fiction_five, R.drawable.fiction_six,
//            R.drawable.fiction_seven, R.drawable.fiction_eight,
//            R.drawable.fiction_nine, R.drawable.fiction_ten
    ));

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bind = FragmentHomePublicBinding.inflate(inflater, container, false);

        HomeImageViewAdapter adapter = new HomeImageViewAdapter(requireContext(), publicList);
        bind.rvHomePublic.setAdapter(adapter);
        bind.rvHomePublic.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
//        bind.rvHomePublic.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        // Inflate the layout for this fragment
        return bind.getRoot();
    }
}
