package com.example.recordjournal.fragment_record;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.recordjournal.R;

/**
 * @author hello word
 * @desc 作用描述
 * @date 2021/9/7
 */
public class BaseRecordFragment extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_outcome,container,false);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
