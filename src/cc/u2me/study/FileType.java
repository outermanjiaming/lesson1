package cc.u2me.study;

import java.util.HashMap;
import java.util.Map;

public enum FileType {

	Image(1, ".jpg .png .tiff"), Text(2, ".txt .log"), Video(3, ".mp4");
	private static Map<String, FileType> map = new HashMap<String, FileType>();
	static {
		for(FileType ft : FileType.values()) {
			String[] suffixs = ft.name.split(" ");
			
			for(String suffix : suffixs) {
				map.put(suffix, ft);
			}
		}
	}
	FileType(int i, String n){
		this.id = i;
		this.name = n;
	}
	public static FileType get(String suffix) {
		return map.get(suffix);
	}
	int id;
	String name;
}
