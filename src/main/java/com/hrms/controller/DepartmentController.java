package com.hrms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hrms.domain.Department;
import com.hrms.domain.Employee;
import com.hrms.service.DepartmentService;
import com.hrms.util.JsonMsg;
@Controller
@RequestMapping(value = "/dept")
public class DepartmentController {
        
	@Autowired
    DepartmentService departmentService;
	
	  /**
     * 分页查询：返回指定页数对应的数据
     * @param pageNo
     * @return
     */
    @RequestMapping(value = "/getDeptList", method = RequestMethod.GET)
    public ModelAndView getDeptList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo){
        ModelAndView mv = new ModelAndView("departmentPage");
        //每页显示的记录行数
        int limit = 5;
        //总记录数
        int totalItems = departmentService.countDepts();
        int temp = totalItems / limit;
        int totalPages = (totalItems % limit== 0) ? temp : temp+1;
        //每页的起始行(offset+1)数据，如第一页(offset=0，从第1(offset+1)行数据开始)
        int offset = (pageNo - 1)*limit;
        List<Department> departments = departmentService.getDeptList(offset, limit);

        mv.addObject("departments", departments)
                .addObject("totalItems", totalItems)
                .addObject("totalPages", totalPages)
                .addObject("curPageNo", pageNo);
        return mv;
    }
    /**
     * 查询所有部门名称
     * @return
     */
       @RequestMapping(value = "/getDeptName" , method=RequestMethod.GET)
       @ResponseBody
       public JsonMsg getDeptName() {
  	      List<Department> departmentList = departmentService.selectDeptList();
  	     /* System.out.println("=======================");
  	      System.out.println(departmentList);
  	    System.out.println("=======================");*/
  	      if(departmentList != null) {
  	    	  return JsonMsg.success().addInfo("departmentList", departmentList);
  	      }
           return JsonMsg.fail();
       }
       /*
        * getDeptById
        * */
       @RequestMapping(value = "/getDeptById/{deptId}" , method=RequestMethod.GET)
       @ResponseBody
       public JsonMsg getDeptById(@PathVariable("deptId") Integer deptId){
           Department department = null;
           if (deptId > 0){
               department = departmentService.getDeptById(deptId);
               System.out.println(department);
           }
           if (department != null){
               return JsonMsg.success().addInfo("department", department);
           }
           return JsonMsg.fail().addInfo("get_dept_error", "无部门信息");
       }
       
       /*
        * addDept
        * */
       @RequestMapping(value = "/addDept" , method=RequestMethod.PUT)
       @ResponseBody
       public JsonMsg addDept(Department dept){
    	   int d = departmentService.addDept(dept);
    	   if(d !=1) {
    		   return JsonMsg.fail().addInfo("add_dept_error", "添加异常！");
    	   }
    	   return JsonMsg.success();
       }
       
       /**
        * deleteDept
        * */
       @RequestMapping(value = "/deleteDept/{deptId}" , method=RequestMethod.DELETE)
       @ResponseBody
       public JsonMsg deleteDept(@PathVariable("deptId") Integer deptId){
    	   int res = 0;
           if (deptId > 0){
               res = departmentService.deleteDept(deptId);
           }
           if (res != 1){
               return JsonMsg.fail().addInfo("dept_del_error", "员工删除异常");
           }
           return JsonMsg.success();
    	   
       }
       /*
        * updateDept
        * */
       @RequestMapping(value = "/updateDept/{deptId}" , method=RequestMethod.POST)
       @ResponseBody
       public JsonMsg updateDept(@PathVariable("deptId") Integer deptId,  Department department){
    	   int d = departmentService.updateDeptById(deptId ,department);
    	   if(d !=1) {
    		   return JsonMsg.fail().addInfo("add_dept_error", "添加异常！");
    	   }
    	   return JsonMsg.success();
       }
       /**
        * 新增记录后，查询最新的页数
        * @return
        */
       @RequestMapping(value = "/getTotalPages", method = RequestMethod.GET)
       @ResponseBody
       public JsonMsg getTotalPage(){
           int totalItems = departmentService.countDepts();
           //获取总的页数
           int temp = totalItems / 5;
           int totalPages = (totalItems % 5 == 0) ? temp : temp+1;
           return JsonMsg.success().addInfo("totalPages", totalPages);
       }

}
