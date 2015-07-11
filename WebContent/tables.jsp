<% /**
* NapoXir Tables.jsp
* @author: Sir Xiradorn
*/
%>
<% /* qua ci va messo qualche cosa forse il login o altro per controllare la pagina. Poi vedi stesso tu */ %>
<% String pageName = "NapoXir - Table Scheduling"; %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="widht=device-width, initial-scale=1, user-scalable=no">
    <!-- The jQuery library is a prerequisite for all jqSuite products -->
    <script type="text/ecmascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
    <script type="text/ecmascript" src="${pageContext.request.contextPath}/assets/js/jquery-ui.min.js"></script>
    <!-- This is the Javascript file of jqGrid -->
    <script type="text/ecmascript" src="${pageContext.request.contextPath}/assets/js/jquery.jqGrid.min.js"></script>
    <!-- This is the localization file of the grid controlling messages, labels, etc. -->
    <!-- We support more than 40 localizations -->
    <script type="text/ecmascript" src="${pageContext.request.contextPath}/assets/js/i18n/grid.locale-en.js"></script>
    <!-- A link to a jQuery UI ThemeRoller theme, more than 22 built-in and many more custom -->
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/assets/css/jquery-ui.min.css" />
    <!-- The link to the CSS that the grid needs -->
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/assets/css/ui.jqgrid.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/assets/css/jquery-ui-1.10.0.bootstrap.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/assets/css/ui.jqgrid-bootstarp.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/assets/css/nopoxir.custom.css" />
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/assets/css/nopoxir.noresponsive.css" />
    <style type="text/css">
        #gbox_jqGrid {
            margin: 20px auto !important;
        }
    </style>
    <title><% out.print(pageName); %></title>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-static-top">
        <div class="container xir-no-res">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/tables.jsp"><% out.print(pageName); %></a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/tables.jsp">Tables</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/login.jsp">Login <span class="sr-only">(current)</span></a></li>
                    <li><a href="#">Register</a></li>
                    <li><a href="#">Profile</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Admin <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">User List</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">User Menager</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <div class="container xir xir_tables xir-no-res">
        <h2 class="text-center"><% out.print(pageName); %></h2>
        <h4 class="text-center">Reporting Table with Ordering, Editing and Adding Functions</h4>

        <table id="jqGrid"></table>
        <div id="jqGridPager"></div>
    </div>

    <div class="container text-center xir-no-res">
        <p class="copyright"><% out.print(pageName); %> <span class="glyphicon glyphicon-copyright-mark"></span> 2015</p>
    </div>
        <script type="text/javascript">
            $(document).ready(function () {
                /* Inizializza for editing */
                var template = "<div style='margin-left:15px;'><div> OrderID <sup>*</sup>:</div><div> {OrderID} </div>";
    			template += "<div> CustomerID: </div><div>{CustomerID} </div>";
    			template += "<div> Date: </div><div>{OrderDate} </div>";
                /* Inizializza Tabella */
                $("#jqGrid").jqGrid({
                    url: "json/data.json",
                    mtype: "GET",
                    datatype: "json",
                    colModel: [
                        { label: 'OrderID', name: 'OrderID', key: true, width: 160, editable: true, editrules : { required: true} },
     					{ label: 'Customer ID', name: 'CustomerID', width: 160, editable: true, editrules : { required: true} },
                        {
                            label: 'Order Date',
                            name: 'OrderDate',
                            width: 160,
                            editable: true,
                            edittype:"text",
                            searchoptions: {
                            // dataInit is the client-side event that fires upon initializing the toolbar search field for a column
                            // use it to place a third party control to customize the toolbar
                                dataInit: function (element) {
                                    $(element).datepicker({
                                        id: 'orderDate_datePicker',
                                        dateFormat: 'yy-mm-dd',
                                        minDate: new Date(2000, 0, 1),
                                        maxDate: new Date(2150, 0, 1),
                                        showOn: 'focus'
                                    });
                                }
                            },
                            editoptions: {
                            // dataInit is the client-side event that fires upon initializing the toolbar search field for a column
                            // use it to place a third party control to customize the toolbar
                                dataInit: function (element) {
                                    $(element).datepicker({
                                        id: 'orderDate_datePicker',
                                        dateFormat: 'yy-mm-dd',
                                        minDate: new Date(2000, 0, 1),
                                        maxDate: new Date(2150, 0, 1),
                                        showOn: 'focus'
                                    });
                                }
                            }
                        },
                        {
    						label: 'Freight',
    						name: 'Freight',
    						width: 160,
    						formatter: 'number',
    						summaryTpl : "<b>{0}</b>",
    						summaryType: "sum"
    					},
                        { label: 'Employee ID', name: 'EmployeeID', width: 160 }
                    ],
    				loadonce:true,
    				viewrecords: true,
    				rowList: [20,30,50,100],
                    width: 850,
                    height: 250,
                    rowNum: 20,
    				sortname: 'OrderDate',
                    subGrid: true, // set the subGrid property to true to show expand buttons for each row
                    subGridRowExpanded: showChildGrid, // javascript function that will take care of showing the child grid
    			    subGridOptions : {
    					// configure the icons from theme rolloer
    					plusicon: "ui-icon-triangle-1-e",
    					minusicon: "ui-icon-triangle-1-s",
    					openicon: "ui-icon-arrowreturn-1-e"
    				},
                    grouping: false,
                    groupingView: {
                        groupField: ["OrderDate"],
                        groupColumnShow: [true],
                        groupText: ["<b>{0}</b>"],
                        groupOrder: ["asc"],
                        groupSummary: [true],
    					groupSummaryPos: ['footer'],
                        groupCollapse: false
                    },
                    pager: "#jqGridPager",
                    caption: "Controll Table Page"
                });
                /* Inizializza Tasti */
                $('#jqGrid').jqGrid('filterToolbar');
                $('#jqGrid').jqGrid('navGrid','#jqGridPager',
                // the buttons to appear on the toolbar of the grid
                { edit: true, add: true, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: true },
                {
                    editCaption: "The Edit Dialog",
                    recreateForm: true,
					checkOnUpdate : true,
					checkOnSubmit : true,
                    closeAfterEdit: true,
                    errorTextFormat: function (data) {
                        return 'Error: ' + data.responseText
                    }
                },
                // options for the Add Dialog
                {
                    closeAfterAdd: true,
                    recreateForm: true,
                    errorTextFormat: function (data) {
                        return 'Error: ' + data.responseText
                    }
                },
                // options for the Delete Dailog
                {
                    errorTextFormat: function (data) {
                        return 'Error: ' + data.responseText
                    }
                });
            });
            // the event handler on expanding parent row receives two parameters
            // the ID of the grid tow  and the primary key of the row
            function showChildGrid(parentRowID, parentRowKey) {
                $.ajax({
                    url: "json/subreports/"+parentRowKey+".html",
                    type: "GET",
                    success: function (html) {
                        $("#" + parentRowID).append(html);
                    }
                });
            }
        </script>

        <script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
</body>
</html>
