package com.spider.dao;

import com.spider.bean.MusicComment;
import com.spider.bean.MusicInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cj34920
 * Date: 2018/06/22
 */
public interface MusicDao {
    /**
     * 新增歌曲信息
     *
     * @param musicInfo
     * @return
     */
    int addMusicInfo(@Param("musicInfo") MusicInfo musicInfo);

    /**
     * 新增歌曲评论
     *
     * @param commentList
     * @return
     */
    int addMusicComment(@Param("commentList") List<MusicComment> commentList);

}
