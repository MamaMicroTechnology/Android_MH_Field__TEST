package com.mamahome360.mamaaps.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mamahome360.mamaaps.R;

public class ViewLogisticFragment extends Fragment {
    View logisticView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     logisticView = inflater.inflate(R.layout.view_logistic_fragment,container,false);
     return logisticView;
    }
}
