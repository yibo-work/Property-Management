package com.controller;

import com.enums.ResultFailureEnum;
import com.pojo.Data;
import com.service.DataService;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    /**
     * 添加数据
     *
     * @param data 数据
     */
    @RequestMapping("/addData")
    public ResultVO addData(@RequestBody Data data) {
        if (dataService.addData(data) > 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.failure(ResultFailureEnum.ADD_PROP_ERROR);
    }

    /**
     * 获取所有的数据
     */
    @RequestMapping("/getAllData")
    public ResultVO getAllData() {
        return ResultVOUtil.success(dataService.getAllData());
    }


    /**
     * 导出数据
     */
    @RequestMapping("/exportData")
    public void exportData(HttpServletRequest request, HttpServletResponse response) {
        dataService.exportData(request, response);
    }
}
