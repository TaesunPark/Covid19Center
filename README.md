# 🏥 Covid-19 Center


감염 위험 낮추고 진료 속도 높이는 선별진료소 서비스 ‘Covid19 Center’

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled.png)

## 💡 Background


- 코로나19 신규 확진자 지속 발생
- 선별 진료소 대기 시 불필요한 접촉
- 불편한 선별진료소 시스템

## **📚 Stack & Library**

- OS: Windows 10
- Android/Java
- Room : 안드로이드 로컬 DB 사용
- DBMS: MySQL - Paas-ta 클라우드 서비스 사용
- Node.js : 개발 플랫폼
- Express.js
- Naver maps API
- COVID-19 API

## 👩‍💻 Project Features


## 1. 선별진료소 정보 제공 기능

선별진료소 API에서 받아온 선별진료소의 주소, 전화번호 등의 정보를 제공한다.

Naver Map API를 통해 선별 진료소 위치를 받아오고 사용자의 현재 위치와 비교해서 사용자에게 가까운 순으로 선별 진료소를 보여준다. 이를 통해 사용자는 선별진료소를 쉽게 찾을 수 있다.

## 2. 예약 기능

예약을 접수하면 예약 날짜, 예약 시간, 예약자 정보, 문진표 내용이 서버에 저장된다.

의료진이 진료 예약 시간을 ‘Covid19 Center’에서 설정하면 서버를 통해 저장되어 방문자의 밀집도를 분산시킬 수 있다.

의료진은 서버를 통해 환자의 진료 여부를 확인하고 데이터를 관리할 수 있다.

## 3. QR 코드 기능

서버에 저장된 예약 정보와 문진표는 QR 코드로 변환하여 사용자에게 제공된다

문진표에서는 방문 국가, 확진자 접촉여부, 증상, 특이사항 등을 작성한다.

선별진료소에서 의료진이 QR 코드를 스캔하면 손쉽게 예약을 확인할 수 있다.

## 🎞️ Service UI


## 사용자 서비스

## 1. 홈 화면 및 선별 진료소 목록

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%201.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%201.png)

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%202.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%202.png)

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%203.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%203.png)

## 2. 선별진료소 상세정보 및 예약 페이지

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%204.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%204.png)

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%205.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%205.png)

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%206.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%206.png)

## 3. 자가 진단 페이지

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%207.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%207.png)

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%208.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%208.png)

## 4. 마이페이지

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%209.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%209.png)


## 의료진용 서비스

## 5. 의료진용 QR 스캔 페이지

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%2010.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%2010.png)

## 6. 의료진용 예약 관리 페이지

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%2011.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%2011.png)

## ⏳ Service Flow

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%2012.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%2012.png)

## 🛠️ Architecture

![%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%2013.png](%F0%9F%8F%A5%20Covid-19%20Center%20468c7c7d88124b288d3422f49f73bebd/Untitled%2013.png)

## 💭 I Learned

- 전반적인 UI/UX를 담당했습니다.
- 선별진료소 API를 사용해 선별진료소를 불러오고, 선별진료소 목록 및 상세 페이지를 담당했습니다.
- Naver Map Api를 이용해 지도 UI/UX 담당했습니다.
- 선별진료소 예약 부분을 담당했습니다.
- 선별 진료소 API를 통해 실시간으로 리스트 뷰를 업데이트 하는 과정을 통해  안드로이드의 라이프 사이클에 대한 중요성을 깨달았습니다.
