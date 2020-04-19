package com.controller;

import com.enums.ResultFailureEnum;
import com.pojo.Prop;
import com.service.PropService;
import com.utils.ResultVOUtil;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prop")
public class PropController {

    @Autowired
    private PropService propService;

    /**
     * 添加属性
     *
     * @param prop 属性
     */
    @RequestMapping("/addProp")
    public ResultVO addProp(@RequestBody Prop prop) {
        if (propService.addProp(prop) > 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.failure(ResultFailureEnum.ADD_PROP_ERROR);
    }

    /**
     * 修改属性
     *
     * @param prop 属性
     */
    @RequestMapping("/updateProp")
    public ResultVO updateProp(@RequestBody Prop prop) {
        if (propService.updateProp(prop) > 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.failure(ResultFailureEnum.UPDATE_PROP_ERROR);
    }

    /**
     * 删除属性
     *
     * @param name 字段名
     */
    @RequestMapping("/removePropByName")
    public ResultVO removePropByName(String name) {
        if (propService.removePropByName(name) > 0) {
            return ResultVOUtil.success();
        }
        return ResultVOUtil.failure(ResultFailureEnum.REMOVE_PROP_ERROR);
    }

    /**
     * 获取所有的属性
     */
    @RequestMapping("/getAllProp")
    public ResultVO getAllProp() {
        return ResultVOUtil.success(propService.getAllProp());
    }

    /**
     * 通过字段名获取属性
     *
     * @param name 字段名
     */
    @RequestMapping("/getPropByName")
    public ResultVO getPropByName(String name) {
        return ResultVOUtil.success(propService.getPropByName(name));
    }


}
