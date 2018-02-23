package com.example.abhishek.workingwithimages;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private final int TOTAL_IMAGES = 100;
    private int IMAGE_COUNT;

    public ImageAdapter(int IMAGE_COUNT) {
        this.IMAGE_COUNT = IMAGE_COUNT;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.image_list_item, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.bind();
    }

    @Override
    public int getItemCount() {
        return TOTAL_IMAGES;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_placeholder);
        }

        public void bind() {
            Log.v("ImageViewAdapter", String.format("Index: %d", getAdapterPosition()));
            switch (getAdapterPosition() % IMAGE_COUNT) {
                case 0:
                    imageView.setImageResource(R.drawable.placeholder_800x800);
                    break;
                case 1:
                    imageView.setImageResource(R.drawable.placeholder_900x800);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.placeholder_800x900);
                    break;
            }
        }
    }
}
