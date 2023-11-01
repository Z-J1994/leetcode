package easy;

/**
 * @author zhangjun
 * @version 2023/3/13
 */
public class Solution2383 {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int energySum = 0;
        int experienceSum = 0;
        for(int i = 0;i < energy.length;i++){
            initialEnergy -= energy[i];
            if(initialEnergy <= 0){
                energySum += 1 - initialEnergy;
                initialEnergy = 1;
            }

            if(initialExperience <= experience[i]){
                int t = experience[i] - initialExperience + 1;
                experienceSum += t;
                initialExperience += t;
            }
            initialExperience += experience[i];

        }
        return energySum + experienceSum;
    }
}
