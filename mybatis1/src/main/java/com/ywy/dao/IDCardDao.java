package com.ywy.dao;

import com.ywy.entity.IDCard;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IDCardDao {
    @Select("select id, card_no cardNo, uid from id_card i")
    List<IDCard> findAll();

    int batchInsert(List<IDCard> idCardList);
}
