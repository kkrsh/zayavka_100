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
public class Spo1KlassPresenter extends SpoPresenter
{
    private Spo1KlassView view;

    @Autowired
    public Spo1KlassPresenter(FormService formService)
    {
        super(formService);
    }

    void init(Spo1KlassView view)
    {
        this.view = view;

        view.programType.setVisible(false);
        view.programType.setItemCaptionGenerator(
                (ItemCaptionGenerator<EducationalProgramType>) EducationalProgramType::getDisplayName);
        view.programType.setItems(EducationalProgramType.CLASS_1);
        view.programType.setEmptySelectionAllowed(false);
    }

    void enterView(ViewChangeListener.ViewChangeEvent event)
    {
        PersonalForm form = new PersonalForm();
        form.setProgramType(EducationalProgramType.CLASS_1);
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
