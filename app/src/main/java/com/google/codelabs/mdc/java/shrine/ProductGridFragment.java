package com.google.codelabs.mdc.java.shrine;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.android.material.button.MaterialButton;
import com.google.codelabs.mdc.java.shrine.network.ProductEntry;
import com.google.codelabs.mdc.java.shrine.staggeredgridlayout.StaggeredProductCardRecyclerViewAdapter;

public class ProductGridFragment extends Fragment {

    MaterialButton backdrop_button_5,backdrop_button_4,backdrop_button_3,backdrop_button_2,
            backdrop_button_1,backdrop_button_6;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment with the ProductGrid theme
        View view = inflater.inflate(R.layout.shr_product_grid_fragment, container, false);

        // Set up the toolbar
        setUpToolbar(view);

        // Set up the RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 4, GridLayoutManager.VERTICAL, false);
        /*gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 5;
            }
        });*/
        recyclerView.setLayoutManager(gridLayoutManager);
        ProductCardRecyclerViewAdapter adapter = new ProductCardRecyclerViewAdapter(
                ProductEntry.initProductEntryList(getResources()));
        recyclerView.setAdapter(adapter);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small);
        recyclerView.addItemDecoration(new ProductGridItemDecoration(largePadding, smallPadding));

        backdrop_button_1 = view.findViewById(R.id.backdrop_button_1);
        backdrop_button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Yo", Toast.LENGTH_SHORT).show();
                ((NavigationHost) getActivity()).navigateTo(new mycartFragment(), false);
            }
        });

        backdrop_button_2 = view.findViewById(R.id.backdrop_button_2);
        backdrop_button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Yo", Toast.LENGTH_SHORT).show();
                ((NavigationHost) getActivity()).navigateTo(new notificationsfragment(), false);
            }
        });

        backdrop_button_3 = view.findViewById(R.id.backdrop_button_3);
        backdrop_button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Yo", Toast.LENGTH_SHORT).show();
                ((NavigationHost) getActivity()).navigateTo(new offerzonefragment(), false);
            }
        });

        backdrop_button_4 = view.findViewById(R.id.backdrop_button_4);
        backdrop_button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Yo", Toast.LENGTH_SHORT).show();
                ((NavigationHost) getActivity()).navigateTo(new PurchaseHistoryFragment(), false);
            }
        });

        backdrop_button_5 = view.findViewById(R.id.backdrop_button_5);
        backdrop_button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Yo", Toast.LENGTH_SHORT).show();
                ((NavigationHost) getActivity()).navigateTo(new FAQFragment(), false);
            }
        });

        backdrop_button_6 = view.findViewById(R.id.backdrop_button_6);
        backdrop_button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Yo", Toast.LENGTH_SHORT).show();
                ((NavigationHost) getActivity()).navigateTo(new MyAccountFragment(), false);
            }
        });

        return view;
    }


    private void setUpToolbar(View view) {
        Toolbar toolbar = view.findViewById(R.id.app_bar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }
        toolbar.setNavigationOnClickListener(new NavigationIconClickListener(
                getContext(),
                view.findViewById(R.id.product_grid),
                new AccelerateDecelerateInterpolator(),
                getContext().getResources().getDrawable(R.drawable.shr_branded_menu), // Menu open icon
                getContext().getResources().getDrawable(R.drawable.shr_close_menu))); // Menu close icon

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.shr_toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }

}