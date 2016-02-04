<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel='stylesheet prefetch'
	href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/themes/smoothness/jquery-ui.css'>
<link rel="stylesheet" href='<c:url value="/resources/css/style.css"/>'>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<script>
	$().ready(function() {
		jQuery.validator.addMethod("cdnPostal", function(postal, element) {
		    return this.optional(element) || 
		    postal.match(/[a-zA-Z][0-9][a-zA-Z](-| |)[0-9][a-zA-Z][0-9]/);
		}, "Please specify a valid postal code.");
		$("#zipform").validate({

			// Specify the validation rules
			rules : {
				zipcode : {
					required : true,
					minlength : 5,
					maxlength : 5
				}
			},
			messages : {
				zipcode : {
					required : "Please type a valid zip code.",
					minlength : "Zip code has to be 5 digits.",
					maxlength : "Zip code has to be 5 digits."
				}
			},
			submitHandler : function(form) {
				getWeather();
			}
		});
	});
	
	function getWeather() {

		var zipcode = document.getElementById("zipcode").value;
		var woeid;
		var country;
		var city;
		var state;
		var whr = new XMLHttpRequest();
		var url = "https://query.yahooapis.com/v1/public/yql?q=SELECT * FROM geo.places WHERE text = "
				+ zipcode
				+ " Limit 1&format=json&env=store://datatables.org/alltableswithkeys";
		whr.open("GET", url, true);
		whr.send();
		whr.onreadystatechange = function() {
			if (whr.readyState == 4 && whr.status == 200) {
				var w = JSON.parse(whr.responseText);
				country = w.query.results.place.country.code;
				state = w.query.results.place.admin1.content;
				city = w.query.results.place.locality1.content;
				woeid = w.query.results.place.woeid;
				var xhr = new XMLHttpRequest();
				xhr
						.open(
								"GET",
								"https://query.yahooapis.com/v1/public/yql?q=select * from weather.forecast where woeid = "
										+ woeid
										+ "&format=json&env=store://datatables.org/alltableswithkeys",
								true);
				xhr.send();
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4 && xhr.status == 200) {

						var w = JSON.parse(xhr.responseText);

						document.getElementById("weather").innerHTML = "<table  class=\"rwd-table\">"
								+ "<th>"
								+ country
								+ "\t"
								+ state
								+ "\t"
								+ city
								+ "</th>"
								+ "<tr><td> Current Temp is "
								+ w.query.results.channel.item.condition.temp
								+ "  degrees"
								+ "</td></tr>"
								+ "<tr><td> Current wind chill is "
								+ w.query.results.channel.wind.chill
								+ "</td></tr></table>";
					}
					;
				};
			}
			;
		};

	}
</script>

<body>
	<div class="login-card">
		<h1>Success</h1>
		<br>
		<form id="zipform">
			<div>
				<input type="text" id="zipcode" name="zipcode" placeholder="Zipcode" />
			</div>
			<div class="login-help">
				<input type="submit" class="login login-submit"
					value="Submit" />
			</div>
		</form>
	</div>
	<div id="weather" align="center"></div>
</body>