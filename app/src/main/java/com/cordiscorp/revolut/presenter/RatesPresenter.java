package com.cordiscorp.revolut.presenter;

import com.cordiscorp.revolut.callback.Callback;
import com.cordiscorp.revolut.connectivity.models.GetRates;
import com.cordiscorp.revolut.connectivity.models.RatesModel;
import com.cordiscorp.revolut.contracts.RatesContracts;
import com.cordiscorp.revolut.task.RatesTask;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ibkunle Adeoluwa on 9/11/2019.
 */
public class RatesPresenter implements RatesContracts.Presenter {

    RatesContracts.View view;

    public RatesPresenter(RatesContracts.View view) {
        this.view = view;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onStart() {
        view.onInit();
    }

    @Override
    public void loadRates(String base) {
        RatesTask.getRates(new Callback<GetRates>() {
            @Override
            public void returnResult(GetRates getRates) {

                HashMap<String, Double> map = new Gson().fromJson(String.valueOf(getRates.getRates()),
                        new TypeToken<HashMap<String, Double>>() {
                        }.getType());

                ObjectMapper mapper = new ObjectMapper();
                ArrayNode ratesNode = mapper.createArrayNode();

                for (Map.Entry<String, Double> entry : map.entrySet()) {
                    JsonNode childNode = mapper.createObjectNode();
                    ((ObjectNode) childNode).put("name", entry.getKey());
                    ((ObjectNode) childNode).put("amount", entry.getValue());
                    ratesNode.add(childNode);
                }

                List<RatesModel> ratesModels =  new ArrayList<>();
                for (int i =0; i < ratesNode.size(); i++){
                    ratesModels.add(new RatesModel(ratesNode.get(i).get("name").toString(),
                            (ratesNode.get(i).get("amount").toString())));
                }


                view.showRates(ratesModels);
            }

            @Override
            public void returnError(String message) {
                view.showError(message);
            }
        }, base);
    }

}
