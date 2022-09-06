<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,org.json.simple.*,org.json.simple.parser.*"%>
<%
/* JSON 데이터 받아오는 과정 */
StringBuffer sb = new StringBuffer();
BufferedReader br = request.getReader();
String line = null;
while((line = br.readLine()) != null) {
	sb.append(line);
}

/* JSON 데이터 받아오는 과정 */
JSONParser parser = new JSONParser();
JSONObject obj = (JSONObject) parser.parse(sb.toString());
String id = (String) obj.get("userid");
String pwd = (String) obj.get("userpwd");
int flag = 0;
String result = "아이디 또는 비밀번호를 확인하세요.";
if("ssafy".equals(id) && "1234".equals(pwd)) {
	flag = 1;
	result = "김싸피님 안녕하세요.";
}
out.println("{\"flag\":" + flag + ", \"msg\":\"" + result + "\"}");

//JSONObject jobj = new JSONObject();
//jobj.put("flag", flag);
//jobj.put("msg", result);
//response.setContentType("application/json");
//out.print(jobj.toJSONString()); // json 형식으로 출력
%>

