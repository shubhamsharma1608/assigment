package com.example.android_assign;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Bitmap bitmap;
    String imageUrl="https://d2bps9p1kiy4ka.cloudfront.net/5eb393ee95fab7468a79d189/71ec7e49-9229-46ab-ac71-71aefee195ff.png";
    List<model> modelList;
    public Myadapter(Context context , List<model> modelList ) {
        this.modelList=modelList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter.ViewHolder holder, int position) {
        holder.userid.setText(Integer.toString(modelList.get(position).getid()));
        holder.name.setText(modelList.get(position).getName());
        holder.subjects.setText(modelList.get(position).getSubjects());
        holder.qualifications.setText(modelList.get(position).getQualification());
        if (holder.imageView != null) {
            /*-------------fatching image------------*/;
            new ImageDownloaderTask(holder.imageView).execute(imageUrl);
        }
        holder.imageView.setImageBitmap(bitmap);






    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView userid,name,subjects,qualifications;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userid=itemView.findViewById(R.id.userid);
            name=itemView.findViewById(R.id.name);
            subjects=itemView.findViewById(R.id.subjects);
            qualifications= itemView.findViewById(R.id.qualifications);
            imageView=itemView.findViewById(R.id.profile);
        }
    }
}
