package autoconfig;

import autoconfigration.AbstractAutoConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import privider.FileProviderFactory;
import service.FileService;

/**
 * @author wei.li
 * @date 2018/11/17 22:23
 * @desc
 */
@EnableConfigurationProperties(FileProperties.class)
public class FileAutoConfig extends AbstractAutoConfig<FileProperties>{
    public FileAutoConfig(FileProperties properties) {
        super(properties);
    }
    @Bean("service.FileService")
    @ConditionalOnMissingBean(FileService.class)
    public FileService fileservice(){
        validate();
        return FileProviderFactory.buildFileService(properties);
    }

}
