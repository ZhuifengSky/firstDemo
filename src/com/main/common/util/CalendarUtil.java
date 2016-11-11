package com.main.common.util;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

	/**
	 * ������ʼ���ںͼ��ʱ������������
	 * 
	 * @param sDate��ʼʱ��
	 * @param days���ʱ��
	 *            ���죩
	 * @return ����ʱ��
	 * */
	public static Date calculateEndDate(Date sDate, int days) {
		// ����ʼʱ�丳������ʵ��
		Calendar sCalendar = Calendar.getInstance();
		sCalendar.setTime(sDate);
		// �������ʱ��
		sCalendar.add(Calendar.DATE, days);
		// ����Date���ͽ���ʱ��
		return sCalendar.getTime();
	}

	/**
	 * ������ʼ���ںͼ��ʱ������������
	 * 
	 * @param sDate��ʼʱ��
	 * @param days���ʱ��
	 *            ���죩
	 * @return ����ʱ��
	 * */
	public static long calculateEndTime(Date sDate, int days) {
		// ����ʼʱ�丳������ʵ��
		Calendar sCalendar = Calendar.getInstance();
		sCalendar.setTime(sDate);
		// �������ʱ��
		sCalendar.add(Calendar.DATE, days);
		// ����Date���ͽ���ʱ��
		return sCalendar.getTimeInMillis();
	}

	/**
	 * ������ʼ���ںͼ��ʱ������������
	 * 
	 * @param sDate��ʼʱ��
	 * @param hours
	 *            ���ʱ��(Сʱ)
	 * @return ����ʱ��
	 * */
	public static Date calculateEndHour(Date sDate, int hours) {
		// ����ʼʱ�丳������ʵ��
		Calendar sCalendar = Calendar.getInstance();
		sCalendar.setTime(sDate);
		// �������ʱ��
		sCalendar.add(Calendar.HOUR, hours);
		// ����Date���ͽ���ʱ��
		return sCalendar.getTime();
	}

	/**
	 * ������ʼ���ںͼ��ʱ������������
	 * 
	 * @param sDate��ʼʱ��
	 * @param hours
	 *            ���ʱ��(����)
	 * @return ����ʱ��
	 * */
	public static Date calculateEndMinute(Date sDate, int minutes) {
		// ����ʼʱ�丳������ʵ��
		Calendar sCalendar = Calendar.getInstance();
		sCalendar.setTime(sDate);
		// �������ʱ��
		sCalendar.add(Calendar.MINUTE, minutes);
		// ����Date���ͽ���ʱ��
		return sCalendar.getTime();
	}

	/**
	 * ������ʼ���ںͼ��ʱ������������
	 * 
	 * @param sDate��ʼʱ��
	 * @param hours
	 *            ���ʱ��(��)
	 * @return ����ʱ��
	 * */
	public static Date calculateEndSecond(Date sDate, int SECOND) {
		// ����ʼʱ�丳������ʵ��
		Calendar sCalendar = Calendar.getInstance();
		sCalendar.setTime(sDate);
		// �������ʱ��
		sCalendar.add(Calendar.SECOND, SECOND);
		// ����Date���ͽ���ʱ��
		return sCalendar.getTime();
	}

	/**
	 * �ַ���ȥ����ͷ�ո����Ϊ�գ��򷵻�""��������գ��򷵻ظ��ַ���ȥ��ǰ��ո�
	 * 
	 * @param tStr�����ַ���
	 * @return ���Ϊ�գ��򷵻�""��������գ��򷵻ظ��ַ���ȥ��ǰ��ո�
	 */
	public static String cTrim(String tStr) {
		String ttStr = "";
		if (tStr == null) {
		} else {
			ttStr = tStr.trim();
		}
		return ttStr;
	}

	/**
	 * �����������ڵ�ʱ����
	 * 
	 * @param sDate��ʼʱ��
	 * @param eDate����ʱ��
	 * @param type�������
	 *            ("Y/y"--�� "M/m"--�� "D/d"--��)
	 * @return intervalʱ����
	 * */
	public static int calInterval(Date sDate, Date eDate, String type) {
		// ʱ��������ʼΪ0
		int interval = 0;
		/* �Ƚ��������ڵĴ�С�������ʼ���ڸ����򽻻��������� */
		// ��־���������Ƿ񽻻���
		boolean reversed = false;
		if (compareDate(sDate, eDate) > 0) {
			Date dTest = sDate;
			sDate = eDate;
			eDate = dTest;
			// �޸Ľ�����־
			reversed = true;
		}

		/* ���������ڸ�������ʵ��������ȡ�ꡢ�¡�������ֶ�ֵ */
		Calendar sCalendar = Calendar.getInstance();
		sCalendar.setTime(sDate);
		int sYears = sCalendar.get(Calendar.YEAR);
		int sMonths = sCalendar.get(Calendar.MONTH);
		int sDays = sCalendar.get(Calendar.DAY_OF_YEAR);

		Calendar eCalendar = Calendar.getInstance();
		eCalendar.setTime(eDate);
		int eYears = eCalendar.get(Calendar.YEAR);
		int eMonths = eCalendar.get(Calendar.MONTH);
		int eDays = eCalendar.get(Calendar.DAY_OF_YEAR);

		// ��
		if (cTrim(type).equals("Y") || cTrim(type).equals("y")) {
			interval = eYears - sYears;
			if (eMonths < sMonths) {
				--interval;
			}
		}
		// ��
		else if (cTrim(type).equals("M") || cTrim(type).equals("m")) {
			interval = 12 * (eYears - sYears);
			interval += (eMonths - sMonths);
		}
		// ��
		else if (cTrim(type).equals("D") || cTrim(type).equals("d")) {
			interval = 365 * (eYears - sYears);
			interval += (eDays - sDays);
			// ��ȥ��������
			while (sYears < eYears) {
				if (isLeapYear(sYears)) {
					--interval;
				}
				++sYears;
			}
		}
		// �����ʼ���ڸ����򷵻ظ�ֵ
		if (reversed) {
			interval = -interval;
		}
		// ���ؼ�����
		return interval;
	}

	/**
	 * �����������ֶΣ���ǰ���ڣ�
	 * 
	 * @param cNow��ǰʱ��
	 * @return null �����ֶ�ֵ��������get(field)�õ���Ҳ������set(field, value)�����޸�
	 * */
	public static void printFields(Calendar cNow) {
		// ����Date���������֤
		SimpleDateFormat df = (SimpleDateFormat) DateFormat.getInstance();
		df.applyPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("��׼����:" + df.format(new Date()));
		// ����������ֶ�ֵ
		System.out.print("���:" + cNow.get(Calendar.YEAR) + "\t");
		// �·�������(������·ݿ�ʼ����Ϊ0)
		System.out.print("�·�:" + cNow.get(Calendar.MONTH) + "\t");
		System.out.print("����:" + cNow.get(Calendar.DATE) + "\t");
		System.out.print("Сʱ:" + cNow.get(Calendar.HOUR) + "\t");
		System.out.print("����:" + cNow.get(Calendar.MINUTE) + "\t");
		System.out.println("����:" + cNow.get(Calendar.SECOND));
		// ����ĵڼ���,�ڼ���ʱ������ʱ������
		System.out.println("һ���е�����:" + cNow.get(Calendar.DAY_OF_YEAR));
		System.out.println("һ���е�����:" + cNow.get(Calendar.WEEK_OF_YEAR));
		// �����µĵڼ���
		System.out.println("һ���е�����:" + cNow.get(Calendar.WEEK_OF_MONTH));
		// ��һ���еĵڼ���(������������Ϊ��һ���)
		System.out.println("һ���е�����:" + cNow.get(Calendar.DAY_OF_WEEK));
	}

	/**
	 * �ж�ĳ������Ƿ�������
	 * 
	 * @param year���ж������
	 * @return �ж����
	 * */
	private static boolean isLeapYear(int year) {
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
	}

	/**
	 * �Ƚ�����Date���͵����ڴ�С
	 * 
	 * @param sDate��ʼʱ��
	 * @param eDate����ʱ��
	 * @return result���ؽ��(0--��ͬ 1--ǰ�ߴ� -1--���ߴ�)
	 * */
	public static int compareDate(Date sDate, Date eDate) {
		int result = 0;
		// ����ʼʱ�丳������ʵ��
		Calendar sC = Calendar.getInstance();
		sC.setTime(sDate);
		// ������ʱ�丳������ʵ��
		Calendar eC = Calendar.getInstance();
		eC.setTime(eDate);
		// �Ƚ�
		result = sC.compareTo(eC);
		// ���ؽ��
		return result;
	}

	public static Date intToDate(int time) {
		String temp = String.valueOf(time) + "000";
		Date date = new Date(Long.valueOf(temp));
		return date;
	}

	public static String intToDate(int time, String type) {
		String temp = String.valueOf(time) + "000";
		Date date = new Date(Long.valueOf(temp));
		SimpleDateFormat sfd = new SimpleDateFormat(type);
		return sfd.format(date);
	}
	
	public static String longToDate(long time, String type) {
 		Date date = new Date(Long.valueOf(time));
		SimpleDateFormat sfd = new SimpleDateFormat(type);
		return sfd.format(date);
	}

	public static int longToInt(long time) {
		return Integer.valueOf(String.valueOf(String.valueOf(time).substring(0,10)));
	}
	
	public static long intToLong(int time){
		String temp = String.valueOf(time) + "000";
 		return Long.valueOf(temp);
	}

	/**
	 * �� yyyy-MM-dd ��ʽ����ת����ʱ���
	 * @return
	 * @throws ParseException 
	 */
	public static long StringToTimestamp(String strTime) throws ParseException{
		 SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");  
		 Date date = format.parse(strTime);
		 return date.getTime();
	}
	
	/**
	 * �Ƚ�����time���͵����ڴ�С
	 * 
	 * @param sDate��ʼʱ��
	 * @param eDate����ʱ��
	 * @return result���ؽ��(0--��ͬ 1--ǰ�ߴ� -1--���ߴ�)
	 * */
	public static int compareTime(int sTime, int eTime) {
		int result = 0;
		if (sTime > eTime) {
			result = 1;
		} else if (sTime == eTime) {
			result = 0;
		} else {
			result = -1;
		}
		return result;
	}

	// MINUTE SECOND
	public static int SubtractTime(int sTime, int eTime, String type) {
		int jetLagTime = eTime - sTime;
		int jetLag = 0;
		if ("MINUTE".equals(type)) {
			jetLag = jetLagTime / (1000 * 60);
		} else if ("SECOND".equals(type)) {
			jetLag = jetLagTime / 1000;
		} else if ("HOUR".equals(type)) {
			jetLag = jetLagTime / (1000 * 60 * 60);
		}
		return jetLag;
	}

	/**
	 * ����time�͵�ǰʱ��֮���ʱ����������һ���°���������ʾ������24Сʱ���������ʾ������Сʱ������ʾ
	 * 
	 * @param sTime
	 * @param eTime
	 * @return
	 */
	public static String TimeInterval(long time) {
		String timeInterval = "";
  		long jetLagTime = new Date().getTime()-intToLong((int) time);
 		if (jetLagTime / 1000 < 60) {
			timeInterval = jetLagTime / 1000 + "��ǰ";
		} else if (jetLagTime / (1000 * 60) < 60) {
			timeInterval = jetLagTime / (1000 * 60) + "��ǰ";
		} else if (jetLagTime / (1000 * 60 * 60) < 24) {
			timeInterval = jetLagTime / (1000 * 60 * 60) + "Сʱǰ";
		} else if (jetLagTime / (1000 * 60 * 60 * 24) > 0) {
			if (jetLagTime / (1000 * 60 * 60 * 24) < 30) {
				BigDecimal days = new BigDecimal(jetLagTime / (1000 * 60 * 60 * 24)).setScale(0,BigDecimal.ROUND_HALF_UP);
				timeInterval = days + "��ǰ";
			} else {
				timeInterval = longToDate(intToLong((int) time), "yyyy-MM-dd");
			}
		}
		 
		return timeInterval;
	}

	public static void main(String agrs[]) {
 		System.out.println(new Date().getTime());
		String day = TimeInterval(1462362404);
		System.out.println(day);
		System.out.println(CalendarUtil.intToDate(1462362404, "yyyy-MM-dd HH:mm:ss"));
		
//		Date date = new Date();
//		int now = CalendarUtil.longToInt(CalendarUtil.calculateEndTime(date, 1));
//		
//		System.out.println(now);
//		
//		System.out.println(longToInt(CalendarUtil.calculateEndDate(date, 31).getTime()));
//
//		System.out.println(CalendarUtil.intToDate(1456482443, "yyyy-MM-dd HH:mm:ss"));
//
//		System.out.println(TimeInterval(new Date().getTime(),intToLong(1456571638)));
 
		
	//	Calendar sCalendar = Calendar.getInstance();
	//	printFields(sCalendar);

		/*
		 * // ��ȡ����ʵ�������赱ǰʱ�� Calendar cNow = Calendar.getInstance();
		 * cNow.setTime(new Date()); // �����������ֶ� printFields(cNow);
		 * 
		 * �����������ڵ�ʱ���� // ��ʼʱ�� Date sDate = new Date(); // ����ʱ�� try { Date eDate
		 * = (new SimpleDateFormat("yyyy-MM-dd")).parse("2012-05-29"); //
		 * ����������� System.out.println("������2020-05-29���:" + calInterval(sDate,
		 * eDate, "d") + "��"); } catch (ParseException e) { e.printStackTrace();
		 * }
		 * 
		 * ����������ڲ���� SimpleDateFormat df = (SimpleDateFormat)
		 * DateFormat.getInstance(); df.applyPattern("yyyy-MM-dd");
		 * System.out.println("�Ӽ��쿪ʼ���㣬2�����:" +
		 * df.format(calculateEndDate(sDate, 2)));
		 */
		
	}

}
