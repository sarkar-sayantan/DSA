class Solution {
    public List<Integer> getRow(int rowIndex) {
        return helper(new ArrayList<>(),rowIndex, 0);
    }

    public List<Integer> helper(List<Integer> currList, int rowIndex, int currRow) {
        if(currRow > rowIndex)
            return currList;
        if(currRow == 0 || currRow == 1)
            currList.add(1);
        ArrayList<Integer> prevList = new ArrayList<>();
        for(int j: currList)
            prevList.add(j);
        for(int i=1; i<currRow; i++) {
            currList.set(i,prevList.get(i-1) + prevList.get(i));
            if(i+1 == currList.size())
                currList.add(1);
        }
        return helper(currList, rowIndex, currRow +1);
    }
}