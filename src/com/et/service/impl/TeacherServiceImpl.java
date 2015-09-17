package com.et.service.impl;

import com.et.base.BaseServiceImpl;
import com.et.bean.Teacher;
import com.et.dao.TeacherDao;
import com.et.service.TeacherService;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月21日 下午5:15:21      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements TeacherService {
   private TeacherDao teacherDao;

   public TeacherDao getTeacherDao() {
      return teacherDao;
   }

   public void setTeacherDao(TeacherDao teacherDao) {
      this.teacherDao = teacherDao;
   }
}
