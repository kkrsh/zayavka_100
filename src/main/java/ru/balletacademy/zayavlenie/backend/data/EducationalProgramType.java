package ru.balletacademy.zayavlenie.backend.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// -- Класс/курс:
// -- 2, 3, 4, 5, I (A),II (B),III (C)
// -- K, предпрофессиональная общеобразовательная программа в области хореографического искусства «Искусство балета»
// -- L, программа среднего профессионального образования, интегрированная с программами основного общего и среднего общего образования
// -- M, обучение по дополнительной общеобразовательной общеразвивающей программе «Основы хореографического искусства»
// -- значения: 2,3,4,5, A,B,C, K,L,M
public enum EducationalProgramType
{
    CLASS_1("1", "1 класс"),
    CLASS_2("2", "2 класс"), CLASS_3("3", "3 класс"), CLASS_4("4", "4 класс"), CLASS_5("5", "5 класс"),
    CURS_1("A", "I курс"), CURS_2("B", "II курс"), CURS_3("C", "III курс"),
    K("K", "Предпроф"), L("L", "Проф"), M("M", "Основы");

    private static Logger logger = LoggerFactory.getLogger(EducationalProgramType.class);

    private final String dbCode;
    private final String displayName;

    EducationalProgramType(String dbCode, String displayName)
    {
        this.dbCode = dbCode;
        this.displayName = displayName;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public static EducationalProgramType forDisplayName(String displayName)
    {
        for (EducationalProgramType type : values())
        {
            if (displayName.toLowerCase()
                           .equals(type.getDisplayName()
                                       .toLowerCase()))
            {
                return type;
            }
        }
        return null;
    }

    public String getDbCode()
    {
        return dbCode;
    }

    public static EducationalProgramType of(String dbData)
    {
        for (EducationalProgramType type : EducationalProgramType.values())
        {
            if (type.getDbCode()
                    .equals(dbData))
                return type;
        }

        String error = String.format("Unable to convert DB data '%s' to EducationalProgramType!", dbData);
        logger.error(error);
        throw new RuntimeException(error);
    }
}
