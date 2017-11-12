package ru.balletacademy.zayavlenie.ui;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.ItemCaptionGenerator;
import com.vaadin.ui.UI;
import ru.balletacademy.zayavlenie.HasLogger;
import ru.balletacademy.zayavlenie.backend.data.EducationalProgramType;
import ru.balletacademy.zayavlenie.backend.data.entity.SubmittedForm;

import java.io.Serializable;

@SpringComponent
@ViewScope
public class SpoPerevodPresenter implements Serializable, HasLogger
{
    private SpoPerevodView view;

    void init(SpoPerevodView view)
    {
        this.view = view;

        view.programType.setItemCaptionGenerator(
                (ItemCaptionGenerator<EducationalProgramType>) EducationalProgramType::getDisplayName);
        view.programType
                .setItems(
                        EducationalProgramType.CLASS_2,
                        EducationalProgramType.CLASS_3,
                        EducationalProgramType.CLASS_4,
                        EducationalProgramType.CLASS_5,
                        EducationalProgramType.CURS_1,
                        EducationalProgramType.CURS_2,
                        EducationalProgramType.CURS_3
                );
        view.programType.setEmptySelectionAllowed(false);
    }

    void enterView(ViewChangeListener.ViewChangeEvent event)
    {
        SubmittedForm form = new SubmittedForm();
        refreshView(form);
    }

    private void refreshView(SubmittedForm form)
    {
        view.setOrder(form);
    }

    public void cancelPressed()
    {
        UI.getCurrent()
          .getNavigator()
          .navigateTo(SelectionView.VIEW_NAME);
    }

    public void okPressed()
    {
        // validate
        // store
        // convert to PDF
        // send email
    }
}
