package service.impl;

import autoconfig.LocalProperties;
import service.FileService;

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
}
