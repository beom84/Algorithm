-- 코드를 입력하세요
/*
 출력 컬럼
 - 아이스크림의 맛
 from
 - FIRST_HALF
 ORDERBy
 - 맛의 총주문량 (내림차순)
 - 출하번호
*/
SELECT FLAVOR FROM FIRST_HALF ORDER BY TOTAL_ORDER DESC , SHIPMENT_ID ASC