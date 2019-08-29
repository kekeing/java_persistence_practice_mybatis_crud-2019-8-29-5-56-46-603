package tws.repository;

import org.apache.ibatis.annotations.*;
import tws.entity.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<Employee> selectAll();
    void insertEmployees(@Param("employee") Employee employee);
    void updateEmployeeById(@Param("employee") Employee employee);
    void deleteEmployeeById(@Param("id") int id);
    Employee getEmployeeById(@Param("id") int id);


}
