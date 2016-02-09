package com.ludomorph.beans.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.struts.upload.FormFile;

public class UploadFile implements FormFile {

	private final File file;

    public UploadFile(File file) {
        this.file = file;
    }
	
	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return file.getName();
	}

	@Override
	public int getFileSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setContentType(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFileName(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFileSize(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public byte[] getFileData() throws IOException {
		byte[] buffer = new byte[(int) file.length()];
		FileInputStream fileInputStream = new FileInputStream(file);
		fileInputStream.read(buffer);
		fileInputStream.close();
		return buffer;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new FileInputStream(file);
	}

	@Override
	public void destroy() {
		if (!file.delete()) {
			throw new RuntimeException("File " + file.getName() + " can't be deleted");
		}
	}

}
