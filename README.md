# spiderMusic
爬取网易云音乐评论，持续更新
该项目采用**springboot**+**mybatis**+**redis**+**webMagic**爬取网易云音乐评论。<br>
该项目默认启动时会对爬取网易云音乐评论进行一次爬取。<br>
# 如何配置：
### 1.下载源码
### 2.初始化数据库相关信息：
    找到src/main/DB/20171108Init.sql,进入mysql执行文件.
### 3.修改springboot的相关配置：
    找到 application.yml  配置数据库相关信息 redis的端口地址密码
### 4.启动项目：
    HouseApplication启动项：
   ```
//        //从歌手列表开始爬歌手id
//        Spider.create(new Music163Processer()).addUrl("https://music.163.com/discover/artist")
//                .setScheduler(new QueueScheduler().setDuplicateRemover(new HashSetDuplicateRemover()))
//                .thread(10).addPipeline(music163PipeLine).run();
//        //爬取指定歌手id
//        Spider.create(new Music163Processer()).addUrl("https://music.163.com/artist?id=10559")
//                .setScheduler(new QueueScheduler().setDuplicateRemover(new HashSetDuplicateRemover()))
//                .thread(10).addPipeline(music163PipeLine).run();
//        //爬取指定歌手下所有专辑
//        Spider.create(new Music163Processer()).addUrl("https://music.163.com/artist/album?id=10559")
//                .setScheduler(new QueueScheduler().setDuplicateRemover(new HashSetDuplicateRemover()))
//                .thread(10).addPipeline(music163PipeLine).run();
//        //爬取指定专辑的歌曲
//        Spider.create(new Music163Processer()).addUrl("https://music.163.com/album?id=2878422")
//                .setScheduler(new QueueScheduler().setDuplicateRemover(new HashSetDuplicateRemover()))
//                .thread(10).addPipeline(music163PipeLine).run();
        //爬取指定歌曲详情（评论）
        Spider.create(new Music163Processer()).addUrl("https://music.163.com/song?id=28754098")
                .setScheduler(new QueueScheduler().setDuplicateRemover(new HashSetDuplicateRemover()))
                .thread(10).addPipeline(music163PipeLine).run();
```
    针对不同的url进行测试爬取数据
# 项目介绍：
详情请点击：
https://blog.csdn.net/bicheng4769/article/details/80802184
