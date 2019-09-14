package com.cordiscorp.revolut.connectivity.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Ibkunle Adeoluwa on 9/10/2019.
 */
public class Rates implements Serializable {

    @SerializedName("AUD")
    @Expose
    private Float aUD;
    @SerializedName("BGN")
    @Expose
    private Float bGN;
    @SerializedName("BRL")
    @Expose
    private Float bRL;
    @SerializedName("CAD")
    @Expose
    private Float cAD;
    @SerializedName("CHF")
    @Expose
    private Float cHF;
    @SerializedName("CNY")
    @Expose
    private Float cNY;
    @SerializedName("CZK")
    @Expose
    private Float cZK;
    @SerializedName("DKK")
    @Expose
    private Float dKK;
    @SerializedName("GBP")
    @Expose
    private Float gBP;
    @SerializedName("HKD")
    @Expose
    private Float hKD;
    @SerializedName("HRK")
    @Expose
    private Float hRK;
    @SerializedName("HUF")
    @Expose
    private Float hUF;
    @SerializedName("IDR")
    @Expose
    private Integer iDR;
    @SerializedName("ILS")
    @Expose
    private Float iLS;
    @SerializedName("INR")
    @Expose
    private Float iNR;
    @SerializedName("ISK")
    @Expose
    private Float iSK;
    @SerializedName("JPY")
    @Expose
    private Float jPY;
    @SerializedName("KRW")
    @Expose
    private Float kRW;
    @SerializedName("MXN")
    @Expose
    private Float mXN;
    @SerializedName("MYR")
    @Expose
    private Float mYR;
    @SerializedName("NOK")
    @Expose
    private Float nOK;
    @SerializedName("NZD")
    @Expose
    private Float nZD;
    @SerializedName("PHP")
    @Expose
    private Float pHP;
    @SerializedName("PLN")
    @Expose
    private Float pLN;
    @SerializedName("RON")
    @Expose
    private Float rON;
    @SerializedName("RUB")
    @Expose
    private Float rUB;
    @SerializedName("SEK")
    @Expose
    private Float sEK;
    @SerializedName("SGD")
    @Expose
    private Float sGD;
    @SerializedName("THB")
    @Expose
    private Float tHB;
    @SerializedName("TRY")
    @Expose
    private Float tRY;
    @SerializedName("USD")
    @Expose
    private Float uSD;
    @SerializedName("ZAR")
    @Expose
    private Float zAR;

    public Float getaUD() {
        return aUD;
    }

    public void setaUD(Float aUD) {
        this.aUD = aUD;
    }

    public Float getbGN() {
        return bGN;
    }

    public void setbGN(Float bGN) {
        this.bGN = bGN;
    }

    public Float getbRL() {
        return bRL;
    }

    public void setbRL(Float bRL) {
        this.bRL = bRL;
    }

    public Float getcAD() {
        return cAD;
    }

    public void setcAD(Float cAD) {
        this.cAD = cAD;
    }

    public Float getcHF() {
        return cHF;
    }

    public void setcHF(Float cHF) {
        this.cHF = cHF;
    }

    public Float getcNY() {
        return cNY;
    }

    public void setcNY(Float cNY) {
        this.cNY = cNY;
    }

    public Float getcZK() {
        return cZK;
    }

    public void setcZK(Float cZK) {
        this.cZK = cZK;
    }

    public Float getdKK() {
        return dKK;
    }

    public void setdKK(Float dKK) {
        this.dKK = dKK;
    }

    public Float getgBP() {
        return gBP;
    }

    public void setgBP(Float gBP) {
        this.gBP = gBP;
    }

    public Float gethKD() {
        return hKD;
    }

    public void sethKD(Float hKD) {
        this.hKD = hKD;
    }

    public Float gethRK() {
        return hRK;
    }

    public void sethRK(Float hRK) {
        this.hRK = hRK;
    }

    public Float gethUF() {
        return hUF;
    }

