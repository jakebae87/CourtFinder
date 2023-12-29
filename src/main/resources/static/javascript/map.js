var geo_latitude = null;
var geo_longitude = null;

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
}