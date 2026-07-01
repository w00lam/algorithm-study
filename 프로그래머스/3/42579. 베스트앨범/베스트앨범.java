import java.util.*;

class Solution {

    static class Song {
        int index;
        int play;

        Song(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlayMap = new HashMap<>();
        Map<String, List<Song>> genreSongsMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            totalPlayMap.put(
                    genre,
                    totalPlayMap.getOrDefault(genre, 0) + play
            );

            genreSongsMap
                    .computeIfAbsent(genre, g -> new ArrayList<>())
                    .add(new Song(i, play));
        }

        List<String> genreOrder = new ArrayList<>(totalPlayMap.keySet());

        genreOrder.sort((a, b) -> totalPlayMap.get(b) - totalPlayMap.get(a));

        List<Integer> answer = new ArrayList<>();

        for (String genre : genreOrder) {
            List<Song> songs = genreSongsMap.get(genre);

            songs.sort((a, b) -> {
                if (a.play != b.play) {
                    return b.play - a.play;
                }

                return a.index - b.index;
            });

            int count = Math.min(2, songs.size());

            for (int i = 0; i < count; i++) {
                answer.add(songs.get(i).index);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}