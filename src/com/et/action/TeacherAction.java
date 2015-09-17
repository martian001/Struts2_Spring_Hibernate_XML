package com.et.action;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;

import com.et.base.BaseAction;
import com.et.bean.Teacher;
import com.opensymphony.xwork2.ActionContext;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月21日 下午5:13:32      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class TeacherAction extends BaseAction<Teacher> {
   private Long classId;

   public String list() {
      List<Teacher> teacherList = teacherService.getAll();
      ActionContext.getContext().put("teacherList", teacherList);
      return "list";
   }

   public String delete() {
      Teacher teacher = teacherService.getById(model.getId());
      teacherService.delete(teacher);
      return "toList";
   }

   public String addUI() {
      return "addUI";
   }

   public String editUI() throws IllegalAccessException, InvocationTargetException {
      Teacher teacher = teacherService.getById(model.getId());
      BeanUtilsBean.getInstance().copyProperties(model, teacher);
      return "editUI";
   }

   public String update() {
      Teacher teacher = teacherService.getById(model.getId());
      teacher.setName(model.getName());
      teacherService.saveOrUpdate(teacher);
      return "toList";
   }

   public String add() {
      teacherService.saveOrUpdate(model);
      return "toList";
   }

   public Long getClassId() {
      return classId;
   }

   public void setClassId(Long classId) {
      this.classId = classId;
   }

}
