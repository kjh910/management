package com.manage.system.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @概要: Timestamp -> LocalDateTimeに、LocalDateTime -> Timestampに変換する。
 */

public class DateTimeUtils {
	
	public static Timestamp timestampOf(LocalDateTime time) {
        return time == null ? null : Timestamp.valueOf(time);
    }

    public static LocalDateTime dateTimeOf(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }

}
