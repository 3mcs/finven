<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html lang="en" class="no-js">
   <!-- Author by Rayulu vemula -->
<!-- http://codyhouse.co/redirect/?resource=login-signup-modal-window -->
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- <link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'> -->
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/login.css"> <!-- Gem style -->
</head>
<body>
	 
	<div class="cd-user-modal"> <!-- this is the entire modal form, including the background -->
		<div class="cd-user-modal-container"> <!-- this is the container wrapper -->
		<span class="logmod__close" id="login-close" style="padding: 37px 37px 78px 8px; margin: 29px -375px 0 0;">Close</span>
			<ul class="cd-switcher">
				<li><a href="#0">Login</a></li>
				<li><a href="#0">Register</a></li>
			</ul>
			<div id="cd-login"> <!-- login form -->
				<form class="cd-form" style="padding: 7em;" action="<c:url value='j_spring_security_check' />" method="post" id="login-submit"><font id="sucessMessage" style="padding:1px 2px 21px 160px; bottom: 306px; font-weight:bold; font-size: 12px; position: absolute; color: #2AABAB;"></font>
				  <div style="border: 1px solid #41BFDA; padding: 0px 44px 0px 44px; border-radius:22px;">
				  <div><br></div>
					<p class="fieldset">
						<label class="image-replace cd-username" for="signin-username">UserName*</label> <font id="errMsgValidate" style="bottom: -15px;font-size: 12px; position: absolute; color: #B94A48;"></font>
						<input class="full-width has-padding has-border" id="signin-username" type="email" placeholder="UserName*" name="username">
						<!-- <span class="cd-error-message">Error message here!</span> -->
					</p>

					<p class="fieldset">
						<label class="image-replace cd-password" for="signin-password">Password*</label>
						<input class="full-width has-padding has-border" id="signin-password" type="password"  placeholder="Password*" name="password">
						<a href="#0" class="hide-password">Un-Hide</a>
						<!-- <span class="cd-error-message">Error message here!</span> -->
					</p>

					<p class="fieldset"> <!-- <font id="sucessMessage" style="padding:1px 2px 21px 160px; bottom: -23px; font-size: 12px; position: absolute; color: #2AABAB;"></font> -->
						<input type="checkbox" id="remember-me" checked>
						<label for="remember-me">Remember me</label>
					</p>

					<p class="fieldset">
						<input class="full-width" type="submit" value="Login" onclick="loginSubmit();">
					</p>
					<div><br></div>
					</div>
				</form>
				<p class="cd-form-bottom-message" style="margin-bottom: 9px;"><a href="#0" style="color: black;">Forgot Password?</a></p>
				<!-- <a href="#0" class="cd-close-form">Close</a> -->
			</div> <!-- cd-login -->
 			<!-- sign up form -->
			<div id="cd-signup">
				<form class="cd-form" action="registration" id="user_submit_form">
				<div style="border: 1px solid #41BFDA; border-radius:22px; padding-left: 8px;">
				<div><br></div>
				<div><br></div>
				<div><br></div>
				<div style="float:left;">
						<p class="fieldset"> 
							<label class="image-replace cd-username" for="signup-username" >UserName</label>
							<font id="errMessage" style="bottom: -15px;font-size: 12px; position: absolute; color: #B94A48;"></font>
							<input class="full-width1 has-padding1 has-border" id="signup-username" type="text" placeholder="Username*"  name="username" onblur="validateUsername();"> &nbsp;&nbsp;&nbsp;
							<span class="cd-error-message">Error message here!</span>
						</p>
						<br>
						<p class="fieldset">
							<label class="image-replace cd-email" for="signup-email">E-mail</label>
							<font id="emailerrMsg" style="bottom: -15px;font-size: 14px; position: absolute; color: #B94A48;"></font><font id="emailexistMsg" style="bottom: -15px;font-size: 12px; position: absolute; color: #B94A48;"></font>
							<input class="full-width1 has-padding1 has-border" id="signup-email" type="text" placeholder="E-mail*" name="email" onblur="validateEmailId();">
							<!-- <span class="cd-error-message">Error message here!</span> -->
						</p>
					<div class="clearfix"></div>
					</div>
					<div style="float:left;">
					<p class="fieldset">
							<label class="image-replace cd-password" for="signup-password">Password</label>
							<input class="full-width1 has-padding1 has-border" id="signup-password" type="password"  placeholder="Password*" name="password">
							<a href="#0" class="hide-password1">Hide</a>
							<span class="cd-error-message">Error message here!</span>
						</p>
						<br>
					<p class="fieldset">
						<label class="image-replace cd-company" for="signup-company">Company</label>
						<input class="full-width1 has-padding2 has-border" id="signup-company" type="text"  placeholder="Company*" name="company">
						<span class="cd-error-message">Error message here!</span>
					</p> 
					<div class="clearfix"></div>
					</div>
					<br><br>
					<div>
					<ul>
					<li style="float:left;">
						<p class="fieldset">
							<label class="image-replace cd-company" for="signup-companytype">Company Type</label>
							<select class="full-width1 has-padding1 has-border row-select1" name="companytype" id="signup-companytype" 
							multiple="multiple" style="border: 1px solid #d0d0d0; height: 92px; padding: 0 10px;"> 
								<option value ="-SELECT-" id="1" style="font-size: 13px; color: #529ECC;"> -Select Company Type- </option>
								<option value="Financial Firm - Sell side" id="2">Financial Firm - Sell side</option>
								<option value="Financial Firm - Buy side" id="3" >Financial Firm - Buy side</option>
								<option value="Financial Firm - Others" id="4">Financial Firm - Others</option>
								<option value="Financial Vendor- Data Aggregators" id="5">Financial Vendor- Data Aggregators</option>
								<option value="Financial Vendor- Trading Applications" id="">Financial Vendor- Trading Applications</option>
								<option value="Financial Vendor- Financial Analytics applications" id="7">Financial Vendor- Financial Analytics applications</option>
								<option value="Financial Vendor- Research report" id="8">Financial Vendor- Research report</option>
								<option value="University/College" id="9">University/College</option>
								<option value="Other firm" id="10">Other firm</option>
							</select>&nbsp;&nbsp;&nbsp;&nbsp;  
							<span class="cd-error-message">Error message here!</span>
						</p>
					</li>
					
					<li style="float:left;">
					 <p class="fieldset">
							<label class="image-replace cd-company" for="signup-vendorareaofinterest">Vendor Area of Interest</label>
							<select class="full-width1 has-padding1 has-border" multiple 
							style= "border: 1px solid #d0d0d0; 
							border-radius: 5px; color: #7f7f7f; float: left;  
							height: 93px; padding: 0 10px; width: 107%;" id="sigup-tags" name="tags">
								<option value ="-SELECT-" style="font-size: 13px; color: #529ECC;">-Select Vendor area of Interest-</option>
								<option value="Data Aggregator">Data Aggregator</option>
								<option value="Trading Application">Trading Application</option>
								<option value="Analytics Application">Analytics Application</option>
								<option value="Research Report">Research Report</option>
							</select> 
							<span class="cd-error-message">Error message here!</span>
						</p>  
						</li>
					</ul>
					<div class="clearfix"></div>
					</div>
					
					<div >
						<ul>
							<li style="float:left;">
								<p class="fieldset" style="padding: 25px 0px 0px 2px; font-size:14px; color: #529ECC;">Choose one or more options</p>
							</li>
							<li style="float:left;">
							 <p class="fieldset" style="padding: 10px 0px 0px 319px; font-size:14px; color: #529ECC;">Choose one or more options</p>  
							</li>
					</ul>
					</div>
					<div class="clearfix"></div>
					<br>
					<p class="fieldset"> 
						<input type="checkbox" id="accept-terms" name="acceptterms" value="acceptterms" /> 
						<label for="accept-terms">I agree to the <a href="#0" id="termsconditions">Terms & Conditions</a>
						</label><br>
						<input type="checkbox" id="accept-terms" name="acceptterms" value="acceptterms" /> 
						<label for="accept-terms">I wish to get regular <a href="#0" id="termsconditions">Newsletters & Alerts</a>
						</label>
						<font id="errMessageforMandatory"  style="padding:1px 2px 21px 160px; bottom: -23px;font-size: 12px; text-align:center; border-style:center; position: absolute; color: #B94A48;"></font>
										 <font id="sucessMessage" style="padding:1px 2px 21px 160px; bottom: -23px; font-size: 12px; position: absolute; color: #2AABAB;"></font>
						<font id="errMessagefortermsandconditions"  style="padding:1px 2px 23px 147px; bottom: -23px;font-size: 12px; text-align:center; border-style:center; position: absolute; color: #B94A48;"></font>
					</p>
					<!-- <p class="fieldset">
					   <font id="sucessMessage" style="bottom: -15px; font-size: 12px; position: absolute; color: #2AABAB;"></font>
					<p> -->
					<p class="fieldset">  
						<input class="full-width has-padding" type="submit" value="Create account" onclick="userRegisteration();">
					</p> 
					<div><br></div>
					</div>
				</form>

				<!-- <a href="#0" class="cd-close-form">Close</a> -->
			</div> <!-- cd-signup -->
			<div id="cd-reset-password"> <!-- reset password form -->
				<p class="cd-form-message">Lost your password? Please enter your email address. You will receive a link to create a new password.</p>
				<form class="cd-form" style="padding: 7em;">
					<div style="border: 1px solid #41BFDA; border-radius:22px; padding: 0px 30px 0px 30px;">
					<div><br></div>
					<p class="fieldset">
						<label class="image-replace cd-email" for="reset-email">E-mail</label>
						<input class="full-width has-padding has-border" id="reset-email" type="email" placeholder="E-mail">
						<span class="cd-error-message">Error message here!</span>
					</p>
					<p class="fieldset">
						<input class="full-width has-padding" type="submit" value="Reset password">
					</p>
				<div><br></div>
					</div>
				</form>
				<p class="cd-form-bottom-message"><a href="#0" style="color: black;">Back to log-in</a></p>
			</div> <!-- cd-reset-password -->
			<a href="#0" class="cd-close-form">Close</a>
			
		</div> <!-- cd-user-modal-container -->
	</div> <!-- cd-user-modal -->
<script src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
</body>
</html>