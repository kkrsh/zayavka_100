package ru.balletacademy.zayavlenie.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;
import ru.balletacademy.zayavlenie.backend.data.EducationalProgramType;

import javax.annotation.PostConstruct;

@SpringView(name = Spo1KlassView.VIEW_NAME)
public class Spo1KlassView extends SpoViewDesign implements View
{
    static final String VIEW_NAME = "spo-1-klass";

    @PostConstruct
    void init()
    {
        super.init();

        setSizeFull();

        addComponent(
                new MVerticalLayout()
                        .add(new Label("Программа среднего профессионального образования, интегрированная с программами основного общего и среднего общего образования."))
                        .add(new MFormLayout()
                                .with(getComponents())
                        ))
        ;
    }
}
