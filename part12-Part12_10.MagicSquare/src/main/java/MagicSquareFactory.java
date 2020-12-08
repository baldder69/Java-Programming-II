
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int base) {

        MagicSquare square = new MagicSquare(base);

        int row = 0;
        int column = base / 2;
        int size = base * base;

        for (int i = 1; i <= size; i++) {
            
            //Values: 1
            square.placeValue(column, row, i);

            //If you at the top row, then check for these
            if (row == 0) {

                //If the current value is at the last column, then go down one row;
                if (column == base - 1) {
                    row++;
                    
                    //Values: 7
                    
                } else {
                    //Go to the last row
                    row = base - 1;
                    //And go one to the right
                    column++;
                    
                    //Values: 2, 9
                }
            } else {

                //If the number is at the last column, do this
                if (column == base - 1) {
                    //Go one row up
                    row--;
                    //Make the column 0
                    column = 0;
                    
                    //Values: 3, 8
                } else {
                    //Checks for the location of one row up, then go one column right
                    //If the value in this position is == 0 (AKA NOT TAKEN), then put the value in that location
                    if (square.readValue(column + 1, row - 1) == 0) {
                        row--;
                        column++;
                        //Values: 5, 6
                    } else {
                        //However, if the value is not 0, then it means that it is taken, so go one row down
                        row++;
                        
                        //Values: 4
                    }
                }

            }

        }

        return square;
    }

}
