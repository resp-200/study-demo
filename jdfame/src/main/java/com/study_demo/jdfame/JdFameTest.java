package com.study_demo.jdfame;

import com.alibaba.fastjson.JSON;
import com.study_demo.jdfame.baseinfo.StaticInfo;
import com.study_demo.jdfame.baseinfo.Student;
import io.github.burukeyou.dataframe.iframe.JDFrame;
import io.github.burukeyou.dataframe.iframe.item.FI2;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author Zhang hao yu
 * @Date 2024/9/29 10:29
 */
public class JdFameTest {

    @Test
    public void basicTest() {
        JDFrame<Student> read = JDFrame.read(StaticInfo.list);
        read.show();
        List<Student> students = read.toLists();

//        System.out.println(read.columns());
//        read.addRankCol(Sorter.toSorter(Comparator.comparingInt(Student::getAge))).show();
        read.forEachDo(System.out::println);
        read.forEachPreDo((prev, curr) -> {
        });

        List<FI2<Integer, List<Student>>> fi2s = read.whereNotNull(Student::getAge).group(Student::getAge).toLists();
        System.out.println(JSON.toJSONString(fi2s));


        read.cutFirst(10);
    }
}
