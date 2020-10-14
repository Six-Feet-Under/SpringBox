package com.llf.springboot.model;

/**
 * 文件定义
 */
public class FidFile {

    /** 自增主键*/
    private String fid;
	/** 文件标签&分类*/
	private String  tag ;
	/** 创建时间 */
	private Long  makeTime;
	/** 借阅次数 */
	private Long  borrowNumber;
	/** 操作Id */
	public String action;
	/** 操作时间 */
	private Long  actionTime ;
	/** 文件名称 */
	private String fileName;

	/** 文件描述 */
	private String fileDes;
	/** 创建Id */
	private String creatId;
	/** 文件状态 */
	private String fileState;
	/** 文件位置 */
	private Long fileWhere;
	/** 文件标志 */
	private String fileAbandon;
	/** 其他信息 */
	private String dataStr;
	/** 文件权限 */
	public int filePermission = -1;
	/** 文件归属 */
	public String fileAttribution = "";

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Long getMakeTime() {
		return makeTime;
	}

	public void setMakeTime(Long makeTime) {
		this.makeTime = makeTime;
	}

	public Long getBorrowNumber() {
		return borrowNumber;
	}

	public void setBorrowNumber(Long borrowNumber) {
		this.borrowNumber = borrowNumber;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Long getActionTime() {
		return actionTime;
	}

	public void setActionTime(Long actionTime) {
		this.actionTime = actionTime;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDes() {
		return fileDes;
	}

	public void setFileDes(String fileDes) {
		this.fileDes = fileDes;
	}

	public String getCreatId() {
		return creatId;
	}

	public void setCreatId(String creatId) {
		this.creatId = creatId;
	}

	public String getFileState() {
		return fileState;
	}

	public void setFileState(String fileState) {
		this.fileState = fileState;
	}

	public Long getFileWhere() {
		return fileWhere;
	}

	public void setFileWhere(Long fileWhere) {
		this.fileWhere = fileWhere;
	}

	public String getFileAbandon() {
		return fileAbandon;
	}

	public void setFileAbandon(String fileAbandon) {
		this.fileAbandon = fileAbandon;
	}

	public String getDataStr() {
		return dataStr;
	}

	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}

	public int getFilePermission() {
		return filePermission;
	}

	public void setFilePermission(int filePermission) {
		this.filePermission = filePermission;
	}

	public String getFileAttribution() {
		return fileAttribution;
	}

	public void setFileAttribution(String fileAttribution) {
		this.fileAttribution = fileAttribution;
	}
}
