package com.pojo;

import com.utils.DataUtil;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Clrvn
 * @description 数据
 * @date 2020/4/19 0019 10:56
 */
@lombok.Data
public class Data {
    private Set<Prop> propList;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Data data = (Data) o;
        return propList.equals(data.propList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propList);
    }
}
