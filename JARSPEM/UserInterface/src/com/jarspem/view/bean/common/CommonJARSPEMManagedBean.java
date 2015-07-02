package com.jarspem.view.bean.common;

import com.jarspem.view.bean.dto.MenuItem;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;

public class CommonJARSPEMManagedBean {
    private RichPanelTabbed mainFrame;

    public CommonJARSPEMManagedBean() {
        super();
        menuList = new ArrayList<MenuItem>();
        for (int i = 0; i < 10; i++) {
            menuList.add(new MenuItem("Label " + i, "Link " + i));
        }
    }

    private List<MenuItem> menuList;

    public void setMenuList(List<MenuItem> menuList) {
        this.menuList = menuList;
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public void menuLinkAL(ActionEvent actionEvent) {
        RichCommandLink rc = (RichCommandLink)actionEvent.getSource();
        System.out.println(rc.getAttributes());
    }

    public void setMainFrame(RichPanelTabbed mainFrame) {
        this.mainFrame = mainFrame;
    }

    public RichPanelTabbed getMainFrame() {
        return mainFrame;
    }
}
