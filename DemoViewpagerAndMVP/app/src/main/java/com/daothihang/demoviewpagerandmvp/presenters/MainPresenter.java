package com.daothihang.demoviewpagerandmvp.presenters;

import android.util.Log;
import android.view.View;

import com.daothihang.demoviewpagerandmvp.models.DataUser;
import com.daothihang.demoviewpagerandmvp.models.LoadData;
import com.daothihang.demoviewpagerandmvp.models.Users;
import com.daothihang.demoviewpagerandmvp.view.MainView;

import java.util.List;

public class MainPresenter implements LoadData {

    private MainView mainView;
    private DataUser dta;

    public MainPresenter(MainView mainView){
        this.mainView = mainView;
        dta = new DataUser(this);
    }
    public void showList(){
        dta.loadUser();

    }
    public void showList1(){
        dta.loadUser1();

    }
    public void showList2(){
        dta.loadUser2();

    }
    @Override
    public void loadData(List<Users> usersList) {
        mainView.hienThi(usersList);

    }
}
