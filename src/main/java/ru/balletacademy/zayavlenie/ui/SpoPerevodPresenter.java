package ru.balletacademy.zayavlenie.ui;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.Registration;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import com.vaadin.ui.ItemCaptionGenerator;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import ru.balletacademy.zayavlenie.HasLogger;
import ru.balletacademy.zayavlenie.backend.data.EducationalProgramType;
import ru.balletacademy.zayavlenie.backend.data.entity.PersonalForm;
import ru.balletacademy.zayavlenie.backend.service.FormService;

import javax.validation.ValidationException;
import java.io.Serializable;

@SpringComponent
@ViewScope
public class SpoPerevodPresenter implements Serializable, HasLogger
{
    private final FormService formService;

    private SpoPerevodView view;
    private Registration   listenerRegistration;

    @Autowired
    public SpoPerevodPresenter(FormService formService)
    {
        this.formService = formService;
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
        listenerRegistration = UI
                .getCurrent()
                .getNavigator()
                .addViewChangeListener((ViewChangeListener) e -> false);
    }

    private void refreshView(PersonalForm form)
    {
        view.setOrder(form);
    }

    public void cancelPressed()
    {
        allDone();
    }

    public boolean okPressed()
    {
        // validate
        // store
        // convert to PDF
        // send email

        final PersonalForm form = view.getForm();
        try
        {
            formService.saveForm(form);
            return true;
        } catch (ValidationException e)
        {
            // Should not get here if validation is setup properly
            Notification.show("Ошибка! Все поля должны быть заполнены.", Notification.Type.ERROR_MESSAGE);
            getLogger().error("Validation error during form for " + form.getChildName());
        } catch (OptimisticLockingFailureException e)
        {
            // Somebody else probably edited the data at the same time. Should never happen as we always make a new form.
            Notification.show("Извините. Произошла системная ошибка. Попробуйте позже или сообщитенам об ошибке по электронной почте.", Notification.Type.ERROR_MESSAGE);
            getLogger().debug("Optimistic locking error while saving form for " + form.getChildName(), e);
        } catch (Exception e)
        {
            // Something went wrong, no idea what
            Notification.show("Извините. Произошла системная ошибка. Попробуйте позже или сообщитенам об ошибке по электронной почте.", Notification.Type.ERROR_MESSAGE);
            getLogger().error("Unable to save form for " + form.getChildName(), e);
        }

        return false;
    }

    public void allDone()
    {
        listenerRegistration.remove();
        UI.getCurrent()
          .getNavigator()
          .navigateTo(SelectionView.VIEW_NAME);
    }
}
