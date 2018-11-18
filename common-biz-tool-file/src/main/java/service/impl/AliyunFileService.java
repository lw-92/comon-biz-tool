package service.impl;

import autoconfig.AliyunOssProperties;
import service.FileService;

/**
 * @author wei.li
 * @date 2018/11/18 9:59
 * @desc
 */
public class AliyunFileService implements FileService{

    private AliyunOssProperties properties;

    public AliyunFileService(AliyunOssProperties properties) {
        this.properties = properties;
    }
}
