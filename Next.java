public class Next{
    public int[] nextCurrent(int[] cpoint, int[] spoint){
        if (cpoint[1]<spoint[1]+1){
            cpoint[1]=cpoint[1]+1;
            return cpoint;
        }else{
            cpoint[0] = cpoint[0]+1;
            cpoint[1] = spoint[1]-1;
            return cpoint;
        }
    }
}