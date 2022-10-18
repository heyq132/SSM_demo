package com.heyq.ssm.service;

import com.github.pagehelper.PageInfo;
import com.heyq.ssm.pojo.Employee;

import java.util.List;

/**
 * @author heyq
 * @create 2022-10-16-10:58
 */
public interface EmployeeService {
    /**
     * 查询所有的员工的信息
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 获取员工分页信息
     * @return
     */
    PageInfo<Employee> getEmployeePage(Integer pageNum);

    /**
     * 添加员工信息
     * @param employee
     */
    void insertEmployee(Employee employee);

    /**
     * 删除员工信息
     * @param empID
     */
    void deleteEmployee(Integer empID);

    /**
     * 根据id获取员工信息
     * @param empId
     */
    Employee getEmployeeById(Integer empId);

    /**
     * 根据回显的用户信息进行修改提交
     * @param employee
     */
    void updateEmployee(Employee employee);
}
