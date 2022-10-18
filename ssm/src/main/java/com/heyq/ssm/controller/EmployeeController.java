package com.heyq.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.heyq.ssm.pojo.Employee;
import com.heyq.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author heyq
 * @create 2022-10-16-10:48
 * 查询所有的员工信息-->/employee-->get
 * 获取员工分页信息-->/employee/page/1-->get
 * 根据员工id查询员工信息-->/employee/1-->get
 * 跳转到添加也买你-->/employee-->get
 * 添加员工信息-->/employee-->post
 * 修改员工信息-->/employee-->get
 * 删除员工信息-->/employee/1-->get
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //获取员工分页信息
    @RequestMapping(value = "/employee/page/{pageNum}" ,method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum,Model model){
        //获取员工分页信息
        PageInfo<Employee> page=employeeService.getEmployeePage(pageNum);
        //将分页数据共享到请求域中
        model.addAttribute("page" ,page);
        //跳转employee_list.tml
        return "employee_list";

    }


    //添加员工信息
    @RequestMapping(value = "/employee" ,method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeService.insertEmployee(employee);
        return "redirect:/employee/page/1";
    }


    //根据id删除指定用户
    @RequestMapping(value = "/employee/{empId}" ,method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("empId") Integer empId){
        employeeService.deleteEmployee(empId);
        return "redirect:/employee/page/1";
    }



    //根据id查询，并回显到修改页面
    @RequestMapping(value = "/employee/{empId}" ,method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("empId") Integer empId, Model model){
        Employee employee = employeeService.getEmployeeById(empId);
        model.addAttribute("employee" ,employee);
        return "employee_update";
    }

    //根据回显的用户信息进行修改提交
    @RequestMapping(value = "/employee" ,method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        System.out.println(employee.toString());
        employeeService.updateEmployee(employee);
        return "redirect:/employee/page/1";
    }













    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        //查询所有的员工的信息
        List<Employee> list=employeeService.getAllEmployee();
        //将员工的请求域中共享
        model.addAttribute("list",list);
        //跳转employee_list.tml
        return "employee_list";
    }
}
