package com.example.jucseroutinery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.Toast;

public class WholeRoutine extends AppCompatActivity implements HorizontalScroll.ScrollViewListener, VerticalScroll.ScrollViewListener{
    RelativeLayout relativeLayoutMain, relativeLayoutA, relativeLayoutB, relativeLayoutC, relativeLayoutD, relativeLayoutSub;


    TableLayout tableLayoutA, tableLayoutB, tableLayoutC, tableLayoutD;
    HorizontalScroll horizontalScrollViewB,horizontalScrollViewD;
    VerticalScroll scrollViewC,scrollViewD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whole_routine);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Entire Batch Routine");


        relativeLayoutMain = (RelativeLayout) findViewById(R.id.rLMain);
        relativeLayoutSub = (RelativeLayout) findViewById(R.id.rL1);
        relativeLayoutA = (RelativeLayout) findViewById(R.id.rL2);
        relativeLayoutB = (RelativeLayout) findViewById(R.id.rL3);
        relativeLayoutC = (RelativeLayout) findViewById(R.id.rL4);
        relativeLayoutD = (RelativeLayout) findViewById(R.id.rL5);

        horizontalScrollViewB = (HorizontalScroll) findViewById(R.id.horizontalView1);
        horizontalScrollViewD = (HorizontalScroll) findViewById(R.id.horizontalView2);
        scrollViewC = (VerticalScroll) findViewById(R.id.scrollView1);
        scrollViewD = (VerticalScroll) findViewById(R.id.scrollView2);

        tableLayoutA = (TableLayout) findViewById(R.id.tL1);
        tableLayoutB = (TableLayout) findViewById(R.id.tL2);
        tableLayoutC = (TableLayout) findViewById(R.id.tL3);
        tableLayoutD = (TableLayout) findViewById(R.id.tL4);



        horizontalScrollViewB.setScrollViewListener(this);
        horizontalScrollViewD.setScrollViewListener(this);
        scrollViewC.setScrollViewListener(this);
        scrollViewD.setScrollViewListener(this);
    }

    @Override
    public void onScrollChanged(HorizontalScroll scrollView, int x, int y, int oldx, int oldy) {
        if (scrollView == horizontalScrollViewB) {
            horizontalScrollViewD.scrollTo(x, y);
        } else if (scrollView == horizontalScrollViewD) {
            horizontalScrollViewB.scrollTo(x, y);
        }

    }

    @Override
    public void onScrollChanged(VerticalScroll scrollView, int x, int y, int oldx, int oldy) {
        if (scrollView == scrollViewC) {
            scrollViewD.scrollTo(x, y);
        } else if (scrollView == scrollViewD) {
            scrollViewC.scrollTo(x, y);
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId= item.getItemId();
        if (itemId==android.R.id.home){
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}