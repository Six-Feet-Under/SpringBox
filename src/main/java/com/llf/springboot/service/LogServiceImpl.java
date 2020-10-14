package com.llf.springboot.service;

import com.llf.springboot.dao.LogMapper;
import com.llf.springboot.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    private LogMapper logMapper;


    @Override
    public List<Log> selectList(Log log) {
        return logMapper.selectList(log);
    }

    @Override
    public void deleteByKey(Long id) {
        logMapper.deleteByKey(id);
    }

    @Override
    public int insertkey(Map map) {
//        Log detailsLog = logMapper.detailsLog(log);
        return logMapper.insertkey(map);
    }

    @Override
    public int updateByKey(Log log) {
        return logMapper.updateByKey(log);
    }
}
