package org.example;

import java.util.ArrayList;

//класс cube состоит из кубиков(cubeBlock)
public class Cube {

    private ArrayList<CubeBlock> cubeBlocks;
    public Cube() {
        cubeBlocks = new ArrayList<>();
        initCube();
    }

    private void initCube() {
        int [][] cords_CubeBlock = {{0, 0, 1}, {0, 1, 0}, {1, 0, 0},
                                    {0, 1, 1}, {1, 1, 0}, {1, 0, 1},
                                    {0, 0, -1}, {0, -1, 0}, {-1, 0, 0},
                                    {0, -1, -1}, {-1, -1, 0}, {-1, 0, -1},
                                    {0, 1, -1}, {1, -1, 0}, {1, 0, -1},
                                    {0, -1, 1}, {-1, 1, 0}, {-1, 0, 1},
                                    {1, 1, 1}, {-1, 1, 1}, {1, -1, 1},
                                    {1, 1, -1}, {-1, 1, -1}, {1, -1, -1},
                                    {-1, -1, 1}, {-1, -1, -1}};

        for (int [] point : cords_CubeBlock) {
            cubeBlocks.add(new CubeBlock(point));
        }
    }

}
