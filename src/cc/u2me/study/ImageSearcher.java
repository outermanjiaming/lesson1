package cc.u2me.study;

import java.io.File;

public class ImageSearcher implements Searcher {
	public static FileType fileType = FileType.Image;

	@Override
	public SearchResult search(String what, File file, String otherConditions) {
		SearchResult sr = null;
		String name = file.getName();
		if(name.contains(what)) {
			sr = new SearchResult();
			sr.setFileName(name);
			sr.setFilePath(file.getAbsolutePath());
			sr.setFileSize(file.length());
			sr.setFileType(fileType);
			sr.setSearchResultDesc(String.format("find '%s' from a picture named '%s'", what, name));
		}
		return sr;
	}

}
