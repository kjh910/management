package com.manage.system.util;

/**
 * @概要: percentageへ変換するクラス
 */

public class InvitationPerCalculation {
	
	public static String perDevideCountByCreatedAtToInvCodeRes(Long countByCreatedAtAndInvCodeRes
			,Long countByCreatedAtRes) {
		Double percentage = ((double)countByCreatedAtAndInvCodeRes/(double)countByCreatedAtRes);
		
		String perParseString = DecimalFormatUtils.decimalFirstDecimalPlacePerFormatter(percentage);
		
		if(perParseString.length()==3 || perParseString.length()==4) {
			perParseString = perParseString.replace("%", ".0%");
		}
		return perParseString;
	}

}
