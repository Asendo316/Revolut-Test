package com.cordiscorp.revolut;

import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cordiscorp.revolut.adapter.RatesRecyclerAdapter;
import com.cordiscorp.revolut.callback.RatesRecyclerDiffCallBack;
import com.cordiscorp.revolut.connectivity.models.RatesModel;
import com.cordiscorp.revolut.contracts.RatesContracts;
import com.cordiscorp.revolut.presenter.RatesPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RatesContracts.View, View.OnTouchListener {

    private RatesContracts.Presenter presenter;
    protected @BindView(R.id.ratesRecycler) RecyclerView ratesRecycler;
    protected @BindView(R.id.errorMessage) TextView errorMessage;
    private RatesRecyclerAdapter ratesRecyclerAdapter;
    private LinearLayoutManager linearLayoutManager;
    private Handler handler = new Handler();
    private Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new RatesPresenter(this);
        presenter.onStart();
        ratesRecycler.setOnTouchListener(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onInit() {
        presenter.loadRates("EUR");

        setCallBack(1000);
    }

    private void setCallBack(int delay) {
        handler.postDelayed(runnable = () -> {
            presenter.loadRates("EUR");
            handler.postDelayed(runnable, delay);
        }, delay);
    }

    @Override
    public void showRates(List<RatesModel> ratesModel) {
        errorMessage.setVisibility(View.GONE);
        linearLayoutManager = new LinearLayoutManager(this);
        ratesRecycler.setItemAnimator(new DefaultItemAnimator());
        ratesRecycler.setLayoutManager(linearLayoutManager);
        ratesRecyclerAdapter = new RatesRecyclerAdapter(this, ratesModel,linearLayoutManager);
        ratesRecycler.setAdapter(ratesRecyclerAdapter);
    }

    public void updateList(List<RatesModel> ratesModels, List<RatesModel> newModel){
        DiffUtil.DiffResult diffResult
                = DiffUtil.calculateDiff(new RatesRecyclerDiffCallBack(ratesModels, newModel));
        diffResult.dispatchUpdatesTo(ratesRecyclerAdapter);
    }

    @Override
    public void onFailed(Throwable throwable) {

    }

    @Override
    public void showError(String message) {
        presenter.loadRates("USD");
        errorMessage.setVisibility(View.VISIBLE);
        errorMessage.setText(message +"\n\n retrying ...");
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        handler.removeCallbacks(runnable); //stop handler when activity not visible
        return false;
    }
}
