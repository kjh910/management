package com.manage.system;

import static com.manage.system.util.DateTimeUtils.dateTimeOf;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manage.result.ViewResult;
import com.manage.system.service.ContinueGoodsService;
import com.manage.system.service.ContinuesService;
import com.manage.system.service.LotteriesServices;
import com.manage.system.service.RegistrationsService;
import com.manage.system.util.DecimalFormatUtils;
import com.manage.system.util.InvitationPerCalculation;
import com.manage.system.util.SumTotalCalculation;

/**
 * @概要: 各Serviceで処理した結果値を Viewに渡すためのControllerクラス
 * @処理内容: 各Serviceで受け取ったRepositoryの結果値をViewResultのコンストラクタの引数として格納する。
 * 			-> ResponseEntity<List<ViewResult>>にViewResultクラスを追加
 * return : ResponseEntity<List<ViewResult>>
 */

@RestController
public class ViewRestController {

	private final RegistrationsService registrationsService;
	private final ContinuesService continuesService;
	private final ContinueGoodsService continueGoodsService;
	private final LotteriesServices lotteriesServices;

	public ViewRestController(
			RegistrationsService registrationsService, 
			ContinuesService continuesService,
			ContinueGoodsService continueGoodsService,
			LotteriesServices lotteriesServices) {
		this.registrationsService = registrationsService;
		this.continuesService = continuesService;
		this.continueGoodsService = continueGoodsService;
		this.lotteriesServices = lotteriesServices;
	}
	
	@RequestMapping(value = "/dateTime", method = RequestMethod.GET)
	public ResponseEntity<List<ViewResult>> input() {
		
		ResponseEntity<List<ViewResult>> resEntity = null;
		
		Long count = registrationsService.countCreatedAt();
		List<Timestamp> createdAtList = registrationsService.createdAtList();
		List<ViewResult> viewResultList = new ArrayList<>();
		
		for(int i=0; i<count; i++) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime convertFromTimestamp = dateTimeOf(createdAtList.get(i));
			String createdAtConvertToString = convertFromTimestamp.format(dateTimeFormatter);
			
			Long countByCreatedAtRes = registrationsService.countByCreatedAtRes(createdAtConvertToString);
			Long countByCreatedAtCon = continuesService.countByCreatedAtCon(createdAtConvertToString);
			Long countByCreatedAtConGoods = continueGoodsService.countByCreatedAtConGoods(createdAtConvertToString);
			Long countByCreatedAtLotteries = lotteriesServices.countByCreatedAtLotteries(createdAtConvertToString);
			Long countByCreatedAtAndInvCodeRes = registrationsService.countByCreatedAtAndInvCodeRes(createdAtConvertToString);
			
			Long sumAmountByCreatedAtAndCashRes = registrationsService.sumAmountByCreatedAtAndCashRes(createdAtConvertToString);
			Long sumAmountByCreatedAtAndCreditRes = registrationsService.sumAmountByCreatedAtAndCreditRes(createdAtConvertToString);
			Long sumTotalCashAndCreditRes = SumTotalCalculation
					.sumTotalCalculationRes(sumAmountByCreatedAtAndCashRes, sumAmountByCreatedAtAndCreditRes);
			
			Long sumAmountByCreatedAtAndCashCon = continuesService.sumAmountByCreatedAtAndCashCon(createdAtConvertToString);
			Long sumAmountByCreatedAtAndCreditCon = continuesService.sumAmountByCreatedAtAndCreditCon(createdAtConvertToString);
			Long sumTotalCashAndCreditCon = SumTotalCalculation
					.sumTotalCalculationRes(sumAmountByCreatedAtAndCashCon, sumAmountByCreatedAtAndCreditCon);
			
			ViewResult viewResult = new ViewResult(
					createdAtConvertToString, 
					DecimalFormatUtils.decimalToThousandUnitsFormatter(countByCreatedAtRes), 
					DecimalFormatUtils.decimalToThousandUnitsFormatter(countByCreatedAtCon), 
					DecimalFormatUtils.decimalToThousandUnitsFormatter(countByCreatedAtConGoods),
					DecimalFormatUtils.decimalToThousandUnitsFormatter(countByCreatedAtLotteries),
					DecimalFormatUtils.decimalToThousandUnitsFormatter(countByCreatedAtAndInvCodeRes),
					InvitationPerCalculation.perDevideCountByCreatedAtToInvCodeRes(countByCreatedAtAndInvCodeRes,countByCreatedAtRes),
					DecimalFormatUtils.decimalYenUnitsFormatter(sumAmountByCreatedAtAndCashRes),
					DecimalFormatUtils.decimalYenUnitsFormatter(sumAmountByCreatedAtAndCreditRes),
					DecimalFormatUtils.decimalYenUnitsFormatter(sumTotalCashAndCreditRes),
					DecimalFormatUtils.decimalYenUnitsFormatter(sumAmountByCreatedAtAndCashCon),
					DecimalFormatUtils.decimalYenUnitsFormatter(sumAmountByCreatedAtAndCreditCon),
					DecimalFormatUtils.decimalYenUnitsFormatter(sumTotalCashAndCreditCon));
			viewResultList.add(viewResult);
		}
		try {
			resEntity = new ResponseEntity<List<ViewResult>>(viewResultList, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			resEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return resEntity;

	}

}
