import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        // 1. id → index 매핑
        Map<String, Integer> idIndexMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idIndexMap.put(id_list[i], i);
        }

        // 2. 중복 제거
        Set<String> uniqueReports = new HashSet<>(Arrays.asList(report));

        // 3. 신고 관계
        Map<String, Set<String>> reportMap = new HashMap<>();

        // 4. 신고당한 횟수
        Map<String, Integer> reportedCount = new HashMap<>();

        for (String r : uniqueReports) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            reportMap.putIfAbsent(reporter, new HashSet<>());
            reportMap.get(reporter).add(reported);

            reportedCount.put(
                reported,
                reportedCount.getOrDefault(reported, 0) + 1
            );
        }

        // 5. 정지된 유저
        Set<String> bannedUsers = new HashSet<>();
        for (String user : reportedCount.keySet()) {
            if (reportedCount.get(user) >= k) {
                bannedUsers.add(user);
            }
        }

        // 6. 결과 배열
        int[] answer = new int[id_list.length];

        // 7. 메일 카운트
        for (String reporter : reportMap.keySet()) {
            for (String target : reportMap.get(reporter)) {
                if (bannedUsers.contains(target)) {
                    answer[idIndexMap.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}