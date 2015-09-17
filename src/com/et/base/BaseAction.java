package com.et.base;

import java.lang.reflect.ParameterizedType;

import org.apache.log4j.Logger;

import com.et.service.ClassService;
import com.et.service.StudentService;
import com.et.service.TeacherService;
import com.opensymphony.xwork2.ModelDriven;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月22日 下午12:45:05     ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public abstract class BaseAction<T> implements ModelDriven<T> {
   protected T model;
   protected StudentService studentService;
   protected ClassService classService;
   protected TeacherService teacherService;
   protected Logger logger = Logger.getLogger(BaseAction.class);

   public BaseAction() {
      System.out.println("BaseAction.BaseAction()");
      // 通过反射技术得到T的真是类型
      ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();// 获取当前new对象 的泛型的 父类类型
      Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];// 获取第一个类型参数的真实类型
      try {
         // 实例化
         model = clazz.newInstance();
         System.out.println(model);
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   @Override
   public T getModel() {
      return model;
   }

   public StudentService getStudentService() {
      return studentService;
   }

   public void setStudentService(StudentService studentService) {
      this.studentService = studentService;
   }

   public ClassService getClassService() {
      return classService;
   }

   public void setClassService(ClassService classService) {
      this.classService = classService;
   }

   public TeacherService getTeacherService() {
      return teacherService;
   }

   public void setTeacherService(TeacherService teacherService) {
      this.teacherService = teacherService;
   }

   public void setModel(T model) {
      this.model = model;
   }

}
