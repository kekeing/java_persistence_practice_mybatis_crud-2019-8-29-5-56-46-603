package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertEmployees(@RequestBody Employee employee){
        employeeMapper.insertEmployees(employee);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployees(@RequestBody Employee employee){
        employeeMapper.updateEmployeeById(employee);

    }
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployees(@PathVariable("id") int id){
        employeeMapper.deleteEmployeeById(id);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Employee getEmployeeById(@PathVariable("id") int id){
        return  employeeMapper.getEmployeeById(id);
    }


}
