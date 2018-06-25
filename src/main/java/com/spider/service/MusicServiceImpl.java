package com.spider.service;

import com.spider.bean.MusicComment;
import com.spider.bean.MusicInfo;
import com.spider.dao.MusicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;
import java.util.List;

/**
 * @author cj34920
 * Date: 2018/06/22
 */
@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicDao musicDao;

    @Override
    public int addMusicInfo(MusicInfo musicInfo) {
        return musicDao.addMusicInfo(musicInfo);
    }

    @Override
    public int addMusicComment(List<MusicComment> commentList) {
        return musicDao.addMusicComment(commentList);
    }
}
