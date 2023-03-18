SELECT A.car_id, ROUND(AVG(ABS(DATEDIFF(A.start_date, A.end_date)))+1,1) AS average_duration
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
GROUP BY A.car_id
HAVING average_duration >= 7
ORDER BY average_duration DESC, A.car_id DESC
