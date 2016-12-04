package cc.u2me.study;

public class SearchResult {
	String fileName;
	String filePath;
	FileType fileType;
	long fileSize;
	String searchResultDesc;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public FileType getFileType() {
		return fileType;
	}
	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getSearchResultDesc() {
		return searchResultDesc;
	}
	public void setSearchResultDesc(String searchResultDesc) {
		this.searchResultDesc = searchResultDesc;
	}
	@Override
	public String toString() {
		return "SearchResult [fileName=" + fileName + ", filePath=" + filePath + ", fileType=" + fileType
				+ ", fileSize=" + fileSize + ", searchResultDesc=" + searchResultDesc + "]";
	}
	
}
