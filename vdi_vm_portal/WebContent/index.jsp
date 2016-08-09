<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="shortcut icon" href="img/tr.ico">
<meta name="viewport" content="width=device-width, initial-scale=1">




<link rel="stylesheet" href="client/foundation-5.5.2/css/foundation.css">
<link rel="stylesheet" href="client/foundation-5.5.2/css/app.css">
<link rel="stylesheet"
	href="client/bootstrap-3.3.5-dist/css/bootstrap.css" />
<link rel="stylesheet"
	href="client/bootstrap-3.3.5-dist/css/bootstrap-theme.css" />

<link rel="stylesheet" href="client/foundation-5.5.2/css/normalize.css">
<link rel="stylesheet"
	href="client/bootstrap_tour/css/bootstrap-tour.css" />
<link rel="stylesheet"
	href="client/bootstrap_tour/css/bootstrap-tour-standalone.css" />

<link href="client/index.css" type="css" rel="stylesheet"></link>

<script src="client/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="client/DataTables-1.10.2/media/js/jquery.js"></script>
<script src="client/foundation-5.5.2/js/foundation/foundation.js"></script>
<script src="client/foundation-5.5.2/joyride/jquery.joyride-2.1.js"></script>
<script src="client/foundation-5.5.2/joyride/jquery.cookie.js"></script>


<script src="client/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script src="client/bootstrap_tour/js/bootstrap-tour-standalone.js"></script>

<script type="text/javascript"
	src="client/DataTables-1.10.2/media/js/jquery.dataTables.js"></script>
<link href="client/DataTables-1.10.2/media/css/jquery.dataTables.css"
	type="text/css" rel="stylesheet" />


<script src="modules/index.js"></script>



<title>VDI Launch Vm Client</title>
<style>
html, body {
	height: 100%;
	width: 100%;
}

#announcements {
	position: absolute;
	margin-left: 20px;
	margin-top: 180px;
}

#appendvm, #tester {
	margin: 20px;
}

a img {
	border: none;
	display: inline;
}

#optimized_chrome {
	color: #ea893f;
	float: right;
	right: 10px;
	display: inline;
}

