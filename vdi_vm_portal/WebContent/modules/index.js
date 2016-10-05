$(document).ready(function() {

  AppendAnnouncement();

  AppendEikonVersions();
  $("#sidebar").load("pages/side.jsp");
  testFor();
  
});

$("#announcements").ready(function() {
 
});

function testFor() {
  var x = "Coded by MarAngelo dela torre!!";

  for ( var y in x) {
    console.log(x[y]);
  }

}

var isEikon = "0";  
function AppendOperatingSystem() {
  $.ajax({
    type: "POST",
    url: "OSController",
    data: "{}",
    contentType: "application/x-www-form-urlencoded",
    dataType: "json",
    success: function(response) {
      $("#os_select").html("");
      var resultsArray = (typeof response) == 'string' ? eval('(' + response
              + ')') : response;
      var dataTable = "";
      dataTable = dataTable + "<option value=''>--</option>";
      for (var i = 0; i < resultsArray.length; i++) {
        dataTable = dataTable + "<option value='" + resultsArray[i].OsId + "'>"
                + resultsArray[i].OsName + "</option>";
      }
      $("#os_select").append(dataTable);
    },
    error: function(a, b, c) {
      alert(a + " " + b + " " + c);
    }
  });
}
function ReloadTuts(){
  localStorage.removeItem("loaded");
  localStorage.removeItem("downloaded");
  location.reload();  

}
function AppendAnnouncement() {
  $
          .ajax({
            type: "POST",
            url: "announcement",
            data: "{}",
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            success: function(response) {
              $("#announcements").html("");
              var resultsArray = (typeof response) == 'string' ? eval('('
                      + response + ')') : response;

              $("#announcements").append(resultsArray[0].comment);
            },
            error: function(a, b, c) {
              alert(a + " " + b + " " + c);
            },
            complete: function(e) {
              if (localStorage.getItem("loaded") != "1") {
                var tour = new Tour(
                        {
                          backdrop: true,
                          container: "body",
                          backdropContainer: 'body',
                          backdropPadding: true,

                          steps: [
                              {
                                element: "#wrapper",
                                title: "Welcome to the new VDI portal",
                                content: "Please take a few minutes to take our quick tour."
                                        + " The Tool will work as your central page for launching the Virtual machines",
                                container: "#wrapper",
                                backdropContainer: '#wrapper',
                                backdropPadding: true,
                                placement: 'top',
                                smartPlacement: false

                              },
                              {
                                element: "#mappng",
                                title: "Click the Map",

                                content: "Click the regions on the map, this will change the avaiable"
                                        + " pools and products that is installed on the machine",
                                container: "body",
                                backdropContainer: 'body',
                                backdropPadding: true,
                                placement: 'top',
                                smartPlacement: false,
                                onHidden: function(tour) {
                                  if (!tour.ended()) {
                                    $("#list_content").load("vmlist.jsp");
                                  }
                                }

                              },

                              {
                                element: "#search_event",
                                title: "Click the search",
                                content: "This will show the available Virtual machine that meets the criteria of the search",
                                onPrev: function(tour) {
                                  ShowMap();
                                }

                              },

                              {
                                element: "#list_content",
                                title: "Click the VM Name",
                                placement: 'top',
                                content: "'This will download a batch file that will be needed to launch "
                                        + "the virtual machine. Run the batch file and it will load the virtual machine."
                              },
                              {
                                element: "#footer",
                                title: "Click the file",
                                placement: 'auto',
                                content: "Click the downloaded batch file at the bottom of the screen ",
                                smartPlacement: false,
                                onShown : function(tour){
                                	$("#step-4").css("left",0);
                                }
                              //
                              }],
                          onEnd: function(tour) {
                            ShowMap();
                            $("#criteria_search").hide();
                            localStorage.setItem("loaded", "1");
                          }
                        });

                tour.init();
                tour.restart();
              }
              
              $("#test_this_tick_1").css("margin-top",
                      $("#announcements").height() - 100);
              $("#footer").css("margin-top", ($("html").height() / 5));
              
            }
          });
}

function AppendMSOffice() {
  $.ajax({
    type: "POST",
    url: "OfficeController",
    data: "{}",
    contentType: "application/x-www-form-urlencoded",
    dataType: "json",
    success: function(response) {
      $("#office_select").html("");
      var resultsArray = (typeof response) == 'string' ? eval('(' + response
              + ')') : response;
      var dataTable = "";
      dataTable = dataTable + "<option value=''>--</option>";
      for (var i = 0; i < resultsArray.length; i++) {
        dataTable = dataTable + "<option value='" + resultsArray[i].MsoId
                + "'>" + resultsArray[i].MsoName + "</option>";
      }
      $("#office_select").append(dataTable);
    },
    error: function(a, b, c) {
      alert(a + " " + b + " " + c);
    }
  });
}

