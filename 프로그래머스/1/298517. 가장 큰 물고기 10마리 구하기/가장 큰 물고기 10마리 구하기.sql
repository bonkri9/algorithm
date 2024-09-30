SELECT 
    ID,
    LENGTH
FROM 
    FISH_INFO
WHERE 
    LENGTH > 10  -- 길이가 10cm 이하인 경우는 제외
ORDER BY 
    LENGTH DESC,  -- 길이를 기준으로 내림차순 정렬
    ID ASC        -- 길이가 같은 경우 ID를 기준으로 오름차순 정렬
LIMIT 10;         -- 상위 10개의 레코드만 출력
