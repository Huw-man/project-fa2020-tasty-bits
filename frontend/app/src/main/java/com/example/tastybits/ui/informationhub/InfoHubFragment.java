package com.example.tastybits.ui.informationhub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tastybits.R;

public class InfoHubFragment extends Fragment {

    private InfoHubViewModel infoHubViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        infoHubViewModel =
                ViewModelProviders.of(this).get(InfoHubViewModel.class);
        View root = inflater.inflate(R.layout.fragment_infohub, container, false);
        final TextView textView = root.findViewById(R.id.infohub);
        infoHubViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}