<%@page import="com.finvendor.util.RequestConstans"%>
<%@page import="org.springframework.security.core.authority.SimpleGrantedAuthority"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@taglib uri="/WEB-INF/finvendor.tld" prefix="finVen"%>

<c:set var="username" value="${finVen:decrypt(param.RaYUnA)}"></c:set>
<c:set var="myusername" value="${myusername}"></c:set>
<div class="header"> 
	<img src="${pageContext.request.contextPath}/resources/images/logo-new.png" style="height:61px;width:115px" alt="FinVendor" title="FinVendor" onclick="homepage();"/> 
	<div class="hd-right">
		<p>
			<c:choose>
				<c:when test="${not empty username || not empty myusername}"></c:when>
				<c:otherwise>
				  	<img src="${pageContext.request.contextPath}/resources/images/fn.png" alt="" title=""/><i>FINANCIAL VENDOR?</i> 
					<a class="cd-signin" href="${pageContext.request.contextPath}/#0">LIST YOUR OFFERINGS</a>
				</c:otherwise>
			</c:choose>
		</p>
		<ul>
			<c:choose>
				<c:when test="${not empty username || not empty myusername}">
					<div class="area">
						<div class="Rowtableinfovaluserpng">
							<div class="ColumnCommonrayuserlogout">
								<a href="<%=request.getContextPath() %>/logout"><span class="lable_headeractionsuserpng"><img src="<%=request.getContextPath() %>/resources/images/sign-out.png" width="25" height="25"/>Logout</span></a>
							</div>  
							<div class="ColumnCommonrayuserpng">
								<a href="#normalModal"><span class="lable_headeractionsuserpng"><img src="<%=request.getContextPath() %>/resources/images/user.png" width="30" height="30"/> Welcome <c:out value="${fn:toUpperCase(username)}" /></span></a>
							</div>  
						</div> 
					</div>
				</c:when>
				<c:otherwise>
					<li class="login"><img src="${pageContext.request.contextPath}/resources/images/lg.png" alt="" title="" /><span><a class="cd-signin" href="${pageContext.request.contextPath}/#0">Login</a>/<a class="cd-signup" href="${pageContext.request.contextPath}/#0">Register</a></span></li>
					<li><span></span></li>
					<li><img src="${pageContext.request.contextPath}/resources/images/msg.png" alt="" title=""/><span><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=CONTACT">CONTACT</a></span></li> 
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	<div class="clearfix"></div>
</div>
<div class="nav-srch">
	<div class="container">
		<div class="nav-srch-cnt">
			<ul class="sf-menu" id="example">
				<li><a href="#" onclick="homePage();"><img src="${pageContext.request.contextPath}/resources/images/hm.png" alt="" title="" /></a></li>
				<c:if test="${not empty myusername}">
				<li><a href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_MY_PROFILE%>?RaYUnA=${finVen:encrypt(myusername)}" style="padding: 9px 6px; font-size: 11px;">My Home</a></li>
				</c:if>
				<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=SOLUTIONS">SOLUTIONS</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=SOLUTIONS&subNav=mdvad&RaYUnA=${finVen:encrypt(username)}">Market Data Vendors</a></li>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=SOLUTIONS&subNav=tavd&RaYUnA=${finVen:encrypt(username)}">Trading Application Vendors</a></li>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=SOLUTIONS&subNav=faavd&RaYUnA=${finVen:encrypt(username)}">Analytics Application Vendors</a></li>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=SOLUTIONS&subNav=frrpd&RaYUnA=${finVen:encrypt(username)}">Research Report Providers</a></li>
					</ul>
				</li>
				<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=SERVICES">SERVICES</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=SERVICES&subNav=dadd">Data Aggregator Services</a></li>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=SERVICES&subNav=tapdd">Trading Application Services</a></li>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=SERVICES&subNav=aapdd">Analytics Application Services</a></li>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=SERVICES&subNav=rrpdd">Research Report Services</a></li>
					</ul>
				</li>
				<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=RESOURCES">RESOURCES</a>
					<ul>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=RESOURCES&subNav=b">Brochures</a></li>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=RESOURCES&subNav=w">Whitepapers</a></li>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=RESOURCES&subNav=blgs">Blogs</a></li>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=RESOURCES&subNav=cs">Case Studies</a></li>
						<li><a href="${pageContext.request.contextPath}/view/common/inner.jsp?nav=RESOURCES&subNav=s">Spotlights</a></li>
					</ul>
			  </li>
			</ul>
			<input name="" type="text" class="srch" value="Search">
		</div>
	</div>
