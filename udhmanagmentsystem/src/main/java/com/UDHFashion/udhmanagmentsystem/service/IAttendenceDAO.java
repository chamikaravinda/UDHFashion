package com.UDHFashion.udhmanagmentsystem.service;

import java.util.ArrayList;

import com.UDHFashion.udhmanagmentsystem.model.Attendence;
import com.UDHFashion.udhmanagmentsystem.model.AttendenceList;

public interface IAttendenceDAO {

	public ArrayList<AttendenceList> getAttendenceList(String date);

	public boolean AddEmployeeAttendence(AttendenceList attend);

	long addDailyAttendence(Attendence attendence);

	boolean UpdateEmployeeAttendence(AttendenceList attend);

	boolean UpdateDailyAttendence(Attendence attendence);

	AttendenceList getEmpDailyAttendence(int id);
}
