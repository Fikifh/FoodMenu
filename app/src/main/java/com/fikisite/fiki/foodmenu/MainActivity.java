package com.fikisite.fiki.foodmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Foods>list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(FoodsData.getListData());
        showRecyclerList();
    }
    public void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListFoodsAdapter listFoodsAdapter = new ListFoodsAdapter(this, R.layout.activity_detail_menu);
        listFoodsAdapter.setListFoods(list);
        rvCategory.setAdapter(listFoodsAdapter);
    }
}
