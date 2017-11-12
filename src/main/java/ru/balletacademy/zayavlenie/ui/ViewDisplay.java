package ru.balletacademy.zayavlenie.ui;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.themes.ValoTheme;

@SpringViewDisplay
public class ViewDisplay extends Panel implements com.vaadin.navigator.ViewDisplay
{

    public ViewDisplay()
    {
        setStyleName(ValoTheme.PANEL_BORDERLESS);
    }

    @Override
    public void showView(View view)
    {
        // Assuming View's are components, which is often the case
        setContent((Component) view);
    }
}
