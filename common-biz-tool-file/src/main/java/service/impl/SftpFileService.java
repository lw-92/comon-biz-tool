package service.impl;

import autoconfig.SftpProperties;
import service.FileService;

/**
 * @author wei.li
 * @date 2018/11/18 9:58
 * @desc
 */
public class SftpFileService implements FileService{
    private SftpProperties properties;

    public SftpFileService(SftpProperties properties) {
        this.properties = properties;
    }
}
