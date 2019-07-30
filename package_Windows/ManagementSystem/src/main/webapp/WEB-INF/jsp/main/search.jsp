<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp"%>
<script type="text/javascript">

window.onload = function() {
	getTimeStamp();
}

 function reListAll(){
	$(document).ready(function() {
		$.getJSON("/dateTime",function(data){
			var html=[]
			$(data).each(function(){
				html.push("<div class='tableSection'>");
				html.push("<table>");
				html.push("<th align='right'>" + this.createdAtConvertToString+"</th>");
				html.push("<th bgcolor='#D9E5FF' align='left'>入会</th>");
				html.push("<th bgcolor='#D9E5FF' align='left'>継続</th>");
				html.push("<th bgcolor='#D9E5FF' align='left'>グッズ</th>");
				html.push("<th bgcolor='#D9E5FF' align='left'>抽選会</th>");
				html.push("<th bgcolor='#D9E5FF' align='left'>友達紹介</th>");
				html.push("<th bgcolor='#D9E5FF' align='left'>友達紹介率(%)</th>");
				html.push("<tr>");
				html.push("<td bgcolor='#FFD5EC'>合計</td>");
				html.push("<td align='right'>" +this.countByCreatedAtRes+"</td>");
				html.push("<td align='right'>"+this.countByCreatedAtCon+"</td>");
				html.push("<td align='right'>"+this.countByCreatedAtConGoods+"</td>");
				html.push("<td align='right'>"+this.countByCreatedAtlotteries+"</td>");
				html.push("<td align='right'>"+this.countByCreatedAtAndInvCodeRes+"</td>");
				html.push("<td align='right'>"+this.perParseString+"</td>");
				html.push("</tr>");
				html.push("<tr>");
				html.push("<td bgcolor='#FFD5EC'>現金</td>");
				html.push("<td align='right'>"+this.sumAmountByCreatedAtAndCashRes+"</td>");
				html.push("<td align='right'>"+this.sumAmountByCreatedAtAndCashCon+"</td>");
				html.push("</tr>");
				html.push("<tr>");
				html.push("<td bgcolor='#FFD5EC'>クレカ</td>");
				html.push("<td align='right'>"+this.sumAmountByCreatedAtAndCreditRes+"</td>");
				html.push("<td align='right'>"+this.sumAmountByCreatedAtAndCreditCon+"</td>");
				html.push("</tr>");
				html.push("<tr>");
				html.push("<td bgcolor='#FFD5EC'>合計金額</td>");
				html.push("<td align='right'>"+this.sumTotalCashAndCreditRes+"</td>");
				html.push("<td align='right'>"+this.sumTotalCashAndCreditCon+"</td>");
				html.push("</tr>");
				html.push("</table>");
				html.push("</div>");
			});
			$("#resultTable").html(html.join(''));
		});
	});
 }

 reListAll();
 
 /* $("#resultTable").on("click", ".btnSize button", function(){
	 console.log("ok");
	 reListAll();
	}); */
 
</script>
<body>
	<header>
		<div class="btnSection">
			<input type="button" class="btnSize" value="会場情報を取得" onclick="getTimeStamp();reListAll();" >
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<span id="realTimePrint"></span>
		</div>
	</header>
	<main id="resultTable">
	</main>
	
</body>


<%@ include file="footer.jsp"%>