package ru.balletacademy.zayavlenie.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MHorizontalLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;
import ru.balletacademy.zayavlenie.backend.data.entity.PersonalForm;

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
        ok.setEnabled(true);
        ok.setDisableOnClick(true);
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
        ok.addClickListener(e -> {
            if (presenter.okPressed())
            {
                Notification.show("Спасибо. Ваше заявление сформировано.", Notification.Type.HUMANIZED_MESSAGE);
                presenter.allDone();
            } else {
                ok.setEnabled(true); // error - re-enable ok button
            }
        });
    }

    public void setOrder(PersonalForm form)
    {
        binder.setBean(form);
        hasChanges = false;
    }

    public PersonalForm getForm()
    {
        return binder.getBean();
    }
}
