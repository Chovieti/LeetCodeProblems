public class WalkingRobotSimulationII {
    class Robot {
        private int width;
        private int height;
        private int cycle;
        private int[] curPos;
        private String curDir;
        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            this.cycle = (width + height - 2) * 2;
            curPos = new int[2];
            curPos[0] = 0;  // x - width
            curPos[1] = 0;  // y - height
            curDir = "East";
        }

        public void step(int num) {
            if (num >= cycle) {
                num = num % cycle;
                if (curPos[0] == 0 && curPos[1] == 0) {
                    curDir = "South";
                } else if (curPos[0] == width - 1 && curPos[1] == 0) {
                    curDir = "East";
                } else if (curPos[0] == width - 1 && curPos[1] == height - 1) {
                    curDir = "North";
                } else if (curPos[0] == 0 && curPos[1] == height - 1) {
                    curDir = "West";
                }
            }
            for (int i = 0; i < num; i++) {
                doStep();
            }
        }

        private void doStep() {
            switch (curDir) {
                case "North" -> {
                    if (curPos[1] + 1 >= height) {
                        curDir = "West";
                        doStep();
                    } else {
                        curPos[1]++;
                    }
                }
                case "East" -> {
                    if (curPos[0] + 1 >= width) {
                        curDir = "North";
                        doStep();
                    } else {
                        curPos[0]++;
                    }
                }
                case "South" -> {
                    if (curPos[1] - 1 < 0) {
                        curDir = "East";
                        doStep();
                    } else {
                        curPos[1]--;
                    }
                }
                case "West" -> {
                    if (curPos[0] - 1 < 0) {
                        curDir = "South";
                        doStep();
                    } else {
                        curPos[0]--;
                    }
                }
            }
        }

        public int[] getPos() {
            return curPos;
        }

        public String getDir() {
            return curDir;
        }
    }
}
