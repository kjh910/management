package com.manage.system.util;

/**
 * @概要: 合計値を計算するクラス
 */

public class SumTotalCalculation {

	public static Long sumTotalCalculationRes(Long sumAmountByCreatedAtAndCashRes,
			Long sumAmountByCreatedAtAndCreditRes) {
		Long resultSumAmountByCreatedAtAndCashRes = 
				sumAmountByCreatedAtAndCashRes == null ? 0 : sumAmountByCreatedAtAndCashRes;
		Long resultSumAmountByCreatedAtAndCreditRes = 
				sumAmountByCreatedAtAndCreditRes == null ? 0 : sumAmountByCreatedAtAndCreditRes;

		return resultSumAmountByCreatedAtAndCashRes + resultSumAmountByCreatedAtAndCreditRes;
	}
}
