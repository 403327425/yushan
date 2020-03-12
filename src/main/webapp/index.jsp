<%
	String contextPath = request.getServletContext().getContextPath();	
	response.sendRedirect(contextPath+ "/user/login");
%>