package com.gdgm.stu.student_public;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//建立一个工厂类
//验证格式
public class verification {

	//验证身份证格式    通过正则表达式验证
	public boolean verification_id(String id)//传入身份证
	{
		//定义判别用户身份证号的正则表达式（要么是15位，要么是18位，最后一位可以为X）
		Pattern idNumPattern = Pattern.compile("(\\d{14}[0-9xX])|(\\d{17}[0-9xX])");
		//通过Pattern获得Matcher
		Matcher idNumMatcher = idNumPattern.matcher(id);
		//正确身份证号码输出true 否则输出flase
		return idNumMatcher.matches();
	}
	
    //验证日期格式    通过正则表达式验证
	public boolean verification_date(String bir)//传入出生日期（String类型的字符串）
	{
		//定义判断日期的正则表达式
		String eL= "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";   
		//通过Pattern获得Matcher
		Pattern p = Pattern.compile(eL);
        Matcher m = p.matcher(bir);
      //正确日期输出true 否则输出flase
        return m.matches();
	}
	
	//验证身份证的出生日期与自己填写的出生日期是否一致
	public boolean verification_id_date(String id,String bir)//传入身份证号和出生日期
	{
		String id_bir="";//定义身份证上的出生日期
		Pattern birthDatePattern= Pattern.compile("\\d{6}(\\d{4})(\\d{2})(\\d{2}).*");//身份证上的前6位以及出生年月日
		//通过Pattern获得Matcher
		Matcher birthDateMather= birthDatePattern.matcher(id);
		//通过Matcher获得用户的出生年月日
		if(birthDateMather.find()){
			String year = birthDateMather.group(1);//年
			String month = birthDateMather.group(2);//月
			String date = birthDateMather.group(3);//日
			id_bir=year+"-"+month+"-"+date;//身份证上的出生日期   写成字符串的yyyy-MM-dd格式
				
			SimpleDateFormat format1= new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format2,format3,format4;
			Date d1 = null;
			Date d2 = null;
		    try {
		        d1 = format1.parse(id_bir);
		        /*自己输入的出生日期可能有3种格式 分别为：
		         * 1  yyyy-MM-dd
		         * 2  yyyy/MM/dd
		         * 3  yyyyMMdd
		         * 所以有三中情况
		         * */
		        format2=new SimpleDateFormat("yyyy-MM-dd");
		        format3=new SimpleDateFormat("yyyyMMdd");
		        format4=new SimpleDateFormat("yyyy/MM/dd");
		        try
		        {
		        	d2 = format2.parse(bir); //第一种情况：自己输入出生日期的输入格式为"yyyy-MM-dd"
		        }
		        catch(Exception e1)  //非第种情况时，可能为二三种情况
		        {
		        	try
		        	{
			        	d2 = format3.parse(bir);//第二种情况：自己输入出生日期的输入格式为"yyyyMMdd"
		        	}
		        	catch(Exception e2)//非第种情况时，可能为三种情况
		        	{
		        		try
			        	{
				        	d2 = format4.parse(bir);//第三种情况：自己输入出生日期的输入格式为"yyyy/MM/dd"
			        	}
			        	catch(Exception e3)
			        	{
			        		return false;
			        	}
		        	}
		        }
		        
		        return format1.format(d1).equals(format1.format(d2));
		    }
		    catch (Exception e) { 
		    	return false;
		    } 
		}
		return false;
	}
}
