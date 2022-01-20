package de.thu.city;

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

/**
 * The RecyclerView needs an adapter to populate the views in each row with data
 */

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder> {

    ArrayList<BankItems> bankLocations;

    /**
     *pass in the data
     */
    public BankAdapter(ArrayList<BankItems> bankLocations) {
        this.bankLocations = bankLocations;
    }

    @NonNull
    @Override
    /**
     * inflates the row layout from xml when needed
     * onCreateViewHolder(ViewGroup, int) method is called right when the adapter is created and is used to initialize the ViewHolders.
     */
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bank_row, parent, false);
        return new BankViewHolder(view);
    }

    @Override
    /**
     * pass our data to our ViewHolders
     */
    public void onBindViewHolder(@NonNull BankViewHolder holder, int position) {

        BankItems bankItems = bankLocations.get(position);
        holder.bankNameTxt.setText(bankLocations.get(position).getBank_name());
        holder.phoneTxt.setText(bankLocations.get(position).getBank_phone());
        holder.addressTxt.setText(bankLocations.get(position).getBank_address());
        holder.emailTxt.setText(bankLocations.get(position).getBank_email());
        holder.bankLogo.setImageResource(bankLocations.get(position).getBank_logo());

        /**
         * If the View is expanded, set its visibility to VISIBLE
         * If the View isn't expanded, set its visibility to GONE
          */
        boolean isExpanded = bankLocations.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }


    @Override
    /**
     * total number of rows
     */
    public int getItemCount() {
        return bankLocations.size();
    }

    /**
     * stores and recycles views as they are scrolled off screen
     */
    public class BankViewHolder extends RecyclerView.ViewHolder {

        TextView bankNameTxt, phoneTxt, addressTxt, emailTxt;
        ImageView bankLogo;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;


        public BankViewHolder(@NonNull View itemView) {
            super(itemView);

            bankNameTxt = itemView.findViewById(R.id.bank_name);
            phoneTxt = itemView.findViewById(R.id.bank_number);
            emailTxt = itemView.findViewById(R.id.ban_email);
            addressTxt = itemView.findViewById(R.id.bank_address);
            bankLogo = itemView.findViewById(R.id.bank_logo);

            linearLayout = itemView.findViewById(R.id.linear_layout1);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);

            /**
             * the setExpanded sets whether the layout is expanded or not, animating if it has already been laid out.
             */
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
