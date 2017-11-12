package ru.balletacademy.zayavlenie.ui;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.ui.*;
import ru.balletacademy.zayavlenie.backend.data.EducationalProgramType;
import ru.balletacademy.zayavlenie.backend.data.entity.SubmittedForm;

public class SpoViewDesign extends VerticalLayout
{

    protected BeanValidationBinder<SubmittedForm> binder;
    protected boolean hasChanges;

    protected TextField parentName;
    protected TextField childName;
    protected TextField childNameAccusative;
    protected DateField childBirthDate;
    protected TextField childCitizenship;

    protected ComboBox<EducationalProgramType> programType;

    protected TextField phone;
    protected TextField parentPassportSerial;
    protected TextField parentPassportNumber;
    protected TextField parentPassportIssuer;
    protected DateField parentPassportIssueDate;
    protected TextField parentAddress;
    protected TextField parentEmail;

    protected Button cancel;
    protected Button ok;

    void init()
    {
        // 123456789_123456789_123456789_123456789_123456789_123456789_123456789_123456789_12
        parentName = new TextField();
        childName = new TextField();
        childNameAccusative = new TextField();
        childBirthDate = new DateField();
        childCitizenship = new TextField();
        programType = new ComboBox<>();
        phone = new TextField();
        parentPassportSerial = new TextField();
        parentPassportNumber = new TextField();
        parentPassportIssuer = new TextField();
        parentPassportIssueDate = new DateField();
        parentAddress = new TextField();
        parentEmail = new TextField();
        ok = new Button("Сформировать заявление");
        cancel = new Button("Отменить");

        parentName.setCaption("ФИО родителя/опекуна");
        childName.setCaption("ФИО ребенка");
        childNameAccusative.setCaption("ФИО ребенка (в винит. падеже)");
        childBirthDate.setCaption("Дата рождения ребенка");
        childCitizenship.setCaption("Гражданство");
        programType.setCaption("Класс/курс");
        phone.setCaption("Телефон");
        parentPassportSerial.setCaption("Паспорт родителя/опекуна серия");
        parentPassportNumber.setCaption("Паспорт родителя/опекуна №");
        parentPassportIssuer.setCaption("Кем выдан");
        parentPassportIssueDate.setCaption("Дата выдачи");
        parentAddress.setCaption("Адрес проживания");
        parentEmail.setCaption("Электронная почта");

        parentName.setWidth(17f, Unit.CM);
        childName.setWidth(17f, Unit.CM);
        childNameAccusative.setWidth(17f, Unit.CM);
        childBirthDate.setWidth(17f, Unit.CM);
        childCitizenship.setWidth(17f, Unit.CM);
        programType.setWidth(17f, Unit.CM);
        phone.setWidth(17f, Unit.CM);
        parentPassportSerial.setWidth(17f, Unit.CM);
        parentPassportNumber.setWidth(17f, Unit.CM);
        parentPassportIssuer.setWidth(17f, Unit.CM);
        parentPassportIssueDate.setWidth(17f, Unit.CM);
        parentAddress.setWidth(17f, Unit.CM);
        parentEmail.setWidth(17f, Unit.CM);

        parentName.setDescription("В именительном падеже. Например, Иванов Иван Иванович");
        childName.setDescription("В именительном падеже. Например, Иванова Мария");
        childNameAccusative.setDescription("В винительном падеже. Например, Иванову Марию");
        parentPassportIssuer.setDescription("Например, Отделением по району Северное Медведково ОУФМС по гор. Москве в СВАО");
        parentEmail.setDescription("Ваш личный email, на который будет направлено сформированное заявление и инструкции для дальнейших действий");
        cancel.setDescription("Введенные данные будут отправлены нам");
        cancel.setDescription("Введенные данные будут стерты");

        childBirthDate.setDateFormat("dd/MM/yyyy");
        parentPassportIssueDate.setDateFormat("dd/MM/yyyy");

        childName.setCaption("ФИО ребенка");
        childNameAccusative.setCaption("ФИО ребенка (в винит. падеже)");
        childBirthDate.setCaption("Дата рождения ребенка");
        childCitizenship.setCaption("Гражданство");
        programType.setCaption("Класс/курс");
        phone.setCaption("Телефон");
        parentPassportSerial.setCaption("Паспорт родителя/опекуна серия");
        parentPassportNumber.setCaption("Паспорт родителя/опекуна №");
        parentPassportIssuer.setCaption("Кем выдан");
        parentPassportIssueDate.setCaption("Дата выдачи");
        parentAddress.setCaption("Адрес проживания");
        parentEmail.setCaption("Электронная почта");

        // Binder takes care of binding Vaadin fields defined as Java member
        // fields in this class to properties in the Order bean
        binder = new BeanValidationBinder<>(SubmittedForm.class);
        // Bindings are done in the order the fields appear on the screen as we
        // report validation errors for the first invalid field and it is most
        // intuitive for the user that we start from the top if there are
        // multiple errors.
        binder.bindInstanceFields(this);
        // Track changes manually as we use setBean and nested binders
        binder.addValueChangeListener(e -> hasChanges = true);
    }

    Component[] getComponents()
    {
        return new Component[]{
                parentName,
                childName,
                childNameAccusative,
                childBirthDate,
                childCitizenship,
                programType,
                phone,
                parentPassportSerial,
                parentPassportNumber,
                parentPassportIssuer,
                parentPassportIssueDate,
                parentAddress,
                parentEmail,
        };
    }
}
