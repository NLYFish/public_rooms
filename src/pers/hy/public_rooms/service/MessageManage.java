package pers.hy.public_rooms.service;

import java.io.File;
import java.io.InputStream;

public interface MessageManage {

	public String getMessageDo();
	public String setMessageDo(String message);
	public String getNoticeDo();
	public String uploadNotice(File file,String fileFileName,String fileContentType);
	public String deleteNotice(String[] noticeSelect);
	public InputStream getDownloadFile(String downloadFileName); 
}
