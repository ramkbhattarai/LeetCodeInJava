class CreateTargetArrayInGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {

        int length = nums.length;
        int[] list = new int[length];

        for (int i = 0; i < length; i++) {
            if (index[i] < i) {
                for (int j = i; j > index[i]; j--)
                    list[j] = list[j - 1];
                list[index[i]] = nums[i];
            } else
                list[i] = nums[i];
        }
        return list;
    }
}
