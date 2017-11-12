package ru.balletacademy.zayavlenie.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.balletacademy.zayavlenie.HasLogger;
import ru.balletacademy.zayavlenie.backend.FormRepository;
import ru.balletacademy.zayavlenie.backend.data.entity.PersonalForm;

import javax.transaction.Transactional;

@Service
public class FormService implements HasLogger
{
    private final FormRepository formRepository;

    @Autowired
    public FormService(FormRepository formRepository)
    {
        this.formRepository = formRepository;
    }


    @Transactional(rollbackOn = Exception.class)
    public PersonalForm saveForm(PersonalForm form) {
        final PersonalForm savedForm = formRepository.save(form);
        getLogger().info("Saved form for '{}' with parents passport as: '{} {}' under id: '{}'",
                savedForm.getChildName(), savedForm.getParentPassportSerial(), savedForm.getParentPassportNumber(),
                savedForm.getId());
        return savedForm;
    }
}
