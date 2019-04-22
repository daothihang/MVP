package com.daothihang.demoviewpagerandmvp.view.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daothihang.demoviewpagerandmvp.R;
import com.daothihang.demoviewpagerandmvp.adapters.AdapterRecyclerView;
import com.daothihang.demoviewpagerandmvp.models.Users;
import com.daothihang.demoviewpagerandmvp.presenters.MainPresenter;
import com.daothihang.demoviewpagerandmvp.view.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentRecyclerView extends Fragment implements MainView {
    private AdapterRecyclerView adapterRecyclerView;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private MainPresenter mainPresenter;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        unbinder = ButterKnife.bind(this,view);
        init();
        return view;
    }

    public void init(){
        mainPresenter = new MainPresenter(this);
        mainPresenter.showList();
    }

    @Override
    public void hienThi(List<Users> usersList) {
        adapterRecyclerView = new AdapterRecyclerView(usersList, R.layout.item_main);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapterRecyclerView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
