package ru.balletacademy.zayavlenie.backend.data.entity;

import ru.balletacademy.zayavlenie.backend.data.EducationalProgramType;
import ru.balletacademy.zayavlenie.backend.data.ProgramTypeConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class PersonalForm extends AbstractEntity
{

// -- ФИО родителя/опекуна
// -- В именительном падеже. Например, Иванов Иван Иванович
    @NotNull
    @Size(min = 1, max = 150)
    private String parentName;

// -- ФИО ребенка
// -- В именительном падеже. Например, Иванова Мария
    @NotNull
    @Size(min = 1, max = 150)
    private String childName;

// -- ФИО ребенка
// -- В винительном падеже. Например, Иванову Марию
    @NotNull
    @Size(min = 1, max = 150)
    private String childNameAccusative;

// -- Дата рождения ребенка
    @NotNull
    private LocalDate childBirthDate;

// -- Гражданство
    @NotNull
    @Size(min = 1, max = 50)
    private String childCitizenship;

// -- Класс/курс:
// -- 2, 3, 4, 5, I (A),II (B),III (C)
// -- K, предпрофессиональная общеобразовательная программа в области хореографического искусства «Искусство балета»
// -- L, программа среднего профессионального образования, интегрированная с программами основного общего и среднего общего образования
// -- M, обучение по дополнительной общеобразовательной общеразвивающей программе «Основы хореографического искусства»
// -- значения: 2,3,4,5, A,B,C, K,L,M
    @NotNull
    @Convert(converter = ProgramTypeConverter.class)
    private EducationalProgramType programType;

// -- Телефон
// -- (___) ___-____
    @NotNull
    @Size(min = 1, max = 20)
    private String phone;

// -- Паспорт родителя/опекуна серия
    @NotNull
    @Size(min = 1, max = 20)
    private String parentPassportSerial;

// -- Паспорт родителя/опекуна №
    @NotNull
    @Size(min = 1, max = 20)
    private String parentPassportNumber;

// -- Кем выдан
    @NotNull
    @Size(min = 1, max = 250)
    private String parentPassportIssuer;

// -- Дата выдачи
    @NotNull
    private LocalDate parentPassportIssueDate;

// -- Адрес проживания
    @NotNull
    @Size(min = 1, max = 250)
    private String parentAddress;

// -- Электронная почта
// -- Ваш личный email, на который будет направлено сформированное заявление и инструкции для дальнейших действий
    @NotNull
    @Size(min = 1, max = 150)
    private String parentEmail;

    public PersonalForm() {
        // Empty constructor is needed by Spring Data / JPA
    }


    public String getParentName()
    {
        return parentName;
    }

    public void setParentName(String parentName)
    {
        this.parentName = parentName;
    }

    public String getChildName()
    {
        return childName;
    }

    public void setChildName(String childName)
    {
        this.childName = childName;
    }

    public String getChildNameAccusative()
    {
        return childNameAccusative;
    }

    public void setChildNameAccusative(String childNameAccusative)
    {
        this.childNameAccusative = childNameAccusative;
    }

    public LocalDate getChildBirthDate()
    {
        return childBirthDate;
    }

    public void setChildBirthDate(LocalDate childBirthDate)
    {
        this.childBirthDate = childBirthDate;
    }

    public String getChildCitizenship()
    {
        return childCitizenship;
    }

    public void setChildCitizenship(String childCitizenship)
    {
        this.childCitizenship = childCitizenship;
    }

    public EducationalProgramType getProgramType()
    {
        return programType;
    }

    public void setProgramType(EducationalProgramType programType)
    {
        this.programType = programType;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getParentPassportSerial()
    {
        return parentPassportSerial;
    }

    public void setParentPassportSerial(String parentPassportSerial)
    {
        this.parentPassportSerial = parentPassportSerial;
    }

    public String getParentPassportNumber()
    {
        return parentPassportNumber;
    }

    public void setParentPassportNumber(String parentPassportNumber)
    {
        this.parentPassportNumber = parentPassportNumber;
    }

    public String getParentPassportIssuer()
    {
        return parentPassportIssuer;
    }

    public void setParentPassportIssuer(String parentPassportIssuer)
    {
        this.parentPassportIssuer = parentPassportIssuer;
    }

    public LocalDate getParentPassportIssueDate()
    {
        return parentPassportIssueDate;
    }

    public void setParentPassportIssueDate(LocalDate parentPassportIssueDate)
    {
        this.parentPassportIssueDate = parentPassportIssueDate;
    }

    public String getParentAddress()
    {
        return parentAddress;
    }

    public void setParentAddress(String parentAddress)
    {
        this.parentAddress = parentAddress;
    }

    public String getParentEmail()
    {
        return parentEmail;
    }

    public void setParentEmail(String parentEmail)
    {
        this.parentEmail = parentEmail;
    }
}
