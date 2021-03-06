package com.android.homework.timemanagement.ui;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.android.homework.timemanagement.R;
import com.android.homework.timemanagement.ui.calendar.CalendarActivity;
import com.android.homework.timemanagement.ui.details.TodoDetailsActivity;
import com.android.homework.timemanagement.ui.main.MainActivity;
import com.google.android.material.navigation.NavigationView;

public class NavigationSupportedActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_supported2);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_closed);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.calendar:
                        openActivityAndCloseDrawer(CalendarActivity.class);
                        break;
                    case R.id.addNewTodo:
                        openActivityAndCloseDrawer(TodoDetailsActivity.class);
                        break;
                    case R.id.todoList:
                        openActivityAndCloseDrawer(MainActivity.class);
                        break;

                }
                return false;
            }
        });

    }

    private void openActivityAndCloseDrawer(Class c)
    {
        Intent intent = new Intent(getApplicationContext(), c);
        startActivity(intent);
        drawerLayout.closeDrawers();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();
    }
}
