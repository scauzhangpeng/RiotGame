package com.muugi.album;

import java.io.File;

/**
 * Created by ZP on 2018/9/18.
 */

public class WrapperFile {

    public WrapperFile(File file, boolean selected) {
        this.file = file;
        this.selected = selected;
    }

    private File file;

    private boolean selected;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getParent() {
        return getFile().getParent();
    }


    public String getAbsolutePath() {
        return getFile().getAbsolutePath();
    }
}
