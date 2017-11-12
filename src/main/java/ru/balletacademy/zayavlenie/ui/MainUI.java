package ru.balletacademy.zayavlenie.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringNavigator;
import com.vaadin.ui.UI;
import org.vaadin.viritin.layouts.MVerticalLayout;

import java.util.Locale;

@SpringUI(path = "/zayavlenie")
@Theme("apptheme")
public class MainUI extends UI
{
    private final ViewDisplay mainContent;
    private final Navigator navigator;

    public MainUI(ViewDisplay mainContent, SpringNavigator navigator)
    {
        this.mainContent = mainContent;
        this.navigator = navigator;

    }

    @Override
    protected void init(VaadinRequest request)
    {
        Locale locale = new Locale("ru");
        this.setLocale( locale ); // Call to affect this current UI. Workaround for bug: http://dev.vaadin.com/ticket/12350
        this.getSession().setLocale( locale ); // Affects only future UI instances, not current one because of bug. See workaround in line above.
        // VaadinSession.getCurrent().setLocale( locale ); // Alternative to "this.getSession".

        setContent(new MVerticalLayout().expand(mainContent).withFullHeight());
        navigator.navigateTo(SelectionView.VIEW_NAME);
    }
}
