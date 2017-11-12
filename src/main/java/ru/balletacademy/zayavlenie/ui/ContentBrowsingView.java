package ru.balletacademy.zayavlenie.ui;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

@SpringView(name = ContentBrowsingView.VIEW_NAME)
public class ContentBrowsingView extends VerticalLayout implements View
{
    static final String VIEW_NAME = "prosmotr";   

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event)
    {
    }

    @PostConstruct
    void init()
    {
        addComponent(new Label("Hello, welcome to " + VIEW_NAME));
    }
}
