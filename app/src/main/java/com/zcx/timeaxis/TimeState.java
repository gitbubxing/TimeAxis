package com.zcx.timeaxis;

/**
 *  Andy on 2017/8/5.
 *  时间轴状态实体类
 */

public class TimeState {
    //时间
    private String time;
    private String detialTime;
    private String state;
    private String content;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDetialTime() {
        return detialTime;
    }

    public void setDetialTime(String detialTime) {
        this.detialTime = detialTime;
    }
}
