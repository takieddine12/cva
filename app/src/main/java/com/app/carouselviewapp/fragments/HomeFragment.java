package com.app.carouselviewapp.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.DisplayMetrics;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.app.carouselviewapp.Extras;
import com.app.carouselviewapp.R;
import com.app.carouselviewapp.adapters.AutoScrollAdapter;
import com.app.carouselviewapp.adapters.AutoScrollAdapter2;
import com.app.carouselviewapp.adapters.AutoScrollAdapter3;
import com.app.carouselviewapp.adapters.RecyclerItemClickListener;
import com.app.carouselviewapp.models.ScrollModel;
import java.util.ArrayList;
import java.util.Objects;


public class HomeFragment extends Fragment {
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;
    private ArrayList<ScrollModel> itemList1;
    private ArrayList<ScrollModel> itemList2;
    private ArrayList<ScrollModel> itemList3;
    private AutoScrollAdapter autoScrollAdapter1;
    private AutoScrollAdapter2 autoScrollAdapter2;
    private AutoScrollAdapter3 autoScrollAdapter3;
    int scrollCount1 = 0;
    int scrollCount2 = 0;
    int scrollCount3 = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_layout, container, false);
        recyclerView1 = view.findViewById(R.id.recyclerView1);
        recyclerView2 = view.findViewById(R.id.recyclerView2);
        recyclerView3 = view.findViewById(R.id.recyclerView3);
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).show();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initLists();
        setUpFirstRecyclerView();
        setUpSecondRecyclerView();
        setUpThirdRecyclerView();

    }

    // TODO :  CREATING 3 RECYCLERVIEW
    public void setUpFirstRecyclerView(){
        autoScrollAdapter1 = new AutoScrollAdapter(itemList1);
        recyclerView1.setAdapter(autoScrollAdapter1);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext()) {

            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(requireContext()) {
                    private static final float SPEED = 3500f;// Change this value (default=25f)

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }
                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }
        };
        autoScrollFirstRecycler();

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.setReverseLayout(true);
        recyclerView1.setLayoutManager(layoutManager);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setItemViewCacheSize(1000);
        recyclerView1.setDrawingCacheEnabled(true);
        recyclerView1.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView1.setAdapter(autoScrollAdapter1);
        recyclerView1.addOnItemTouchListener(new RecyclerItemClickListener(
                requireContext(), recyclerView1, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("url",itemList1.get(position).getUrl());
                NavHostController navHostController = (NavHostController) Navigation.findNavController(requireView());
                navHostController.navigate(R.id.action_homeFragment_to_webFragment,bundle);

            }

            @Override
            public void onLongItemClick(View view, int position) {
                Log.i("recyclerView ", "onLongItemClick " + position);
            }
        }));


    }
    public void setUpSecondRecyclerView(){
        autoScrollAdapter2 = new AutoScrollAdapter2(itemList2);
        recyclerView2.setAdapter(autoScrollAdapter2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext()) {

            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(requireContext()) {
                    private static final float SPEED = 3500f;// Change this value (default=25f)

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }
                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }
        };
        autoScrollSecondRecycler();

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setItemViewCacheSize(1000);
        recyclerView2.setDrawingCacheEnabled(true);
        recyclerView2.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView2.setAdapter(autoScrollAdapter2);
        recyclerView2.addOnItemTouchListener(new RecyclerItemClickListener(
                requireContext(), recyclerView2, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("url",itemList2.get(position).getUrl());
                Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_webFragment,bundle);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Log.i("recyclerView ", "onLongItemClick " + position);
            }
        }));

    }
    public void setUpThirdRecyclerView(){
        autoScrollAdapter3 = new AutoScrollAdapter3(itemList3);
        recyclerView3.setAdapter(autoScrollAdapter3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext()) {

            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(requireContext()) {
                    private static final float SPEED = 3500f;// Change this value (default=25f)

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }
                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }
        };
        autoScrollThirdRecycler();

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.setReverseLayout(true);
        recyclerView3.setLayoutManager(layoutManager);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setItemViewCacheSize(1000);
        recyclerView3.setDrawingCacheEnabled(true);
        recyclerView3.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView3.setAdapter(autoScrollAdapter3);
        recyclerView3.addOnItemTouchListener(new RecyclerItemClickListener(
                requireContext(), recyclerView3, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("url",itemList3.get(position).getUrl());
                Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_webFragment,bundle);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Log.i("recyclerView ", "onLongItemClick " + position);
            }
        }));

    }

    // TODO : CREATING 3 AUTOSCROLLER
    public void autoScrollFirstRecycler() {
        scrollCount1 = 0;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void run() {
                recyclerView1.smoothScrollToPosition((scrollCount1++));
                if (scrollCount1 == autoScrollAdapter1.getItemCount()) {
                    autoScrollAdapter1.addData(itemList1);
                    autoScrollAdapter1.notifyDataSetChanged();
                }
                handler.postDelayed(this, 700);
            }
        };
        handler.postDelayed(runnable, 700);
    }
    public void autoScrollSecondRecycler() {
        scrollCount2 = 0;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void run() {
                recyclerView2.smoothScrollToPosition((scrollCount2++));
                if (scrollCount2 == autoScrollAdapter2.getItemCount()) {
                    autoScrollAdapter2.addData(itemList2);
                    autoScrollAdapter2.notifyDataSetChanged();
                }
                handler.postDelayed(this, 500);
            }
        };
        handler.postDelayed(runnable, 500);
    }
    public void autoScrollThirdRecycler() {
        scrollCount3 = 0;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void run() {
                recyclerView3.smoothScrollToPosition((scrollCount3++));
                if (scrollCount3 == autoScrollAdapter3.getItemCount()) {
                    autoScrollAdapter3.addData(itemList3);
                    autoScrollAdapter3.notifyDataSetChanged();
                }
                handler.postDelayed(this, 900);
            }
        };
        handler.postDelayed(runnable, 900);
    }

   // INIT LISTS
    public void initLists(){
        //
        itemList1 = new ArrayList<>();
        itemList1.add(new ScrollModel( "https://store-images.s-microsoft.com/image/apps.28856.69802328231064156.03ff84cc-b6b1-4226-8e6c-545d183e5fbf.b6546b0b-9563-4129-b79e-15bb4282048a"));
        itemList1.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2020/10/Destiny-2-Shadowkeep-Expansion-–-Everything-You-Need-To-Know-600x338.jpg"));
        itemList1.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2020/07/Apex-Legends-450x253.jpg"));
        itemList1.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2020/09/Rainbow-Six-Siege-600x338.jpg"));
        itemList1.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2019/11/The-Witcher-3-Wild-Hunt-450x254.jpg"));
        itemList1.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2020/12/Anno-1800-600x271.jpg"));
        itemList1.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2019/12/Assassin’s-Creed-Odyssey-450x253.jpg"));
        itemList1.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2021/03/Hellish-Quart-600x338.jpg"));
        itemList1.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2019/12/Kingdom-Come-Deliverance-450x253.jpg"));
        itemList1.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2020/05/cyberpunk-2077-450x224.jpg"));


        ///
        itemList2 = new ArrayList<>();
        itemList2.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2019/12/Shadow-of-the-Tomb-Raider-1-450x258.jpg"));
        itemList2.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2019/08/no-mans-sky-beyond-release-date-450x253.jpg"));
        itemList2.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2018/09/metro-exodus-release-date-450x253.jpg"));
        itemList2.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2020/02/Ultrakill-450x210.jpg"));
        itemList2.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2021/03/Control-Ultimate-Edition-600x338.jpg"));
        itemList2.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2023/03/Devil-May-Cry-Games-In-Order.jpg"));
        itemList2.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2023/02/Spyro-Games-In-Order.jpg"));
        itemList2.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2023/02/best-4X-games-on-PC-conquest-of-eo.jpg"));
        itemList2.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2022/11/street-fighter-6-fighting-game-1536x864.jpg"));
        itemList2.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2023/02/best-games-like-the-last-of-us.jpg"));


        ///
        itemList3 = new ArrayList<>();
        itemList3.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2023/02/best-marvel-games-marvel-snap.jpg"));
        itemList3.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2023/03/Sword-Art-Online-Games-In-Order.jpg"));
        itemList3.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2023/03/Best-Games-Like-Arma-Reforger.jpg"));
        itemList3.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2023/03/Castlevania-Games-In-Order.jpg"));
        itemList3.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2023/03/Marvel-Ultimate-Alliance-Games-In-Order.jpg"));
        itemList3.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2023/03/Best-Resident-Evil-2-Remake-Mods.jpg"));
        itemList3.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2022/02/Best-Games-Like-Clash-Of-Clans.jpg"));
        itemList3.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2022/02/Best-Games-Like-Elden-Ring.jpg"));
        itemList3.add(new ScrollModel(  "https://www.gamingscan.com/wp-content/uploads/2023/03/best-nintendo-exclusives-fire-emblem-engage.jpg"));
        itemList3.add(new ScrollModel( "https://www.gamingscan.com/wp-content/uploads/2022/02/Best-Games-Like-Guardians-Of-The-Galaxy.jpg"));


    }
}
