angular.module("navbar", [])
	.controller("navbarC", function ($scope, $templateRequest, $sce, $compile){
		var thisURL = "";
		var lastURL = "";
		var carousel = angular.element(myCarousel); // getting carousel (variable part)
		var carouselToggled = false; // is carousel up?
		var htmlContainer = angular.element(HTMLContainer);
		initHTML();
		$scope.update = function(url){
			thisURL = url;
			click();
			$scope.urlActive = thisURL;
		}
		function click() {
			console.log("lastURL: " + lastURL);
			console.log("thisURL: " + thisURL);
			console.log("htmlContainer: " + htmlContainer);
			console.log("carouselToggler: " + carouselToggled);
			if(carouselToggled){
				if(isAnotherElement()){
					if(thisURL=='home'){
						carousel.removeClass('carouselAnimUp');
						carousel.addClass('carouselAnimDown');
						toggleVisibility();
						carouselToggled = false;
						makeTheMagicHappen();
					}
					else{
						makeTheMagicHappen();
					}
					lastURL = thisURL;
				}
				else{
					makeTheMagicHappen();
					lastURL = thisURL;
				}
			}
			else{
				if(thisURL!='home'){
					carousel.removeClass('carouselAnimDown');
					carousel.addClass('carouselAnimUp');
					setTimeout(toggleVisibility, 1000);
					carouselToggled = true;
				}
				makeTheMagicHappen();
				lastURL = thisURL;
			}
		};
		
		function initHTML(){
			thisURL = "home";
			$scope.urlActive = thisURL;
			var templateURL = $sce.getTrustedResourceUrl('home.html');
			$templateRequest(templateURL).then(function(template){
				$compile(htmlContainer.html(template).contents())($scope);
			},function(){
				console.log("fileerror");
			});
			console.log("initialized")
		};
		function toggleVisibility (){
			carousel.toggleClass('notVisible');
		};
		function changeHTML(){
			setTimeout(function(){
				var templateURL = $sce.getTrustedResourceUrl(thisURL+'.html');
				$templateRequest(templateURL).then(function(template){
					$compile(htmlContainer.html(template).contents())($scope);
				},function(){
					console.log("fileerror");
				});
			},1000);
		};
		function isAnotherElement(){
			return thisURL != lastURL;
		}
		function makeTheMagicHappen(){
			htmlContainer.addClass('opacityDown');
			setTimeout(changeHTML(), 1000);
			setTimeout(function(){
				htmlContainer.removeClass('opacityDown');
				}, 1000);
			setTimeout(function(){
				htmlContainer.addClass('opacityUp');
				}, 1000);
			setTimeout(function(){
				htmlContainer.removeClass('opacityUp');
				}, 2000);
		}
	})