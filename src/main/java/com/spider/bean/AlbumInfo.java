package com.spider.bean;

/**
 * @author cj34920
 * Date: 2018/06/25
 * 专辑信息实体类
 */
public class AlbumInfo {
    private int id;
    private int albumId;
    private String albumName;
    private String albumTime;
    private String albumCompany;
    private String albumSingerName;
    private String albumSingerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getAlbumTime() {
        return albumTime;
    }

    public void setAlbumTime(String albumTime) {
        this.albumTime = albumTime;
    }

    public String getAlbumCompany() {
        return albumCompany;
    }

    public void setAlbumCompany(String albumCompany) {
        this.albumCompany = albumCompany;
    }

    public String getAlbumSingerName() {
        return albumSingerName;
    }

    public void setAlbumSingerName(String albumSingerName) {
        this.albumSingerName = albumSingerName;
    }

    public String getAlbumSingerId() {
        return albumSingerId;
    }

    public void setAlbumSingerId(String albumSingerId) {
        this.albumSingerId = albumSingerId;
    }
}
