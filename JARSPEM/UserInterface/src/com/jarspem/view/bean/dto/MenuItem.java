package com.jarspem.view.bean.dto;

public class MenuItem {
    public MenuItem() {
        super();
    }

    private String label, link;

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
