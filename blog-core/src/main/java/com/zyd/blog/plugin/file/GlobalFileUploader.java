package com.zyd.blog.plugin.file;

import com.zyd.blog.file.Uploader.FileUploader;
import com.zyd.blog.file.client.ApiClient;
import com.zyd.blog.file.entity.VirtualFile;
import com.zyd.blog.file.exception.GlobalFileException;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

/**

 * @version 1.0

 * @date 2019/2/11 13:47
 * @since 1.8
 * @description  uploader有两步，第一步上传数据，第二部保存路径到数据库中
 */
public class GlobalFileUploader extends BaseFileUploader implements FileUploader {

    @Override
    public VirtualFile upload(InputStream is, String uploadType, String imageUrl, boolean save) {
        ApiClient apiClient = this.getApiClient(uploadType);
        VirtualFile virtualFile = apiClient.uploadImg(is, imageUrl);
        return this.saveFile(virtualFile, save, uploadType);
    }

    @Override
    public VirtualFile upload(File file, String uploadType, boolean save) {
        ApiClient apiClient = this.getApiClient(uploadType);
        VirtualFile virtualFile = apiClient.uploadImg(file);
        return this.saveFile(virtualFile, save, uploadType);
    }

    @Override
    public VirtualFile upload(MultipartFile file, String uploadType, boolean save) {
        //初始化上传组件
        ApiClient apiClient = this.getApiClient(uploadType);
        //信息封装,并上传到服务器
        VirtualFile virtualFile = apiClient.uploadImg(file);
        //保存文件
        return this.saveFile(virtualFile, save, uploadType);
    }

    @Override
    public boolean delete(String filePath, String uploadType) {
        if (StringUtils.isEmpty(filePath)) {
            throw new GlobalFileException("[文件服务]文件删除失败，文件为空！");
        }

        ApiClient apiClient = this.getApiClient(uploadType);
        return this.removeFile(apiClient, filePath, uploadType);
    }
}
