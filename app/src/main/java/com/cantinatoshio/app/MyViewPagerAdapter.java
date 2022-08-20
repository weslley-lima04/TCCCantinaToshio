package com.cantinatoshio.app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyViewPagerAdapter extends FragmentStateAdapter
{
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity)
    {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position)
    {
        switch (position){
            case 0:
                return new Doces_Home_Fragment();
            case 1:
                return new Bebidas_Home_Fragment();
            case 2:
                return new Salgados_Home_Fragment();
            case 3:
                return new Outros_Home_Fragment();
            default:
                return new Doces_Home_Fragment();
        }
    }

    @Override
    public int getItemCount()
    {
        return 4;
    }
}