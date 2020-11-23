package com.example.tastybits.ui.questionhub;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.tastybits.R;

public class QuestionHubFragment extends Fragment {

    //private com.example.tastybits.ui.questionhub.QuestionHubViewModel questionHubViewModel;
    //private OnFragmentInteractionListener mListener;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //questionHubViewModel = ViewModelProviders.of(this).get(com.example.tastybits.ui.questionhub.QuestionHubViewModel.class);
        View view = inflater.inflate(R.layout.fragment_questionhub, container, false);
        /*final TextView textView = root.findViewById(R.id.questionhub);
        questionHubViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        ImageView classplan = view.findViewById(R.id.classplanning);
        classplan.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.questionhub_ask));

        ImageView enrollment = view.findViewById(R.id.enrollment);
        enrollment.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.questionhub_post));
        return view;
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/
}