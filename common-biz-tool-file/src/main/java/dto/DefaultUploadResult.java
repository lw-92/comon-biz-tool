package dto;

/**
 * @author wei.li
 * @date 2018/11/18 10:26
 * @desc
 */
public class DefaultUploadResult implements UploadResult{
    private String fileKey;
    @Override
    public String getFileKey() {
        return null;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    public DefaultUploadResult(String fileKey) {
        this.fileKey = fileKey;
    }
}
