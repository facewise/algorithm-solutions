class Solution {
    
    int maxHp;
    int curHp;
    int maxCombo;
    int combo;
    int healPerSec;
    int bonusHeal;
    int[] attack;
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t;
        int maxTime = attacks[attacks.length - 1][0];
        maxHp = health;
        curHp = health;
        maxCombo = bandage[0];
        healPerSec = bandage[1];
        bonusHeal = bandage[2];
        
        // 연속 성공
        combo = 0;
        
        // 시간별 공격값을 배열로
        attack = new int[maxTime + 1];
        
        for (int[] att : attacks) {
            attack[att[0]] = att[1];
        }
        
        for (t = 1; t <= maxTime; t++) {
            int damage = attack[t];
            if (damage != 0) {
                if (attack(damage)) {
                    return -1;
                }
            } else {
                band();
            }
        }
        
        return curHp;
    }
    
    /**
     * 공격하고 죽으면 true 리턴
     */
    boolean attack(int damage) {
        curHp -= damage;
        combo = 0;
        return curHp <= 0;
    }
    
    // 붕대 감기
    void band() {
        combo++;
        if (combo == maxCombo) {
            combo = 0;
            heal(healPerSec + bonusHeal);
        } else {
            heal(healPerSec);
        }
    }
    
    void heal(int healing) {
        if (curHp + healing > maxHp) {
            curHp = maxHp;
        } else {
            curHp += healing;
        }
    }
    
}