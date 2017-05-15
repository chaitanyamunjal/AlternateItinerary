<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en"><head>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/mdb.css" rel="stylesheet">  -->
    <link href="css/compiled.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
	<link rel="shortcut icon" href="images/icon.png" type="image/png">
	<link href="css/jquery-gauge.css" type="text/css" rel="stylesheet">
	<link rel="stylesheet" href="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
	<script src="https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>

<body class="fixed-sn mdb-skin">
    <!--Double navigation-->
    <header>
        <!-- Sidebar navigation -->
        <ul id="slide-out" class="side-nav fixed sn-bg-1 custom-scrollbar ps-container ps-theme-default" data-ps-id="3ecf9dba-fa3a-3de6-2787-13cac3a4570e" style="transform: translateX(0%); background-color:#005EB8;">
            <!-- Logo -->
            <li>
                <div class="logo-wrapper waves-light waves-effect waves-light">
                    <a href="#"><img src="images/logo.jpg" class="img-fluid flex-center"></a>
                </div>
            </li><br>
            <!--/. Logo -->
            <!--Social-->
            <li>
                <ul class="social">
                    <li><a class="icons-sm fb-ic" href="https://www.facebook.com/amadeuslabsindia/"><i class="fa fa-facebook"> </i></a></li>
                    <li><a class="icons-sm pin-ic" href="https://www.pinterest.com/amadeusitgroup/"><i class="fa fa-pinterest"> </i></a></li>
                    <li><a class="icons-sm gplus-ic" href="https://www.google.com/maps/d/viewer?mid=1N5k7JYYgwKAmOPcO9Kpy6Vez5Cg&hl=en&ll=12.943333999999998%2C77.69140700000003&z=17"><i class="fa fa-google-plus"> </i></a></li>
                    <li><a class="icons-sm tw-ic" href="https://twitter.com/AmadeusITGroup?ref_src=twsrc%5Egoogle%7Ctwcamp%5Eserp%7Ctwgr%5Eauthor"><i class="fa fa-twitter"> </i></a></li>
                </ul>
            </li>
            <!--/Social-->
            <!--Search Form-->
            <li>
                <form class="search-form" role="search">
                    <div class="form-group waves-light waves-effect waves-light">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                </form>
            </li>
            <!--/.Search Form-->
            <!-- Side navigation links -->
            
            <c:if test="${not empty admin}">
            <li>
                <ul class="collapsible collapsible-accordion">
                    
                    <li class=""><a class="collapsible-header waves-effect arrow-r"><i class="fa fa-hand-pointer-o"></i>Customize Factors<i class="fa fa-angle-down rotate-icon"></i></a>
                        <div class="collapsible-body" style="display: none;">
                            <ul>
                            	<c:if test="${admin == '0' }">
	                                <li><a href="similaritycustomization" class="waves-effect">Similarity Factors</a>
	                                </li>
	                                <li><a href="riskcustomization" class="waves-effect">Risk Factors</a>
	                                </li>
                				</c:if>
                                <c:if test="${admin == '1' }">
	                                <li><a href="similaritycustomization" class="waves-effect">Similarity Factors</a>
	                                </li>
	                                <li><a href="riskcustomization" class="waves-effect">Risk Factors</a>
	                                </li>
	                                <li><a href="threshold" class="waves-effect">Threshold Values</a>
	                                </li>
                				</c:if>
                            </ul>
                        </div>
                    </li>
                    
                    <li class=""><a class="collapsible-header waves-effect arrow-r"><i class="fa fa-building-o right"></i>Similar City Finder<i class="fa fa-angle-down rotate-icon"></i></a>
                        <div class="collapsible-body" style="display: none; padding-top: 0px; margin-top: 0px; padding-bottom: 0px; margin-bottom: 0px;">
                            <ul>
                                <li><a href="customcity" class="waves-effect">Custom Similar City Finder</a>
                                </li>
                                <li><a href="city" class="waves-effect">Similar City Finder</a>
                                </li>
                                <li><a href="home" class="waves-effect">City Comparator</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    
                    <!-- 
	                    <li class=""><a class="collapsible-header waves-effect arrow-r"><i class="fa fa-eye"></i>Risk Calculator<i class="fa fa-angle-down rotate-icon"></i></a>
	                        <div class="collapsible-body" style="display: none;">
	                            <ul>
	                                <li><a href="customrisk" class="waves-effect">Customized Risk Calculator</a>
	                                </li>
	                            </ul>
	                        </div>
	                    </li>
                     -->
                     
                    <li class=""><a class="collapsible-header waves-effect arrow-r"><i class="fa fa-envelope-o"></i>Contact Us<i class="fa fa-angle-down rotate-icon"></i></a>
                        <div class="collapsible-body" style="display: none;">
                            <ul>
                                <li><a href="mailto:support@alternateitinerary.com" class="waves-effect">Mail Us</a>
                                </li>
                                <li><a href="contact" class="waves-effect">Write a message</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </li>
           </c:if>
            <!--/. Side navigation links -->
            <div class="sidenav-bg mask-strong" id="kk"></div>
        </ul>
        <!--/. Sidebar navigation -->
        <!-- Navbar -->
        <nav class="navbar fixed-top navbar-toggleable-md navbar-dark scrolling-navbar double-nav">
            <!-- SideNav slide-out button -->
            <div class="float-xs-left">
                <a href="#" data-activates="slide-out" class="button-collapse"><i class="fa fa-bars"></i></a>
            </div>
            <!-- Breadcrumb-->
            <div class="breadcrumb-dn mr-auto">
                <p><b>Alternate Itinerary <c:if test="${admin == '1' }">- Admin Page</c:if></b></p>
            </div>
            <ul class="nav navbar-nav nav-flex-icons ml-auto">
                <li class="nav-item">
                    <a class="nav-link waves-effect waves-light" href="main"><i class="fa fa-home" aria-hidden="true"></i><span class="hidden-sm-down">Home</span></a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link waves-effect waves-light" href="contact"><i class="fa fa-comments-o"></i> <span class="hidden-sm-down">Support</span></a>
                </li>
                <li class="nav-item">
                	<a class="nav-link waves-effect waves-light" href="account"><i class="fa fa-user"></i> <span class="hidden-sm-down">Account</span></a>
            	</li>
                <c:if test="${not empty un}">
	    		<li class="nav-item logout">
                    <a class="nav-link dropdown-toggle waves-effect waves-light" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="images/${pic}" class="img-responsive profile " height="35"width="45">
                    </a>
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
	                      <a class="dropdown-item waves-effect waves-light" href="account">${un}</a>
                          <a class="dropdown-item waves-effect waves-light" href="logout">Logout</a>
                      
                    </div>
                </li>
                </c:if>
                
            </ul>
        </nav>
        <!-- /.Navbar -->
    </header>
    <!--/.Double navigation-->
    <!--Main layout-->	
	<jsp:include page="${page}.jsp"/>
	
    <!--/Main layout-->
    <!-- SCRIPTS -->
    <script type="text/javascript" src="js/compiled.js"></script>
     <script type="text/javascript" src="js/main.js"></script>
     <script type="text/javascript" src="js/myGauge.js"></script>
     <script type="text/javascript" src="js/city.js"></script>
     <script type="text/javascript" src="js/home.js"></script>
     <script type="text/javascript" src="js/login.js"></script>
     <script type="text/javascript" src="js/customCity.js"></script>
     <script type="text/javascript" src="js/customRisk.js"></script>
     <script type="text/javascript" src="js/similarityCustomization.js"></script>
     <script type="text/javascript" src="js/riskCustomization.js"></script>
     <script type="text/javascript" src="js/signup.js"></script>
     <script type="text/javascript" src="js/threshold.js"></script>
     <c:if test="${admin == '1' }">
     	<script type="text/javascript" src="js/AdminLayout.js"></script>
     </c:if>
     <script src="js/jquery-gauge.min.js"></script>
    
    <script>
    $(".button-collapse").sideNav();
    
    function submit_form() {
        document.getElementById("loginForm").submit();
    }
    
    
    </script>



<div class="hiddendiv common"></div><div class="drag-target" style="touch-action: pan-y; user-select: none; -webkit-user-drag: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); left: 0px;"></div></body></html>