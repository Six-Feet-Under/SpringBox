package com.llf.springboot.service;

import com.llf.springboot.model.FidFile;
import com.llf.springboot.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FidFileService {

    List<FidFile> selectList(FidFile fidFile);

    int insertkey(FidFile fidFile);

    int updateByKey(Map map);

    void deleteById(String fid);

    FidFile selectById(String fid);
}
