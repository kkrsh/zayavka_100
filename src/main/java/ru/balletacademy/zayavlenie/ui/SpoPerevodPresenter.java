package ru.balletacademy.zayavlenie.ui;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.ItemCaptionGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import ru.balletacademy.zayavlenie.backend.data.EducationalProgramType;
import ru.balletacademy.zayavlenie.backend.data.entity.PersonalForm;
import ru.balletacademy.zayavlenie.backend.service.FormService;

@SpringComponent
@ViewScope
public class SpoPerevodPresenter extends SpoPresenter
{
    private SpoPerevodView view;

    @Autowired
    public SpoPerevodPresenter(FormService formService)
    {
        super(formService);
    }

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
        PersonalForm form = new PersonalForm();
        refreshView(form);
        lockView();
    }

    private void refreshView(PersonalForm form)
    {
        view.setOrder(form);
    }

    public boolean okPressed()
    {
        // validate
        // store
        // convert to PDF
        // send email

        final PersonalForm form = view.getForm();
        return saveForm(form);
    }
}
