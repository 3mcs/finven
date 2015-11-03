<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/WEB-INF/finvendor.tld" prefix="finVen"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.finvendor.util.RequestConstans"%>
<div class="banner" id="banner">
	<div class="container">
		<div id="slider2_container"
			style="position: relative; top: 0px; left: 0px; width: 1000px; height: 391px; overflow: hidden;">
			<div u="slides"
				style="width: 1000px; height: 391px; overflow: hidden;">
				<div>
					<div style="overflow: hidden;" class="hm-slide-1">
						<div class="home-slider-wrap">
							<div class="content">
								<h2>
									<span>List Your</span><span>Offerings Here</span>
								</h2>
								<h3>Shared Platform For<br>All Financial Vendors</h3>
								<div class="para">
									<p>Market Data Vendors (Aggregators)</p>
									<p>Trading Application Vendors</p>
									<p>Analytical Application Vendors</p>
									<p>Research Report Providers</p>
								</div>
							</div>
						</div>
					</div>
					<div u="thumb">
						<img
							src="<%=request.getContextPath()%>/resources/images/slected-ico.png"
							alt="" title="" /><a href="#view1">Vendor -<span>Hassle-Free Product Listing</span></a>
					</div>
				</div>
				<div>
					<div style="overflow: hidden;" class="hm-slide-2">
						<div class="home-slider-wrap">
							<div class="content">
								<h2>
									<span>Find Your</span><span>Optimal</span><span>Vendor</span>
								</h2>
								<h3>Well Researched Search Platform</h3>
								<div class="para">
									<p>Search Our Pre-Screened Vendor Database</p>
									<p>in a very interactive way</p>
								</div>
							</div>
						</div>
					</div>
					<div u="thumb">
						<img
							src="<%=request.getContextPath()%>/resources/images/slected-ico.png"
							alt="" title="" /><i></i><a href="#view2">EndUsers -<span>Searching Fin vendor made Easy</span></a>
					</div>
				</div>
				<div>
					<div style="overflow: hidden;" class="hm-slide-3">
						<div class="home-slider-wrap">
							<div class="content">
								<h2>
									<span>Helps Increasing</span><span>Your Sales</span>
								</h2>
								<h3>Send Your Response to<br>End-User's RFP</h3>
								<div class="para">
									<p>Authenticated RFPs at FinVendor (as initiated by End-Users)</p>
									<p>are open for application for all qualified vendors</p>
								</div>
							</div>
						</div>
					</div>
					<div u="thumb">
						<img
							src="<%=request.getContextPath()%>/resources/images/slected-ico.png"
							alt="" title="" /><i></i><a href="#view3">Vendor -<span>Keep Track of New RFPs/Sales Leads</span></a>
					</div>
				</div>
				<div>
					<div style="overflow: hidden;" class="hm-slide-4">
						<div class="home-slider-wrap">
							<div class="content">
								<h2>
									<span>Post Your Vendor</span><span>Needs as a RFP</span>
								</h2>
								<h3>Helping You Going Public<br>With Your Vendor Needs</h3>
								<div class="para">
									<p>An Easy-to-use medium to share your vendor needs,</p>
									<p>track the response and shortlist the vendors</p>
								</div>
							</div>
						</div>
					</div>
					<div u="thumb">
						<img
							src="<%=request.getContextPath()%>/resources/images/slected-ico.png"
							alt="" title="" /><i></i><a href="#view4">EndUsers -<span>Post Your Fin Vendor Needs as a RFP</span></a>
					</div>
				</div>
			</div>
			<div u="thumbnavigator" class="jssort12">
				<div u="slides">
					<div u="prototype" class="p">
						<div class=w>
							<div u="thumbnailtemplate" class="c"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="clearfix"></div>
