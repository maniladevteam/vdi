

<style>
#table-wrapper {
	position: relative;
}

#table-scroll {
	height: 720px;
	overflow: auto;
	margin-top: 20px;
}

#table-wrapper table {
	width: 100%;
}

#table-wrapper table * {
	
}

#table-wrapper table thead th .text {
	position: absolute;
	top: -20px;
	z-index: 2;
	height: 100%;
}
</style>
<script>
  $("#search_event").ready(
 
          function() {
            $("#criteria_search").show();
            $("#clear_search").click(function() {
              ClearSearchBoxes();
            });
            $("#search_event").click(
                    function() {
                      $('#myModal').modal('toggle');
                      $("#list_content").load("vmlist.jsp");
                      InsertWhentInvalue($("#vmref").val(), $("#os_select")
                              .val(), $("#office_select").val(),
                              $("#ie_select").val(), $("#language_select")
                                      .val(), $("#produclist_select").val(),
                              "6016812", $("#current_region").text());
                    });
            $("#back_region").click(function() {
              ShowMap();
            });  

          });
</script>
</head>
<div id="criteria_search">
	Region <span class="label" id="current_region"></span>
	<ul class="side-nav">
		<li><label>Virtual Machine Reference Name</label><input
			class='form-control' type="text" name="vmref" id="vmref" />
		<li><label>Operating System</label><select id="os_select"
			class='form-control'>

		</select></li>
		<li><label>Microsoft Office</label><select id="office_select"
			class='form-control'>

		</select></li>
		<li><label>Internet Explorer</label><select id="ie_select"
			class='form-control'>

		</select></li>
		<li><label>Language</label><select id="language_select"
			class='form-control'>

		</select></li>
		<li><label>Products</label><select id="produclist_select"
			class='form-control'>

		</select></li>
	</ul>
	<button type="button" class="btn-default" id="search_event"
		style="width: 100%;">Search</button>

	<a href="javascript:void(0)" class="button secondary" id="clear_search"
		style="width: 48%;">Clear</a> <a href="javascript:void(0)"
		class="button secondary" id="back_region" style="width: 50%;">Back</a>

	<button type="button" class="btn-default" id="relaunch_tuts"
		style="width: 100%;">Relaunch Tutorial</button>
</div>
<div id="vm_div_part" style="display: none" style="max-height: 100%;">

</div>
<script>

$("#relaunch_tuts").click(function(){
    ReloadTuts();
});
</script>