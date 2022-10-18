package com.heyq.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heyq.ssm.mapper.EmployeeMapper;
import com.heyq.ssm.pojo.Employee;
import com.heyq.ssm.service.EmployeeService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author heyq
 * @create 2022-10-16-10:58
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum ,8);
        //查询所有的员工信息
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关数据
        PageInfo<Employee> page=new PageInfo<Employee>(list,3);
        return page;
    }

    public void insertEmployee(Employee employee) {
        employeeMapper.insertEmployee(employee);
    }

    public void deleteEmployee(Integer empID) {
        employeeMapper.deleteEmployee(empID);
    }

    public Employee getEmployeeById(Integer empId) {
        return employeeMapper.getEmployeeById(empId);
    }

    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }


}
