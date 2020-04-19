package com.utils;

import com.pojo.Data;
import com.pojo.Prop;
import com.pojo.User;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Clrvn
 * @description 数据工具类
 * @date 2020/4/19 17:01
 */
public class DataUtil {

    /**
     * 定义用户列表
     */
    public static List<User> userList = new ArrayList<>();
    /**
     * 定义属性列表
     */
    public static Set<Prop> propList = new LinkedHashSet<>();
    /**
     * 自定义数据列表
     */
    public static List<Data> dataList = new ArrayList<>();

    /*下面三个是我自己加的默认数据，你不要的话可以删除 -- start*/
    /*static {
        User user = new User();
        user.setName("admin");
        user.setPassword("123");
        userList.add(user);
    }

    static {
        Prop prop = new Prop();
        prop.setOrder(1);
        prop.setName("测试字段1");
        prop.setType(1);
        prop.setRequired(false);
        prop.setScopeStart(0);
        prop.setScopeEnd(1000);
        prop.setLengthStart(0);
        prop.setLengthEnd(10);
        prop.setUnit("测试单位");
        prop.setParam("测试参数");
        Prop prop2 = new Prop();
        prop2.setOrder(2);
        prop2.setType(2);
        prop2.setName("测试字段2");

        propList.add(prop);
        propList.add(prop2);
    }

    static {
        Data data = new Data();
        int i = 0;
        LinkedHashSet<Prop> propList = DataUtil.propList.stream()
                .sorted(Comparator.comparingInt(Prop::getOrder))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Prop> dataPropList = new HashSet<>(propList.size());

        for (Prop prop : propList) {
            Prop dataProp = new Prop();
            dataProp.setOrder(prop.getOrder());
            dataProp.setName(prop.getName());
            dataProp.setValue("第一行测试数据" + ++i);
            dataPropList.add(dataProp);
        }
        data.setPropList(dataPropList);
        dataList.add(data);

        Data data2 = new Data();
        System.err.println(dataList.toString());

        Set<Prop> data2PropList = new HashSet<>(propList.size());

        for (Prop prop : propList) {
            Prop dataProp = new Prop();
            dataProp.setOrder(prop.getOrder());
            dataProp.setName(prop.getName());
            dataProp.setValue("第二行测试数据" + ++i);
            data2PropList.add(dataProp);
        }
        data2.setPropList(data2PropList);
        dataList.add(data2);

        System.err.println(dataList.toString());
    }*/

    /* 删除到这里 -- end */

    private DataUtil() {
    }

}
