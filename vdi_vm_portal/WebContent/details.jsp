<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Machine Details</title>
<head>
<script src="client/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="client/DataTables-1.10.2/media/js/jquery.dataTables.js"></script>

<script type="text/javascript"
	src="client/DataTables-1.10.2/media/js/jquery.dataTables.js"></script>
<link href="client/DataTables-1.10.2/media/css/jquery.dataTables.css"
	type="text/css" rel="stylesheet" />
<script type="text/javascript">
	var vmregion = getUrlParameter("reg");
	var vmref = getUrlParameter("vmref");
	var isEikon = getUrlParameter("!$3!k0n");
	$(document).ready(function() {
		DisplayDetails(vmref, vmregion);

	});

	function DisplayDetails(vmref, region) {
		$.ajax({
			type : "POST",
			url : "SearchVmDetails",
			data : "{\"vmref\":\"" + vmref + "\",\"region\":\"" + region
					+ "\"}",
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {

				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;
				for (var i = 0; i < resultsArray.length; i++) {
					$("#vm_detail_ref_field").append(
							'<a href="javascript:void(0)" title="Launch '
									+ (vmref).replace("%20", "")
									+ '" onclick="LaunchVmPortalDetail(&quot;'
									+ resultsArray[0].URILink + '&quot;,&quot;'
									+ region + '&quot;,&quot;' + vmref
									+ '&quot;)">' + (vmref).replace("%20", "")
									+ '</a>');

					$("#vm_detail_os_field").text(resultsArray[0].OsName);
					$("#vm_detail_off_field").text(resultsArray[0].MsoName);
					$("#vm_detail_ie_field").text(resultsArray[0].IeName);
					$("#vm_detail_lang_field").text(
							resultsArray[0].LanguageName);
				}

			},
			complete : function(e) {
				$("#append_vm_details").dataTable({
					bFilter : false,
					bInfo : false,
					"bPaginate" : false,
					"aaSorting" : []
				});
				DisplayProducts(vmref, region);
			}
		});
	}

	function LaunchVmPortalDetail(urilink, region, vmref) {
		window.open("LauncherClass?poolname=" + encodeURIComponent(urilink)
				+ "&region=" + region + "&vmref=" + vmref, "_blank",
				"width=400,height=200,menubar=no,toolbar=no");
		window.close();
		event.preventDefault();
	}

	function ReturnBlank(prod) {
		var blank = prod;
		if (prod == undefined || prod == "undefined") {
			blank = "";
		}

		return blank;

	}
	function DisplayProducts(vmref, region) {
		var prodRegion = "";

		switch (region) {
		case "VirtualMachineAMERS":
			prodRegion = "VirtualProducts";
			break;
		case "VirtualMachineEMEA":
			prodRegion = "VirtualProducts";
			break;
		case "VirtualMachineAPAC":
			prodRegion = "VirtualProductsAPAC";
			break;
		case "VirtualMachineIPBS":
			prodRegion = "VirtualProductsIPBS";
			break;
		}
		var dataTable = "";
		$.ajax({
			type : "POST",
			url : "SearchVmProdDetails",
			data : "{\"vmref\":\"" + vmref + "\",\"region\":\"" + region
					+ "\",\"prodRegion\":\"" + prodRegion + "\"}",
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;
				$("#append_vm_products").html("");
				dataTable = dataTable + "<thead><tr>";
				dataTable = dataTable + "<th>Product Name</th>";
				dataTable = dataTable + "<th>Version</th>";
				dataTable = dataTable + "<th>Release Date</th>";
				dataTable = dataTable + "</tr></thead><tbody>";
				var version = "";
				for (var i = 0; i < resultsArray.length; i++) {
   
					dataTable = dataTable + "<tr><td>"
							+ resultsArray[i].ProductName + "</td>";
					dataTable = dataTable + "<td style='text-align:center;'>"
							+ ReturnBlank(resultsArray[i].ProductVersion)
							+ "</td>";
					dataTable = dataTable + "<td style='text-align:center'>" + ReturnBlank(resultsArray[i].release_date) + "</td></tr>";
					//if (resultsArray[i].append_vm_products != "") {
						version = resultsArray[i].ProductVersion;
					//}

				}  
        
				/* if (isEikon == "1") {
					$("#eikon_field_row").show();*/
					$("#vm_detail_eikon_field").text(version);
				/*} */
   
				dataTable = dataTable + "</tbody>";
				$("#append_vm_products").append(dataTable);

			},
			complete : function(e) {
				$("#append_vm_products").dataTable({
					bFilter : false,
					bInfo : false,
					"bPaginate" : false,
					"aaSorting" : []
				});
			}
		});
	}
	function getUrlParameter(sParam) {
		var sPageURL = window.location.search.substring(1);
		var sURLVariables = sPageURL.split('&');
		for (var i = 0; i < sURLVariables.length; i++) {
			var sParameterName = sURLVariables[i].split('=');
			if (sParameterName[0] == sParam) {
				return sParameterName[1];
			}
		}
	}
	
	function ReturnEmpty(stringUnderfined){
	  newString = stringUnderfined;
	  if(stringUnderfined == undefined || stringUnderfined == "undefined"){
	    newString = "";
	  }
	  
	  return newString;
	}
</script>
</head>
<body>
	<div>
		<table id="append_vm_details" class="display">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>VM Reference Name :</td>
					<td><span id="vm_detail_ref_field"></span></td>
				</tr>
				<tr>
					<td>Operating System :</td>
					<td><span id="vm_detail_os_field"></span></td>
				</tr>
				<tr>
					<td>Microsoft Office :</td>
					<td><span id="vm_detail_off_field"></span></td>
				</tr>
				<tr>
					<td>Internet Explorer :</td>
					<td><span id="vm_detail_ie_field"></span></td>
				</tr>
				<tr>
					<td>Language :</td>
					<td><span id="vm_detail_lang_field"></span></td>
				</tr>
				<tr id="eikon_field_row" style="display: none">
					<td>Eikon Version :</td>
					<td><span id="vm_detail_eikon_field"></span></td>
				</tr>
			</tbody>
		</table>
		<table id="append_vm_products">



		</table>


	</div>
</body>
</html>
