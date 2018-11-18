package autoconfig;

import javax.validation.constraints.NotNull;

/**
 * @author wei.li
 * @date 2018/11/18 9:23
 * @desc
 */
public class LocalProperties {
    /**
     * 本地文件存储路径
     */
    @NotNull
    private String storePath;

    public String getStorePath() {
        return storePath;
    }

    public void setStorePath(String storePath) {
        this.storePath = storePath;
    }
}
