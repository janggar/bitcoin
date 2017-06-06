package com.yunhai.model.automatic;

import java.math.BigDecimal;
import java.util.Date;

public class MarketKline {
    private Long id;

    private String moneytype;

    private String symbol;

    private Date date;

    private BigDecimal openprice;

    private BigDecimal endprice;

    private BigDecimal highprice;

    private BigDecimal lowprice;

    private BigDecimal volume;

    private String platform;

    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoneytype() {
        return moneytype;
    }

    public void setMoneytype(String moneytype) {
        this.moneytype = moneytype == null ? null : moneytype.trim();
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getOpenprice() {
        return openprice;
    }

    public void setOpenprice(BigDecimal openprice) {
        this.openprice = openprice;
    }

    public BigDecimal getEndprice() {
        return endprice;
    }

    public void setEndprice(BigDecimal endprice) {
        this.endprice = endprice;
    }

    public BigDecimal getHighprice() {
        return highprice;
    }

    public void setHighprice(BigDecimal highprice) {
        this.highprice = highprice;
    }

    public BigDecimal getLowprice() {
        return lowprice;
    }

    public void setLowprice(BigDecimal lowprice) {
        this.lowprice = lowprice;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}