public class Values{
    String[] grid;

    public void setGrid(String letters){
        grid = new String[16];
        for (int i=0; i<16; i++){
            grid[i] = letters.substring(i,i+1);
        }
    }

    public String getLetter(int[] point){
        int x = point[0];
        int y = point[1];
        if(x==0){
            if (y==0){
                return grid[0];
            }
            if (y==1){
                return grid[1];
            }
            if (y==2){
                return grid[2];
            }
            if (y==3){
                return grid[3];
            }
        }
        if(x==1){
            if (y==0){
                return grid[4];
            }
            if (y==1){
                return grid[5];
            }
            if (y==2){
                return grid[6];
            }
            if (y==3){
                return grid[7];
            }
        }
        if(x==2){
            if (y==0){
                return grid[8];
            }
            if (y==1){
                return grid[9];
            }
            if (y==2){
                return grid[10];
            }
            if (y==3){
                return grid[11];
            }
        }
        if(x==3){
            if (y==0){
                return grid[12];
            }
            if (y==1){
                return grid[13];
            }
            if (y==2){
                return grid[14];
            }
            if (y==3){
                return grid[15];
            }
        }
        return null;
    }
}