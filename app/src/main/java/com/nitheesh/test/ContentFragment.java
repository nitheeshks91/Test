package com.nitheesh.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import com.nitheesh.test.Model.Entity;

/**
 * Created by 08468 on 5/24/2016.
 */
public class ContentFragment extends Fragment {

    private View view;
    private OnDestroyListener onDestroyListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = inflater.inflate(R.layout.content_layout, container, false);
        TextView viewById = (TextView) this.view.findViewById(R.id.descirption);
        TextView gender = (TextView) this.view.findViewById(R.id.gender);
        NetworkImageView networkImageView = (NetworkImageView) this.view.findViewById(R.id.image);
        if (getArguments() != null) {
            Entity bundle = (Entity) getArguments().getSerializable("BUNDLE");
            viewById.setText(bundle.getDescritpion());
            gender.setText(bundle.getGender());
            ImageLoader mImageLoader = CustomImageLoader.getInstance(getActivity())
                    .getImageLoader();
            //Image URL - This can point to any image file supported by Android
            final String url = bundle.getThumbnail();
            mImageLoader.get(url, ImageLoader.getImageListener(networkImageView,
                    0, android.R.drawable
                            .ic_dialog_alert));
            networkImageView.setImageUrl(url, mImageLoader);
        }
        return this.view;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (this.onDestroyListener != null) {
            this.onDestroyListener.onDestroy();
        }
    }

    public void setOnDestroyListener(OnDestroyListener onDestroyListener) {
        this.onDestroyListener = onDestroyListener;

    }

    public interface OnDestroyListener {
        void onDestroy();
    }
}
