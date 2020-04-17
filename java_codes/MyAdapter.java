package com.yunuskaratepe.e_mailapplication;

import android.content.Context;
import android.opengl.Visibility;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private ArrayList<User> users = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Context context;

    public MyAdapter(ArrayList<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = layoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.user_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.userName.setText("Username: " + users.get(position).getUserName());
        holder.password.setText(users.get(position).getPassword());
        holder.imageView.setImageBitmap(users.get(position).getImage());
        holder.linearLayout.setTag(holder);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHolder holder = (ViewHolder) v.getTag();
                holder.password.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView userName;
        TextView passwordTxt;
        TextView password;
        ImageView imageView;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.cardUsername);
            passwordTxt = itemView.findViewById(R.id.cardPasswordText);
            password = itemView.findViewById(R.id.cardPassword);
            imageView = itemView.findViewById(R.id.cardUserImage);
            linearLayout = itemView.findViewById(R.id.cardLinear);
        }
    }

}
