import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lc54 {
    @Test
    public void test(){
        int[][] arr = new int[4][4];
        int num = 1;
        for(int i = 0;i<4;i++){
            for(int j=0;j<4;j++){
                arr[i][j] = num++;
            }
        }
        //List<Integer> list = spiralOrder(arr);
        List<Integer> list2 = spiralOrder2(arr);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        //记录传入数组的行数
        int m = matrix.length;
        //记录传入数组的列数
        int n = matrix[0].length;
        //生成结果数组
        List<Integer> result = new ArrayList<>();

        //int[] result = new int[m*n];
        //int index = 0;
        //开始循环的位置
        int start = 0;
        //记录循环的次数
        int loop = 0;
        //记录多维数组的位置下标
        int i=0,j=0;
        //边数更小的决定循环几圈
        while(loop++<(Math.min(m, n))/2){
            //上行 从左到右
            for(j = start;j<n-loop;j++){
                //result[index++]=matrix[start][j];
                result.add(matrix[start][j]);
            }
            //右列 从上到下
            for(i = start;i<m-loop;i++){
                //result[index++]=matrix[i][j];
                result.add(matrix[i][j]);
            }
            //下行 从右到左
            for(;j>=loop;j--){
                //result[index++]=matrix[i][j];
                result.add(matrix[i][j]);
            }
            //左列，从下到上
            for(;i>=loop;i--){
                //result[index++]=matrix[i][j];
                result.add(matrix[i][j]);
            }
            start+=1;
        }
        if((Math.min(m, n))%2!=0){
            if(m>n){
                for(j = start;j<n-loop+1;j++){
                    //result[index++] = matrix[start][j];
                    result.add(matrix[start][j]);
                }
            }else{
                for(i = start;i<m-loop+1;i++){
                    //result[index++] = matrix[i][start];
                    result.add(matrix[i][start]);
                }
            }
        }
        return result;
    }
    public List<Integer> spiralOrder2(int[][] matrix) {
        //记录传入数组的行数
        int m = matrix.length;
        List<Integer> result = new ArrayList<>();
        int start = 0,loop = 0;
        int i=0,j=0;
        while(loop++<m/2){
            //上行 从左到右
            for(j = start;j<m-loop;j++){
                result.add(matrix[start][j]);
            }
            //右列 从上到下
            for(i = start;i<m-loop;i++){
                result.add(matrix[i][j]);
            }
            //下行 从右到左
            for(;j>=loop;j--){
                result.add(matrix[i][j]);
            }
            //左列，从下到上
            for(;i>=loop;i--){
                result.add(matrix[i][j]);
            }
            start+=1;
        }
        if(m%2!=0){
            result.add(matrix[start][start]);
        }
        return result;
    }
}
