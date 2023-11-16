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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IDCardController {
    private static SqlSession sqlSession;

    static {
        try {
            InputStream is = null;
            is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFindAll() throws IOException {
        IDCardDao mapper = sqlSession.getMapper(IDCardDao.class);
        List<IDCard> idCardList = mapper.findAll();
        for (IDCard idCard : idCardList) {
            System.out.println(idCard);
        }
    }

    @Test
    public void testBatchInsert() throws IOException {
        IDCardDao mapper = sqlSession.getMapper(IDCardDao.class);
        List<IDCard> idCardList = new ArrayList<>();
        int[] ids = new int[]{1, 2, 3, 4, 13, 14};
        for (int i = 0; i < 6; i++) {
            UUID cardNo = UUID.randomUUID();
            Integer uid = ids[i]; // 生成0-5索引匹配id
            System.out.println(cardNo);
            System.out.println(uid);
            IDCard idCard = new IDCard(null, cardNo.toString(), uid);
            idCardList.add(idCard);
        }
        int effectRows = mapper.batchInsert(idCardList);
        System.out.println(effectRows + "条成功");
    }
}
