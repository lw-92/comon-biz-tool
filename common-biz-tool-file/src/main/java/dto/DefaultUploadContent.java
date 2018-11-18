package dto;

import java.io.InputStream;

/**
 * @author wei.li
 * @date 2018/11/18 16:36
 * @desc
 */
public class DefaultUploadContent implements UploadContent{
    private InputStream content;

    public DefaultUploadContent(InputStream content) {
        this.content = content;
    }

    @Override
    public InputStream getContent() {
        return content;
    }
}
