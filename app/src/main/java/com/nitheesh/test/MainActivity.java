package com.nitheesh.test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.nitheesh.test.Model.Entity;

/**
 * Created by 08468 on 5/24/2016.
 */
public class MainActivity extends FragmentActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_main);

        final EntityListFragment entityListFragment = new EntityListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.details_list_view, entityListFragment).commit();
        entityListFragment.setOnItemClick(new EntityListFragment.EnityItemClick() {
            @Override
            public void onEnityItemClick(Entity entity) {
                entityListFragment.enableView(false);
                ContentFragment contentFragment = new ContentFragment();
                contentFragment.setOnDestroyListener(new ContentFragment.OnDestroyListener() {
                    @Override
                    public void onDestroy() {
                        entityListFragment.enableView(true);
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putSerializable("BUNDLE", entity);
                contentFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.details_list_view, contentFragment).addToBackStack("null").commit();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}
