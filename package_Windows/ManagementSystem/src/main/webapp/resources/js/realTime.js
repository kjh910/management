function getTimeStamp() {
  var date = new Date();
  var parseDate =
    leadingZeros(date.getFullYear(), 4) + '-' +
    leadingZeros(date.getMonth() + 1, 2) + '-' +
    leadingZeros(date.getDate(), 2) + ' ' +

    leadingZeros(date.getHours(), 2) + ':' +
    leadingZeros(date.getMinutes(), 2) + ':' +
    leadingZeros(date.getSeconds(), 2);

    document.getElementById("realTimePrint").innerHTML = "更新時間 : " + parseDate;
  return parseDate;
}

function leadingZeros(n, digits) {
  var zero = '';
  n = n.toString();

  if (n.length < digits) {
    for (i = 0; i < digits - n.length; i++)
      zero += '0';
  }
  return zero + n;
}