</div>
<!--  Vendor Dashboard Tabs--- -->
	  <c:if test="${not empty myprofiletab }">
	 <div class="text_area"><div class="text_arw"> <a href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_MY_PROFILE%>?RaYUnA=${finVen:encrypt(username)}">My Profile</a> </div><div class="arw"> <img src="<%=request.getContextPath() %>/resources/images/arw.png"  width="22" height="16" /></div> <div class="text_arw">Information</div></div>
	</c:if>  
	<c:if test="${not empty myofferingstab }">
	 <div class="text_area"><div class="text_arw"> <a href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_MY_OFFERINGS%>?RaYUnA=${finVen:encrypt(username)}">My Offerings</a> </div><div class="arw"> <img src="<%=request.getContextPath() %>/resources/images/arw.png"  width="22" height="16" /></div> <div class="text_arw">Information</div></div>
	</c:if>
	<c:if test="${not empty RFPInbox}">
	 <div class="text_area"><div class="text_arw"> <a href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_RFP_INBOX%>?RaYUnA=${finVen:encrypt(username)}">RFP Inbox</a> </div><div class="arw"> <img src="<%=request.getContextPath() %>/resources/images/arw.png"  width="22" height="16" /></div> <div class="text_arw">Information</div></div>
	</c:if>
	<c:if test="${not empty searchDataBuyers}">
	 <div class="text_area"><div class="text_arw"> <a href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_SEARCH_DATABUYER%>?RaYUnA=${finVen:encrypt(username)}">Search Data-Buyers</a> </div><div class="arw"> <img src="<%=request.getContextPath() %>/resources/images/arw.png"  width="22" height="16" /></div> <div class="text_arw">Information</div></div>
	</c:if>
	<!-- Consumer Dashboard info--- -->
	
	<c:if test="${not empty consumerMyProfiletab }">
	 <div class="text_area"><div class="text_arw"> <a href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_MY_PROFILE%>?RaYVeMu=${finVen:encrypt(username)}">My Profile</a> </div><div class="arw"> <img src="<%=request.getContextPath() %>/resources/images/arw.png"  width="22" height="16" /></div> <div class="text_arw">Information</div></div>
	</c:if>
	
	<c:if test="${not empty consumerMyOfferingstab }">
	 <div class="text_area"><div class="text_arw"> <a href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_MY_OFFERINGS%>?RaYVeMu=${finVen:encrypt(username)}">My Offerings</a> </div><div class="arw"> <img src="<%=request.getContextPath() %>/resources/images/arw.png"  width="22" height="16" /></div> <div class="text_arw">Information</div></div>
	</c:if>
	<c:if test="${not empty consumerInviteAnRFP }">
	 <div class="text_area"><div class="text_arw"> <a href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}" onclick="consumerInviteRFPModes('${consumerinviteanrfpmarketdataneeds}');">Invite An RFP</a> </div><div class="arw"> <img src="<%=request.getContextPath() %>/resources/images/arw.png"  width="22" height="16" /></div> <div class="text_arw">Information</div></div>
	</c:if>
	<div class="right_nav_area">
		  <div class="right_nav">  
		 <ul>
		 <!-- Vendor Dashboard tab's -->
		  <c:if test="${not empty myprofiletab }">
		   <li><a class="active" href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_MY_PROFILE%>?RaYUnA=${finVen:encrypt(username)}">My Profile</a></li>
		   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_MY_OFFERINGS%>?RaYUnA=${finVen:encrypt(username)}">My Offerings</a></li>
		   <li><a class="#" href="#">My Stats</a></li>
		   <li><a class="#" href="#">My Blog</a></li>
		   </c:if>
		    <c:if test="${not empty myofferingstab }">
		   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_MY_PROFILE%>?RaYUnA=${finVen:encrypt(username)}">My Profile</a></li>
		   <li><a class="active" href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_MY_OFFERINGS%>?RaYUnA=${finVen:encrypt(username)}">My Offerings</a></li>
		   <li><a class="#" href="#">My Stats</a></li>
		   <li><a class="#" href="#">My Blog</a></li>
		   </c:if>
		   <c:if test="${not empty RFPInbox}">
		 	   <li><a class="active" href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_RFP_INBOX%>?RaYUnA=${finVen:encrypt(username)}">RFP Inbox</a></li>
		 	   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_MY_PROFILE%>?RaYUnA=${finVen:encrypt(username)}">My Profile</a></li>
		   	   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_MY_OFFERINGS%>?RaYUnA=${finVen:encrypt(username)}">My Offerings</a></li>
		   	   <li><a class="#" href="#">My Stats</a></li>
		       <li><a class="#" href="#">My Blog</a></li>
			</c:if>
			<c:if test="${not empty searchDataBuyers}">
		 	   <li><a class="active" href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_SEARCH_DATABUYER%>?RaYUnA=${finVen:encrypt(username)}">Search Data-Buyers</a></li>
		 	   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_MY_PROFILE%>?RaYUnA=${finVen:encrypt(username)}">My Profile</a></li>
		   	   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Vendor.VENDOR_MY_OFFERINGS%>?RaYUnA=${finVen:encrypt(username)}">My Offerings</a></li>
		   	   <li><a class="#" href="#">My Stats</a></li>
		   	   <li><a class="#" href="#">My Blog</a></li>
			</c:if>
			<!-- Consumer Dashboard tab's -->
			
			<c:if test="${not empty consumerMyProfiletab }">
			   <li><a class="active" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_MY_PROFILE%>?RaYVeMu=${finVen:encrypt(username)}">My profile</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_MY_OFFERINGS%>?RaYVeMu=${finVen:encrypt(username)}">My Subscription</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}">Invite an RFP</a></li>
			   <li><a class="#" href="#">Search vendors</a></li>
			   <li><a class="#" href="#">Newsletters & Alerts</a></li>
			   <li><a class="#" href="#">My Blog</a></li>
			   <li><a class="#" href="#">My History</a></li>
			   <li><a class="#" href="#">My Statistics</a></li>
			   <li><a class="#" href="#">Invite Your team</a></li>
		   </c:if>
			<c:if test="${not empty consumerMyOfferingstab }">
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_MY_PROFILE%>?RaYVeMu=${finVen:encrypt(username)}">My profile</a></li>
			   <li><a class="active" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_MY_OFFERINGS%>?RaYVeMu=${finVen:encrypt(username)}">My Subscription</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}">Invite an RFP</a></li>
			   <li><a class="#" href="#">Search vendors</a></li>
			   <li><a class="#" href="#">Newsletters & Alerts</a></li>
			   <li><a class="#" href="#">My Blog</a></li>
			   <li><a class="#" href="#">My History</a></li>
			   <li><a class="#" href="#">My Statistics</a></li>
			   <li><a class="#" href="#">Invite Your team</a></li>
		   </c:if>
		   <c:if test="${not empty consumerInviteAnRFP }">
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_MY_PROFILE%>?RaYVeMu=${finVen:encrypt(username)}">My profile</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_MY_OFFERINGS%>?RaYVeMu=${finVen:encrypt(username)}">My Subscription</a></li>
			   <li><a class="active" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}">Invite an RFP</a></li>
			   <li><a class="#" href="#">Search vendors</a></li>
			   <li><a class="#" href="#">Newsletters & Alerts</a></li>
			   <li><a class="#" href="#">My Blog</a></li>
			   <li><a class="#" href="#">My History</a></li>
			   <li><a class="#" href="#">My Statistics</a></li>
			   <li><a class="#" href="#">Invite Your team</a></li>
		   </c:if>
		   <c:if test="${not empty consumerInviteAnRFP && not empty consumermarketdataneedsInviteAnRFP }">
		   <br/><br/>
			   <li><a class="active" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_MARKET_DATANEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}">Market Data Needs</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_TRADING_APPLICATION_NEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}">Trading Application Needs</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_ANALYTICS_APPLICATION_NEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}" onclick="consumerInviteRFPModes('${consumerinviteanrfpmarketdataneeds}');">Analytics Application Needs</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_RESEARCG_REPORT_NEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}" onclick="consumerInviteRFPModes('${consumerinviteanrfpmarketdataneeds}');">Research Report Needs</a></li>
		   </c:if>
		   
		   <c:if test="${not empty consumerInviteAnRFP && not empty consumertradingapplicationInviteAnRFP }">
		   <br/><br/>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_MARKET_DATANEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}">Market Data Needs</a></li>
			   <li><a class="active" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_TRADING_APPLICATION_NEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}">Trading Application Needs</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_ANALYTICS_APPLICATION_NEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}" onclick="consumerInviteRFPModes('${consumerinviteanrfpmarketdataneeds}');">Analytics Application Needs</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_RESEARCG_REPORT_NEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}" onclick="consumerInviteRFPModes('${consumerinviteanrfpmarketdataneeds}');">Research Report Needs</a></li>
		   </c:if>
		   
		   <c:if test="${not empty consumerInviteAnRFP && not empty consumeranalyticsapplicationInviteAnRFP }">
		   <br/><br/>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_MARKET_DATANEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}">Market Data Needs</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_TRADING_APPLICATION_NEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}">Trading Application Needs</a></li>
			   <li><a class="active" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_ANALYTICS_APPLICATION_NEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}" onclick="consumerInviteRFPModes('${consumerinviteanrfpmarketdataneeds}');">Analytics Application Needs</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_RESEARCG_REPORT_NEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}" onclick="consumerInviteRFPModes('${consumerinviteanrfpmarketdataneeds}');">Research Report Needs</a></li>
		   </c:if>
		   
		   <c:if test="${not empty consumerInviteAnRFP && not empty consumerresearchreportInviteAnRFP }">
		   <br/><br/>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_MARKET_DATANEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}">Market Data Needs</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_TRADING_APPLICATION_NEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}">Trading Application Needs</a></li>
			   <li><a class="#" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_ANALYTICS_APPLICATION_NEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}" onclick="consumerInviteRFPModes('${consumerinviteanrfpmarketdataneeds}');">Analytics Application Needs</a></li>
			   <li><a class="active" href="<%=request.getContextPath()%>/<%=RequestConstans.Consumer.CONSUMER_RESEARCG_REPORT_NEEDS_INVITE_AN_RFP%>?RaYVeMu=${finVen:encrypt(username)}" onclick="consumerInviteRFPModes('${consumerinviteanrfpmarketdataneeds}');">Research Report Needs</a></li>
		   </c:if>
		   
		 </ul>
		  </div> 
	</div>
<script type="text/javascript">
  function userCheck(checktype){
		 if(checktype.match('logout') && checktype != ''){
			 window.location.href  = "${pageContext.request.contextPath}/<%=RequestConstans.Login.LOGOUT%>";
		 }else{
			 window.location.href  = "${pageContext.request.contextPath}/<%=RequestConstans.Login.FORGET%>"; 
		 }
	} 
  function homePage(){
	  window.location.href  = "<%= request.getContextPath()%>/<%=RequestConstans.Login.MY_HOME_PAGE%>?RaYUnA=${finVen:encrypt(myusername)}";
  }
</script>