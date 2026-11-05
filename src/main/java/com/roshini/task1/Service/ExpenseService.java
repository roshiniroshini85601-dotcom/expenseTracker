package com.roshini.task1.Service;

import java.util.List;

import com.roshini.task1.Dto.RequestDto;
import com.roshini.task1.Dto.ResponseDto;
import com.roshini.task1.Exception.ExpenseException;
import com.roshini.task1.Model.Expense;
import com.roshini.task1.Repository.ExpenseRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public List<Expense> getExpense() {
        return expenseRepository.findAll();
    }
    public Expense getExpenseById(long id ) {
        return expenseRepository.findById(id).orElseThrow(()->
                new ExpenseException("expense not with "+id+" not found"));
    }
    public void getDeleteById(long id){
        expenseRepository.deleteById(id);
    }
    public Expense getUpdateExpense(long id,Expense expense){

        Expense existingExpense=expenseRepository.findById(id).orElse(null);
        if(existingExpense!=null){
            existingExpense.setTitle(expense.getTitle());
            existingExpense.setName(expense.getName());
            existingExpense.setAmount(expense.getAmount());
           return expenseRepository.save(existingExpense);
        }
        return null;
    }

    public Page<Expense> getPageExpense(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        // this is object which makes the page page by page
    return expenseRepository.findAll(pageable);
    }



}