function AppendInternetExplorer() {
  $.ajax({
    type: "POST",
    url: "IEController",
    data: "{}",
    contentType: "application/x-www-form-urlencoded",
    dataType: "json",
    success: function(response) {
      $("#ie_select").html("");
      var resultsArray = (typeof response) == 'string' ? eval('(' + response
              + ')') : response;
      var dataTable = "";
      dataTable = dataTable + "<option value=''>--</option>";
      for (var i = 0; i < resultsArray.length; i++) {
        dataTable = dataTable + "<option value='" + resultsArray[i].IeId + "'>"
                + resultsArray[i].IeName + "</option>";
      }
      $("#ie_select").append(dataTable);
    },
    error: function(a, b, c) {
      alert(a + " " + b + " " + c);
    }
  });
}

function AppendLanguage() {
  $.ajax({
    type: "POST",
    url: "LanguageController",
    data: "{}",
    contentType: "application/x-www-form-urlencoded",
    dataType: "json",
    success: function(response) {
      $("#language_select").html("");
      var resultsArray = (typeof response) == 'string' ? eval('(' + response
              + ')') : response;
      var dataTable = "";
      dataTable = dataTable + "<option value=''>--</option>";
      for (var i = 0; i < resultsArray.length; i++) {
        dataTable = dataTable + "<option value='" + resultsArray[i].LanguageId
                + "'>" + resultsArray[i].LanguageName + "</option>";
      }
      $("#language_select").append(dataTable);
    },
    complete: function(e) {

    },
    error: function(a, b, c) {
      alert(a + " " + b + " " + c);
    }
  });
}

function AppendProducts(region) {
  $.ajax({
    type: "POST",
    url: "ProductController",
    data: "{\"region\":\"" + region + "\"}",
    contentType: "application/x-www-form-urlencoded",
    dataType: "json",
    success: function(response) {
      $("#produclist_select").html("");
      var resultsArray = (typeof response) == 'string' ? eval('(' + response
              + ')') : response;
      var dataTable = "";
      dataTable = dataTable + "<option value=''>--</option>";
      for (var i = 0; i < resultsArray.length; i++) {
        dataTable = dataTable + "<option value='" + resultsArray[i].ProductId
                + "'>" + resultsArray[i].ProductName + "</option>";
      }
      $("#produclist_select").append(dataTable);
    },
    complete: function(e) {
      AppendMSOffice();
      AppendOperatingSystem();
      AppendInternetExplorer();
      AppendLanguage();
    },
    error: function(a, b, c) {
      alert(a + " " + b + " " + c);
    }
  });
}

function AppendLists() {

}

