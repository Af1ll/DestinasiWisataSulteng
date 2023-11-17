package com.aplikasi.destinasiwisatasulteng;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ListViewHolder> {

    private ArrayList<Wisata> listWisata;
    public WisataAdapter(ArrayList<Wisata>list){
        this.listWisata = list;
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wisata, parent, false);
        return new ListViewHolder(itemView);
    }
    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    @Override
    public void onBindViewHolder(@NonNull final WisataAdapter.ListViewHolder holder, int position) {
        Wisata wisata = listWisata.get(position);

        if (wisata != null) {
            holder.imageViewWisata.setImageResource(wisata.getPhoto());

            if (wisata.getName() != null) {
                holder.tvName.setText(wisata.getName());
            }

            if (wisata.getDescription() != null) {
                holder.tvDescription.setText(wisata.getDescription());
            }
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Wisata data);
    }

    @Override
    public int getItemCount() {
        return listWisata.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewWisata;
        TextView tvName;
        TextView tvDescription;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewWisata = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
        }
    }
}
