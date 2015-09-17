package com.et.action;

import org.apache.struts2.ServletActionContext;

import com.et.bean.Student;
import com.et.service.StudentService;
import com.opensymphony.xwork2.ModelDriven;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月19日 下午5:27:14      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class LoginAction implements ModelDriven<Student> {
   private StudentService studentService;
   private Student student = new Student();

   public String execute() {
      Student loginstudent = getStudentService().login(student);
      if (loginstudent == null) {
         return "login";
      }
      ServletActionContext.getRequest().setAttribute("loginstudent", loginstudent);
      return "succeed";
   }

   public LoginAction() {
      System.out.println("登录action");
   }

   public Student getStudent() {
      return student;
   }

   public void setStudent(Student student) {
      this.student = student;
   }

   @Override
   public Student getModel() {
      return student;
   }

   public StudentService getStudentService() {
      return studentService;
   }

   public void setStudentService(StudentService studentService) {
      this.studentService = studentService;
      System.out.println("LoginAction.setStudentService()");
   }

}
