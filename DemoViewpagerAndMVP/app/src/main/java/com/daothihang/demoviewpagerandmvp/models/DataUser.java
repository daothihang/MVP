package com.daothihang.demoviewpagerandmvp.models;

import com.daothihang.demoviewpagerandmvp.presenters.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class DataUser  {
    private MainPresenter mainPresenter;
    private final static String[] name = {
            "Anh 1",
            "Anh 2",
            "Anh 3",
            "Anh 4",
            "Anh 5",
            "Anh 6"
    };

    private final static String[] images = {
            "https://thuypetpro.com.vn/wp-content/uploads/2017/07/co-nen-cat-duoi-meo-hay-khong.jpg",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTwX1K_xwtd2zTQDkhvfvfJWFTReq0oBRJ34T28gHLbHONHoc56",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYowmg98ODogXv9hbDOqMxte3et77M-_moRaIfo5DJpxpmZi5Y",
            "data:image/jpeg;base64,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",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpGHZskvlRkB9KlHFx3F2CxB4HIhQ8CCYCF5x5m4L_bnYkctfN",
            "https://ngathang.gov.vn/wp-content/uploads/imgup/upload/dat-ten-o-nha-cho-con-gai-nhung-cai-ten-de-134324.jpg"
    };
    public DataUser(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }


    public void loadUser() {
        List<Users> usersList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Users users1 = new Users(name[i], images[i]);
            usersList.add(users1);
        }
        mainPresenter.loadData(usersList);
    }
}