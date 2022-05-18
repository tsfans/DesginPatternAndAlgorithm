package cn.hl.gof.structure7.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TextEditorFactory {

	private static TextEditorFactory editor = new TextEditorFactory();
	
	private Map<String,AbstractMedia> map = new HashMap<String,AbstractMedia>();
	
	private TextEditorFactory() {
		map.put("video", new MediaVideo());
		map.put("flash", new MediaFlash());
		map.put("picture", new MediaPicture());
	}
	
	public static TextEditorFactory getInstance() {
		return editor;
	}
	
	public AbstractMedia getMedia(String key) {
		return map.get(key);
	}
}
