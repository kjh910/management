package com.manage.system.util;

import java.text.DecimalFormat;

/**
 * @概要: 各単位処理を変換するクラス
 */

public class DecimalFormatUtils {

	static DecimalFormat thousandUnitsFormatter = new DecimalFormat("###,###");
	static DecimalFormat firstDecimalPlacePerFormatter = new DecimalFormat("#.#%");
	static DecimalFormat yenUnitsFormatter = new DecimalFormat("¥ ###,###");

	public static String decimalToThousandUnitsFormatter(Long countByCreatedAt) {
		String decimal = thousandUnitsFormatter.format(countByCreatedAt);
		return decimal;
	}
	
	public static String decimalFirstDecimalPlacePerFormatter(Double countByCreatedAt) {
		String decimal = firstDecimalPlacePerFormatter.format(countByCreatedAt);
		return decimal;
	}
	
	public static String decimalYenUnitsFormatter(Long sumByCreatedAt) {
		String decimal = "¥ 0";
		if(sumByCreatedAt!=null) {
			decimal = yenUnitsFormatter.format(sumByCreatedAt);
		} return decimal;
	}
}
