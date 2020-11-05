package com.example.contactme.Adepter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactme.ContectDetail;
import com.example.contactme.R;

import java.util.ArrayList;

public class AddContectAdepter extends RecyclerView.Adapter<AddContectAdepter.ADDCONTECT> {

    ArrayList<AddContectItem> addContectItems;
    Context context;

    public AddContectAdepter(ArrayList<AddContectItem> addContectItems, Context context) {
        this.addContectItems = addContectItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ADDCONTECT onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.addcontect_item, parent, false);
        return new ADDCONTECT(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ADDCONTECT holder, final int position) {

//        holder.gender.setText(addContectItems.get(position).getGender());

        holder.fname.setText(addContectItems.get(position).getFname());
        holder.mname.setText(addContectItems.get(position).getMname());
        holder.lname.setText(addContectItems.get(position).getLname());

        holder.mnumber.setText(addContectItems.get(position).getMnumber());
        holder.hnumber.setText(addContectItems.get(position).getHnumber());
        holder.cnumber.setText(addContectItems.get(position).getCnumber());

        holder.haddress.setText(addContectItems.get(position).getHaddress());
        holder.caddress.setText(addContectItems.get(position).getCaddress());

        holder.email.setText(addContectItems.get(position).getEmail());


        holder.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ContectDetail.class);

//                intent.putExtra("gender", addContectItems.get(position).getGender());

                intent.putExtra("fname", addContectItems.get(position).getFname());
                intent.putExtra("mname", addContectItems.get(position).getMname());
                intent.putExtra("lname", addContectItems.get(position).getLname());

                intent.putExtra("mnumber", addContectItems.get(position).getMnumber());
                intent.putExtra("hnumber", addContectItems.get(position).getHnumber());
                intent.putExtra("cnumber", addContectItems.get(position).getCnumber());

                intent.putExtra("haddress", addContectItems.get(position).getHaddress());
                intent.putExtra("caddress", addContectItems.get(position).getCaddress());

                intent.putExtra("email", addContectItems.get(position).getEmail());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return addContectItems.size();
    }


    public class ADDCONTECT extends RecyclerView.ViewHolder {

        TextView gender, fname, mname, lname, mnumber, hnumber, cnumber, haddress, caddress, email;
        LinearLayout click;

        public ADDCONTECT(@NonNull View itemView) {
            super(itemView);

            gender = itemView.findViewById(R.id.gender);
            fname = itemView.findViewById(R.id.fname);
            mname = itemView.findViewById(R.id.mname);
            lname = itemView.findViewById(R.id.sname);
            mnumber = itemView.findViewById(R.id.mnumber);
            hnumber = itemView.findViewById(R.id.hnumber);
            cnumber = itemView.findViewById(R.id.cnumber);
            haddress = itemView.findViewById(R.id.haddress);
            caddress = itemView.findViewById(R.id.caddress);
            email = itemView.findViewById(R.id.email);

            click = itemView.findViewById(R.id.click);
        }
    }
}
