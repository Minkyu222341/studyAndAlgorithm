package algorithm.result.programmers.lv2;

public class _12_16_스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++) {
            String replaceSkill = skill_trees[i].replaceAll("[^" + skill + "]", "");
            String[] splitSkillTree = replaceSkill.split("");
            String[] splitSkill = skill.split("");
            int count = 0;

            if (replaceSkill.equals("")) {
                answer++;
            }

            for (int j = 0; j < splitSkillTree.length ; j++) {
                if (!splitSkillTree[j].equals(splitSkill[j])) {
                    break;
                }
                count++;
                if (splitSkillTree.length == count) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        _12_16_스킬트리 solution = new _12_16_스킬트리();
        solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA", "AQWER"});
    }
}
