package com.mamahome360.mamaaps.view;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mamahome360.mamaaps.R;
public class ViewTrainingVideosFragment extends Fragment {
    View trainingView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        trainingView = inflater.inflate(R.layout.trainingvideos_fragment,container,false);
        return  trainingView;
    }
}
