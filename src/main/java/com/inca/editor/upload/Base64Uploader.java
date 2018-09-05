package com.inca.editor.upload;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import com.inca.editor.PathFormat;
import com.inca.editor.define.AppInfo;
import com.inca.editor.define.BaseState;
import com.inca.editor.define.FileType;
import com.inca.editor.define.State;

public final class Base64Uploader {

	public static State save(String content, Map<String, Object> conf) {
		byte[] data = decode(content);
		long maxSize = ((Long) conf.get("maxSize")).longValue();
		if (!validSize(data, maxSize)) {
			return new BaseState(false, AppInfo.MAX_SIZE);
		}
		String suffix = FileType.getSuffix("JPG");
		String savePath = PathFormat.parse((String) conf.get("savePath"), (String) conf.get("filename"));
		savePath = savePath + suffix;
		String physicalPath = (String) conf.get("fileStore") + savePath;
		State storageState = StorageManager.saveBinaryFile(data, physicalPath);
		if (storageState.isSuccess()) {
			storageState.putInfo("url", PathFormat.format(savePath));
			storageState.putInfo("type", suffix);
			storageState.putInfo("original", "");
		}
		return storageState;
	}

	private static byte[] decode(String content) {
		return Base64.decodeBase64(content);
	}

	private static boolean validSize(byte[] data, long length) {
		return data.length <= length;
	}

}