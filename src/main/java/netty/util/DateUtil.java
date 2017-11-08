package netty.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



/**
 * ʱ��util
 * @author admin
 * 
 */
public class DateUtil {
	
	/**һ�������*/
	public static final int DAY_SEC = 60*60*24;
	/**һСʱ������**/
	public static final int HOUR_SEC = 60*60;
	/**һ���ӵ�����*/
	public static final int MINUTE_SEC = 60;
	/**һ��ĺ�����*/
	public static final long DAY_MILL_SEC = 60*60*24 * 1000;
	
	/**
	 * ��õ�ǰUtilʱ��
	 * 
	 * @return
	 */
	public static Date getCurrentUtilDate() {
		return new Date();
	}
	
	/**
	 * ����ʱ�������
	 * @return
	 *��int
	 */
	public static int getDateSeconds(){
		return getDateSeconds(new Date());
	}
	/**
	 * ����ʱ�������
	 * @param date
	 * @return
	 *��int
	 */
	public static int getDateSeconds(Date date){
		return (int)(date.getTime() / 1000);
	}

	/**
	 * ��������
	 * 
	 * @param date
	 * @return
	 */
	public static int getSecond(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.SECOND);
	}

	/**
	 * ���ط���
	 * @param date
	 * @return
	 */
	public static int getMinute(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MINUTE);
	}
	
	/**
	 * ����Сʱ
	 * @param date
	 * @return
	 */
	public static int getHour(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * ������
	 * */
	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_YEAR);
	}
	
	public static int getMonthDay(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getMonth(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		
		return c.get(Calendar.MONTH) + 1;
	}
	
	public static int getYear(Date date){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}
	/**
	 * ��ȡһ��Ŀ�ʼʱ��(yyyy-MM-dd 00:00:00)
	 * @param time
	 * @return
	 */
	public static Date getDayOfStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * ��ȡһ��Ľ���ʱ��(yyyy-MM-dd 23:59:59)
	 * @param time
	 * @return
	 */
	public static Date getDayOfEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}
	
	/**
	 * ��ȡһ��Сʱ�Ŀ�ʼʱ��(yyyy-MM-dd hh:00:00)
	 * @param time
	 * @return
	 */
	public static Date getHourOfStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * ��ȡһ��Сʱ�Ľ���ʱ��(yyyy-MM-dd hh:59:59)
	 * @param time
	 * @return
	 */
	public static Date getHourOfEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}
	
	/**
	 * ���������޸�ʱ��(��ʱ��)
	 * @param date
	 * @param type �룬�֣�Сʱ����ȵ�
	 * @param time 
	 * @return
	 */
	public static Date addDateByType(Date date, int type, int time) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, time);
		
		return calendar.getTime();
	}
	
	/**
	 * ���������޸�ʱ��(��ʱ��)
	 * @param date
	 * @param type �룬�֣�Сʱ����ȵ�
	 * @param time 
	 * @return
	 */
	public static Date subDateByType(Date date, int type, int time) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		long dateTime = calendar.getTimeInMillis();
		
		long mul = 1;
		
		switch (type) {
		case Calendar.DAY_OF_MONTH:
			mul = mul * 24 * 60 * 60 * 1000;
			break;
		case Calendar.HOUR:
		case Calendar.HOUR_OF_DAY:
			mul = mul * 60 * 60 * 1000;
			break;
		case Calendar.MINUTE:
			mul = mul * 60 * 1000;
			break;
		case Calendar.SECOND:
			mul = mul * 1000;
			break;
		}
		
		calendar.setTimeInMillis(dateTime - mul * time);
		
		return calendar.getTime();
	}
	
	/**
	 * �Ƿ��ǵ���
	 * @param date
	 * @return
	 */
	public static boolean isCurrentDay(Date date) {
		boolean result = false;
		
		Calendar today = Calendar.getInstance();
		
		Calendar dateDay = Calendar.getInstance();
		dateDay.setTime(date);
		
		if (today.get(Calendar.YEAR) == dateDay.get(Calendar.YEAR)
				&& today.get(Calendar.MONTH) == dateDay.get(Calendar.MONTH)
				&& today.get(Calendar.DAY_OF_MONTH) == dateDay.get(Calendar.DAY_OF_MONTH)) {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * ��ǰʱ���Ƿ��ڿ�ʼʱ��ͽ���ʱ��֮��
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static boolean isInTime(Date startTime, Date endTime) {
		boolean result = false;

		if (System.currentTimeMillis() > startTime.getTime()
				&& System.currentTimeMillis() < endTime.getTime()) {
			result = true;
		}

		return result;
	}
	
	/**
	 *	ָ����ʱ���Ƿ��ڿ�ʼʱ��ͽ���ʱ��֮��
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static boolean isInTime(Date date, Date startTime, Date endTime) {
		boolean result = false;

		if (date.getTime() > startTime.getTime()
				&& date.getTime() < endTime.getTime()) {
			result = true;
		}

		return result;
	}
	
	/**
	 * ��ǰʱ���Ƿ��ڿ�ʼʱ��ͽ���ʱ��֮��
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static boolean isInTime(long startTime, long endTime) {
		boolean result = false;

		if (System.currentTimeMillis() > startTime
				&& System.currentTimeMillis() < endTime) {
			result = true;
		}

		return result;
	}
	
	/**
	 * ��֤ʱ���Ƿ�������
	 * @param getGiftbagTime
	 * @return
	 */
	public static boolean checkIsInWeek(Date getGiftbagTime) {
		boolean result = false;
		
		if (getGiftbagTime != null) {
			
			Calendar calendar = Calendar.getInstance();
			int week = calendar.get(Calendar.DAY_OF_WEEK);
			
			// ���ܵ�һ��
			Calendar fistDay = Calendar.getInstance();
			fistDay.add(Calendar.DAY_OF_MONTH, 2 - week);
			fistDay.set(Calendar.HOUR_OF_DAY, 0);
			fistDay.set(Calendar.MINUTE, 0);
			fistDay.set(Calendar.SECOND, 0);
			
			// �������һ��
			Calendar lastDay = Calendar.getInstance();
			lastDay.add(Calendar.DAY_OF_MONTH, 8 - week);
			lastDay.set(Calendar.HOUR_OF_DAY, 23);
			lastDay.set(Calendar.MINUTE, 59);
			lastDay.set(Calendar.SECOND, 59);
			
			if (getGiftbagTime.getTime() > fistDay.getTime().getTime() && getGiftbagTime.getTime() < lastDay.getTime().getTime()) {
				result = true;
			}
		}
		
		return result;
	}
	
	/**
	 * �Ƿ�ÿ�ܵ�һ��
	 * @return
	 */
	public static boolean isFirstWeekDay() {
		boolean result = false;
		
		Calendar calendar = Calendar.getInstance();
		if (calendar.get(Calendar.DAY_OF_WEEK) == 2) {
			result = true;
		}
		
		return result;
	}
	
	/**
	 * ����calendarʱ��
	 */
	public static Calendar setCalendarTime(int hour, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, 0);
		return calendar;
	}
	
	/**
	 * ��ȡʱ���ַ���(00:00:00)
	 */
	public static String getTimeStr(int hour, int minute) {
		String str = hour + ":";
		if (minute > 9) {
			str = str + minute + ":00";
		} else {
			str = str + "0" + minute + ":00";
		}
		return str;
	}
	
	/**
	 * ָ���ַ���ʱ��תDate
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static Date getDateByString(String timeStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return dateFormat.parse(timeStr);
		} catch (Exception e) {
			return getDateString(timeStr);
		}
	}
	
	/**
	 * ָ���ַ���ʱ��תDate
	 * yyyy-MM-dd
	 */
	public static Date getDateString(String timeStr) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(timeStr);
		} catch (Exception e) {
			//TODO tianjiayige logutil by xuzhishun
			//LogUtil.error("�쳣:",e);
		}
		
		return null; 
	}
	
	/**�ַ���ת����date ����ǰѳ��õĸ�ʽ����ɳ���.. */
	public static Date parseDate(String strDate) throws ParseException{
		return parseDate(strDate,null);
	}
	
	/**�ַ���ת����date */
	public static Date parseDate(String strDate,String fmt) throws ParseException{
		
		if(fmt == null || fmt.trim().equals("")){
			fmt = "yyyy-MM-dd HH:mm:ss";
		}
		
		return new SimpleDateFormat(fmt).parse(strDate);
		
	}
	
	/** ʱ���ʽ�� �ø�ʽ�ܹ�����*/
	public static String dateFormt(Date date, String fmt){
		if(fmt == null || fmt.trim().equals("")){
			fmt = "yyyy-MM-dd HH:mm:ss";
		}
		
		return new SimpleDateFormat(fmt).format(date);
	}
	/** ʱ���ʽ�� */
	public static String dateFormat(Date date) {
		return dateFormt(date,"yyyy-MM-dd HH:mm:ss");
	}
	
	/** ʱ���ʽ�� */
	public static String dateFormatYMD(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	/** �������*/
	public static int difDate(Date startTime, Date endTime){
		return (int) ((getYMDOfStartTime(endTime).getTime() / 1000 - getYMDOfStartTime(startTime).getTime() / 1000) / (24 * 60 * 60 ) + 1);
	}
	
	/** ��ȡһ��Сʱ�Ŀ�ʼʱ��(yyyy-MM-dd 00:00:00)*/
	@SuppressWarnings("static-access")
	public static Date getYMDOfStartTime(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	
	/** ����ʱ��*/
	public static Date getDateAddTime(Date date, int addTime){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date.getTime() + addTime);
		
		return c.getTime();
	}
	
	
	/** ����ʱ��*/
	public static int difTime(Date startTime){
		return (int)((System.currentTimeMillis() - startTime.getTime()) / 1000);
	}
	
	
	/** ��ȡָ���·� ������ʱ��*/
	public static Date getDateByMonthDay(int year, int month, int day){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH , month - 1);
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		
		return c.getTime();
	}
	
	
	
	/** ת��Ϊ���ݿ�ʱ��*/
	public static Timestamp getSqlDate(Date date){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		String nowTime = dateFormat(c.getTime());
		Timestamp time = java.sql.Timestamp.valueOf(nowTime);
		
		return time; 

	}
	
	/**��ȡ����������*/
	public static int getMonthMaxDay(){
		Calendar instance = Calendar.getInstance();
		return instance.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	
	
}
