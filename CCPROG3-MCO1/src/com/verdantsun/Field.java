package com.verdantsun;

public class Field {

    private Tile[][] tiles;

    public Field() {
        tiles = new Tile[10][10];
    }

    public Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    public void displayField() {
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles[i].length; j++) {
                if (this.tiles[i][j].hasPlant()) {
                    System.out.print("P ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public void nextDayUpdate() {
        for (Tile[] row : this.tiles) {
            for (Tile tile : row) {
                tile.growPlant();
                tile.reduceFertilizer();
            }
        }
    }

    public void applyMeteoritePattern() {

        int[][] affectedTiles = {
                {1,1}, {1,4}, {1,5}, {1,8},
                {3,3}, {3,4}, {3,5}, {3,6},
                {4,1}, {4,3}, {4,4}, {4,5}, {4,6}, {4,8},
                {5,1}, {5,3}, {5,4}, {5,5}, {5,6}, {5,8},
                {6,3}, {6,4}, {6,5}, {6,6},
                {8,1}, {8,4}, {8,5}, {8,8}
        };

        for (int[] coord : affectedTiles) {
            int row = coord[0];
            int col = coord[1];

            this.tiles[row][col].setMeteoriteAffected(true);
        }
    }
}
