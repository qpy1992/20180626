package com.jeecg.file.service;
import com.jeecg.file.entity.FileEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface FileServiceI extends CommonService{
	
 	public void delete(FileEntity entity) throws Exception;
 	
 	public Serializable save(FileEntity entity) throws Exception;
 	
 	public void saveOrUpdate(FileEntity entity) throws Exception;
 	
}
