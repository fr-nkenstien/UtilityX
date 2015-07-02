package com.jarspem.view.bean.common;

import com.jarspem.view.bean.dto.MenuItem;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandLink;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

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
        String text = (String)rc.getAttributes().get("text");
        String link = (String)rc.getAttributes().get("link");
        RichShowDetailItem rsdi = new RichShowDetailItem();
        rsdi.setText(text);
        System.out.println(rsdi.getToolbar());
        
        mainFrame.getChildren().add(rsdi);
        RichPanelGroupLayout pg = new RichPanelGroupLayout();
        RichOutputText ot = new RichOutputText();
        ot.setValue(link);
        pg.getChildren().add(ot);
        for (UIComponent uICom : rsdi.getParent().getChildren()) {
            if (uICom instanceof RichShowDetailItem) {
                ((RichShowDetailItem)uICom).setDisclosed(false);
            }
        }
        rsdi.setDisclosed(true);
    }


    public void setMainFrame(RichPanelTabbed mainFrame) {
        this.mainFrame = mainFrame;
    }

    public RichPanelTabbed getMainFrame() {
        return mainFrame;
    }
}
