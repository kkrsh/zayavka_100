package ru.balletacademy.zayavlenie.ui;


import com.vaadin.data.ValueProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import ru.balletacademy.zayavlenie.backend.FormRepository;
import ru.balletacademy.zayavlenie.backend.data.entity.PersonalForm;

import javax.annotation.PostConstruct;

@SpringView(name = ContentBrowsingView.VIEW_NAME)
public class ContentBrowsingView extends VerticalLayout implements View
{
    static final String VIEW_NAME = "prosmotr";
    private final FormRepository formRepository;

    private Grid<PersonalForm> formGrid;

    @Autowired
    public ContentBrowsingView(FormRepository formRepository)
    {
        this.formRepository = formRepository;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event)
    {
        formGrid.setItems(formRepository.findAll());
        formGrid.addColumn(PersonalForm::getId).setCaption("Id");
        formGrid.addColumn(PersonalForm::getChildName).setCaption("Child's Name");
        formGrid.addColumn(PersonalForm::getChildBirthDate).setCaption("Child's Birthdate");
        formGrid.addColumn(PersonalForm::getParentName).setCaption("Parent Name");
        formGrid.addColumn((ValueProvider<PersonalForm, String>) personalForm ->
                personalForm.getParentPassportSerial() + " "  +personalForm.getParentPassportNumber()).setCaption("Parent Passport");
        formGrid.addColumn((ValueProvider<PersonalForm, String>) personalForm ->
                personalForm.getProgramType().getDisplayName()).setCaption("Program Type");
    }

    @PostConstruct
    void init()
    {
        formGrid = new Grid<>();
        formGrid.setWidth("100%");
        addComponent(formGrid);
    }
}
