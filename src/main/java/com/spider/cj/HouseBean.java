package com.spider.cj;

/**
 * @author cj34920
 * Date: 2018/05/30
 */
public class HouseBean {
    /**
     * 房子 id
     */
    private String houseId;
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
    private String referencePrice;
    /**
     * 周边价格
     */
    private String circumPrice;
    /**
     * 联系电话
     */
    private String contactNumber;
    private String imgUrl;

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

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(String referencePrice) {
        this.referencePrice = referencePrice;
    }

    public String getCircumPrice() {
        return circumPrice;
    }

    public void setCircumPrice(String circumPrice) {
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
}
