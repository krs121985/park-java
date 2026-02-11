package home.beans;

//검색과 목록 페이지에서 결과를 분할시키기 위해 사용하는 DB와는 관련없는 클래스
//VO (Value Object, 값이 있는 객체)
public class PageVO {
	//필드 - 전달받아야 하는 파라미터 (String)
	private String column;
	private String keyword;
	private String begin;
	private String end;
	private String page = "1";		//기본 페이지는 1 (자동 수신을 위해 String 처리)
	private String pagesize = "10";	//기본 데이터 개수는 10 (자동 수신을 위해 String 처리)
	private String count;	//전체 데이터 개수 (마지막 블록 계산을 위한 값, 없으면 처리 안함)
	
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		try {
			int number = Integer.parseInt(count);
			if(number < 0) throw new Exception();
			this.count = count;
		}
		catch(Exception e) {
			//this.count = null;
		}
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		this.begin = begin;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		//숫자가 아닌 데이터는 설정 금지 (예외처리로 구현)
		try {
			int number = Integer.parseInt(page);//숫자로 변환(안되면 예외)
			if(number < 1) throw new Exception();//1보다 작으면 강제예외
			this.page = page;
		}
		catch(Exception e) {
			this.page = "1";
		}
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		try {
			int number = Integer.parseInt(pagesize);//변환해서 걸러내고
			if(number <= 0) throw new Exception();//0이하 걸러내고
			if(number % 5 != 0) throw new Exception();//5의배수 아니면 걸러내라!
			this.pagesize = pagesize;//안걸러지면 설정! (0보다 큰 5의 배수 형태의 문자열)
		}
		catch(Exception e) {
			this.pagesize = "10";
		}
	}
	
	@Override
	public String toString() {
		return "PageVO [column=" + column + ", keyword=" + keyword + ", begin=" + begin + ", end=" + end + ", page="
				+ page + ", pagesize=" + pagesize + ", count=" + count + ", blocksize=" + blocksize
				+ ", getColumnValue()=" + getColumnValue() + ", getKeywordValue()=" + getKeywordValue()
				+ ", getBeginValue()=" + getBeginValue() + ", getEndValue()=" + getEndValue() + ", isList()=" + isList()
				+ ", isColumnSearch()=" + isColumnSearch() + ", isPeriodSearch()=" + isPeriodSearch()
				+ ", getStartRownum()=" + getStartRownum() + ", getFinishRownum()=" + getFinishRownum()
				+ ", getQueryString()=" + getQueryString() + ", getStartBlock()=" + getStartBlock()
				+ ", getFinishBlock()=" + getFinishBlock() + ", getCountNumber()=" + getCountNumber()
				+ ", getPagecount()=" + getPagecount() + ", isFirstBlock()=" + isFirstBlock() + ", isLastBlock()="
				+ isLastBlock() + "]";
	}
	public PageVO() {
		super();
	}
	//가상의 Getter
	public String getColumnValue() {
		if(column == null) return "";
		return column;
	}
	public String getKeywordValue() {
		if(keyword == null) return "";
		return keyword;
	}
	public String getBeginValue() {
		if(begin == null) return "";
		return begin;
	}
	public String getEndValue() {
		if(end == null) return "";
		return end;
	}
	
	//boolean 형태의 getter 메소드는 이름을 get~이 아닌 is~로 쓴다 (자바 규약)
	public boolean isList() {
		return 	(column == null || column.isEmpty()
				|| keyword == null || keyword.isEmpty())
				&&
				(begin == null || begin.isEmpty()
				|| end == null || end.isEmpty());
	}
	public boolean isColumnSearch() {
		return 	(column != null && column.length() > 0)
				&&
				(keyword != null && keyword.length() > 0)
				&&
				(begin == null || begin.isEmpty() 
					|| end == null || end.isEmpty());
	}
	public boolean isPeriodSearch() {
		return 	(column == null || column.isEmpty()
				|| keyword == null || keyword.isEmpty())
				&&
				(begin != null && begin.length() > 0)
				&&
				(end != null && end.length() > 0);
	}
	
	public int getPageNumber() {
		return Integer.parseInt(page);
	}
	public int getPagesizeNumber() {
		return Integer.parseInt(pagesize);
	}
	public int getStartRownum() {
		//return getPageNumber() * getPagesizeNumber() - (getPagesizeNumber()-1);
		return (getPageNumber() - 1) * getPagesizeNumber() + 1;
	}
	public int getFinishRownum() {
		return getPageNumber() * getPagesizeNumber();
	}
	
	//? 뒤에 들어가야 하는 검색 관련 정보들을 계산하여 반환
	public String getQueryString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("column=");
		buffer.append(getColumnValue());
		buffer.append("&keyword=");
		buffer.append(getKeywordValue());
		buffer.append("&begin=");
		buffer.append(getBeginValue());
		buffer.append("&end=");
		buffer.append(getEndValue());
		buffer.append("&pagesize=");
		buffer.append(getPagesizeNumber());
		return buffer.toString();
	}
	
	private final int blocksize = 10;
	public int getStartBlock() {
		//return (getPageNumber()-1) / 10 * 10 + 1;
		return (getPageNumber()-1) / blocksize * blocksize + 1;
	}
	//(주의) finishBlock은 상황에 따라 달라질 수 있다 (전체 페이지수를 고려)
	public int getFinishBlock() {
		//return (getPageNumber()-1) / 10 * 10 + 10;
		int value = (getPageNumber()-1) / blocksize * blocksize + blocksize;
		return Math.min(value, getPagecount());//둘 중 작은걸로 처리
	}
	
	public int getCountNumber() {
		//만약 count가 null이면 페이지블록 상한선을 두지 않겠다는 뜻
		if(count == null) return Integer.MAX_VALUE;
		return Integer.parseInt(count);
	}
	public int getPagecount() {
		return (getCountNumber()-1) / getPagesizeNumber() + 1;
	}
	
	public boolean isFirstBlock() {
		return getStartBlock() == 1;
	}
	public boolean isLastBlock() {
		return getFinishBlock() >= getPagecount();
	}
}








