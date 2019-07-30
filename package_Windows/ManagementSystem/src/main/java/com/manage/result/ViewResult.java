package com.manage.result;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @概要: DBで処理した数値演算の結果値をJavaの変数で格納するクラス
 * @処理内容: 各 Repositoryで処理したクエリの結果値を ViewResultの変数に格納する。
 */
public class ViewResult {

	private final String createdAtConvertToString;
	private final String countByCreatedAtRes;
	private final String countByCreatedAtCon;
	private final String countByCreatedAtConGoods;
	private final String countByCreatedAtlotteries;
	private final String countByCreatedAtAndInvCodeRes;
	private final String perParseString;
	private final String sumAmountByCreatedAtAndCashRes;
	private final String sumAmountByCreatedAtAndCreditRes;
	private final String sumTotalCashAndCreditRes;
	private final String sumAmountByCreatedAtAndCashCon;
	private final String sumAmountByCreatedAtAndCreditCon;
	private final String sumTotalCashAndCreditCon;

	public ViewResult(
			String createdAtConvertToString, 
			String countByCreatedAtRes, 
			String countByCreatedAtCon,
			String countByCreatedAtConGoods,
			String countByCreatedAtlotteries,
			String countByCreatedAtAndInvCodeRes,
			String perParseString,
			String sumAmountByCreatedAtAndCashRes,
			String sumAmountByCreatedAtAndCreditRes,
			String sumTotalCashAndCreditRes,
			String sumAmountByCreatedAtAndCashCon,
			String sumAmountByCreatedAtAndCreditCon,
			String sumTotalCashAndCreditCon
			) {
		super();
		this.createdAtConvertToString = createdAtConvertToString;
		this.countByCreatedAtRes = countByCreatedAtRes;
		this.countByCreatedAtCon = countByCreatedAtCon;
		this.countByCreatedAtConGoods = countByCreatedAtConGoods;
		this.countByCreatedAtlotteries = countByCreatedAtlotteries;
		this.countByCreatedAtAndInvCodeRes = countByCreatedAtAndInvCodeRes;
		this.perParseString = perParseString;
		this.sumAmountByCreatedAtAndCashRes = sumAmountByCreatedAtAndCashRes;
		this.sumAmountByCreatedAtAndCreditRes = sumAmountByCreatedAtAndCreditRes;
		this.sumTotalCashAndCreditRes = sumTotalCashAndCreditRes;
		this.sumAmountByCreatedAtAndCashCon = sumAmountByCreatedAtAndCashCon;
		this.sumAmountByCreatedAtAndCreditCon = sumAmountByCreatedAtAndCreditCon;
		this.sumTotalCashAndCreditCon = sumTotalCashAndCreditCon;
	}

	public String getCreatedAtConvertToString() {
		return createdAtConvertToString;
	}

	public String getCountByCreatedAtRes() {
		return countByCreatedAtRes;
	}

	public String getCountByCreatedAtCon() {
		return countByCreatedAtCon;
	}

	public String getCountByCreatedAtConGoods() {
		return countByCreatedAtConGoods;
	}
	
	public String getCountByCreatedAtlotteries() {
		return countByCreatedAtlotteries;
	}

	public String getCountByCreatedAtAndInvCodeRes() {
		return countByCreatedAtAndInvCodeRes;
	}

	public String getPerParseString() {
		return perParseString;
	}

	public String getSumAmountByCreatedAtAndCashRes() {
		return sumAmountByCreatedAtAndCashRes;
	}

	public String getSumAmountByCreatedAtAndCreditRes() {
		return sumAmountByCreatedAtAndCreditRes;
	}

	public String getSumTotalCashAndCreditRes() {
		return sumTotalCashAndCreditRes;
	}

	public String getSumAmountByCreatedAtAndCashCon() {
		return sumAmountByCreatedAtAndCashCon;
	}

	public String getSumAmountByCreatedAtAndCreditCon() {
		return sumAmountByCreatedAtAndCreditCon;
	}

