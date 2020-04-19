package com.service;

import com.pojo.Prop;
import com.utils.DataUtil;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Clrvn
 * @description 属性Service
 * @date 2020/4/18 23:18
 */
@Service
public class PropService {

    /**
     * 删除属性
     *
     * @param name 字段名
     * @return 删除的行数
     */
    public int removePropByName(String name) {
        if (DataUtil.propList.removeIf(prop -> prop.getName().equals(name))) {
            return 1;
        }
        return 0;
    }

    /**
     * 添加属性
     *
     * @param prop 属性
     * @return 添加的行数
     */
    public int addProp(Prop prop) {
        if (DataUtil.propList.add(prop)) {
            return 1;
        }
        return 0;
    }

    /**
     * 修改属性
     *
     * @param prop 属性
     * @return 修改的行数
     */
    public int updateProp(Prop prop) {
        if (removePropByName(prop.getName()) > 0) {
            return addProp(prop);
        }
        return 0;
    }

    /**
     * 获取所有的属性
     *
     * @return 所有的属性
     */
    public Set<Prop> getAllProp() {
        return DataUtil.propList.stream()
                .sorted(Comparator.comparingInt(Prop::getOrder))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * 通过字段名获取属性
     *
     * @param name 字段名
     * @return 属性
     */
    public Prop getPropByName(String name) {
        return DataUtil.propList.stream()
                .filter(prop -> prop.getName().equals(name))
                .findFirst().orElse(null);
    }
}
