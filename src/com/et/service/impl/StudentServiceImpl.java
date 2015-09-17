package com.et.service.impl;

import com.et.base.BaseServiceImpl;
import com.et.bean.Student;
import com.et.dao.StudentDao;
import com.et.service.StudentService;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月20日 下午9:09:01      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {
   private StudentDao studentDao;

   public StudentDao getStudentDao() {
      return studentDao;
   }

   public void setStudentDao(StudentDao studentDao) {
      this.studentDao = studentDao;
      System.out.println("StudentServiceImpl.setStudentDao()");
   }

   @Override
   public Student login(Student student) {
      return studentDao.login(student);
   }

   @Override
   public boolean nameIsExist(String name) {
      return studentDao.nameIsExist(name);
   }
}
