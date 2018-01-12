package com.zll.common.pojo;

/**
 * 分页实体
 * @Author: zhangll
 * @Date: 2018/1/12  17:13
 */
public class PageModel {
	/** 页码 */
	private Integer pageNo = 1;
	/** 当前记录起始索引 */
	private Integer startRow = 0;
	/** 每页数量 */
	private Integer pageSize = 10;
	/** 排序字段 */
	private String sortName;
	/** 排序类型 */
	private String sortOrder = "asc";

	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getStartRow() {
		startRow = (getPageNo() - 1) * getPageSize();
		if (startRow < 0) {
			startRow = 0;
		}
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
}
