package org.example;

import java.util.ArrayList;

public class CubeBlock {

    private int x;
    private int y;
    private int z;

    //цвета граней будем хранить в численном массиве
    private ArrayList<Face> faces;
    public CubeBlock(int [] point) {
        this.x = point[0];
        this.y = point[1];
        this.z = point[2];

        faces = new ArrayList<>();
        setColorBlock();
    }

    //в зависимости от того, какие координаты у малого куба в кубе, зависит то, какие грани у малого кубика будут наружу.
    private void setColorBlock() {
        faces.add(new Face(1, x, 0, 0));
        faces.add(new Face(2, 0, y, 0));
        faces.add(new Face(3, 0, 0, z));
        faces.add(new Face(4, -x, 0, 0));
        faces.add(new Face(5, 0, -y, 0));
        faces.add(new Face(6, 0, 0, -z));

    }

    public int [] getPoint() {
        return new int[]{x, y, z};
    }

    //поворот кубика в пространстве
    public void turn(String rotation_axis, String direction) {
        int [] res = new int[3];

        //матрицы поворота при угле 90 град.
        int [][] Mx = {{1, 0, 0},{0, 0, -1},{0, 1, 0}};
        int [][] My = {{0, 0, 1},{0, 1, 0},{-1, 0, 0}};
        int [][] Mz = {{0, -1, 0},{1, 0, 0},{0, 0, 1}};

        switch (rotation_axis) {
            case "X" :
                switch (direction) {
                    case "R" :
                        calc_matrix(-x, -y, -z, Mx);
                        break;
                    case "L" :
                        calc_matrix(x, y, z, Mx);
                        break;
                }
                break;
            case "Y" :
                switch (direction) {
                    case "R" :
                        calc_matrix(-x, -y, -z, My);
                        break;
                    case "L" :
                        calc_matrix(x, y, z, My);
                        break;
                }
                break;
            case "Z" :
                switch (direction) {
                    case "R" :
                        calc_matrix(-x, -y, -z, Mz);
                        break;
                    case "L" :
                        calc_matrix(x, y, z, Mz);
                        break;
                }
                break;
        }
    }

    //расчитывает матрицу поворота для кубика относительно заданной оси на 90 град.
    private void calc_matrix(int x, int y, int z, int[][] M) {
        int [] res = new int[3];
        for(int i = 0; i < M.length; i++){
            res[i] = (M[i][0] * x) + (M[i][1] * y) + (M[i][2] * z);
        }
        this.x = res[0];
        this.y = res[1];
        this.z = res[2];
        System.out.println(x + ", " + y + ", " + z);
    }


    //проверка
    public static void main(String [] args){
        int x = 0;
        int y = -1;
        int z = 0;
        int[][] M = {{1, 0, 0},{0, 0, -1},{0, 1, 0}};
        int [] res = new int[3];
        for(int i = 0; i < M.length; i++){
            res[i] = (M[i][0] * x) + (M[i][1] * y) + (M[i][2] * z);
        }
        System.out.println(res[0] + ", " + res[1] + ", " + res[2]);
    }

}
