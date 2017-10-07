package com.smartjump.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartjump.app.R;
import com.smartjump.domain.model.Jump;

import java.util.List;

/**
 *
 */
public class JumpAdapter extends RecyclerView.Adapter<JumpAdapter.Holder> {

    private final List<Jump> jumps;

    public JumpAdapter(List<Jump> jumps) {
        this.jumps = jumps;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter, viewGroup, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int i) {
        Jump jump = jumps.get(i);
        holder.txtDistance.setText(String.format("%s metros", jump.getDistance()));
        holder.txtAddress.setText(jump.getAddress());
    }

    @Override
    public int getItemCount() {
        return jumps.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        TextView txtDistance;
        TextView txtAddress;

        public Holder(View itemView) {
            super(itemView);
            txtDistance = itemView.findViewById(R.id.txt_distance);
            txtAddress = itemView.findViewById(R.id.txt_address);
        }
    }
}
