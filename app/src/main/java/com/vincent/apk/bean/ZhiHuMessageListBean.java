package com.vincent.apk.bean;

import java.util.List;

/**
 * description ：
 * project name：DownAndInstallApk
 * author : Vincent
 * creation date: 2017/2/7 17:26
 *
 * @version 1.0
 */

public class ZhiHuMessageListBean {
    /**
     * date : 20170206
     * stories : [{"images":["http://pic4.zhimg.com/3be8f303313f8f9f33700e13ead6057b.jpg"],"type":0,"id":9200807,"ga_prefix":"020622","title":"小事 · 哪些不经意发生的事，改变了你的一生？"},{"title":"有哪些类似于《神探夏洛克》《无人生还》的「三集片」？","ga_prefix":"020621","images":["http://pic2.zhimg.com/577cee9b74a5f173a365f0df51517df5.jpg"],"multipic":true,"type":0,"id":9200119},{"images":["http://pic2.zhimg.com/3cbe9f3bfa725f75dbb8acf00e1c0c51.jpg"],"type":0,"id":9200698,"ga_prefix":"020620","title":"关于视觉的三个问题，比如猫头鹰为什么要歪脖子？"},{"images":["http://pic2.zhimg.com/a78482825c30790d000a8117ee110999.jpg"],"type":0,"id":9200385,"ga_prefix":"020619","title":"今天起，体育史上的最强逆转属于这场比赛"},{"images":["http://pic3.zhimg.com/8e3b16a3947e7bd638b678e6aac74a4a.jpg"],"type":0,"id":9200058,"ga_prefix":"020618","title":"跳槽是为了走好下一步，而不是逃避走错的上一步"},{"images":["http://pic1.zhimg.com/27e393c3da2282c0d91b5ed558cd5eec.jpg"],"type":0,"id":9200261,"ga_prefix":"020617","title":"600 人站一排，每次随机杀一个奇数位的人，几号最安全？"},{"images":["http://pic4.zhimg.com/b5f1a19dbbb52c84aec852e56b5536a3.jpg"],"type":0,"id":9200176,"ga_prefix":"020616","title":"「祝你鸡年大吉吧」这个梗，怎么别的生肖就没有？"},{"images":["http://pic1.zhimg.com/eed01b9e53c7f80812a41c38c59138a8.jpg"],"type":0,"id":9200109,"ga_prefix":"020615","title":"如何快捷有效地教爸妈学会使用智能手机？"},{"images":["http://pic4.zhimg.com/7d1519cf175039fa9b1bb6e1a65469eb.jpg"],"type":0,"id":9199938,"ga_prefix":"020614","title":"为什么美国国父要当一名邮政局长？"},{"images":["http://pic4.zhimg.com/3ea1e19f1347f45819b53a7c1c35565f.jpg"],"type":0,"id":9199415,"ga_prefix":"020613","title":"《歌手》第三期，大家的水平整体下滑了"},{"images":["http://pic4.zhimg.com/e345cd1b6ad15f8565062221f2f1ce5b.jpg"],"type":0,"id":9199433,"ga_prefix":"020612","title":"大误 · 「我在梦里醒来」"},{"images":["http://pic1.zhimg.com/f1204da91b9b1d71039a53679e6a08c8.jpg"],"type":0,"id":9198830,"ga_prefix":"020611","title":"是艺术家也是时尚 icon，这是她的传奇一生"},{"images":["http://pic4.zhimg.com/e84ea108c8967815724f966a823d2d0b.jpg"],"type":0,"id":9195071,"ga_prefix":"020610","title":"我们感知这个世界的方式，可能从一出生就决定了"},{"images":["http://pic3.zhimg.com/8cec702dfeac127c1f6df3b716d86792.jpg"],"type":0,"id":9197561,"ga_prefix":"020609","title":"每天都离不开便利店，不过它们真的能赚到钱吗？"},{"images":["http://pic4.zhimg.com/64a5ace8534ae7f562badfa7e4c3cfef.jpg"],"type":0,"id":9198585,"ga_prefix":"020608","title":"美国发生过的杠杆收购大潮，会不会在中国出现？"},{"title":"养猫的薛定谔说，生命现象原则上都可以用物理学来解释","ga_prefix":"020607","images":["http://pic2.zhimg.com/13b4384639ad1a23788836f9d915032d.jpg"],"multipic":true,"type":0,"id":9198401},{"images":["http://pic1.zhimg.com/2bbf77cf77e430910b84674ee26d14bc.jpg"],"type":0,"id":9170945,"ga_prefix":"020607","title":"那些好玩的 3D 立体图如何「骗」了你的眼睛？"},{"images":["http://pic3.zhimg.com/d114542662ddb6b3fb094356fa3e435e.jpg"],"type":0,"id":9197566,"ga_prefix":"020607","title":"在动荡中失去曙光，这就是消费级无人机的 2016 年"},{"images":["http://pic4.zhimg.com/3aba8bf71c97b9e81a7d237d8c566dc3.jpg"],"type":0,"id":9194647,"ga_prefix":"020606","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public static class StoriesBean {
        /**
         * images : ["http://pic4.zhimg.com/3be8f303313f8f9f33700e13ead6057b.jpg"]
         * type : 0
         * id : 9200807
         * ga_prefix : 020622
         * title : 小事 · 哪些不经意发生的事，改变了你的一生？
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
