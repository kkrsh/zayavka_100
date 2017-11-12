package ru.balletacademy.zayavlenie.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.balletacademy.zayavlenie.backend.data.entity.SubmittedForm;

public interface FormRepository extends JpaRepository<SubmittedForm, Long>
{
}
