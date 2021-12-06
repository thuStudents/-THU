package de.thu.ulm.banking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.thu.R;
import de.thu.ulm.cafe.CafeItems;

public class CafeAdapter extends RecyclerView.Adapter<CafeAdapter.CafeViewHolder> {

    ArrayList<CafeItems> cafeLocations;

    public CafeAdapter(ArrayList<CafeItems> cafeLocations) {
        this.cafeLocations = cafeLocations;
    }

    @NonNull
    @Override
    public CafeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cafe_row, parent, false);
        return new CafeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CafeViewHolder holder, int position) {


        CafeItems cafeItems = cafeLocations.get(position);
        holder.bankNameTxt.setText(bankLocations.get(position).getBank_name());
        holder.phoneTxt.setText(bankLocations.get(position).getBank_phone());
        holder.addressTxt.setText(bankLocations.get(position).getBank_address());
        holder.emailTxt.setText(bankLocations.get(position).getBank_email());
        holder.bankLogo.setImageResource(bankLocations.get(position).getBank_logo());

        boolean isExpanded = bankLocations.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return cafeLocations.size();
    }


    public class BankViewHolder extends RecyclerView.ViewHolder {

        TextView cafe_name, cafe_time;
        ImageView cafe_image;
        LinearLayout linearLayout_c;
        RelativeLayout expandableLayout_c;


        public CafeViewHolder(@NonNull View itemView) {
            super(itemView);

            cafe_name = itemView.findViewById(R.id.cafe_name);
            cafe_time = itemView.findViewById(R.id.cafe_time);
            cafe_image = itemView.findViewById(R.id.);


            linearLayout = itemView.findViewById(R.id.linear_layout1);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BankItems bankItems = bankLocations.get(getAdapterPosition());
                    bankItems.setExpanded(!bankItems.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });


        }
    }
}
