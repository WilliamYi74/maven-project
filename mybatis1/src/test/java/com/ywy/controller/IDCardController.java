package com.ywy.controller;

import com.ywy.dao.IDCardDao;
import com.ywy.entity.IDCard;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class IDCardController {
    @Test
    public void testFindAll() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IDCardDao mapper = sqlSession.getMapper(IDCardDao.class);
        List<IDCard> idCardList = mapper.findAll();
        for (IDCard idCard : idCardList) {
            System.out.println(idCard);
        }
    }
}
