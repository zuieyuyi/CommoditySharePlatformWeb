/**
 * 验证密码复杂度（必须包含数字字母）
 */
function validateStr(str){
    var reg1 = /^(([0-9]{1,})([a-z]{1,}))|(([a-z]{1,})([0-9]{1,}))$/;
    var reg2 = /^(([0-9]{1,})([A-Z]{1,}))|(([A-Z]{1,})([0-9]{1,}))$/;
    //var reg3 = /^([a-zA-Z]{0,})[0-9a-z-A-z]{0,}[~`!@#$%^&*.]{0,}$/;
    str = valueTrim(str);
    //if(reg3.test(str)){
    //	return true;
    //}
    if(reg1.test(str)){
        return true;
    }
    if(reg2.test(str)){
        return true;
    }
    return false;
}

/**
 * 判断字符串长度
 */
function valiDateLength(str,end,start){
    if(str==null || str==''){
        return false;
    }
    str = valueTrim(str);
    if(parseFloat(str.length)<start ){
        return false;
    }
    if(parseFloat(str.length)>end){
        return false;
    }
    return true;
}
/**
 * 验证时间
 */
function valiDate(dateValue){
    var result = dateValue.match(/((^((1[8-9]\d{2})|([2-9]\d{3}))(-)(10|12|0?[13578])(-)(3[01]|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(11|0?[469])(-)(30|[12][0-9]|0?[1-9])$)|(^((1[8-9]\d{2})|([2-9]\d{3}))(-)(0?2)(-)(2[0-8]|1[0-9]|0?[1-9])$)|(^([2468][048]00)(-)(0?2)(-)(29)$)|(^([3579][26]00)(-)(0?2)(-)(29)$)|(^([1][89][0][48])(-)(0?2)(-)(29)$)|(^([2-9][0-9][0][48])(-)(0?2)(-)(29)$)|(^([1][89][2468][048])(-)(0?2)(-)(29)$)|(^([2-9][0-9][2468][048])(-)(0?2)(-)(29)$)|(^([1][89][13579][26])(-)(0?2)(-)(29)$)|(^([2-9][0-9][13579][26])(-)(0?2)(-)(29)$))/);
    if(result==null){
        return false;
    }
    return true;
}
/**
 * 验证电话号码
 */
function validatePhone(phoneValue) {
    phoneValue = valueTrim(phoneValue);
    var reg = /^[1][0-9]{10}$/;
    return reg.test(phoneValue);
}
/**
 * 验证邮箱
 */
function validateEmail(emailValue){
    // var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    // var reg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
    var reg = /^[A-Za-zd0-9] ([-_.][A-Za-zd] )*@([A-Za-zd] [-.]) [A-Za-zd]{2,5}$/;
    return reg.test(emailValue);
}
/**
 * 判断是否是数字
 */
function isNumber(numberValue){
    //定义正则表达式部分
    var reg1 = /^[0-9]{0,}$/;
    var reg2 = /^[1-9]{1}[0-9]{0,}$/;
    //alert(numberValue);
    if(numberValue ==null || numberValue.length==0){
        return false;
    }
    numberValue = valueTrim(numberValue);
    //判断当数字只有1位时
    if(numberValue.length<2){
        return reg1.test(numberValue);
    }
    return reg2.test(numberValue);;
}
/***
 * 金额
 */
function isMoney(value) {
    if(value==''){
        return false;
    }
    value = valueTrim(value);
    value = value.replace(/(^\s*)|(\s*$)/g, "");
    var reg = /^[0-9]*\.?[0-9]{0,2}$/;
    if(isNumber(value)){
        return true;
    }
    if(value.length>3){
        if(value.substr(0, 1)=="0"){
            if(value.substr(3,value.length).length>2){
                return false;
            }
        }
    }
    return reg.test(value);
}
/***
 * 判断是否是0到100之间的数
 */
function isZeroToOne(value) {
    if(value==''){
        return false;
    }
    value = valueTrim(value);
    if(isMyFloat(value)){
        if(parseFloat(value)<100 && parseFloat(value)>0){
            return true;
        }
    }
    return false;
}


/**
 * 验证是否是浮点数
 */
function isMyFloat(floatValue){
    if(floatValue==''){
        return false;
    }
    floatValue = valueTrim(floatValue);
    var reg = /^(\d+)(\.\d+)$/;
    if(isNumber(floatValue)){
        return true;
    }
    if(floatValue.length>3){
        if(floatValue.substr(0, 1)=="0"){
            if(floatValue.substr(0, 2)!="0."){
                return false;
            }
        }
    }
    return reg.test(floatValue);
}
/**
 * 判断是否是汉字
 */
function isCharacter(charValue){
    var reg = /^[\u4e00-\u9fa5]{0,}$/;
    return reg.test(charValue);
}
/**
 * 验证座机号
 */
function valiDateTel(telValue){
    var reg = /^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/;
    telValue = valueTrim(telValue);
    if(!reg.test(telValue)){
        return false;
    }
    return true;
}
//去掉字符串头尾空格
function valueTrim(str) {
    return str.replace(/(^\s*)|(\s*$)/g, "");
}

/**
 * 获取指定日期之前或之后的第几天
 *
 * @param dayCount
 *            正数为以后时间，负数为以前时间 如：1表示为明天，-1为昨天
 */
function getDateStr(dates, dayCount) {
    var dateTime = dayCount * 24 * 60 * 60 * 1000;
    var dd = new Date();
    if (dates == "") {
        dd = new Date();
    } else {
        dd = new Date(dates);
    }
    var dateNumber = dd.getTime() + dateTime;
    var newDate = new Date(dateNumber);
    var y = newDate.getFullYear();
    var m = newDate.getMonth() + 1;// 获取当前月份的日期
    var d = newDate.getDate();
    if (m < 10) {
        m = "0" + m;
    }
    if (d < 10) {
        d = "0" + d;
    }
    return y + "-" + m + "-" + d;
}
/**
 * 获取指定月份的之前或之后的第几个月
 *
 * @param dayCount
 *            正数为以后月份，负数为以前月份 如：1表示为下月，-1为上月
 *
 */
function getMonthStr(dates, monthCount) {
    var dd = new Date();
    if (dates == "") {
        dd = new Date();
    } else {
        dd = new Date(dates);
    }
    var y = dd.getFullYear();
    var m = dd.getMonth() + 1;// 获取当前月份的日期
    m = m + monthCount;
    if (m == 0) {
        m = "12";
        y = y - 1;
    } else if (m < 10) {
        m = "0" + m;
    } else if (m > 12) {
        m = m - 12;
        m = "0" + m;
        y = y + 1;
    }
    return y + "-" + m;
}
/**
 *
 *对val值为undefined返回“”，否则返回原值
 */
function dealNull(val) {
    if (typeof (val) == "undefined") {
        return "";
    } else {
        return val;
    }
}