function SearchVMPool(name, os, office, ie, lang, prod, region) {

  var SearchOS = "";
  var SearchOffice = "";
  var SearchProd = "";
  var SearchLang = "";
  var SearchIe = "";
  var search = "";
  var SearchName = "";
  if (name != "" && name != null) {
    SearchName = " AND vmRef LIKE '~" + name + "~' ";
  }
  if (os != "" && os != null) {
    SearchOS = " AND vmOsId#" + os;
  }
  if (office != "" && office != null) {
    SearchOffice = " AND vmMSOId#" + office;
  }
  if (ie != "" && ie != null) {
    SearchIe = " AND vmIeId#" + ie;
  }
  if (prod != "" && prod != null) {
    SearchProd = " AND vmProdId#" + prod;
    if ($("#produclist_select option:selected").text() == "Eikon Last Client Version"
            || $("#produclist_select option:selected").text() == "Eikon Last Client Version n-1"
            || $("#produclist_select option:selected").text() == "Eikon Last Client Version n-2") {
      isEikon = "1";
    }
  }
  if (lang != "" && lang != null) {
    SearchLang = " AND vmLangId#" + lang;
  }

  var completeSearch = SearchName + SearchOS + SearchOffice + SearchIe
          + SearchProd + SearchLang;
  var dataTable = dataTable + "<thead><tr>";
  dataTable = dataTable + "<th>Reference Name</th>";
  dataTable = dataTable + "<th>OS Version</th>";
  dataTable = dataTable + "<th>Office Version</th>";
  dataTable = dataTable + "<th>Internet Explorer</th>";
  dataTable = dataTable + "<th>Language</th>";
  dataTable = dataTable + "<th>Version</th>";
  dataTable = dataTable + "<th>Details</th>";
  dataTable = dataTable + "</tr></thead><tbody>";
  $.ajax({
    type: "POST",
    url: "SearchVdiVM",
    data: "{\"searchString\":\"" + completeSearch + "\",\"region\":\""
            + (region == "" ? "VirtualMachineAMERS" : region) + "\"}",
    contentType: "application/x-www-form-urlencoded",
    dataType: "json",
    success: function(response) {
      var resultsArray = (typeof response) == 'string' ? eval('(' + response
              + ')') : response;
      $("#appendvm").html("");

      $("#list_content").show();
      for (var i = 0; i < resultsArray.length; i++) {
        dataTable = dataTable + "<tr class='info-hover' row-for='"
                + (resultsArray[i].vmRef) + "'>";
        dataTable = dataTable
                + "<td><a href='javascript:void(0)' title='launch "
                + resultsArray[i].vmRef + "' onclick='LaunchVmPortal(\""
                + resultsArray[i].URIlink + "\",\""
                + $("#current_region").text() + "\",\"" + resultsArray[i].vmRef
                + "\")'>" + resultsArray[i].vmRef + "</a></td>";
        dataTable = dataTable + "<td>" + (resultsArray[i].osname) + "</td>";
        dataTable = dataTable + "<td>" + (resultsArray[i].offname) + "</td>";
        dataTable = dataTable + "<td>" + (resultsArray[i].iename) + "</td>";
        dataTable = dataTable + "<td>" + (resultsArray[i].langnames) + "</td>";
        dataTable = dataTable + "<td>"
                + ReturnBlank(resultsArray[i].ProductVersion) + "</td>";

        dataTable = dataTable
                + "<td><a href='javascript:void(0)' onclick='LaunchInfo(\""
                + (resultsArray[i].vmRef) + "\",\""
                + $("#virtualRegions").val() + "\")'>details</a></td>";

        dataTable = dataTable + "</tr>";
      }

      $("#orig_content").hide();

    },
    complete: function(e) {
      $('#myModal').modal('hide');
      $("#orig_content").hide();
      $("#appendvm").append(dataTable + "</tbody>");
      try {
        $("#appendvm").dataTable({
          bInfo: false,
          "aaSorting": [],
          "sScrollY": "500",
          "bScrollCollapse": true
        });
      } catch (err) {
        $('#myModal').modal('hide');
      }
      $("#tester").css("margin-top", $("#announcements").height() - 100);
      $("html, body").animate({
        scrollTop: $('#appendvm').offset().top
      }, 2000);

    },
    error: function(a, b, c) {

    }
  });

}

function SetStrimToTrim(strlen) {
  var newStr = strlen;
  if (strlen.length >= 15) {
    newStr = strlen.substring(0, 14) + ".....";
  }

  return newStr;
}

function LaunchInfo(vmref, region) {
  window.open("details.jsp?vmref=" + vmref + "&reg=" + region + "&!$3!k0n="
          + isEikon, "_blank", "width=800,height=600,menubar=no,toolbar=no");
}

function LaunchKb() {
  window.open("kb/vdi_kb.pdf", "_blank");
}
function LaunchVmPortal(urilink, region, vmref) {
  if (localStorage.getItem("downloaded") != "1") {
    var tour = new Tour({
      backdrop: true,
      container: "body",
      backdropContainer: 'body',
      backdropPadding: true,
      duration: '10000',
      keyboard: true,
      steps: [{
        element: "#download_loc",
        title: "Click the file",
        placement: 'top',
        content: "Click the downloaded batch file at the bottom of the screen "
      //
      }],
      onEnd: function(tour) {

        localStorage.setItem("downloaded", "1");
      }
    });

    tour.init();
    tour.restart();
  }
  CollateDataForInsert(vmref, "launch", "1", "6016812", region);

  window.open("LauncherClass?poolname=" + encodeURIComponent(urilink)
          + "&region=" + region + "&vmref=" + vmref, "_blank");
  /* window.close(); */
  event.preventDefault();
}

function ReturnBlank(stringUndefined) {
  var newstring = stringUndefined;
  if (stringUndefined == null || stringUndefined == undefined) {
    newstring = "";
  }

  return newstring;
}

