package com.khan.maaz.sampleinsta.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khan.maaz.sampleinsta.R;
import com.khan.maaz.sampleinsta.models.Stories;

import java.util.ArrayList;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoriesViewHolder>{
    private ArrayList<Stories> list;
    public StoryAdapter(ArrayList<Stories> list)
    {
        this.list=list;

    }

    @NonNull
    @Override
    public StoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_story,parent,false);
        return new StoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesViewHolder holder, int position) {
        holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StoriesViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public StoriesViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.my_stories);
            textView = (TextView) itemView.findViewById(R.id.my_uploader);
        }

        public void bind(final Stories stories) {
            imageView.setImageResource(stories.getStory());
            textView.setText(stories.getUploader());
        }
    }
}