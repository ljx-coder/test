package util;

import java.util.List;

public class Page<T> {// 当做一个工具类
	private Integer pageNo = 1;// 当前页数
	private Integer pageSize = 5;// 每页包含记录数
	private Long pageCount;// 总页数,通过总记录数计算得出
	private List<T> pageData;// 分页后的数据

	public Page() {
		super();
	}

	public Page(Integer pageNo, Integer pageSize, Long pageCount,
			List<T> pageData) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
		this.pageData = pageData;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

}
