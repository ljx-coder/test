package util;

import java.util.List;

public class Page<T> {// ����һ��������
	private Integer pageNo = 1;// ��ǰҳ��
	private Integer pageSize = 5;// ÿҳ������¼��
	private Long pageCount;// ��ҳ��,ͨ���ܼ�¼������ó�
	private List<T> pageData;// ��ҳ�������

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
