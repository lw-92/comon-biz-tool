package service;

import dto.UploadContent;
import dto.UploadResult;

/**
 * @author wei.li
 * @date 2018/11/18 9:29
 * @desc
 */
public interface FileService {
    /**
     * 文件上传
     * @param content
     * @return
     */
    UploadResult upload(UploadContent content) throws Exception;
}
