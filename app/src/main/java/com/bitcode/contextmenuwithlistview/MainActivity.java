package com.bitcode.contextmenuwithlistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView foodItemsListView;
    Resources resources;
    String [] foodItems;
    ArrayAdapter<String> stringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initResources();
        stringArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                foodItems);
        foodItemsListView.setAdapter(stringArrayAdapter);
        registerForContextMenu(foodItemsListView);
    }

    private void initViews(){
        foodItemsListView = findViewById(R.id.foodItemsListView);
    }

    private void initResources(){
        resources = getResources();
        foodItems = resources.getStringArray(R.array.foodItems);

        //resources.getString(R.string.comments);
        //resources.getInteger(R.integer.Five);
        //int [] numbers = resources.getIntArray(R.array.numbers);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("Context Menu");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.addToCart:
                makeToast("Add To Cart");
                break;
            case R.id.like:
                makeToast("Like");
                break;
            case R.id.dislike:
                makeToast("Dislike");
                break;
            case R.id.comments:
                makeToast("Comments");
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void makeToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}