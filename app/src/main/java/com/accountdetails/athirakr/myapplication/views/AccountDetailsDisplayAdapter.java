package com.accountdetails.athirakr.myapplication.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.accountdetails.athirakr.myapplication.R;
import com.accountdetails.athirakr.myapplication.dto.AdapterListDto;

import java.util.List;

/**
 * Created by athira.kr on 22-07-2018.
 */

public class AccountDetailsDisplayAdapter extends RecyclerView.Adapter<AccountDetailsDisplayAdapter.MyHolder> {

    private List<AdapterListDto> list;

    private Context context;

    AccountDetailsDisplayAdapter(List<AdapterListDto> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_details_display, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        final AdapterListDto adapterListDto = list.get(position);
        holder.txtHeading.setText(adapterListDto.getHeading().trim());
        holder.txtValue.setText(adapterListDto.getValue().trim());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView txtHeading;
        private TextView txtValue;


        public MyHolder(View itemView) {
            super(itemView);
            txtHeading = (TextView) itemView.findViewById(R.id.txtHeading);
            txtValue = (TextView) itemView.findViewById(R.id.txtValue);
        }
    }
}