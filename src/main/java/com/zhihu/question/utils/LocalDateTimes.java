package com.zhihu.question.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author admin
 * @create 2022/4/14 10:38 下午
 */
public interface LocalDateTimes {

    /**
     * LocalDateTime截取,精确到MILLIS 该精度需要同数据库脚本的字段值对应 mysql:dateTime(3)
     *
     * @return LocalDateTime
     */
    static LocalDateTime currentTime() {
        return LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
    }
}