<div class="main-wrap" id="main-wrap">
	<div class="main-content-wrap">
		<c:choose>
			<c:when test="${sessionScope.loggedInUser != null}">
				<a href="${pageContext.request.contextPath}/<%=RequestConstans.MarketAggregators.MARKETAGGREGATORS%>">
			</c:when>
			<c:otherwise>
				<a href="javascript:inner_login('<%=RequestConstans.MarketAggregators.MARKETAGGREGATORS%>')">
			</c:otherwise>
		</c:choose>
			<img src="${pageContext.request.contextPath}/resources/images/main-img-1.png" style="float:right" alt="Click here to Search Market Data Vendors" title="Click here to Search Market Data Vendors">
		</a>
		<h2>
			Market Data <span>Vendors</span>
		</h2>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ac
			feugiat justo, quis condimentum leo. Ut nisl dui, interdum id libero
			in, sodales lobortis risus. Ut in condimentum mauris. Etiam arcu.</p>
		<a href="#"><img
			src="<%=request.getContextPath()%>/resources/images/rd-mr.png"
			alt="" title="" class="read-more" /></a>
	</div>
	<div class="main-content-wrap">
		<c:choose>
			<c:when test="${sessionScope.loggedInUser != null}">
				<a href="${pageContext.request.contextPath}/<%=RequestConstans.TradingApplication.TRADING_APPLICATION_INDEX_PAGE%>">
			</c:when>
			<c:otherwise>
				<a href="javascript:inner_login('<%=RequestConstans.TradingApplication.TRADING_APPLICATION_INDEX_PAGE%>')">
			</c:otherwise>
		</c:choose>	
			<img src="${pageContext.request.contextPath}/resources/images/main-img-2.png" style="float:right" alt="Click here to Search Trading Application Vendors" title="Click here to Search Trading Application Vendors">
		</a>
		<h2>
			Trading Application <span>Vendors</span>
		</h2>
		<p>Ut nisl dui, interdum id libero in, sodales lobortis risus. Ut
			in condimentum mauris. Etiam arcu magna, vulputate porttitor nisl
			non, ultrices porta felis. Phasellus venenatis justo quis dolor.</p>
		<a href="#"><img
			src="<%=request.getContextPath()%>/resources/images/rd-mr.png"
			alt="" title="" class="read-more" /></a>
	</div>
	<div class="main-content-wrap">
		<c:choose>
			<c:when test="${sessionScope.loggedInUser != null}">
				<a href="${pageContext.request.contextPath}/<%=RequestConstans.FinancialAnalyticsApplication.FINANCIAL_ANALYTICS_APPLICATION_INDEX_PAGE%>">
			</c:when>
			<c:otherwise>
				<a href="javascript:inner_login('<%=RequestConstans.FinancialAnalyticsApplication.FINANCIAL_ANALYTICS_APPLICATION_INDEX_PAGE%>')">
			</c:otherwise>
		</c:choose>
			<img src="${pageContext.request.contextPath}/resources/images/main-img-3.png" style="float:right" alt="Click here to Search Analytics Application Vendors" title="Click here to Search Analytics Application Vendors">
		</a>
		<h2>
			Financial Analytics <span>Vendors</span>
		</h2>
		<p>Etiam arcu magna, vulputate porttitor nisl non, ultrices porta
			felis. Phasellus venenatis justo quis dolor euismod, quis ullamcorper
			dui tincidunt. Lorem ipsum dolor sit amet.</p>
		<a href="#"><img
			src="<%=request.getContextPath()%>/resources/images/rd-mr.png"
			alt="" title="" class="read-more" /></a>
	</div>
	<div class="main-content-wrap last-child">
		<c:choose>
			<c:when test="${sessionScope.loggedInUser != null}">
				<a href="${pageContext.request.contextPath}/<%=RequestConstans.ResearchReportProviders.RESEARCH_REPORT_PROVIDERS_INDEX_PAGE%>">
			</c:when>
			<c:otherwise>
				<a href="javascript:inner_login('<%=RequestConstans.ResearchReportProviders.RESEARCH_REPORT_PROVIDERS_INDEX_PAGE%>')">
			</c:otherwise>
		</c:choose>
			<img src="${pageContext.request.contextPath}/resources/images/main-img-4.png" style="float:right" alt="Click here to Search Research Report Providers" title="Click here to Search Research Report Providers">
		</a>
		<h2>
			Financial Research <span>Report Vendors</span>
		</h2>
		<p>Phasellus venenatis justo quis dolor euismod, quis ullamcorper
			dui tincidunt. Lorem ipsum dolor sit amet, consectetur adipiscing
			elit. In ac feugiat justo, quis condimentum.</p>
		<a href="#"><img
			src="<%=request.getContextPath()%>/resources/images/rd-mr.png"
			alt="" title="" class="read-more" /></a>
	</div>
	<div class="clearfix"></div>
</div>
<div class="slider-home" id="slider-home">
	<img src="<%=request.getContextPath()%>/resources/images/hear.png"
		alt="" title="" class="slider-hr" />
	<h2>Hear what people are saying about Fin Vendor</h2>
	<div class="slider2">
		<div class="slide">
			<p>orem ipsum dolor sit amet, consectetur adipiscing elit.
				Integer eget cursus ipsum. Integer eu gravida erat, vel tempor diam.
				Praesent elementum efficitur placerat. Vestibulum vel nunc eget leo
				interdum fringilla quis id lorem. Nullam sollicitudin elit id ipsum
				posuere rutrum. Quisque nec mauris odio. Quisque cursus, mauris vel
				ornare suscipit, metus ante aliquet felis, vel rhoncus velit leo at
				quam.</p>
			<p class="signature">
				<strong>Jith Puthoor</strong> <span>Lead Designer,
					CreativeLeaves</span>
			</p>
		</div>
		<div class="slide">
			<p>orem ipsum dolor sit amet, consectetur adipiscing elit.
				Integer eget cursus ipsum. Integer eu gravida erat, vel tempor diam.
				Praesent elementum efficitur placerat. Vestibulum vel nunc eget leo
				interdum fringilla quis id lorem. Nullam sollicitudin elit id ipsum
				posuere rutrum. Quisque nec mauris odio. Quisque cursus, mauris vel
				ornare suscipit, metus ante aliquet felis, vel rhoncus velit leo at
				quam.</p>
			<p class="signature">
				<strong>Jith Puthoor</strong> <span>Lead Designer,
					CreativeLeaves</span>
			</p>
		</div>
		<div class="slide">
			<p>orem ipsum dolor sit amet, consectetur adipiscing elit.
				Integer eget cursus ipsum. Integer eu gravida erat, vel tempor diam.
				Praesent elementum efficitur placerat. Vestibulum vel nunc eget leo
				interdum fringilla quis id lorem. Nullam sollicitudin elit id ipsum
				posuere rutrum. Quisque nec mauris odio. Quisque cursus, mauris vel
				ornare suscipit, metus ante aliquet felis, vel rhoncus velit leo at
				quam.</p>
			<p class="signature">
				<strong>Jith Puthoor</strong> <span>Lead Designer,
					CreativeLeaves</span>
			</p>
		</div>
	</div>
</div>
<div class="clearfix"></div>
