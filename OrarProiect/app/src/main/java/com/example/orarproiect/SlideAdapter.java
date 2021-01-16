package com.example.orarproiect;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

class SlideAdapter extends FragmentPagerAdapter {
    private static final int NUM_PAGES = 5;

    private List<Ora> listLuni = new ArrayList<Ora>();
    private List<Ora> listMarti = new ArrayList<Ora>();
    private List<Ora> listMiercuri = new ArrayList<Ora>();
    private List<Ora> listJoi = new ArrayList<Ora>();
    private List<Ora> listVineri = new ArrayList<Ora>();



    SlideAdapter(FragmentManager fm) {
        super(fm);

        // Aici as fi vrut sa dau .execute() la Decoder

    }

    @Override
    public Fragment getItem(int position) { // Si sa dau .getList() din Decoder la fiecare case
        switch (position) {
            case 0:
                return new SlideFragment("Luni", listLuni);
            case 1:
                return new SlideFragment("Marti", listMarti);
            case 2:
                return new SlideFragment("Miercuri", listMiercuri);
            case 3:
                return new SlideFragment("Joi", listJoi);
            case 4:
                return new SlideFragment("Vineri", listVineri);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

    public void setList(List<Ora> list, int dayCounter) {
        switch (dayCounter) {
            case 1:
                listLuni = list;
                Log.d("LIST2", listLuni.toString());
                break;
            case 2:
                listMarti = list;
                break;
            case 3:
                listMiercuri = list;
                break;
            case 4:
                listJoi = list;
                break;
            case 5:
                listVineri = list;
                break;
            default:
                break;
        }
    }

   public static class SlideFragment extends Fragment {
        private String dayString;
        private List<Ora> recyclerList;

        public SlideFragment(String day, List<Ora> list) {
            dayString = day;
            recyclerList = list;
        }



       @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = (ViewGroup) inflater.inflate(
                    R.layout.fragment_screen_slide_page, container, false);

            TextView dayText = (TextView) view.findViewById(R.id.dayText);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_fragment);

            dayText.setText(dayString);

            RecyclerAdapter adapter = new RecyclerAdapter(recyclerList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            return view;
        }

    }
}