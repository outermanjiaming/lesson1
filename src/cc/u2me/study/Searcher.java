package cc.u2me.study;

import java.io.File;

public interface Searcher {
	public SearchResult search(String what, File file, String otherConditions);
}
