var geo_latitude = null;
var geo_longitude = null;
var infowindow = new kakao.maps.InfoWindow(); // 인포윈도우를 함수 외부에서 선언

window.onload = function() {
	var locationPermission = sessionStorage.getItem('locationPermission');
	if (!locationPermission) {
		var answer = confirm("현재 위치정보를 보시려면 '확인'을 눌러주세요.");
		if (answer == true) {
			sessionStorage.setItem('locationPermission', 'granted');
			getUserLocation();
		} else {
			createMap(37.5665, 126.9780); // 현재 위치정보 허용하지 않을 경우 서울 시청역으로 이동
		}
	} else {
		getUserLocation();
	}
};

function getUserLocation() {
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			geo_latitude = position.coords.latitude;
			geo_longitude = position.coords.longitude;

			createMap(geo_latitude, geo_longitude);
		});
	}
}

function createMap(latitude, longitude) {
	var mapContainer = document.getElementById('map');
	var mapOption = {
		center: new kakao.maps.LatLng(latitude, longitude),
		level: 3
	};

	var map = new kakao.maps.Map(mapContainer, mapOption);

	getSavedLocations(map);
}

function getSavedLocations(map) {
	axios.get('/allCourt')
		.then(response => {
			const courtData = response.data;

			const markers = courtData.map(court => {
				const marker = new kakao.maps.Marker({
					position: new kakao.maps.LatLng(court.latitude, court.longitude)
				});

				kakao.maps.event.addListener(marker, 'mouseover', function() {
					infowindow.setContent(court.content);
					infowindow.open(map, marker);
				});

				kakao.maps.event.addListener(marker, 'mouseout', function() {
					infowindow.close();
				});

				kakao.maps.event.addListener(marker, 'click', function() {
					// 클릭한 마커의 정보를 모달에 표시
					displayModal(court);
				});

				return marker;
			});

			markers.forEach(marker => {
				marker.setMap(map);
			});

			var clusterer = new kakao.maps.MarkerClusterer({
				map: map,
				averageCenter: true,
				minLevel: 5,
				markers: markers
			});
		})
		.catch(error => {
			alert("에러 발생: " + error.message);
		});
}

function displayModal(court) {
	var modalContent = document.getElementById('modalContent');
	axios.get('/detail/' + court.id)
		.then(response => {
			modalContent.innerHTML = response.data;
			var modal = new bootstrap.Modal(document.getElementById('myModal'));
			modal.show();
		})
		.catch(error => console.error('서버 통신 중 오류 발생:', error));
}
