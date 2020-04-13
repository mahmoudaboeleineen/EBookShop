package com.maboe.ebookshop;

import android.os.Bundle;

import com.maboe.ebookshop.databinding.ActivityMainBinding;
import com.maboe.ebookshop.model.Book;
import com.maboe.ebookshop.model.Category;
import com.maboe.ebookshop.viewmodel.MainActivityViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;
    private ArrayList<Category> categoriesList;
    private MainActivityClickHandlers handlers;
    private Category selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handlers = new MainActivityClickHandlers();
        activityMainBinding.setClickHandlers(handlers);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getGetAllCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {

                categoriesList = (ArrayList<Category>) categories;
                for (Category c : categories) {
                    Log.i("MyTAG", c.getCategoryName());
                    Toast.makeText(MainActivity.this, "HI", Toast.LENGTH_SHORT).show();

                }

                showOnSpinner();
            }
        });

        mainActivityViewModel.getGetAllBooksOfSelectedCategory(0).observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {

                for (Book b : books) {
                    Log.i("MY TAG", b.getBookName());
                    Toast.makeText(getApplicationContext(), "HI", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void showOnSpinner() {
        ArrayAdapter<Category> categoryArrayAdapter =
                new ArrayAdapter<Category>(this, R.layout.spinner_items, categoriesList);
        categoryArrayAdapter.setDropDownViewResource(R.layout.spinner_items);
        activityMainBinding.setSpinnerAdapter(categoryArrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class MainActivityClickHandlers {
        public void onFabClicked(View view) {
            Toast.makeText(getApplicationContext(), "FAB Clicked", Toast.LENGTH_SHORT).show();
        }

        public void onSelectItem(AdapterView<?> parent, View view, int pos, long id) {

            selectedCategory = (Category) parent.getItemAtPosition(pos);

            String message = " id is " + selectedCategory.getId()
                    + "\n name is "
                    + selectedCategory.getCategoryName() + "\n email is "
                    + selectedCategory.getCategoryDescription();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), message, Toast.LENGTH_LONG).show();


        }
    }
}
