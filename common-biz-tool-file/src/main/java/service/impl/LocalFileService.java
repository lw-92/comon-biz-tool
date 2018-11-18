package service.impl;

import autoconfig.LocalProperties;
import constant.FileConstants;
import dto.DefaultUploadResult;
import dto.UploadContent;
import dto.UploadResult;
import org.apache.commons.io.FileUtils;
import service.FileService;
import utils.FilekeyUtil;

import java.io.File;

/**
 * @author wei.li
 * @date 2018/11/18 9:55
 * @desc
 */
public class LocalFileService implements FileService{

    private LocalProperties properties;

    public LocalFileService(LocalProperties properties) {
        this.properties = properties;
    }
    @Override
    public UploadResult upload(UploadContent content) throws Exception{
        final String key = FilekeyUtil.generateFileKey();
        File file = new File(properties.getStorePath() + File.separator + key + FileConstants.FILE_SUFFIX);
        FileUtils.copyInputStreamToFile(content.getContent(),file);
        return new DefaultUploadResult(key);
    }
}
