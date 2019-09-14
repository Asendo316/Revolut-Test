package com.cordiscorp.revolut.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cordiscorp.revolut.R;
import com.cordiscorp.revolut.connectivity.models.ConversionModel;
import com.cordiscorp.revolut.connectivity.models.RatesModel;
import com.mynameismidori.currencypicker.ExtendedCurrency;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Ibkunle Adeoluwa on 8/28/2019.
 */
public class RatesRecyclerAdapter extends RecyclerView.Adapter<RatesRecyclerAdapter.MyViewHolder> {
    private Context mContext;
    private List<RatesModel> ratesModels, holderModel, tempModel;
    private LinearLayoutManager linearLayoutManager;
    private ConversionModel conversionModel;
    private Double amount = 0.0;
    private ExtendedCurrency currencies;
    private RatesModel ratesModel;


    public RatesRecyclerAdapter(Context mContext, List<RatesModel> ratesModels, LinearLayoutManager linearLayoutManager) {
        this.mContext = mContext;
        this.ratesModels = ratesModels;
        this.linearLayoutManager = linearLayoutManager;
        this.holderModel = ratesModels;
    }

    @NonNull
    @Override
    public RatesRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rates_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RatesRecyclerAdapter.MyViewHolder holder, int position) {
        ratesModel = ratesModels.get(position);
        try {
            holder.currency.setText(ratesModel.getName().replace("\"", ""));
            holder.amountEdit.setHint(ratesModel.getAmount());
            holder.amountEdit.clearComposingText();
            holder.currName.setText(Currency.getInstance(holder.currency.getText().toString()).getDisplayName());
            currencies = ExtendedCurrency.getCurrencyByISO(holder.currency.getText().toString().toUpperCase());
            holder.flagImage.setImageResource(currencies.getFlag());

            if (holder.getAdapterPosition() != 0) {
                holder.amountEdit.getText().clear();
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static Locale getLocale(String strCode) {
        for (Locale locale : NumberFormat.getAvailableLocales()) {
            String code = NumberFormat.getCurrencyInstance(locale).getCurrency().getCurrencyCode();
            if (strCode.equals(code)) {
                return locale;
            }
        }
        return null;
    }

    private void focusItem(int fromPosition, int toPosition) {
        Collections.swap(ratesModels, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        linearLayoutManager.scrollToPosition(toPosition);
    }

    @Override
    public int getItemCount() {
        return ratesModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, TextWatcher, View.OnTouchListener {

        protected @BindView(R.id.flagImage) CircleImageView flagImage;
        protected @BindView(R.id.currency) TextView currency;
        protected @BindView(R.id.currName) TextView currName;
        protected @BindView(R.id.amountEdit) EditText amountEdit;
        protected @BindView(R.id.card_view) CardView card_view;

        public MyViewHolder(@NonNull View view) {
            super(view);
            ButterKnife.bind(this, view);

            card_view.setOnClickListener(this);

            amountEdit.setOnTouchListener(this);

            amountEdit.addTextChangedListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = this.getAdapterPosition();
            notifyItemChanged(2);
            focusItem(position, 0);
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            conversionModel = new ConversionModel(amountEdit.getText().toString());
            updateRecycler(conversionModel);
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }

        private String formatMoney(Double money) {
            String amount;
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
            DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) currencyFormatter)
                    .getDecimalFormatSymbols();
            decimalFormatSymbols.setCurrencySymbol("");
            ((DecimalFormat) currencyFormatter).setDecimalFormatSymbols(decimalFormatSymbols);
            amount = currencyFormatter.format(money);
            return amount;
        }

        private void updateRecycler(ConversionModel conversionModel){
            try {
                if (conversionModel.getAmount() != null && !conversionModel.getAmount().isEmpty()) {
                    amount = Double.parseDouble(conversionModel.getAmount());
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }

            tempModel = new ArrayList<>();
            for (int x = 0; x < ratesModels.size(); x++) {
                if (x == 0) {
                    tempModel.add(x, new RatesModel(ratesModels.get(x).getName(), conversionModel.getAmount()));
                } else {
                    try {
                        tempModel.add(x, new RatesModel(holderModel.get(x).getName(),
                                String.valueOf(
                                        formatMoney(Double.parseDouble(holderModel.get(x).getAmount())
                                                * amount))));
                    } catch (NumberFormatException e) {
                        tempModel.add(x, new RatesModel(holderModel.get(x).getName(),
                                String.valueOf(formatMoney(0 * amount))));
                    }
                }

            }

            ratesModels = tempModel;
            try {
                notifyItemRangeChanged(1, ratesModels.size(), ratesModels);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int position = this.getAdapterPosition();
            focusItem(position, 0);
            return false;
        }
    }
}
