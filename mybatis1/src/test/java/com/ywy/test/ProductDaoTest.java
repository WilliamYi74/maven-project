package com.ywy.test;

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
import java.util.Random;
import java.util.UUID;

public class ProductDaoTest {
    @Test
    public void testBatchInsert() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        IDCardDao mapper = sqlSession.getMapper(IDCardDao.class);
        List<IDCard> idCardList = new ArrayList<>();
        int[] ids = new int[]{1, 2, 3, 4, 13, 14};
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            UUID cardNo = UUID.fromString("CARD_NO");
            Integer uid = ids[random.nextInt(6)]; // 生成0-6随机索引取一个id
            IDCard idCard = new IDCard(null, cardNo.toString(), uid);
            idCardList.add(idCard);
        }
        int effectRows = mapper.batchInsert(idCardList);
        System.out.println(effectRows + "条成功");
    }
}
