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
