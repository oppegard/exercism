class Matrix {

    private int[][] matrix;

    Matrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\n");
        int columnCount = rows[0].split(" ").length;
        matrix = new int[rows.length][columnCount];

        for (int i = 0; i < rows.length; i++) {
            String[] values = rows[i].split(" ");
            for (int j = 0; j < values.length; j++) {
                matrix[i][j] = Integer.parseInt(values[j]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber - 1];
    }

    int[] getColumn(int columnNumber) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnNumber - 1];
        }
        return column;
    }
}
