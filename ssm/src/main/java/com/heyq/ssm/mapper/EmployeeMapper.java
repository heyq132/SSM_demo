package com.heyq.ssm.mapper;

import com.heyq.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author heyq
 * @create 2022-10-16-11:06
 */
public interface EmployeeMapper {

    /**
     * 查询所有的员工的信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 添加员工信息
     * @param employee
     */
    void insertEmployee(Employee employee);

    /**
     * 删除员工信息
     * @param empId
     */
    void deleteEmployee(@Param("empId") Integer empId);

    /**
     * 根据员工id获取获取员工信息
     * @param empId
     * @return
     */
    Employee getEmployeeById(@Param("empId") Integer empId);

    /**
     * 根据回显的用户信息进行修改提交
     * @param employee
     */
    void updateEmployee(Employee employee);
}