    public void sethUF(Float hUF) {
        this.hUF = hUF;
    }

    public Integer getiDR() {
        return iDR;
    }

    public void setiDR(Integer iDR) {
        this.iDR = iDR;
    }

    public Float getiLS() {
        return iLS;
    }

    public void setiLS(Float iLS) {
        this.iLS = iLS;
    }

    public Float getiNR() {
        return iNR;
    }

    public void setiNR(Float iNR) {
        this.iNR = iNR;
    }

    public Float getiSK() {
        return iSK;
    }

    public void setiSK(Float iSK) {
        this.iSK = iSK;
    }

    public Float getjPY() {
        return jPY;
    }

    public void setjPY(Float jPY) {
        this.jPY = jPY;
    }

    public Float getkRW() {
        return kRW;
    }

    public void setkRW(Float kRW) {
        this.kRW = kRW;
    }

    public Float getmXN() {
        return mXN;
    }

    public void setmXN(Float mXN) {
        this.mXN = mXN;
    }

    public Float getmYR() {
        return mYR;
    }

    public void setmYR(Float mYR) {
        this.mYR = mYR;
    }

    public Float getnOK() {
        return nOK;
    }

    public void setnOK(Float nOK) {
        this.nOK = nOK;
    }

    public Float getnZD() {
        return nZD;
    }

    public void setnZD(Float nZD) {
        this.nZD = nZD;
    }

    public Float getpHP() {
        return pHP;
    }

    public void setpHP(Float pHP) {
        this.pHP = pHP;
    }

    public Float getpLN() {
        return pLN;
    }

    public void setpLN(Float pLN) {
        this.pLN = pLN;
    }

    public Float getrON() {
        return rON;
    }

    public void setrON(Float rON) {
        this.rON = rON;
    }

    public Float getrUB() {
        return rUB;
    }

    public void setrUB(Float rUB) {
        this.rUB = rUB;
    }

    public Float getsEK() {
        return sEK;
    }

    public void setsEK(Float sEK) {
        this.sEK = sEK;
    }

    public Float getsGD() {
        return sGD;
    }

    public void setsGD(Float sGD) {
        this.sGD = sGD;
    }

    public Float gettHB() {
        return tHB;
    }

    public void settHB(Float tHB) {
        this.tHB = tHB;
    }

    public Float gettRY() {
        return tRY;
    }

    public void settRY(Float tRY) {
        this.tRY = tRY;
    }

    public Float getuSD() {
        return uSD;
    }

    public void setuSD(Float uSD) {
        this.uSD = uSD;
    }

    public Float getzAR() {
        return zAR;
    }

    public void setzAR(Float zAR) {
        this.zAR = zAR;
    }

    @Override
    public String toString() {
        return "{" +
                "aUD=" + aUD +
                ", bGN=" + bGN +
                ", bRL=" + bRL +
                ", cAD=" + cAD +
                ", cHF=" + cHF +
                ", cNY=" + cNY +
                ", cZK=" + cZK +
                ", dKK=" + dKK +
                ", gBP=" + gBP +
                ", hKD=" + hKD +
                ", hRK=" + hRK +
                ", hUF=" + hUF +
                ", iDR=" + iDR +
                ", iLS=" + iLS +
                ", iNR=" + iNR +
                ", iSK=" + iSK +
                ", jPY=" + jPY +
                ", kRW=" + kRW +
                ", mXN=" + mXN +
                ", mYR=" + mYR +
                ", nOK=" + nOK +
                ", nZD=" + nZD +
                ", pHP=" + pHP +
                ", pLN=" + pLN +
                ", rON=" + rON +
                ", rUB=" + rUB +
                ", sEK=" + sEK +
                ", sGD=" + sGD +
                ", tHB=" + tHB +
                ", tRY=" + tRY +
                ", uSD=" + uSD +
                ", zAR=" + zAR +
                '}';
    }
}
