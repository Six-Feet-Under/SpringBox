package com.llf.springboot.dao;

import com.llf.springboot.model.FidFile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FidFileMapper {
    List<FidFile> selectList(FidFile fidFile);

    int insertkey(FidFile fidFile);

    int updateByKey(Map map);

    void deleteById(String fid);

    FidFile selectById(String fid);

    List<FidFile> selectAll(Integer len,Integer countNum);

    int insertfidFile(FidFile fidFile);

    int updatefidFile(FidFile fidFile);

    Integer count();
}

