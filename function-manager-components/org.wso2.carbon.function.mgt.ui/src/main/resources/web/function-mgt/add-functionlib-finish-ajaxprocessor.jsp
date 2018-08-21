

<%
    String httpMethod = request.getMethod();
    if (!"post".equalsIgnoreCase(httpMethod)) {
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        return;
    }

    String functionLibName = request.getParameter("functionLibName");
    String description = request.getParameter("functionLib-description");
%>