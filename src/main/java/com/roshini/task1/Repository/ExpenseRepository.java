package com.roshini.task1.Repository;
import com.roshini.task1.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
