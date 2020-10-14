package com.llf.springboot.model;

public class User {

    /** 自增主键 */
    private Long id;
    /** 登陆id 2键 */
    private String uid;
    /** 用户名 */
    private String name;
    /** 密码 */
    private String pwd;
    /** 联系方式*/
    private String phone;
    /** 登陆时间*/
    private Long time;
    /** 退出时间*/
    private Long timeOut;
    /** 创建时间*/
    private Long timeMake;
    /** 用户数据 json格式参数, 启用标记 权限 指纹标记 操作*/
    private String pwdhint;
    /** 创建时间*/
    private String grade;
    /** 创建时间*/
    private String abandon;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPwdhint() {
		return pwdhint;
	}

	public void setPwdhint(String pwdhint) {
		this.pwdhint = pwdhint;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getAbandon() {
		return abandon;
	}

	public void setAbandon(String abandon) {
		this.abandon = abandon;
	}

	public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }

    public Long getTimeMake() {
        return timeMake;
    }

    public void setTimeMake(Long timeMake) {
        this.timeMake = timeMake;
    }

}