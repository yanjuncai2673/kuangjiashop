package com.example.shops.ui.mainTitle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.shops.R;
import com.example.shops.base.BaseFragment;
import com.example.shops.interfaces.IBasePersenter;

public class MainTitleFragment extends Fragment {
    private MainTitleViewModel mainTitleViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mainTitleViewModel =
                ViewModelProviders.of(this).get(MainTitleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_maintitle, container, false);
        final TextView textView = root.findViewById(R.id.text_mainTitle);
        mainTitleViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }


}