# spiderHouse
爬取安居客的信息，持续更新
该项目采用springboot+mybatis+redis+webMagic爬取安居客新房信息。<br>
该项目默认启动时会对安居客的新房信息进行一次爬取。以后每天1点钟获取新房信息<br>
在获取新房地理位置时，获取的经纬度是经过偏移计算的。换句话说获取的经纬度是不正确的， 我们需要通过高德地图提供的api处理获取准备的经纬度。具体操作可查看
http://lbs.amap.com/api/javascript-api/guide/transform/convertfrom
# 如何配置：
### 1.下载源码
### 2.初始化数据库相关信息：
    找到src/main/DB/20171108Init.sql,进入mysql执行文件.
### 3.修改springboot的相关配置：
    找到 application.yml  配置数据库相关信息 redis的端口地址密码 lbs云地址的key。
# 项目介绍：
详情请点击：