	public String getSumTotalCashAndCreditCon() {
		return sumTotalCashAndCreditCon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((countByCreatedAtAndInvCodeRes == null) ? 0 : countByCreatedAtAndInvCodeRes.hashCode());
		result = prime * result + ((countByCreatedAtCon == null) ? 0 : countByCreatedAtCon.hashCode());
		result = prime * result + ((countByCreatedAtConGoods == null) ? 0 : countByCreatedAtConGoods.hashCode());
		result = prime * result + ((countByCreatedAtRes == null) ? 0 : countByCreatedAtRes.hashCode());
		result = prime * result + ((countByCreatedAtlotteries == null) ? 0 : countByCreatedAtlotteries.hashCode());
		result = prime * result + ((createdAtConvertToString == null) ? 0 : createdAtConvertToString.hashCode());
		result = prime * result + ((perParseString == null) ? 0 : perParseString.hashCode());
		result = prime * result
				+ ((sumAmountByCreatedAtAndCashCon == null) ? 0 : sumAmountByCreatedAtAndCashCon.hashCode());
		result = prime * result
				+ ((sumAmountByCreatedAtAndCashRes == null) ? 0 : sumAmountByCreatedAtAndCashRes.hashCode());
		result = prime * result
				+ ((sumAmountByCreatedAtAndCreditCon == null) ? 0 : sumAmountByCreatedAtAndCreditCon.hashCode());
		result = prime * result
				+ ((sumAmountByCreatedAtAndCreditRes == null) ? 0 : sumAmountByCreatedAtAndCreditRes.hashCode());
		result = prime * result + ((sumTotalCashAndCreditCon == null) ? 0 : sumTotalCashAndCreditCon.hashCode());
		result = prime * result + ((sumTotalCashAndCreditRes == null) ? 0 : sumTotalCashAndCreditRes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewResult other = (ViewResult) obj;
		if (countByCreatedAtAndInvCodeRes == null) {
			if (other.countByCreatedAtAndInvCodeRes != null)
				return false;
		} else if (!countByCreatedAtAndInvCodeRes.equals(other.countByCreatedAtAndInvCodeRes))
			return false;
		if (countByCreatedAtCon == null) {
			if (other.countByCreatedAtCon != null)
				return false;
		} else if (!countByCreatedAtCon.equals(other.countByCreatedAtCon))
			return false;
		if (countByCreatedAtConGoods == null) {
			if (other.countByCreatedAtConGoods != null)
				return false;
		} else if (!countByCreatedAtConGoods.equals(other.countByCreatedAtConGoods))
			return false;
		if (countByCreatedAtRes == null) {
			if (other.countByCreatedAtRes != null)
				return false;
		} else if (!countByCreatedAtRes.equals(other.countByCreatedAtRes))
			return false;
		if (countByCreatedAtlotteries == null) {
			if (other.countByCreatedAtlotteries != null)
				return false;
		} else if (!countByCreatedAtlotteries.equals(other.countByCreatedAtlotteries))
			return false;
		if (createdAtConvertToString == null) {
			if (other.createdAtConvertToString != null)
				return false;
		} else if (!createdAtConvertToString.equals(other.createdAtConvertToString))
			return false;
		if (perParseString == null) {
			if (other.perParseString != null)
				return false;
		} else if (!perParseString.equals(other.perParseString))
			return false;
		if (sumAmountByCreatedAtAndCashCon == null) {
			if (other.sumAmountByCreatedAtAndCashCon != null)
				return false;
		} else if (!sumAmountByCreatedAtAndCashCon.equals(other.sumAmountByCreatedAtAndCashCon))
			return false;
		if (sumAmountByCreatedAtAndCashRes == null) {
			if (other.sumAmountByCreatedAtAndCashRes != null)
				return false;
		} else if (!sumAmountByCreatedAtAndCashRes.equals(other.sumAmountByCreatedAtAndCashRes))
			return false;
		if (sumAmountByCreatedAtAndCreditCon == null) {
			if (other.sumAmountByCreatedAtAndCreditCon != null)
				return false;
		} else if (!sumAmountByCreatedAtAndCreditCon.equals(other.sumAmountByCreatedAtAndCreditCon))
			return false;
		if (sumAmountByCreatedAtAndCreditRes == null) {
			if (other.sumAmountByCreatedAtAndCreditRes != null)
				return false;
		} else if (!sumAmountByCreatedAtAndCreditRes.equals(other.sumAmountByCreatedAtAndCreditRes))
			return false;
		if (sumTotalCashAndCreditCon == null) {
			if (other.sumTotalCashAndCreditCon != null)
				return false;
		} else if (!sumTotalCashAndCreditCon.equals(other.sumTotalCashAndCreditCon))
			return false;
		if (sumTotalCashAndCreditRes == null) {
			if (other.sumTotalCashAndCreditRes != null)
				return false;
		} else if (!sumTotalCashAndCreditRes.equals(other.sumTotalCashAndCreditRes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
				.append("createdAtConvertToString")
				.append("countByCreatedAt")
				.append("countByCreatedAtCon")
				.append("countByCreatedAtConGoods")
				.append("countByCreatedAtlotteries")
				.append("countByCreatedAtAndInvCodeRes")
				.append("perParseString")
				.append("sumAmountByCreatedAtAndCashRes")
				.append("sumAmountByCreatedAtAndCreditRes")
				.append("sumTotalCashAndCreditRes")
				.append("sumAmountByCreatedAtAndCreditCon")
				.append("sumAmountByCreatedAtAndCreditRes")
				.append("sumTotalCashAndCreditRes")
				.toString();
	}
}
