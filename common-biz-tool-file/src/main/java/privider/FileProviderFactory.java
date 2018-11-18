package privider;

import autoconfig.FileProperties;
import enums.FileStoreType;
import exception.FileNotSurportException;
import service.FileService;
import service.impl.AliyunFileService;
import service.impl.LocalFileService;
import service.impl.SftpFileService;

/**
 * @author wei.li
 * @date 2018/11/18 9:40
 * @desc
 */
public class FileProviderFactory {

    public static FileService buildFileService(FileProperties properties){
        final FileStoreType storeType = properties.getStoreType();
        switch (storeType){
            case LOCAL:
                return new LocalFileService(properties.getLocal());
            case SFTP:
                return new SftpFileService(properties.getSftp());
            case ALIYUN:
                return new AliyunFileService(properties.getAliyun());
            default:
                throw new FileNotSurportException("file store type not support");
        }

    }
}
