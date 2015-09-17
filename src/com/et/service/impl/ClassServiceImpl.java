package com.et.service.impl;

import com.et.base.BaseServiceImpl;
import com.et.bean.Classe;
import com.et.dao.ClassDao;
import com.et.service.ClassService;

/**
 ★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆            @author： The One                  ☆★
★☆            @time：2014年11月20日 下午9:08:28      ☆★
★☆            @version：1.0                      ☆★
★☆            @lastMotifyTime：                                                      ☆★
★☆            @ClassAnnotation：                                                   ☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
 */
public class ClassServiceImpl extends BaseServiceImpl<Classe> implements ClassService {
   private ClassDao classDao;

   public ClassDao getClassDao() {
      return classDao;
   }

   public void setClassDao(ClassDao classDao) {
      this.classDao = classDao;
   }

}
