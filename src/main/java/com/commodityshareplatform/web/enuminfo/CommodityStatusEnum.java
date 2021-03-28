package com.commodityshareplatform.web.enuminfo;

public enum CommodityStatusEnum {
    SELL(100,"出售中"),
    SELL_OUT(200,"售罄"),
    NOR_SELL(1,"未上架");

    private Integer statusCode;
    private String status;

    CommodityStatusEnum(Integer statusCode, String status) {
        this.statusCode = statusCode;
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
