<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/man/js/jquery/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/man/css/pagination.css"  charset="utf-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/man/css/basic.css" charset="utf-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/man/css/detailPage.css" charset="utf-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/man/css/dataList.css" charset="utf-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/man/css/error.css" charset="utf-8" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/man/css/tablecloth/tablecloth.css" charset="utf-8" />
<script type="text/javascript" src='<%=request.getContextPath()%>/man/js/pagination.js'> </script>
<script type="text/javascript" src='<%=request.getContextPath()%>/man/js/check.js'> </script>

<script type="text/javascript" src='<%=request.getContextPath()%>/man/js/jquery/jquery-1.7.2.min.js'> </script>
<script type="text/javascript" src="<%=request.getContextPath()%>/man/js/jquery-easyui-1.3.3/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/man/js/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/man/js/jquery-easyui-1.3.3/themes/bootstrap/easyui.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/man/js/jquery-easyui-1.3.3/extEasyUI.js?v=201305241044" charset="utf-8"></script>

<link rel="stylesheet" href="<%=request.getContextPath()%>/man/js/jquery-easyui-1.3.3/extEasyUIIcon.css?v=201305301906" type="text/css">

<script type="text/javascript" src="<%=request.getContextPath()%>/man/js/jquery-easyui-1.3.3/extJquery.js?v=201305301341" charset="utf-8"></script>


<script type="text/javascript" src='<%=request.getContextPath()%>/man/js/jquery/jQuery.tableScroll.js'> </script>
<script type="text/javascript" src='<%=request.getContextPath()%>/man/js/jquery/jqueryform.js'> </script>
<script type="text/javascript" src='<%=request.getContextPath()%>/man/js/cm_DatePicker/WdatePicker.js'></script>
<script type="text/javascript" src='<%=request.getContextPath()%>/man/js/listPage.js'></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/man/js/easyui/dialog.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/man/js/validateExt.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/man/js/cm_ajax.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/man/css/tablecloth/tablecloth.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/man/js/biz.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/man/js/autoCompletion.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/man/js/date.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/man/js/util.js"></script>

<script type="text/javascript" src='<%=request.getContextPath()%>/man/js/checkIsNull.js'> </script>
<script type="text/javascript" src='<%=request.getContextPath()%>/man/js/dicInfo.js'> </script>

<script type="text/javascript" src='<%=request.getContextPath()%>/man/js/ctablehead.js'> </script>
<script type="text/javascript" src='<%=request.getContextPath()%>/man/js/public.js'> </script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/man/css/ctab.css" charset="utf-8" />

<script type="text/javascript">
function inputNoEnter(){
  $("input[type=text]").not("#inputPageNum").keydown(function(event){if(event.keyCode==13){return false;}});
}
$(document).ready(function(){
  inputNoEnter();
});
var autoNumber =20;
</script>