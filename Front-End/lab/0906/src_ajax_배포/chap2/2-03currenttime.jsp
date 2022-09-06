<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.*,java.util.*"%><%
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String curTime = dateFormat.format(new Date());
System.out.println(curTime);
%><%= curTime %>