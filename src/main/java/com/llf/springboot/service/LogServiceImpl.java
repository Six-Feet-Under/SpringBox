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
    public List<Log> selectList(Integer pageSize ,Integer pageCount) {
        return logMapper.selectList(pageSize,pageCount);
    }

    @Override
    public int deleteByKey(Long id) {
        return logMapper.deleteByKey(id);
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

    @Override
    public List<Log> selectLogById(Long id) {
        return logMapper.selectLogById(id);
    }

    @Override
    public Log detailsLog(Log log) {
        return logMapper.detailsLog(log);
    }

    @Override
    public int deleteByid(Long id) {
        return logMapper.deleteByid(id);
    }

    @Override
    public int insertLog(Log log) {
        return logMapper.insertLog(log);
    }

    @Override
    public int updateById(Log log) {
        return logMapper.updateById(log);
    }

}
