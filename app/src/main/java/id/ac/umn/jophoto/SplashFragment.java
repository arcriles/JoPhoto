package id.ac.umn.jophoto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.ac.umn.jophoto.databinding.FragmentSplashBinding;

public class SplashFragment extends Fragment {

    public static final String GETTING_STARTED_SHARED = "gettingStarted";
    public static final String GETTING_STARTED_STATUS = "isFinished";

    FragmentSplashBinding bind;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        bind = FragmentSplashBinding.inflate(inflater, container, false);

        final Handler handler = new Handler();
        Runnable r;
        Intent intent = new Intent(getActivity(), TestingActivity.class);
        startActivity(intent);
        finish();
//        if (checkGettingStartedStatus()) {
//            r = () -> {
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                requireActivity().startActivity(intent);
////                Navigation.findNavController(bind.getRoot()).navigate(R.id.action_splashFragment_to_homeActivity);
//            };
//        } else {
//            r = () -> Navigation.findNavController(bind.getRoot()).navigate(R.id.action_splashFragment_to_startedViewPagerFragment);
//        }

//        handler.postDelayed(r, 1500);


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Navigation.findNavController(this, R.id.main_nav);
//            }
//        }, 3000);

        // Inflate the layout for this fragment
        return bind.getRoot();
    }

    private void finish() {
    }

    private boolean checkGettingStartedStatus() {
        SharedPreferences sharedPref = requireActivity().getSharedPreferences(GETTING_STARTED_SHARED, Context.MODE_PRIVATE);
        return sharedPref.getBoolean(GETTING_STARTED_STATUS, false);
    }
}

