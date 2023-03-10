package com.app.carouselviewapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.Dialog;
import android.content.ClipData;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout fabLayout;
    private Button button1,button2,button3,button4;
    private FloatingActionButton fab;
    float x, y , dx, dy;
    private ImageView clearImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);
        fabLayout = findViewById(R.id.fabLayout);
        button1 = findViewById(R.id.imageButton1);
        button2 = findViewById(R.id.imageButton2);
        button3 = findViewById(R.id.imageButton3);
        button4 = findViewById(R.id.imageButton4);
        clearImg = findViewById(R.id.clearImg);
        Toolbar toolbar = findViewById(R.id.toolbar);
        fabLayout.setOnDragListener(new MyDragListener());
        setSupportActionBar(toolbar);
        fab.setTag("closed");


        /// CIRCLE MENU
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                fab.setTag("closed");
                fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.orangeColor)));
                fab.setImageResource(R.drawable.ic_baseline_open_with_24);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                fab.setTag("closed");
                fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.orangeColor)));
                fab.setImageResource(R.drawable.ic_baseline_open_with_24);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                fab.setTag("closed");
                fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.orangeColor)));
                fab.setImageResource(R.drawable.ic_baseline_open_with_24);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.GONE);
                button3.setVisibility(View.GONE);
                button4.setVisibility(View.GONE);
                fab.setTag("closed");
                fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.orangeColor)));
                fab.setImageResource(R.drawable.ic_baseline_open_with_24);
            }
        });

        showCircleMenu();
    }

    private void showDialog(){
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_view,null);
        TextView about = view.findViewById(R.id.about);
        TextView tutorial = view.findViewById(R.id.tutorial);
        SwitchCompat showHideFab = view.findViewById(R.id.showHideFab);

        showHideFab.setChecked(Extras.isFabToggled(MainActivity.this));

        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setView(view);

        Dialog dialog = builder.create();
        dialog.show();

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"About",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Tutorial",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        showHideFab.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"Fab Shown",Toast.LENGTH_SHORT).show();
                    Extras.saveState(MainActivity.this,true);
                    fabLayout.setVisibility(View.VISIBLE);
                    dialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this,"Fab Hidden",Toast.LENGTH_SHORT).show();
                    Extras.saveState(MainActivity.this,false);
                    fabLayout.setVisibility(View.GONE);
                    dialog.dismiss();
                }
            }
        });
    }
    private void showCircleMenu() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fab.getTag().equals("closed")){
                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.lightGrey)));
                    fab.setImageResource(R.drawable.ic_baseline_clear_24);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    button4.setVisibility(View.VISIBLE);
                    fab.setTag("open");
                } else if (fab.getTag().equals("open")){
                    fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.orangeColor)));
                    fab.setImageResource(R.drawable.ic_baseline_open_with_24);
                    button1.setVisibility(View.GONE);
                    button2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                    button4.setVisibility(View.GONE);
                    fab.setTag("closed");
                }
            }
        });
        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                    v.startDrag(data, shadowBuilder, v, 0);
                } else {
                    v.startDragAndDrop(data, shadowBuilder, v, 0);
                }
                return true;
            }
        });
    }
    private class MyDragListener implements View.OnDragListener {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (action) {
                case DragEvent.ACTION_DRAG_STARTED:
                    // Code to handle drag started
                    x = event.getX();
                    y = event.getY();
                    return true;
                case DragEvent.ACTION_DRAG_ENTERED:
                    // Code to handle drag entered
                    return true;
                case DragEvent.ACTION_DRAG_LOCATION:
                    clearImg.setVisibility(View.VISIBLE);
                    // Code to handle drag location
                    //Toast.makeText(MainActivity.this,"Drag LOCATION Called",Toast.LENGTH_SHORT).show();
                    dx = event.getX() - x;
                    dy = event.getY() - y;

                    fabLayout.setX(fabLayout.getX() + dx);
                    fabLayout.setY(fabLayout.getY() + dy);

//                    x = event.getX();
//                    y = event.getY();
                    return true;
                case DragEvent.ACTION_DRAG_EXITED:
                    // Code to handle drag exited
                    return true;
                case DragEvent.ACTION_DROP:
                    if(areViewsTouching()){
                        Extras.saveState(MainActivity.this,false);
                        fabLayout.setVisibility(View.GONE);
                        clearImg.setVisibility(View.GONE);
                    } else {
                        clearImg.setVisibility(View.GONE);
                    }
                    return true;
                case DragEvent.ACTION_DRAG_ENDED:
                    // Code to handle drag ended
                    clearImg.setVisibility(View.GONE);
                    return true;
                default:
                    return false;
            }
        }
    }
    private Boolean areViewsTouching(){
        int[] firstPosition = new int[2];
        int[] secondPosition = new int[2];
        fab.getLocationOnScreen(firstPosition);
        clearImg.getLocationOnScreen(secondPosition);
        // Rect constructor parameters: left, top, right, bottom
        Rect rectFirstView = new Rect(firstPosition[0], firstPosition[1],
                firstPosition[0] + fab.getMeasuredWidth(), firstPosition[1] + fab.getMeasuredHeight());
        Rect rectSecondView = new Rect(secondPosition[0], secondPosition[1],
                secondPosition[0] + clearImg.getMeasuredWidth(), secondPosition[1] + clearImg.getMeasuredHeight());
        return rectFirstView.intersect(rectSecondView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.settings){
            showDialog();
            return true;
        }
        return false;
    }


}







