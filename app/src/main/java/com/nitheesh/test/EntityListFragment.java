package com.nitheesh.test;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nitheesh.test.Model.Entity;
import com.nitheesh.test.Model.Results;

/**
 * Created by 08468 on 5/24/2016.
 */
public class EntityListFragment extends Fragment {

    private View view;
    private RecyclerView recyclerView;
    private EnityItemClick itemClick;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.details_list_layout, container, false);
        recyclerView = (RecyclerView) this.view.findViewById(R.id.recycler_view);
        return this.view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isNetworkAvailable()) {
            requestForData();
        } else {
            Toast.makeText(getActivity(), "Please check the network connection", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void requestForData() {
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://randomapi.com/api/?key=LMW0-SW97-ISC4-FF25&id=t60ldyb&results=20";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Gson gson = new GsonBuilder().create();
                        Results results = gson.fromJson(response, Results.class);
                        EntityAdapter entityAdapter = new EntityAdapter(results.getEntities(), getActivity());
                        entityAdapter.setOnItemClick(new EntityAdapter.EnityItemClick() {
                            @Override
                            public void onEnityItemClick(Entity entity) {
                                if (itemClick != null) {
                                    itemClick.onEnityItemClick(entity);
                                }
                            }
                        });
                        recyclerView.setHasFixedSize(false);
                        LinearLayoutManager myLinearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
                        recyclerView.setLayoutManager(myLinearLayoutManager);
                        recyclerView.setAdapter(entityAdapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Service failure", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(stringRequest);
    }

    public void setOnItemClick(EnityItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public void enableView(boolean b) {
        this.view.setVisibility(b ? View.VISIBLE : View.GONE);
    }

    public interface EnityItemClick {
        void onEnityItemClick(Entity entity);
    }

}
