package com.et.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtilsBean;

import com.et.base.BaseAction;
import com.et.bean.Classe;
import com.et.bean.Student;
import com.opensymphony.xwork2.ActionContext;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月20日 下午3:07:42      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class StudentAction extends BaseAction<Student> {
   private InputStream inputStream;
   private Long classeId;

   public String list() {
      logger.info("list,params:" + model);
      List<Student> studentList = studentService.getAll();
      ActionContext.getContext().put("studentList", studentList);
      return "list";
   }

   public String delete() {
      studentService.delete(model);
      return "toList";
   }

   public String addUI() {
      model = new Student();
      List<Classe> classeList = classService.getAll();
      ActionContext.getContext().put("classeList", classeList);
      return "addUI";
   }

   public String editUI() throws IllegalAccessException, InvocationTargetException {
      // 拷贝
      Student editStudent = studentService.getById(model.getId());
      BeanUtilsBean.getInstance().copyProperties(model, editStudent);
      if (editStudent.getClasse() != null) {
         setClasseId(editStudent.getClasse().getId());
      }
      List<Classe> classeList = classService.getAll();
      ActionContext.getContext().put("classeList", classeList);
      return "editUI";
   }

   public String update() {
      Student updateStudent = studentService.getById(model.getId());
      Classe classe = classService.getById(getClasseId());
      updateStudent.setClasse(classe);
      updateStudent.setName(model.getName());
      updateStudent.setPassword(model.getPassword());
      studentService.saveOrUpdate(updateStudent);
      return "toList";
   }

   public String add() {
      Classe classe = classService.getById(getClasseId());
      model.setClasse(classe);
      studentService.saveOrUpdate(model);
      return "toList";
   }

   public String nameIsExist() throws UnsupportedEncodingException {
      boolean bool = studentService.nameIsExist(model.getName());
      if (bool) {
         setInputStream(new ByteArrayInputStream("1".getBytes("utf-8")));
      } else {
         setInputStream(new ByteArrayInputStream("0".getBytes("utf-8")));
      }
      return "ajax_success";
   }

   public StudentAction() {
      System.out.println("StudentAction.StudentAction()构造器");
   }

   public InputStream getInputStream() {
      return inputStream;
   }

   public void setInputStream(InputStream inputStream) {
      this.inputStream = inputStream;
   }

   public Long getClasseId() {
      return classeId;
   }

   public void setClasseId(Long classeId) {
      this.classeId = classeId;
   }

}
