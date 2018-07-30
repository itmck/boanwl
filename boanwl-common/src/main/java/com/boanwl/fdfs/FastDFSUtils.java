package com.boanwl.fdfs;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

/**
 * User: DHC
 * Date: 2018/5/3
 * Time: 10:17
 * Version:V1.0
 */
public class FastDFSUtils implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -4462272673174266738L;
    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    private static StorageClient1 storageClient1;

    static {
        try {
            //clientGloble读配置文件
            ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
            ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
            //trackerclient
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();
            //storageclient
            storageClient1 = new StorageClient1(trackerServer,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * fastDFS文件上传
     * @param file 上传的文件 FastDFSFile
     * @return String 返回文件的绝对路径
     */
    public static String uploadFile(FastDFSFile file){
        String path = null;
        try {
            //文件扩展名
            String ext = FilenameUtils.getExtension(file.getName());
            //mata list是表文件的描述
            NameValuePair[] mata_list = new NameValuePair[3];
            mata_list[0] = new NameValuePair("fileName",file.getName());
            mata_list[1] = new NameValuePair("fileExt",ext);
            mata_list[2] = new NameValuePair("fileSize",String.valueOf(file.getSize()));
            path = storageClient1.upload_file1(file.getContent(), ext, mata_list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * fastDFS文件下载
     * @param groupName 组名
     * @param remoteFileName 文件名
     * @param specFileName 真实文件名
     * @return ResponseEntity<byte[]>
     */
    public static ResponseEntity<byte[]> downloadFile(String groupName, String remoteFileName, String specFileName){
        byte[] content = null;
        HttpHeaders headers = new HttpHeaders();
        try {
            content = storageClient1.download_file(groupName, remoteFileName);
            headers.setContentDispositionFormData("attachment",  new String(specFileName.getBytes("UTF-8"),"iso-8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(content, headers, HttpStatus.CREATED);
    }

    /**
     * 根据fastDFS返回的path得到文件的组名
     * @param path fastDFS返回的path
     * @return
     */
    public static String getGroupFormFilePath(String path){
        return path.split("/")[0];
    }

    /**
     * 根据fastDFS返回的path得到文件名
     * @param path fastDFS返回的path
     * @return
     */
    public static String getFileNameFormFilePath(String path) {
        return path.substring(path.indexOf("/")+1);
    }
}
