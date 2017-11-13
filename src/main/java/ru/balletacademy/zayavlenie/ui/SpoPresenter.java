package ru.balletacademy.zayavlenie.ui;

import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.Registration;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import org.springframework.dao.OptimisticLockingFailureException;
import ru.balletacademy.zayavlenie.HasLogger;
import ru.balletacademy.zayavlenie.backend.data.entity.PersonalForm;
import ru.balletacademy.zayavlenie.backend.service.FormService;

import javax.validation.ValidationException;
import java.io.Serializable;

public class SpoPresenter implements Serializable, HasLogger
{
    private Registration listenerRegistration;
    private final FormService formService;

    public SpoPresenter(FormService formService)
    {
        this.formService = formService;
    }

    void lockView()
    {
        listenerRegistration = UI
                .getCurrent()
                .getNavigator()
                .addViewChangeListener((ViewChangeListener) e -> false);
    }

    void unlockView()
    {
        listenerRegistration.remove();
    }

    public void allDone()
    {
        unlockView();
        UI.getCurrent()
          .getNavigator()
          .navigateTo(SelectionView.VIEW_NAME);
    }

    public void cancelPressed()
    {
        allDone();
    }

    public boolean saveForm(PersonalForm form)
    {
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
}
