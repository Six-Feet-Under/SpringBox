package com.llf.springboot.dao;

import com.llf.springboot.model.Log;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LogMapper {

    List<Log> selectList(Integer pageSize ,Integer pageCount);

    int deleteByKey(Long id);

    int insertkey(Map map);

    int updateByKey(Log log);

    Log detailsLog(Log log);

    List<Log> selectLogById(Long id);

    int deleteByid(Long id);

    int insertLog(Log log);

    int updateById(Log log);
}
