package com.otitan.grasslandecology.bean;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by sp on 2019/7/19.
 * 图片
 */
@Entity
public class PicBitmap {

    @Id
    private long id;

    private String bitmap;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBitmap() {
        return bitmap;
    }

    public void setBitmap(String bitmap) {
        this.bitmap = bitmap;
    }
}
