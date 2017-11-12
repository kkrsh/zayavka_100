package ru.balletacademy.zayavlenie.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.viritin.layouts.MVerticalLayout;

import javax.annotation.PostConstruct;

@SpringView(name = SelectionView.VIEW_NAME)
public class SelectionView extends VerticalLayout implements View
{
    static final String VIEW_NAME = "selection";

    @PostConstruct
    void init()
    {
        setSizeFull();
        addStyleName("app-shell");
        addComponent(
                new MVerticalLayout()
                        .add(new Label("Выберете желаемый тип заявления:"))
                        .add(createNavigationBar())
        );
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event)
    {
        // ...
    }

    private Component createNavigationBar()
    {
        MVerticalLayout m = new MVerticalLayout().withWidth("300px");
        m.addComponent(createNavButton("Заявление о приёме", Spo1KlassView.VIEW_NAME));
        m.addComponent(createNavButton("Заявление о переводе", SpoPerevodView.VIEW_NAME));
        m.addComponent(createNavButton("Просмотр заявлений", ContentBrowsingView.VIEW_NAME));
        return m;
    }

    private Component createNavButton(String first, String viewName)
    {
        Button button = new Button(first);
        button.addClickListener(e -> getUI().getNavigator()
                                            .navigateTo(viewName));
        button.addStyleName(ValoTheme.BUTTON_LARGE);
        button.addStyleName(ValoTheme.BUTTON_BORDERLESS_COLORED);
        return button;
    }
}
