package com.example.jayshri.chalochallenge.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jayshri.chalochallenge.R;
import com.example.jayshri.chalochallenge.models.RouteInfoData;
import com.example.jayshri.chalochallenge.models.StopData;

import java.util.List;

public class AllRoutesAdapter extends RecyclerView.Adapter<AllRoutesAdapter.ViewHolder> {

    private Context context;
    private List<RouteInfoData> routeInfoDataList;
    public AllRoutesAdapter(Context context, List<RouteInfoData> routeInfoDataList){
        this.context = context;
        this.routeInfoDataList = routeInfoDataList;
    }

    public AllRoutesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.single_route_info,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        initCard(viewHolder,i);
    }

    private void initCard(ViewHolder holder,int position){
        RouteInfoData routeInfoData = routeInfoDataList.get(position);
        holder.routeNAme.setText(routeInfoData.getRouteName());
        List<StopData> stopData = routeInfoData.getStopDataList();
        holder.firstStop.setText(stopData.get(0).getStopName());
        holder.lastStop.setText(stopData.get(stopData.size()-1).getStopName());
    }

    @Override
    public int getItemCount() {
        return routeInfoDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView routeNAme;
        private TextView firstStop;
        private TextView lastStop;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            routeNAme = itemView.findViewById(R.id.route_name_card);
            firstStop  = itemView.findViewById(R.id.route_content_card);
            lastStop = itemView.findViewById(R.id.route_content_card1);

        }
    }
}
