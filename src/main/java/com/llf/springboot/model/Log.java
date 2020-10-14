package com.llf.springboot.model;

 
/**
 * 操作日志
 */ 
public class Log {
 
    private Long id;             // 数据库主键
    private String types;        // 日志类型
    private String actionId;        // 操作Id
    private String actionResult;    // 操作结果 0 无, -1失败, 1成功
    private String uid;          // 用户id
    private String target;       // 目标
    private Long time;           // 操作时间
    private String dataStr;      // 备用数据

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getActionResult() {
        return actionResult;
    }

    public void setActionResult(String actionResult) {
        this.actionResult = actionResult;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getDataStr() {
        return dataStr;
    }

    public void setDataStr(String dataStr) {
        this.dataStr = dataStr;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", types='" + types + '\'' +
                ", actionId='" + actionId + '\'' +
                ", actionResult='" + actionResult + '\'' +
                ", uid='" + uid + '\'' +
                ", target='" + target + '\'' +
                ", time=" + time +
                ", dataStr='" + dataStr + '\'' +
                '}';
    }
}
