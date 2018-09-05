package com.inca.editor.define;

import java.util.HashMap;
import java.util.Map;

public class MIMEType {

	public static final Map<String, String> types = new HashMap<String, String>() {
		
		    /**
		    * @Fields field:field:{todo}(用一句话描述这个变量表示什么)
		    */
		    
		private static final long serialVersionUID = 4486095029798796982L;

		{
			put("image/gif", ".gif");
			put("image/jpeg", ".jpg");
			put("image/jpg", ".jpg");
			put("image/png", ".png");
			put("image/bmp", ".bmp");
		}
	};

	public static String getSuffix(String mime) {
		return MIMEType.types.get(mime);
	}

}
