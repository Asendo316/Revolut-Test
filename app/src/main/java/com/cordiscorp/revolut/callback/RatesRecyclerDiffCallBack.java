package com.cordiscorp.revolut.callback;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

import com.cordiscorp.revolut.connectivity.models.RatesModel;

import java.util.List;

/**
 * Created by Ibkunle Adeoluwa on 9/13/2019.
 */
public class RatesRecyclerDiffCallBack extends DiffUtil.Callback {

    private List<RatesModel> ratesModels, tempModel;

    public RatesRecyclerDiffCallBack(List<RatesModel> ratesModels, List<RatesModel> tempModel) {
        this.ratesModels = ratesModels;
        this.tempModel = tempModel;
    }

    @Override
    public int getOldListSize() {
        return ratesModels.size();
    }

    @Override
    public int getNewListSize() {
        return tempModel.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return ratesModels.get(oldItemPosition).getAmount() == tempModel.get(newItemPosition).getAmount();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return ratesModels.get(oldItemPosition) == tempModel.get(newItemPosition);
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
