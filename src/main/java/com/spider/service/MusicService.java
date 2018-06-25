package com.spider.service;

import com.spider.bean.AlbumInfo;
import com.spider.bean.MusicComment;
import com.spider.bean.MusicInfo;
import com.spider.bean.SingerInfo;

import java.util.List;

/**
 * @author cj34920
 * Date: 2018/06/22
 */
public interface MusicService {

    /**
     * 新增歌曲信息
     *
     * @param musicInfo
     * @return
     */
    int addMusicInfo( MusicInfo musicInfo);

    /**
     * 新增歌曲评论
     *
     * @param commentList
     * @return
     */
    int addMusicComment( List<MusicComment> commentList);


    /**
     * 新增专辑信息
     *
     * @param albumInfo
     * @return
     */
    int addAlbumInfo( AlbumInfo albumInfo);

    /**
     * 新增歌手信息
     *
     * @param singerInfo
     * @return
     */
    int addSingerInfo( SingerInfo singerInfo);

}
