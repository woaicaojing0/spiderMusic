package com.spider.bean;

/**
 * @author cj34920
 * Date: 2018/06/04
 */
public class LbsResultBean {

    /**
     * status : 1
     * info : ok
     * infocode : 10000
     * locations : 0,0
     */

    private int status;
    private String info;
    private String infocode;
    private String locations;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }
}
