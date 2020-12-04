package com.example.tastybits.ui.onboarding;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class OnboardingPagerAdapter extends FragmentStateAdapter {

    public OnboardingPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        //render one of the 4 fragments needed for onboarding from the position

        //have the login/register fragment short circuit the onboarding process and finish early
        switch (position) {
            case 0:
                return new OnBoardFragment1();
            case 1:
                return new OnBoardFragment2();
            case 2:
                return new OnBoardFragment3();
            case 3:
                return new OnBoardFragment4();
            default:
                return new OnBoardFragment1();
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
