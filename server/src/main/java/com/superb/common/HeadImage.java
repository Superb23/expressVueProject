package com.superb.common;

public class HeadImage {
    /**
     * 随机返回一个头像
     * @return
     */
    public static String getRandomImage() {
        String[] images = {
                "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/10.jpeg",
                "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/11.jpeg",
                "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/12.jpeg",
                "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/13.jpeg",
                "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/14.jpeg",
                "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/15.jpeg",
                "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/16.jpeg",
                "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/17.jpeg",
                "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/18.jpeg",
                "https://xd-video-pc-img.oss-cn-beijing.aliyuncs.com/xdclass_pro/default/head_img/19.jpeg"
        };
        int randomIndex = (int) Math.floor(Math.random() * 10);

        return images[randomIndex];
    }
}
