package com.example.william.asynchw;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by william on 5/3/18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{

    private ArrayList<GameUsers> gameUsers;

    public UserAdapter(ArrayList<GameUsers> gameUsers) {
        this.gameUsers = gameUsers;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tvUsername;
        public TextView tvScore;
        public TextView tvTime;

        public MyViewHolder(View view) {
            super(view);

            tvUsername = view.findViewById(R.id.tvUsername);
            tvScore = view.findViewById(R.id.tvScore);
            tvTime = view.findViewById(R.id.tvTime);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);

        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GameUsers gameUser = gameUsers.get(position);

        holder.tvUsername.setText(gameUser.Username());
        holder.tvScore.setText(gameUser.Score()+"");
        holder.tvTime.setText(gameUser.Time());
    }

    @Override
    public int getItemCount() {
        return gameUsers.size();
    }
}
