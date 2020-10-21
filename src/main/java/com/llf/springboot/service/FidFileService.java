package com.llf.springboot.service;

import com.llf.springboot.model.FidFile;
import com.llf.springboot.model.User;
import com.llf.springboot.util.ResponseJSONResult;
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

    Map selectAll(Integer pageNum,Integer countNum,String txt);

    int insertfidFile(FidFile fidFile);

    int updatefidFile(FidFile fidFile);

    List listFile();
}
