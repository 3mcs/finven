<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page import="com.finvendor.util.RequestConstans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<!-- [if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> -->
<meta name="viewport"
	content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
<meta name="SKYPE_TOOLBAR" content="SKYPE_TOOLBAR_PARSER_COMPATIBLE" />
<title>FinVendor</title>
<link href="<%=request.getContextPath() %>/resources/css/style.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/jquery.bxslider.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/superfish.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/jquery-ui.css" />
</head>
<body>
<c:set var="checkingresultpageview" value="${checkingresultpageview}"></c:set>
	<div class="container">
		<jsp:include page="common/header.jsp"></jsp:include>
	</div>
	
	<div class="container">
		<jsp:include page="common/banner.jsp"/>
	</div>
	
	<jsp:include page="login.jsp"></jsp:include>
	
	<div class="container">
		<jsp:include page="common/footer.jsp"></jsp:include>
	</div>
	<div class="sideslider" id="sideslider" style="margin-left: -265px;">
    <div class="sideslider-tab">C<br>o<br>n<br>t<br>a<br>c<br>t<br>u<br>s</div>
    <a href="#">
        <div id="sideslider-smartbutton">
            <div id="sideslider-text">
                <form>
				Name:<br>
				<input type="text" name="firstname">  <br>
				Company name:<br>
				<input type="text" name="firstname">  <br>
				Email<br>
				<input type="text" name="lastname">
				<br>
				<input type="button" value="Submit"/>
				</form>
				
            </div>
            <div class="sideclear"></div>
        </div>

    </a>
    <div class="sideslider-close sideslider-close_en">Close&nbsp;</div>
</div>


</body>
<!--<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-1.11.0.min.js"></script>-->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery.side-slider.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $('#sideslider').sideSlider();

    });
</script>
<!-- <script type="text/javascript">
window.onload = function(){
	alert('message view---:');
	var check= '${checkingresultpageview}';
	alert('rayulu vemula---:' + check);
	if(personalDetails != null && personalDetails.length > 0 && personalDetails.match("personaldetails")){
		 
	}
};
</script> -->
</html>
