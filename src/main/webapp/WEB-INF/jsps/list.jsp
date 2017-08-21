<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
    pageContext.setAttribute("ctp", request.getContextPath());
%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<%@include file="/WEB-INF/includes/css-file.jsp"%>
<link rel="stylesheet" href="${ctp}/css/main.css">
<style>
.tree li {
	list-style-type: none;
	cursor: pointer;
}

table tbody tr:nth-child(odd) {
	background: #F4F4F4;
}

table tbody td:nth-child(even) {
	color: #C00;
}
</style>
</head>
<body>


	<h1>手机列表</h1>
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>phoneId</th>
			<th>phoneName</th>
			<th>phonePrice</th>
			<th>phoneColor</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>
		<c:forEach items="${phones.list }" var="phone">
			<tr>
				<td>${phone.phoneId }</td>
				<td>${phone.phoneName}</td>
				<td>${phone.phonePrice }</td>
				<td>${phone.phoneColor }</td>
				<td>
					<button phoneId="${phone.phoneId }" phoneName="${phone.phoneName}"
						phonePrice="${phone.phonePrice }" phoneColor="${phone.phoneColor }"
					type="button" id="edit_btn" class="btn btn-primary editBtn"
							style="float: right;" >
							<i class="glyphicon glyphicon-plus "></i> 修改
					</button>
				</td>
				<td>
					<button type="button" del_id="${phone.phoneId }" id="del_btn" class="btn btn-danger deleteBtn"
							style="float: right; margin-left: 10px;">
							<i class="glyphicon glyphicon-remove"></i> 删除
					</button>
				</td>
			</tr>
		</c:forEach>
		<button type="button" id="add_btn" class="btn btn-primary" style="float:center;" >
				<i class="glyphicon glyphicon-plus "></i> 添加
			</button>
		
		
		<tfoot>
			<tr>
				<td colspan="6" align="center">
					<ul class="pagination">
						<!-- 即使点击分页连接也应该带上查询条件的值 -->
						<!-- 给分页超链接绑定单击事件； -->
						<li><a href="${ctp}/phones?pn=1">首页</a></li>
						<c:if test="${phones.hasPreviousPage}">
							<li><a href="${ctp}/phones?pn=${phones.prePage}">上一页</a></li>
						</c:if>

						<!-- 遍历连续显示的页面 navigatepageNums : int[]-->
						<c:forEach items="${phones.navigatepageNums}" var="pn">
							<c:if test="${pn == phones.pageNum }">
								<li class="active"><a href="${ctp}/phones?pn=${pn}">${pn } 
									<span class="sr-only">(current)</span></a>
								</li>	
							</c:if>
							<c:if test="${pn != phones.pageNum }">
								<li><a href="${ctp}/phones?pn=${pn}">${pn }</a></li>
							</c:if>
						</c:forEach>

						<c:if test="${phones.hasNextPage}">
							<li><a href="${ctp}/phones?pn=${phones.nextPage}">下一页</a></li>
						</c:if>
						
						<li><a href="${ctp}/phones?pn=${phones.pages}">末页</a></li>
							
					</ul>
				</td>
			</tr>

		</tfoot>
	</table>

	<!-- 模态框 -->
	<div class="modal fade" id="ad_add_model" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<div class="modal-body">
					<form action="${ctp }/add" id="add_form"
						method="post" enctype="multipart/form-data">
						<div class="form-group">
							<input type="hidden" id="phoneId" name="phoneId"/>
							<label>phoneName</label> <input type="text" class="form-contrl add_name"
								id="add_name_input" name="name" placeholder="phoneName" />
						</div>
						<div class="form-group">
							<label>phonePrice</label> <input type="text" class="form-contrl add_price"
								id="add_price_input" name="price" placeholder="phonePrice" />
						</div>
						<div class="form-group">
							<label>phoneColor</label> <input type="text" class="form-contrl add_color"
								id="add_color_input" name="color" placeholder="phoneColor" />
						</div>

						<div class="form-group">
							<div class="row">
								<div class="col-md-12 imgdiv"></div>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="submitBtn">确定</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>

				</div>
			</div>
		</div>
	</div>

	<%@include file="/WEB-INF/includes/js-file.jsp" %>
	<script type="text/javascript">
		console.log("${phones}");
		//获取最后一页的url
		var lastPageUrl = "${ctp}/phones?pn=${phones.pages}";
		//获取当前页的url
		var thisPageUrl = "${ctp}/phones?pn=${phones.pageNum}" ;
		var index; //layer提示框索引
		
		//获取所有手机在页面展示
		function getAllUsers(pn) {

			$.ajax({
				url : "${ctp}/list",
				type : "get",
				data : "pn=" + pn,
				beforeSend : function() {
					index = layer.load();
				},
				success : function(result) {
					location.href = lastPageUrl;
				}
			})
		}
		
		//点击添加按钮弹出模态框
		$("#add_btn").click(function(){
			$("#myModalLabel").text("添加手机");
			$("#ad_add_model").modal("show"); 
			$("#submitBtn").attr("opreate", "add");
			$("#add_form")[0].reset(); //重置模态框
			
		});
		
		//手机信息填写完成，点击确定按钮，将手机添加到页面展示
		$("#submitBtn").click(function(){
			var opreate = $(this).attr("opreate")
			//发送ajax
			$.ajax({
				url : "${ctp}/"+opreate,
				type : "get",
				data : {
					phoneName : $("#add_name_input").val(),
					phonePrice : $("#add_price_input").val(),
					phoneColor : $("#add_color_input").val()
				},
				success : function(result){
					layer.msg(result);
					
					//添加成功来到最后一页
					location.href = lastPageUrl;
				},
				error : function(result){
					layer.msg(result);
				}
			});
		});
		
		$(".deleteBtn").click(function(){
			//点击删除按钮，获取要删除的员工的id
			var delUrl = "${ctp}/del?pn=${phones.pageNum}&phoneId="
			var phoneId = $(this).attr("del_id");
			
			//让浏览器访问这个删除链接
			if(confirm("确认删除【"+phoneId+"】这部手机吗?")){
				location.href = delUrl + phoneId;
			}
			return false;
		});
		
		//点击修改，弹出编辑页面的模态框
		$(".editBtn").click(function(){
			
			$("#myModalLabel").text("编辑手机");
			$("#submitBtn").attr("opreate", "edit");
			//找到标签,设置标签的属性值
			$("#phoneId").attr("value",$(this).attr("phoneId"));
			$(".add_name").attr("value",$(this).attr("phoneName"));
			$(".add_price").attr("value",$(this).attr("phonePrice"));
			$(".add_color").attr("value",$(this).attr("phoneColor"));
			
			$("#ad_add_model").modal("show");
			
			
			
		});
		
		//点击修改模态框的确定按钮
		$("#submitBtn").click(function(){
			var opreate = $(this).attr("opreate");
			$.ajax({
				url : "${ctp}/" + opreate,
				type : "get",
				data : {
					phoneId : $("#phoneId").val(),
					phoneName : $("#add_name_input").val(),
					phonePrice : $("#add_price_input").val(),
					phoneColor : $("#add_color_input").val()
				},
				success : function(result){
					layer.msg(result);
					
					//修改成功，来到当前页
					location.href = thisPageUrl;
				},
				error : function(result){
					layer.msg(result);
				}
			});
		});
	</script>
</body>
</html>