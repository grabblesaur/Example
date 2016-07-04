package com.qqq.basic;

import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager;

public class MinimalDraggableExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minimal_draggable_example);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.minimal_recyclerview);

        // Setup D&D feature and RecyclerView
        RecyclerViewDragDropManager dragDropManager = new RecyclerViewDragDropManager();

        dragDropManager.setInitiateOnMove(false);
        dragDropManager.setInitiateOnLongPress(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dragDropManager.createWrappedAdapter(new MyAdapter()));

        dragDropManager.setDraggingItemShadowDrawable(
                (NinePatchDrawable) ContextCompat.getDrawable(this, R.drawable.item_shadow));
        dragDropManager.attachRecyclerView(recyclerView);

        Snackbar snackbar = Snackbar.make(findViewById(R.id.container),
                "TIP: Long press item to initiate Drag & Drop action!",
                Snackbar.LENGTH_INDEFINITE);
        snackbar.setDuration(8000); // 8 seconds
        snackbar.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // TODO: saving information in DB
    }
}
