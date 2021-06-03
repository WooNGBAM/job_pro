점포 관리 
==========
# 1. 개발환경


### InteliJ IDEA 


### JAVA Spring Boot 2.4.5     
### (Spring Data JPA, Lombok, Spring Web)

 
### JDK 1.8
   
### H2 Database

# 2. 테이블 생성   

### Market 테이블 
![Alt text](https://imgdb.in/iDGn.png)   

### Market_Business_Times 테이블   
![Alt text](https://imgdb.in/iDGs.png)

### Market_Holiday 테이블
![Alt text](https://imgdb.in/iDGt.png)

# 3. API 사용 가이드   
### 3-1 점포 추가   
##### 쿼리 예시   
<pre>   
<code>
{
	"name": "처갓집",
	"owner": "처돌이",
	"description": "처갓집의 메뉴중 제일은 슈프림양념치킨이다.",
	"level": 2,
	"address": "서울특별시 노원구",
	"phone": "010-1111-2222",
	"businessTimes": [
		{
			"day": "Monday",
			"open": "13:00",
			"close": "23:00"
		},
		{
			"day": "Tuesday",
			"open": "13:00",
			"close": "23:00"
		},
		{
			"day": "Wednesday",
			"open": "09:00",
			"close": "18:00"
		},
		{
			"day": "Thursday",
			"open": "09:00",
			"close": "23:00"
		},
		{
			"day": "Friday",
			"open": "09:00",
			"close": "23:00"
		}
	]
}   
</code>
</pre>

### 3-2 점포 휴무일 등록   
<pre>
<code>
{
 "id": 1,
 "holidays": [
 "2021-05-07",
 "2021-05-08"
 ]
}
</code>
</pre>

### 3-3 점포 목록 조회   
HTTP GET Request 

### 3-4 점포 상세 정보 조회
조회할 점포의 ID를 파라미터로 전달

### 3-5 점포 삭제
삭제할 점포의 ID를 파라미터로 전달

