package com.llf.springboot.service;

import com.llf.springboot.dao.FidFileMapper;
import com.llf.springboot.model.FidFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FidFileServiceImpl implements FidFileService{

    @Autowired
    private FidFileMapper fidFileMapper;

    @Override
    public List<FidFile> selectList(FidFile fidFile) {
        return fidFileMapper.selectList(fidFile);
    }

    @Override
    public int insertkey(FidFile fidFile) {
        try {
            fidFileMapper.insertkey(fidFile);
            return 1;
        } catch (Exception e){
            return 0;
        }
    }

    @Override
    public int updateByKey(Map map) {
        try {
            fidFileMapper.updateByKey(map);
            return 1;
        } catch (Exception e){
            return 0;
        }
    }

    @Override
    public void deleteById(String fid) {
        fidFileMapper.deleteById(fid);
    }

    @Override
    public FidFile selectById(String fid) {
        return fidFileMapper.selectById(fid);
    }

    @Override
    public Map selectAll(Integer pageNum,Integer countNum) {
        Map map = new HashMap();
        map.put("list",fidFileMapper.selectAll(pageNum,countNum));
        map.put("count",fidFileMapper.count());
        return map;
    }

    @Override
    public int insertfidFile(FidFile fidFile) {
        try{
            fidFileMapper.insertfidFile(fidFile);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int updatefidFile(FidFile fidFile) {
        try {
            fidFileMapper.updatefidFile(fidFile);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public List listFile() {
        return fidFileMapper.listFile();
    }
}
