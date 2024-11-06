document.addEventListener('DOMContentLoaded', function () {
    var mapOptions = {
        center: new naver.maps.LatLng(37.3595704, 127.105399), // 초기 위치 (기본값)
        zoom: 10
    };
    var map = new naver.maps.Map('map', mapOptions);
    var markers = []; // 기존 마커 배열 생성

    // 내 위치 보기 버튼 클릭 시 위치 찾기
    document.getElementById('find-me').addEventListener('click', function () {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                var lat = position.coords.latitude;
                var lng = position.coords.longitude;

                if (isNaN(lat) || isNaN(lng)) {
                    document.getElementById('status').textContent = "위치 정보를 가져올 수 없습니다.";
                    return;
                }

                var userLocation = new naver.maps.LatLng(lat, lng);
                map.setCenter(userLocation); // 지도 중심을 사용자 위치로 설정

                // 마커 추가
                new naver.maps.Marker({
                    position: userLocation,
                    map: map
                });

                document.getElementById('status').textContent = "현재 위치를 찾았습니다!";
            }, function (error) {
                document.getElementById('status').textContent = "위치를 가져올 수 없습니다. 권한을 허용해주세요.";
            });
        } else {
            document.getElementById('status').textContent = "Geolocation을 지원하지 않는 브라우저입니다.";
        }
    });

    // 수족관 찾기 버튼 클릭 시 수족관 위치 표시
    document.getElementById('find-aquarium').addEventListener('click', function () {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                var lat = position.coords.latitude;
                var lng = position.coords.longitude;

                if (!lat || !lng) {
                    document.getElementById('status').textContent = "위치 정보를 가져올 수 없습니다.";
                    return;
                }

                // query 파라미터는 '아쿠아리움'으로 설정
                const query = '아쿠아리움';
                const url = `/find/naver-proxy?query=${encodeURIComponent(query)}&lat=${lat}&lng=${lng}`;

                console.log("Fetching data from:", url);

                if (!query || !lat || !lng) {
                    document.getElementById('status').textContent = "유효한 값을 입력해주세요.";
                    return;
                }

                fetch(url)
                    .then(response => {
                        if (!response.ok) {  // 응답 상태 코드 확인 (200번대 응답만 처리)
                            throw new Error(`HTTP error! status: ${response.status}`);
                        }
                        return response.text();  // JSON을 텍스트로 먼저 읽음
                    })
                    .then(text => {
                        try {
                            if (text.startsWith("{")) {  // 응답이 JSON 형식일 경우
                                const data = JSON.parse(text);
                                if (data.items) {
                                    displayAquariumLocations(data.items);
                                } else {
                                    document.getElementById('status').textContent = "수족관 데이터를 찾을 수 없습니다.";
                                }
                            } else {
                                throw new Error("응답이 JSON 형식이 아닙니다.");
                            }
                        } catch (e) {
                            // JSON 파싱 에러나 다른 오류 발생 시 처리
                            document.getElementById('status').textContent = "응답 처리 중 오류가 발생했습니다.";
                            console.error('Parsing error:', e);
                        }
                    })
                    .catch(error => {
                        document.getElementById('status').textContent = "수족관 데이터를 가져오는 중 오류 발생: " + error;
                        console.error('Error:', error);
                    });

            }, function (error) {
                document.getElementById('status').textContent = "위치를 가져올 수 없습니다. 권한을 허용해주세요.";
            });
        } else {
            document.getElementById('status').textContent = "Geolocation을 지원하지 않는 브라우저입니다.";
        }
    });
});

function displayAquariumLocations(items) {
    const resultsContainer = document.getElementById('results');
    resultsContainer.innerHTML = ''; // 기존 결과 비우기

    items.forEach(item => {
        const resultItem = document.createElement('div');
        resultItem.className = 'result-item';
        
        const title = document.createElement('h3');
        title.innerHTML = item.title.replace(/<\/?b>/g, ''); // HTML 태그 제거
        resultItem.appendChild(title);

        const address = document.createElement('p');
        address.textContent = item.address;
        resultItem.appendChild(address);

        const link = document.createElement('a');
        link.href = item.link;
        link.textContent = '더 보기';
        resultItem.appendChild(link);

        resultsContainer.appendChild(resultItem);
    });
}