img.map, map area {
	outline: none;
}
</style>
</head>
<body>
	<div>

		<span id="announcements"></span>
		<div id="wrapper" class-test="container-full">
			
			<div id="header">
				<div id="header-content">
					<a href="javascript:void(0)" onclick='location.reload()'><img
						id="headerimg" src="img/vdi_vm_header2.jpg"
						href="javascript:void(0)" onclick="window.reload" /> <!-- <span
						id="optimized_chrome">****************This portal is
							optimized for Google Chrome******************</span> --> </a>
				</div>

			</div>

			<div id="classless"></div>
			
			<div id="content" class-test="container-fluid">
				<div id="sidebar"></div>

				<div id="main" class-test="container-fluid">
					<div id="orig_content" class-test="container-fluid">
						<input type="hidden" id="regionProducts" /> <input type="hidden"
							id="virtualRegions" />
						<div class-test="container-fluid" id="test_tour_here"></div>

						<div id="test_this_tick_1" class-test="container-fluid">
							<div style="resize: both; overflow: auto;">
								<img src="img/test2408.jpg" border="0" usemap="#myImage"
									hidefocus="true" id="mappng" />

								<map name="myImage" id="myImage" style="color: #000000"
									height="761" width="418">
									<!-- <area
									onclick="SetRegion('VirtualProducts','VirtualMachineAMERS')"
									title="AMERS" href="javascript:void(0)" shape="poly"
									alt="AMERS"
									coords="34,4,41,393,272,389,326,391,310,210,316,167,312,105,326,57,341,26,344,11,346,5,346,3" />
								<area alt="EMEA"
									onclick="SetRegion('VirtualProducts','VirtualMachineEMEA')"
									title="EMEA" href="javascript:void(0)" shape="poly"
									coords="377,7,342,32,329,100,332,147,333,202,329,219,327,240,330,263,337,284,396,337,412,335,436,314,130,463,90,490,83,521,74,554,61,628,55,651,65,678,51,683,35,686,24,686,16,684,5" />
								<area alt="IPBS"
									onclick="SetRegion('VirtualProductsIPBS','VirtualMachineIPBS')"
									title="IPBS" href="javascript:void(0)" shape="poly"
									coords="508,137,507,176,542,196,562,154" />
								
								<area alt="APAC"
									onclick="SetRegion('VirtualProductsAPAC','VirtualMachineAPAC')"   
									title="APAC" href="javascript:void(0)" shape="poly"
									coords="731,347,549,308,519,222,497,195,488,150,457,82,493,70,588,98,645,89,671,93" /> -->



									<area shape="poly" title="apac" alt=""
										href="javascript:void(0)"
										onclick="SetRegion('VirtualProductsAPAC','VirtualMachineAPAC')"
										coords="497, 151, 493, 146, 490, 133, 485, 101, 481, 92, 463, 94, 477, 75, 519, 85, 551, 86, 579, 98, 608, 104, 638, 116, 648, 129, 654, 141, 666, 155, 686, 173, 705, 193, 720, 222, 725, 250, 719, 280, 709, 299, 693, 318, 675, 323, 641, 320, 601, 307, 590, 301, 586, 270, 594, 251, 596, 236, 595, 210, 588, 197, 582, 180, 573, 161, 571, 158, 563, 153, 543, 146, 526, 145, 512, 148, 509, 151, 501, 158" />
									<area shape="poly" title="emea" alt=""
										href="javascript:void(0)"
										onclick="SetRegion('VirtualProducts','VirtualMachineEMEA')"
										coords="348, 240, 360, 259, 377, 284, 412, 311, 436, 325, 466, 316, 482, 287, 484, 259, 481, 231, 487, 198, 488, 164, 485, 141, 482, 128, 470, 113, 460, 93, 459, 81, 480, 64, 493, 67, 539, 70, 558, 83, 597, 92, 618, 101, 628, 107, 635, 100, 647, 86, 660, 68, 666, 56, 674, 39, 661, 25, 620, 9, 580, 11, 548, 12, 500, 7, 452, 11, 412, 10, 391, 16, 380, 21, 363, 35, 341, 43, 326, 54, 322, 67, 319, 92, 307, 120, 307, 134, 305, 134, 305, 134, 314, 153, 314, 171, 315, 190, 323, 206, 330, 214, 334, 225, 336, 227" />
									<area shape="poly" title="amers" alt=""
										href="javascript:void(0)"
										onclick="SetRegion('VirtualProducts','VirtualMachineAMERS')"
										coords="119, 161, 149, 258, 208, 336, 272, 370, 295, 327, 297, 259, 293, 206, 264, 161, 293, 97, 313, 49, 349, 21, 359, 10, 340, 0, 299, 7, 228, 8, 167, 10, 113, 21, 66, 39, 54, 56, 58, 95, 76, 132, 92, 159, 103, 164" />
									<area shape="poly" alt="" href="javascript:void(0)"
										onclick="SetRegion('VirtualProductsIPBS','VirtualMachineIPBS')"
										coords="507, 160, 521, 182, 536, 197, 548, 197, 562, 176, 563, 167, 555, 158, 544, 150, 526, 154, 523, 155, 516, 156"
										title="IPBS" />
								</map>

							</div>

						</div>

					</div>
					<div id="list_content"></div>
				</div>

			</div>

			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">Searching.....</h4>
						</div>
						<div class="modal-body">...</div>
						<div class="modal-footer"></div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<div id="footer"
		style="min-width: 100%; list-style: none; margin-top: 100px; float: left; position: inherit; cue-after: inherit; clear: both"
		class-test="container">

		<table class-test="table-fluid" style="min-width: 100%; float: left;"
			border="0">
			<tbody>
				<tr>
					<td><a
						href="https://infocenter.thomsonreuters.com/search/index?page=content&amp;id=SO63190"
						target="_blank">Needs Support ? InQuira customized pages for
							G-VDI</a></td>
					<td><a
						href="https://thehub.thomsonreuters.com/groups/trcs-global-virtual-desktop-infra-vdi"
						target="_blank">Global VDI Share Point</a></td>
					<td><a href="https://thehub.thomsonreuters.com/welcome"
						target="_blank"></a></td>
					<td><a
						href="http://10.4.10.137:8080/vdi_admin_portal/login.jsp"
						target="_blank">VDI Admin Portal(Restricted)</a></td>
					<TD></TD>

					<td><a
						href="mailto:marangelo.delatorre@thomsonreuters.com?subject=Global Virtual Desktop Infrastructure - Platform Chooser Website&amp;cc=didier.goupil@thomsonreuters.com">Email
							Website development team</a></td>

				</tr>
			</tbody>
		</table>
		<div id="download_loc" style="width:10%; float:left; left:0px;"></div>
	</div>


</body>
</html>