/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.wtu.broadcast.openapi.ts.Tables;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class MJDDateTime {

	public short MJD;
	public MJDTIME BCDTime;

	public MJDDateTime(Date time) {

		int y, m, d, h, mi, s;
		byte l;
		//java.util.Calendar cal = java.util.Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(time);

		if (cal.get(Calendar.YEAR) < 1900) {
			MJD = 0;
			BCDTime = new MJDTIME(0, 0, 0);
		} else {
			y = cal.get(Calendar.YEAR) - 1900;

			m = cal.get(Calendar.MONTH) + 1;
			d = cal.get(Calendar.DAY_OF_MONTH);

			h = cal.get(Calendar.HOUR_OF_DAY);
			
			mi = cal.get(Calendar.MINUTE);
			s = cal.get(Calendar.SECOND);
			if (m == 1 || m == 2) {
				l = 1;
			} else {
				l = 0;
			}

			int MJD1 = (int) (14956 + d + (int) ((y - l) * 365.25) + (int) ((m + 1 + l * 12) * 30.6001));
			MJD = (short) MJD1;
			BCDTime = new MJDTIME(h, mi, s);

		}
	}

	public int getSize() {
		return 5;
	}

	public byte[] convertToBytes() {
		int offSet = 0;
		byte[] data = new byte[5];
		data[offSet++] = (byte) (MJD >> 8);
		data[offSet++] = (byte) (MJD & 0xff);
		System.arraycopy(BCDTime.convertToBytes(), 0, data, offSet, 3);
		return data;
	}

	public static class MJDTIME {

		private byte Hour;
		private byte Minute;
		private byte Second;

		public byte[] convertToBytes() {
			byte[] data = new byte[3];
			data[0] = Hour;
			data[1] = Minute;
			data[2] = Second;
			return data;
		}

		public MJDTIME(byte[] data) {
			Hour = data[0];
			Minute = data[1];
			Second = data[2];
		}

		/// <summary>
		///
		/// </summary>
		/// <param name="seconds">秒数</param>
		public MJDTIME(int seconds) {

			int hour = (int) (seconds / 3600);
			int minute = (int) ((seconds - hour * 3600) / 60);
			int second = (int) ((seconds - hour * 3600) % 60);
			Hour = (byte) Tools.toBCD(hour);
			Minute = (byte) Tools.toBCD(minute);
			Second = (byte) Tools.toBCD(second);
		}
		/// <summary>
		///
		/// </summary>
		/// <param name="minutes">分</param>
		/// <param name="seconds">秒</param>

		public MJDTIME(int minutes, int seconds) {
			minutes += (int) (seconds / 60);
			seconds = seconds % 60;
			int hour = (int) (minutes / 60);
			int minute = (int) (minutes % 60);
			Hour = (byte) Tools.toBCD(hour);
			Minute = (byte) Tools.toBCD(minute);
			Second = (byte) Tools.toBCD(seconds);
		}

		/// <summary>
		///
		/// </summary>
		/// <param name="hours">时</param>
		/// <param name="minutes">分</param>
		/// <param name="seconds">秒</param>
		public MJDTIME(int hours, int minutes, int seconds) {
			minutes += (int) (seconds / 60);
			seconds = seconds % 60;
			hours += (int) (minutes / 60);
			minutes = minutes % 60;
			Hour = (byte) Tools.toBCD(hours);
			Minute = (byte) Tools.toBCD(minutes);
			Second = (byte) Tools.toBCD(seconds);
		}

		public int getSize() {
			return 3;
		}

	}

}
