package ru.balletacademy.zayavlenie.backend.data;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ProgramTypeConverter implements AttributeConverter<EducationalProgramType, String>
{

    @Override
    public String convertToDatabaseColumn(EducationalProgramType attribute)
    {
        return attribute.getDbCode();
    }

    @Override
    public EducationalProgramType convertToEntityAttribute(String dbData)
    {
        return EducationalProgramType.of(dbData);
    }
}
