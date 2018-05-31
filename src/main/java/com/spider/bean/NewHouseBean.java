package com.spider.bean;

import java.math.BigDecimal;

/**
 * @author cj34920
 * Date: 2018/05/30
 */
public class NewHouseBean {
    /**
     * 房子 id
     */
    private int houseId;
    /**
     * 房子名称
     */
    private String houseName;
    /**
     * 房子地址
     */
    private String houseAddress;
    /**
     * 建筑面积
     */
    private String houseBig;
    /**
     * 户型
     */
    private String houseType;
    /**
     * 参考价格
     */
    private BigDecimal referencePrice;
    /**
     * 价格单位
     */
    private String referencePriceUnit;
    /**
     * 房子类型商住还是住宅
     */
    private String referencePriceType;
    /**
     * 周边价格
     */
    private BigDecimal circumPrice;
    /**
     * 联系电话
     */
    private String contactNumber;
    private String imgUrl;
    /**
     * 地址纬度
     */
    private String baiduLat;
    /**
     * 地址经度
     */
    private String baiduLng;

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHouseBig() {
        return houseBig;
    }

    public void setHouseBig(String houseBig) {
        this.houseBig = houseBig;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public BigDecimal getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(BigDecimal referencePrice) {
        this.referencePrice = referencePrice;
    }

    public BigDecimal getCircumPrice() {
        return circumPrice;
    }

    public void setCircumPrice(BigDecimal circumPrice) {
        this.circumPrice = circumPrice;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBaiduLat() {
        return baiduLat;
    }

    public void setBaiduLat(String baiduLat) {
        this.baiduLat = baiduLat;
    }

    public String getBaiduLng() {
        return baiduLng;
    }

    public void setBaiduLng(String baiduLng) {
        this.baiduLng = baiduLng;
    }

    public String getReferencePriceUnit() {
        return referencePriceUnit;
    }

    public void setReferencePriceUnit(String referencePriceUnit) {
        this.referencePriceUnit = referencePriceUnit;
    }

    public String getReferencePriceType() {
        return referencePriceType;
    }

    public void setReferencePriceType(String referencePriceType) {
        this.referencePriceType = referencePriceType;
    }
}
