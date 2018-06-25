package com.spider.pipeline;

import com.spider.bean.AlbumInfo;
import com.spider.bean.MusicComment;
import com.spider.bean.MusicInfo;
import com.spider.bean.SingerInfo;
import com.spider.service.MusicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.List;
import java.util.Map;

/**
 * @author cj34920
 * Date: 2018/06/19
 */
@Component
public class Music163PipeLine implements Pipeline {

    @Autowired
    private MusicServiceImpl musicService;

    @Override
    public void process(ResultItems resultItems, Task task) {
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if ("commentsList".equals(entry.getKey())) {
                List<MusicComment> commentList = (List<MusicComment>) entry.getValue();
                if (commentList.size() < 0) {
                    return;
                }
                try {
                    musicService.addMusicComment(commentList);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("评论长度：" + commentList.size());
                }

            } else if ("musicInfo".equals(entry.getKey())) {
                MusicInfo musicInfo = (MusicInfo) entry.getValue();
                musicService.addMusicInfo(musicInfo);
            } else if ("singerInfo".equals(entry.getKey())) {
                SingerInfo singerInfo = (SingerInfo) entry.getValue();
                musicService.addSingerInfo(singerInfo);
            } else if ("albumInfo".equals(entry.getKey())) {
                AlbumInfo albumInfo = (AlbumInfo) entry.getValue();
                musicService.addAlbumInfo(albumInfo);
            }

        }
    }
}
