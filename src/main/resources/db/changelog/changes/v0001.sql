
--liquibase formatted sql

--changeset zayavka:1

create table personal_form (

    id bigserial not null,

    version int not null,

-- ФИО родителя/опекуна
-- В именительном падеже. Например, Иванов Иван Иванович
    parent_name varchar(150) not null,

-- ФИО ребенка
-- В именительном падеже. Например, Иванова Мария
    child_name varchar(150) not null,

-- ФИО ребенка
-- В винительном падеже. Например, Иванову Марию
    child_name_accusative  varchar(150) not null,

-- Дата рождения ребенка
    child_birth_date date not null,

-- Гражданство
    child_citizenship varchar(50) not null,

-- Класс/курс:
-- 2, 3, 4, 5, I (A),II (B),III (C)
-- K, предпрофессиональная общеобразовательная программа в области хореографического искусства «Искусство балета»
-- L, программа среднего профессионального образования, интегрированная с программами основного общего и среднего общего образования
-- M, обучение по дополнительной общеобразовательной общеразвивающей программе «Основы хореографического искусства»
-- значения: 2,3,4,5, A,B,C, K,L,M
   program_type char(1) not null,

-- Телефон
-- (___) ___-____
    phone varchar(20) not null,

-- Паспорт родителя/опекуна серия
    parent_passport_serial varchar(20) not null,

-- Паспорт родителя/опекуна №
    parent_passport_number varchar(20) not null,

-- Кем выдан
    parent_passport_issuer varchar(250) not null,

-- Дата выдачи
    parent_passport_issue_date date not null,

-- Адрес проживания
    parent_address varchar(250) not null,

-- Электронная почта
-- Ваш личный email, на который будет направлено сформированное заявление и инструкции для дальнейших действий
    parent_email varchar(150) not null,

    primary key (id)
);
