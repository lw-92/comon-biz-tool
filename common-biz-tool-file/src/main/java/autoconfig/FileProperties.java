package autoconfig;

import dto.CommonProperties;
import enums.FileStoreType;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;

/**
 * @author wei.li
 * @date 2018/11/17 22:24
 * @desc
 */
@ConfigurationProperties(prefix = "common.tool.file")
public class FileProperties extends CommonProperties{
    //文件存储类型
    private FileStoreType storeType=FileStoreType.LOCAL;
    @Valid
    private LocalProperties local;
    @Valid
    private SftpProperties sftp;
    @Valid
    private AliyunOssProperties aliyun;

    public FileStoreType getStoreType() {
        return storeType;
    }

    public void setStoreType(FileStoreType storeType) {
        this.storeType = storeType;
    }

    public LocalProperties getLocal() {
        return local;
    }

    public void setLocal(LocalProperties local) {
        this.local = local;
    }

    public SftpProperties getSftp() {
        return sftp;
    }

    public void setSftp(SftpProperties sftp) {
        this.sftp = sftp;
    }

    public AliyunOssProperties getAliyun() {
        return aliyun;
    }

    public void setAliyun(AliyunOssProperties aliyun) {
        this.aliyun = aliyun;
    }

}
