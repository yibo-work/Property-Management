package com.service;

import com.pojo.Data;
import com.pojo.Prop;
import com.utils.DataUtil;
import com.utils.XSSFWriteExtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Clrvn
 * @description 数据Service
 * @date 2020/4/18  23:18
 */
@Service
public class DataService {

    @Autowired
    private PropService propService;

    /**
     * 添加数据
     *
     * @param data 数据
     * @return 添加的行数
     */
    public int addData(Data data) {
        DataUtil.dataList.add(data);
        return 1;
    }

    /**
     * 获取所有的数据
     *
     * @return 所有的数据
     */
    public List<Data> getAllData() {
        return DataUtil.dataList;
    }

    /**
     * 导出数据
     */
    public void exportData(HttpServletRequest request, HttpServletResponse response) {

        // 创建一个文本输出流对象
        PrintWriter writer = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            writer = response.getWriter();

            List<String> header = new ArrayList<>();
            for (Prop prop : propService.getAllProp()) {
                header.add(prop.getName());
            }

            List<Data> data = getAllData();
            String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\upload\\";
            String fileName = path + "/" + System.currentTimeMillis() + ".xlsx";
            XSSFWriteExtUtil.writeToExcel(data, fileName, header);
            long fileLength;
            File file = new File(fileName);

            String fileDisplay = "数据_" + System.currentTimeMillis();
            String agent = request.getHeader("User-Agent").toUpperCase();
            boolean bool = agent.indexOf("MSIE") > 0 || (agent.indexOf("GECKO") > 0 && agent.indexOf("RV:11") > 0);
            if (bool) {
                fileDisplay = URLEncoder.encode(fileDisplay, "UTF-8");
            } else {
                fileDisplay = new String(fileDisplay.getBytes(StandardCharsets.UTF_8), "ISO8859-1");
            }
            fileLength = file.length();
            response.reset();
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-disposition", "attachment;filename=\"" + fileDisplay + ".xlsx\";target=_blank");
            response.setHeader("Content-Length", String.valueOf(fileLength));
            FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();

            if (null != writer) {
                writer.print("下载文件时发生错误.");
            }
        }
    }

    /**
     * 删除数据
     *
     * @param data 数据
     * @return 删除的行数
     */
    public int removeData(Data data) {

        for (Data allData : new ArrayList<>(DataUtil.dataList)) {
            for (Prop prop : allData.getPropList()) {
                boolean bool = true;
                for (Prop removeProp : data.getPropList()) {
                    if (removeProp.getName().equals(prop.getName())) {
                        if (!Objects.equals(removeProp.getOrder(), prop.getOrder()) ||
                                !Objects.equals(removeProp.getType(), prop.getType()) ||
                                !Objects.equals(removeProp.getRequired(), prop.getRequired()) ||
                                !Objects.equals(removeProp.getDefaultValue(), prop.getDefaultValue()) ||
                                !Objects.equals(removeProp.getScopeStart(), prop.getScopeStart()) ||
                                !Objects.equals(removeProp.getScopeEnd(), prop.getScopeEnd()) ||
                                !Objects.equals(removeProp.getLengthStart(), prop.getLengthStart()) ||
                                !Objects.equals(removeProp.getLengthEnd(), prop.getLengthEnd()) ||
                                !Objects.equals(removeProp.getUnit(), prop.getUnit()) ||
                                !Objects.equals(removeProp.getParam(), prop.getParam()) ||
                                !Objects.equals(removeProp.getValue(), prop.getValue())) {
                            bool = false;
                            break;
                        }
                    }
                }

                if (bool && DataUtil.dataList.remove(allData)) {
                    return 1;
                }
            }
        }

        /*if (DataUtil.dataList.removeIf(ele -> {
            for (Prop prop : ele.getPropList()) {
                for (Prop removeProp : data.getPropList()) {
                    if (Objects.equals(removeProp.getOrder(), prop.getOrder()) &&
                            Objects.equals(removeProp.getName(), prop.getName()) &&
                            Objects.equals(removeProp.getType(), prop.getType()) &&
                            Objects.equals(removeProp.getRequired(), prop.getRequired()) &&
                            Objects.equals(removeProp.getDefaultValue(), prop.getDefaultValue()) &&
                            Objects.equals(removeProp.getScopeStart(), prop.getScopeStart()) &&
                            Objects.equals(removeProp.getScopeEnd(), prop.getScopeEnd()) &&
                            Objects.equals(removeProp.getLengthStart(), prop.getLengthStart()) &&
                            Objects.equals(removeProp.getLengthEnd(), prop.getLengthEnd()) &&
                            Objects.equals(removeProp.getUnit(), prop.getUnit()) &&
                            Objects.equals(removeProp.getParam(), prop.getParam()) &&
                            Objects.equals(removeProp.getValue(), prop.getValue())) {
                        return true;
                    }
                }
            }
            return false;
        })) {
            return 1;
        }*/
        return 0;
    }
}
