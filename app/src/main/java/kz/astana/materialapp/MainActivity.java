package kz.astana.materialapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import static kz.astana.materialapp.R.layout.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        DrawerLayout dl = findViewById(R.id.drawerLayout);
        NavigationView nv = findViewById(R.id.navigation);
        FrameLayout frameLayout = findViewById(R.id.container);
        LinearLayout foodLayout = findViewById(R.id.food_container);
        RelativeLayout drinkLayout = findViewById(R.id.drink_container);
        ConstraintLayout desertLayout = findViewById(R.id.desert_container);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dl.openDrawer(nv);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fab.hide();
            }
        });

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.first) {
                    toolbar.setTitle("Еда");
                    foodLayout.setVisibility(View.VISIBLE);
                    drinkLayout.setVisibility(View.GONE);
                    desertLayout.setVisibility(View.GONE);
                    fab.show();
                } else if (item.getItemId() == R.id.second) {
                    toolbar.setTitle("Напитки");
                    foodLayout.setVisibility(View.GONE);
                    drinkLayout.setVisibility(View.VISIBLE);
                    desertLayout.setVisibility(View.GONE);
                    fab.show();
                } else if (item.getItemId() == R.id.third) {
                    toolbar.setTitle("Десерты");
                    foodLayout.setVisibility(View.GONE);
                    drinkLayout.setVisibility(View.GONE);
                    desertLayout.setVisibility(View.VISIBLE);
                    fab.show();
                }
                dl.closeDrawers();
                return true;
            }
        });
    }

}