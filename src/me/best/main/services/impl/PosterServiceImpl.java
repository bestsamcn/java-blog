package me.best.main.services.impl;

import me.best.main.dao.FactoryDao;
import me.best.main.models.Poster;
import me.best.main.services.PosterService;
import me.best.main.utils.Utils;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author: Sam
 * @Date: 2018/9/23 18:50
 */
public class PosterServiceImpl implements PosterService {
    @Override
    public JSONObject add(HttpServletRequest req) {
        JSONObject ret = Utils.setResponse(-1, "上传失败", "null");
        String savePath = req.getServletContext().getRealPath("/WEB-INF/upload");
        String tempPath = req.getServletContext().getRealPath("/WEB-INF/temp");
        File tempFile = new File(tempPath);

        //临时文件夹
        if(!tempFile.exists()){
            tempFile.mkdir();
        }

        try {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

            //设置文件大小阈值1mb时使用内存
            diskFileItemFactory.setSizeThreshold(1024*1024);

            //超过1mb时使用临时文件夹
            diskFileItemFactory.setRepository(tempFile);

            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

            //设置单个文件大小为10Mb
            servletFileUpload.setFileSizeMax(10*1024*1024);

            //设置总文件大小为30MB
            servletFileUpload.setSizeMax(30*1024*1024);

            //设置编码，防止中文乱码
            servletFileUpload.setHeaderEncoding("UTF-8");

            //非二进制流，返回
            if(ServletFileUpload.isMultipartContent(req)){
                ret.replace("msg", "请求内容类型不符合要求");
                return ret;
            }

            //进度监听
            servletFileUpload.setProgressListener(new ProgressListener() {
                @Override
                public void update(long hasRead, long total, int i) {
                    System.out.println("total: "+total+"; hasRead: "+hasRead);
                }
            });

            List<FileItem> fileItemList = servletFileUpload.parseRequest(req);
            for(FileItem fileItem:fileItemList){

                //普通表单上传，忽略
                if(fileItem.isFormField()){
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    System.out.println("name: "+name+", value: "+value);
                }else{
                    String fileName = fileItem.getName();

                    //文件名称和类型
                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);

                    //保存的名称
                    String saveFileName = Utils.getUUID()+"."+fileName;

                    //保存的路径
                    String saveFilePath = savePath+"\\"+saveFileName;

                    InputStream in = fileItem.getInputStream();

                    FileOutputStream out = new FileOutputStream(saveFilePath);

                    //创建一个1kb的缓存区
                    byte buffer[] = new byte[1024];
                    int len = 0;
                    while((len=in.read(buffer))>0){
                        out.write(buffer, 0, len);
                    }
                    in.close();
                    out.close();

                    //插入相关信息进数据库
                    Poster poster = new Poster(Utils.getUUID(), new Timestamp(new Date().getTime()), saveFileName, saveFilePath, "");
                    int count = FactoryDao.getPosterDao().add(poster);
                    if(count == 1){
                        ret = Utils.setResponse(0, "上传成功", saveFilePath);
                        return ret;
                    }
                }
            }
        }catch (FileUploadBase.FileSizeLimitExceededException e){
            ret.replace("msg", "单个文件大小超出10MB");
            return ret;
        }catch (FileUploadBase.SizeLimitExceededException e){
            ret.replace("msg", "总文件大小超过30MB");
            return ret;
        }catch (Exception e){
            ret.replace("msg", "异常");
        }
        return ret;
    }

    @Override
    public JSONObject delete(String id) {
        return null;
    }

    @Override
    public JSONObject getList(String pageIndex, String pageSize) {
        return null;
    }
}
