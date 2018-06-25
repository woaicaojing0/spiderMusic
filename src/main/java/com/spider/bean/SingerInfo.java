package com.spider.bean;

/**
 * @author cj34920
 * Date: 2018/06/25
 * 歌手信息实体类
 */
public class SingerInfo {

    private int id;
    private int singerId;
    private String singerName;
    private String singerDescription;
    private String singerHref;
    private String createTime;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getSingerDescription() {
        return singerDescription;
    }

    public void setSingerDescription(String singerDescription) {
        this.singerDescription = singerDescription;
    }

    public String getSingerHref() {
        return singerHref;
    }

    public void setSingerHref(String singerHref) {
        this.singerHref = singerHref;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
