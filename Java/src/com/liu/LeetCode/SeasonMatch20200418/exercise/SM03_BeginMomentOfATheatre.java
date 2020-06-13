package com.liu.LeetCode.SeasonMatch20200418.exercise;

public class SM03_BeginMomentOfATheatre {
    public static int[] getTriggerTimeMy1(int[][] increase, int[][] requirements) {
        int increaseLength = increase.length;
        int requireLength = requirements.length;
        if (increaseLength == 0 || requireLength == 0) {
            return new int[0];
        }
        int[] nowResource = new int[]{0, 0, 0};
        int[] result = new int[requireLength];
        for (int i = 0; i < requireLength; i++) {
            result[i] = -1;
        }
        for (int day = 0; day < increaseLength; day++) {
            for (int require = 0; require < requireLength; require++) {
                if (result[require] == -1) {
                    int[] checkPoint = requirements[require];
                    boolean checkOK = true;
                    for (int s = 0; s < 3; s++) {
                        if (nowResource[s] < checkPoint[s]) {
                            checkOK = false;
                            break;
                        }
                    }
                    if (checkOK) {
                        result[require] = day;
                    }
                }
            }
            for (int type = 0; type < 3; type++) {
                nowResource[type] += increase[day][type];
            }
        }
        for (int require = 0; require < requireLength; require++) {
            if (result[require] == -1) {
                int[] checkPoint = requirements[require];
                boolean checkOK = true;
                for (int s = 0; s < 3; s++) {
                    if (nowResource[s] < checkPoint[s]) {
                        checkOK = false;
                        break;
                    }
                }
                if (checkOK) {
                    result[require] = increaseLength;
                }
            }
        }
        return result;
    }

    public static int[] getTriggerTimeMy2(int[][] increase, int[][] requirements) {
        int increaseLength = increase.length;
        int requireLength = requirements.length;
        if (increaseLength == 0 || requireLength == 0) {
            return new int[0];
        }
        int[][] resourceRecord = new int[increaseLength + 1][3];
        int[] result = new int[requireLength];
        for (int i = 0; i < requireLength; i++) {
            result[i] = -1;
        }
        int[] nowResource = new int[3];
        for (int day = 0; day < increaseLength; day++) {
            int[] increaseSource = increase[day];
            for (int i = 0; i < 3; i++) {
                nowResource[i] += increaseSource[i];
                resourceRecord[day + 1][i] = nowResource[i];
            }
        }
        for (int day = 0; day < increaseLength + 1; day++) {
            for (int task = 0; task < requireLength; task++) {
                if (result[task] == -1) {
                    if (resourceRecord[day][0] >= requirements[task][0]
                            && resourceRecord[day][1] >= requirements[task][1]
                            && resourceRecord[day][2] >= requirements[task][2]) {
                        result[task] = day;
                    }
                }
            }
        }
        return result;
    }

    public static int[] getTriggerTimeMy3(int[][] increase, int[][] requirements) {
        int increaseLength = increase.length;
        int requireLength = requirements.length;
        if (increaseLength == 0 || requireLength == 0) {
            return new int[0];
        }
        int[] result = new int[requireLength];
        for (int i = 0; i < requireLength; i++) {
            result[i] = -1;
        }
        int[] nowResource = new int[3];
        int[][] resourceRecord = new int[100001][3];
        int max = 0;
        for (int day = 0; day < increaseLength; day++) {
            int[] increaseSource = increase[day];
            for (int i = 0; i < 3; i++) {
                int cache = nowResource[i] + increaseSource[i];
                for (int j = nowResource[i] + 1; j <= cache; j++) {
                    resourceRecord[j][i] = day + 1;
                }
                nowResource[i] = cache;
                max = Math.max(max, cache);
            }
        }
        for (int task = 0; task < requireLength; task++) {
            if (result[task] == -1) {
                int targetC = requirements[task][0];
                int targetR = requirements[task][1];
                int targetH = requirements[task][2];
                if (targetC > max || targetR > max || targetH > max) {
                    continue;
                }
                int CMatchDay = resourceRecord[targetC][0];
                int RMatchDay = resourceRecord[targetR][1];
                int HMatchDay = resourceRecord[targetH][2];
                if (CMatchDay > 0 && RMatchDay > 0 && HMatchDay > 0) {
                    result[task] = Math.max(Math.max(CMatchDay, RMatchDay), HMatchDay);
                } else if (targetC == 0 && targetR == 0 && targetH == 0) {
                    result[task] = 0;
                }
            }
        }
        return result;
    }
}
