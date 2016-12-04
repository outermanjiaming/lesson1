package cc.u2me.study;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

	public static final Map<FileType, Searcher> searcher = new HashMap<FileType, Searcher>();
	static {
		searcher.put(FileType.Image, new ImageSearcher());
		searcher.put(FileType.Text, new TextSearcher());
	}
	
	public static void main(String[] args) {
		String path = "/Users/lijiaming/Documents";
		String what = "lijiaming";
		Scanner sc = new Scanner(System.in);
		what = sc.nextLine();
		while(!what.equals("exit()")) {
			search(path, what);
			what = sc.nextLine();
		}
		sc.close();
	}
	public static void search(String path, String what) {
		//1.list all files
		File parent = new File(path);
		File[] files = parent.listFiles();
		//2.use file's suffix to get FileType then get a searcher
		for(File file : files) {
			if(file.isDirectory()) {
				continue;
			}
			String name = file.getName();
			int index = name.lastIndexOf(".");
			if(index < 0) {
				continue;
			}
			String suffix = name.substring(index);
			FileType fileType = FileType.get(suffix);
			//3.use searcher to do the searching
			Searcher sc = searcher.get(fileType);
			if(sc != null) {
				SearchResult result = sc.search(what, file, null);
				//4.return Search Result and print it
				if(result != null) {
					System.out.println(result.getSearchResultDesc());
				} else {
					System.err.println("nothing found");
				}
			} else {
				System.err.println("ignore unsupported file type");
			}
		}
		
		
	}
}
