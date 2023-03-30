package com.example.lab2_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner thumbnailSpinner;
    ThumbnailAdapter thumbnailAdapter;

    GridView gridView;
    DishAdapter dishAdapter;

    List<Dish> dishes = new ArrayList<>();

    EditText editTextName;
    CheckBox checkBoxPromotion;

    Button addDish;

    private Thumbnail[] thumbnails = new Thumbnail[] {Thumbnail.Thumbnail1, Thumbnail.Thumbnail2, Thumbnail.Thumbnail3, Thumbnail.Thumbnail4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thumbnailSpinner = findViewById(R.id.spinner_thumnail);
        thumbnailAdapter = new ThumbnailAdapter(this, R.layout.item_thumnail, R.layout.item_selected_thumbnail, thumbnails);

        thumbnailSpinner.setAdapter(thumbnailAdapter);

        gridView = findViewById(R.id.gv_dishes);
        dishAdapter = new DishAdapter(this, R.layout.gridview_item, dishes);
        gridView.setAdapter(dishAdapter);

        editTextName = (EditText) findViewById(R.id.et_name);
        checkBoxPromotion = (CheckBox) findViewById(R.id.ckb_is_promotion);

        addDish = findViewById(R.id.btn_add);

        addDish.setOnClickListener((view) -> {
            Dish dish = new Dish(editTextName.getText().toString(), thumbnails[thumbnailSpinner.getSelectedItemPosition()], checkBoxPromotion.isChecked());
            dishes.add(dish);
            dishAdapter.notifyDataSetChanged();
            editTextName.setText("");
            thumbnailSpinner.setSelection(0);
            checkBoxPromotion.setChecked(false);
            Toast.makeText(this, R.string.added_successful, Toast.LENGTH_SHORT).show();
//            View v = this.getCurrentFocus();
//            if (view != null) {
//                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//            }
        });
    }
}