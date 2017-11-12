package ru.balletacademy.zayavlenie.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;
import ru.balletacademy.zayavlenie.backend.data.EducationalProgramType;
import ru.balletacademy.zayavlenie.backend.data.entity.SubmittedForm;

import javax.annotation.PostConstruct;

@SpringView(name = SpoPerevodView.VIEW_NAME)
public class SpoPerevodView extends SpoViewDesign implements View
{
    static final String VIEW_NAME = "spo-perevod";

    private final SpoPerevodPresenter presenter;

    @Autowired
    public SpoPerevodView(SpoPerevodPresenter presenter)
    {
        this.presenter = presenter;
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event)
    {
        presenter.enterView(event);
    }

    @PostConstruct
    void init()
    {
        super.init();

        presenter.init(this);

        setSizeFull();

        addComponent(
                new MVerticalLayout()
                        .add(new Label("Программа среднего профессионального образования, интегрированная с программами основного общего и среднего общего образования."))
                        .add(new MFormLayout().with(getComponents()))
                        .add(new MHorizontalLayout().add(ok, cancel))
        );

        cancel.addClickListener(e -> presenter.cancelPressed());
        ok.addClickListener(e -> presenter.okPressed());
    }

    public void setOrder(SubmittedForm form)
    {
        binder.setBean(form);
        hasChanges = false;
    }
}
