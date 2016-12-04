package cc.u2me.study;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextSearcher implements Searcher {
	public static FileType fileType = FileType.Text;
	
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
			sr.setSearchResultDesc(String.format("find '%s' from a text file named '%s'", what, name));
		} else {
			Path path = Paths.get(file.getParent(), name);
			try {
				List<String> lines = Files.readAllLines(path);
				int i = 0;
				for(String line : lines) {
					i ++;
					if(line.contains(what)) {
						sr = new SearchResult();
						sr.setFileName(name);
						sr.setFilePath(file.getAbsolutePath());
						sr.setFileSize(file.length());
						sr.setFileType(fileType);
						sr.setSearchResultDesc(String.format("find '%s' from a text file named '%s' in the content at line %d which is '%s'", what, name, i, line));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return sr;
	}

}
