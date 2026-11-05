package com.roshini.task1.Controller;
import java.util.List;
import com.roshini.task1.Model.Expense;
import com.roshini.task1.Service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.swing.text.html.parser.Entity;
// controller which handles request/response
@RestController
public class ExpenseController {
    @GetMapping("/users")
    public String first() {
        return "this is the first expense message";
    }
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @PostMapping("/addUser")
    public ResponseEntity<Expense> expense(@RequestBody Expense expense) {
        Expense savedExpense= expenseService.addExpense(expense);
        return ResponseEntity.status(201).body(savedExpense);
    }
    @GetMapping("/allExpenses")
    public List<Expense> getExpense() {
        return expenseService.getExpense();
    }
    @GetMapping("/expense/{id}")
    public Expense getExpenseById(@PathVariable long id) {
        return expenseService.getExpenseById(id);
    }
    @DeleteMapping("/deleteExpense/{id}")
    public ResponseEntity<String> getDeleteById(@PathVariable long id){
        expenseService.getDeleteById(id);
        return ResponseEntity.ok("deleted successfully");
    }
    @PutMapping("updateExpense/{id}")
    public Expense getUpdateExpense(@PathVariable long id, @RequestBody Expense expense){
        return expenseService.getUpdateExpense(id,expense);
    }

    @GetMapping("/page")
    public Page<Expense> getPageExpense(@RequestParam int page,@RequestParam int size){
        return expenseService.getPageExpense(page,size);
    }

}