function ReplaceCH(stringsuri) {
  var newStr = stringsuri.replace(/%20/g, "******");
  return newStr;
}
function returnToSearch() {
  $("#criteria_search").show();
  $("#vm_div_part").hide();
}

function AppendEikonVersions() {
  $
          .ajax({
            type: "post",
            url: "EikonVersions",
            data: "{}",
            contentType: "application/x-www-form-urlencoded",
            dataType: "json",
            success: function(response) {
              var resultsArray = (typeof response) == 'string' ? eval('('
                      + response + ')') : response;
              var dataTable = "<tr><td colspan='3' style='text-align:center'>Eikon last client versions offered</td></tr><tr><td><small>Eikon Last Version</td></small><td><small>Eikon Last Version N-1</small></td><td><small>Eikon Last Version N-2</small></td></tr>";

              dataTable = dataTable + "<tr><td><small>"
                      + resultsArray[0].ProductVersion + "</td>";
              dataTable = dataTable + "<td><small>"
                      + resultsArray[1].ProductVersion + "</td>";
              dataTable = dataTable + "<td><small>"
                      + resultsArray[2].ProductVersion + "</td></tr>";

              $("#appendEikontable").append(dataTable);

            },
            complete: function(e) {

            }
          });
}

function ClearSearchBoxes() {
  $("#os_select").val("");
  $("#office_select").val("");
  $("#ie_select").val("");
  $("#language_select").val("");
  $("#produclist_select").val("");
  $("#vmref").val("");
}

function ShowMap() {
  $("#sidebar").hide();
  $("#orig_content").show();
  $("#list_content").hide();

}

function SetRegion(regionProd, regionVm) {
  $("#criteria_search").show();
  var shortRegion = "";

  switch (regionVm) {

  case "VirtualMachineAMERS":
    shortRegion = "AMERS";
    break;
  case "VirtualMachineEMEA":
    shortRegion = "EMEA";
    break;
  case "VirtualMachineAPAC":
    shortRegion = "APAC";
    break;
  case "VirtualMachineIPBS":
    shortRegion = "IPBS";
    break;

  }
  $("#sidebar").show();
  $("#current_region").text(shortRegion);
  $("#regionProducts").val(regionProd);
  $("#virtualRegions").val(regionVm);
  AppendProducts($("#regionProducts").val());

}

/*
 * function InsertSearch(vmName, osName, officeName, iEName, langName, Products) {
 * $.ajax({ type: "post", url: "EikonVersions", data: "{\"vmName\":\"" + vmName +
 * "\"," + "\"osName\":\"" + osName + "\"," + "\"officeName\":\"" + officeName +
 * "\"," + "\"iEName\":\"" + iEName + "\"," + "\"langName\":\"" + langName +
 * "\"," + "\"Products\":\"" + Products + "\"," + "}", contentType:
 * "application/x-www-form-urlencoded", dataType: "json", success:
 * function(response) { var resultsArray = (typeof response) == 'string' ?
 * eval('(' + response + ')') : response; }, complete: function(e) { } }); }
 */

function InsertWhentInvalue(vmref, os_select, office_select, ie_select,
        language_select, produclist_select, userId, region) {
  if (vmref != "") {
    CollateDataForInsert(vmref, "vmref", "1", userId, region);
  }
  if (os_select != "") {
    CollateDataForInsert(os_select, "os", "1", userId, region);
  }
  if (office_select != "") {
    CollateDataForInsert(office_select, "office", "1", userId, region);
  }
  if (language_select != "") {
    CollateDataForInsert(language_select, "language", "1", userId, region);
  }
  if (ie_select != "") {
    CollateDataForInsert(ie_select, "Internet", "1", userId, region);
  }
  if (produclist_select != "") {
    CollateDataForInsert(produclist_select, "product", "1", userId, region);
  }

}

// TO DO:
function CollateDataForInsert(fieldName, category, count, userId, region) {
  $.ajax({
    type: "post",
    url: "AddVMActivity",
    data: "{\"fieldName\":\"" + fieldName + "\"," + "\"category\":\""
            + category + "\"," + "\"count\":\"" + count + "\","
            + "\"userId\":\"" + userId + "\"," + "\"region\":\"" + region
            + "\"" + "}",
    contentType: "application/x-www-form-urlencoded",
    dataType: "json",
    success: function(response) {
      var resultsArray = (typeof response) == 'string' ? eval('(' + response
              + ')') : response;

    },
    complete: function(e) {

    }
  });
}
