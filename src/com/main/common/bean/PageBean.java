package com.main.common.bean;

public class PageBean {
	// 1.ÿҳ��ʾ����(pageSize)
	private int pageSize;
	// 2.�ܼ�¼��(totalCount)
	private int totalCount;
	// 3.��ҳ��(totalPage)
	private int totalPage;
	// 4.��ǰҳ(currentPage)
	private int currentPage;
	// 5.��ʼ��(beginIndex)
	private int beginIndex;
	// 6.�Ƿ�����һҳ(hasPrePage)
	private boolean hasPrePage;
	// 7.�Ƿ�����һҳ(hasNextPage)
	private boolean hasNextPage;

	public PageBean(int pageSize, int totalCount, int totalPage,
			int currentPage, int beginIndex, boolean hasPrePage,
			boolean hasNextPage) {
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.beginIndex = beginIndex;
		this.hasPrePage = hasPrePage;
		this.hasNextPage = hasNextPage;
	}

	// ���캯����Ĭ��
	public PageBean() {
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public static PageBean createPage(int pageSize,int totalCount,int currentPage) {
		pageSize = getEveryPage(pageSize);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(pageSize, totalCount);
		int beginIndex = getBeginIndex(pageSize, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new PageBean(pageSize, totalCount, totalPage, currentPage,
				beginIndex, hasPrePage,  hasNextPage);
	}
	
	public static PageBean createPage(PageBean page,int totalCount) {
		int pageSize = getEveryPage(page.getPageSize());
		int currentPage = getCurrentPage(page.getCurrentPage());
		int totalPage = getTotalPage(pageSize, totalCount);
		int beginIndex = getBeginIndex(pageSize, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new PageBean(pageSize, totalCount, totalPage, currentPage,
				beginIndex, hasPrePage,  hasNextPage);
	}
	
	//����ÿҳ��ʾ��¼��
	public static int getEveryPage(int everyPage) {
		return everyPage == 0 ? 5 : everyPage;
	}
	
	//���õ�ǰҳ
	public static int getCurrentPage(int currentPage) {
		return currentPage == 0 ? 1 : currentPage;
	}
	
	//������ҳ��,��Ҫ�ܼ�¼����ÿҳ��ʾ����
	public static int getTotalPage(int pageSize,int totalCount) {
		int totalPage = 0;
		if(totalCount % pageSize == 0) {
			totalPage = (totalCount / pageSize);
		} else {
			totalPage = (totalCount / pageSize + 1);
		}
		return totalPage;
	}
	
	//������ʼ�㣬��Ҫÿҳ��ʾ���٣���ǰҳ
	public static int getBeginIndex(int everyPage,int currentPage) {
		return (currentPage - 1) * everyPage;
	}
	
	//�����Ƿ�����һҳ����Ҫ��ǰҳ
	public static boolean getHasPrePage(int currentPage) {
		return currentPage == 1 ? false : true;
	}
	
	//�����Ƿ�����һ������Ҫ��ҳ���͵�ǰҳ
	public static boolean getHasNextPage(int totalPage, int currentPage) {
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
	

}
