<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	//1. 문서 로딩
	$(document).ready(function(){
		//2. ajax 요청
		$.ajax({
			type:'GET',
			url:'/web/pizzaPieChart',
			//3. 요청 성공 시
			success:function(pizzaData){
				//console.log(pizzaData);	
				google.charts.load('current', {'packages':['corechart']});
				google.charts.setOnLoadCallback(drawChart);
				function drawChart() {
					var data = new google.visualization.DataTable();
			        data.addColumn('string', 'Topping');
			        data.addColumn('number', 'Slices');
			        var rowList = [];
					$(pizzaData).each(function(){
						var row = [];
						row[0] = this.topping;
						row[1] = this.slices;
						rowList.push(row);
					});
					data.addRows(rowList);
					//console.log(data);
					
					var options = {
							'title' : 'How Much Pizza I Ate Last Night',
							'width' : 400,
							'height' : 300
						};
					var chart = new google.visualization.PieChart($('#chart_div')[0]);
			        chart.draw(data, options);
				}
			}
		});
	});
</script>
</head>
<body>
	<div id="chart_div"></div>
</body>
</html>