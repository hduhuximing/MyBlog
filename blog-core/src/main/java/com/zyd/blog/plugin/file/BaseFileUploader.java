package com.zyd.blog.plugin.file;

import com.zyd.blog.business.entity.File;
import com.zyd.blog.business.entity.User;
import com.zyd.blog.business.enums.ConfigKeyEnum;
import com.zyd.blog.business.service.BizFileService;
import com.zyd.blog.business.service.SysConfigService;
import com.zyd.blog.file.client.AliyunOssApiClient;
import com.zyd.blog.file.client.ApiClient;
import com.zyd.blog.file.client.LocalApiClient;
import com.zyd.blog.file.client.QiniuApiClient;
import com.zyd.blog.file.entity.VirtualFile;
import com.zyd.blog.file.exception.GlobalFileException;
import com.zyd.blog.framework.exception.ZhydException;
import com.zyd.blog.framework.holder.SpringContextHolder;
import com.zyd.blog.persistence.beans.BizFile;
import com.zyd.blog.util.BeanConvertUtil;
import com.zyd.blog.util.SessionUtil;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2019/2/11 14:26
 * @description 实现上传选择，根据configService获取配置的参数
 * @since 1.8'
 */
public class BaseFileUploader {
    public ApiClient getApiClient(String uploadType) {
        SysConfigService configService = SpringContextHolder.getBean(SysConfigService.class);
        Map<String, Object> config = configService.getConfigs();
        String storageType = null;
        if (null == config
                || StringUtils.isEmpty((storageType = (String) config.get(ConfigKeyEnum.STORAGE_TYPE.getKey())))) {
            throw new ZhydException("[文件服务]当前系统暂未配置文件服务相关的内容！");
        }
        ApiClient res = null;
        switch (storageType) {
            case "local":
                String localFileUrl = (String) config.get(ConfigKeyEnum.LOCAL_FILE_URL.getKey()),
                        localFilePath = (String) config.get(ConfigKeyEnum.LOCAL_FILE_PATH.getKey());
                res = new LocalApiClient()
                        .init(localFileUrl, localFilePath, uploadType);
                break;
            case "qiniu":
                String accessKey = (String) config.get(ConfigKeyEnum.QINIU_ACCESS_KEY.getKey()),
                        secretKey = (String) config.get(ConfigKeyEnum.QINIU_SECRET_KEY.getKey()),
                        qiniuBucketName = (String) config.get(ConfigKeyEnum.QINIU_BUCKET_NAME.getKey()),
                        baseUrl = (String) config.get(ConfigKeyEnum.QINIU_BASE_PATH.getKey());
                res = new QiniuApiClient()
                        .init(accessKey, secretKey, qiniuBucketName, baseUrl, uploadType);
                break;
            case "aliyun":
                String endpoint = (String) config.get(ConfigKeyEnum.ALIYUN_ENDPOINT.getKey()),
                        accessKeyId = (String) config.get(ConfigKeyEnum.ALIYUN_ACCESS_KEY.getKey()),
                        accessKeySecret = (String) config.get(ConfigKeyEnum.ALIYUN_ACCESS_KEY_SECRET.getKey()),
                        url = (String) config.get(ConfigKeyEnum.ALIYUN_FILE_URL.getKey()),
                        aliYunBucketName = (String) config.get(ConfigKeyEnum.ALIYUN_BUCKET_NAME.getKey());
                res = new AliyunOssApiClient()
                        .init(endpoint, accessKeyId, accessKeySecret, url, aliYunBucketName, uploadType);
                break;
            default:
                break;
        }
        if (null == res) {
            throw new GlobalFileException("[文件服务]当前系统暂未配置文件服务相关的内容！");
        }
        return res;
    }

    public VirtualFile saveFile(VirtualFile virtualFile, boolean save, String uploadType) {
        if (save) {
            BizFileService fileService = SpringContextHolder.getBean(BizFileService.class);
            try {
                SysConfigService configService = SpringContextHolder.getBean(SysConfigService.class);
                Map<String, Object> config = configService.getConfigs();
                String storageType = (String) config.get(ConfigKeyEnum.STORAGE_TYPE.getKey());

                BizFile fileInfo = BeanConvertUtil.doConvert(virtualFile, BizFile.class);
                User sessionUser = SessionUtil.getUser();
                fileInfo.setUserId(null == sessionUser ? null : sessionUser.getId());
                fileInfo.setUploadType(uploadType);
                fileInfo.setStorageType(storageType);
                fileService.insert(new File(fileInfo));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return virtualFile;
    }

    boolean removeFile(ApiClient apiClient, String filePath, String uploadType) {
        BizFileService fileService = SpringContextHolder.getBean(BizFileService.class);
        File file = fileService.selectFileByPathAndUploadType(filePath, uploadType);
        String fileKey = filePath;
        if (null != file) {
            fileKey = file.getFilePath();
        }
        return apiClient.removeFile(fileKey);
    }

}
