package com.llf.springboot.service;

import com.llf.springboot.model.Log;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LogService {

    Map selectList(Integer pageSize ,Integer pageCount);

    int deleteByKey(Long id);

    int insertkey(Map map);

    int updateByKey(Log log);

    List<Log> selectLogById(Long id);

    Log detailsLog(Log log);

    int deleteByid(Long id);

    int insertLog(Log log);

    int updateById(Log log);

    List selectAll();
}
