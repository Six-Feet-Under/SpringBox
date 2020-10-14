package com.llf.springboot.dao;

import com.llf.springboot.model.Log;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LogMapper {

    List<Log> selectList(Log log);

    int deleteByKey(Long id);

    int insertkey(Map map);

    int updateByKey(Log log);

    Log detailsLog(Log log);
}
