

public class TestQueen {
 
	// 皇后/棋盘的个数
	private static final int QUEEN_NUM = 8;
 
	// 首先定义一个8 * 8 的棋盘
	private static final int[][] Checkerboard = new int[QUEEN_NUM][QUEEN_NUM];
 
	// 定义一共有多少种放置皇后的算法
	private static int COUNT = 0;
 
	/**
	 * 打印棋盘
	 */
	public static final void show() {
		System.out.println("第" + (++COUNT) + "次摆法");
		for (int i = 0; i < QUEEN_NUM; i++) {
			for (int j = 0; j < QUEEN_NUM; j++) {
				System.out.print(Checkerboard[i][j] + " ");
			}
			System.out.println("");
		}
	}
 
	/**
	 * 判断当前位置是否能放置皇后
	 * 
	 * @param Checkerboard
	 * @param row
	 *            行数
	 * @param col
	 *            列数
	 * @return
	 */
	public static final boolean check(int row, int col) {
 
		// 判断当前位置的上面是否有皇后
		for (int i = row - 1; i >= 0; i--) {
			if (Checkerboard[i][col] == 1)
				return false;
		}
 
		// 判断左上是否有皇后
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (Checkerboard[i][j] == 1)
				return false;
		}
 
		// 判断右上是否有皇后
		for (int i = row - 1, j = col + 1; i >= 0 && j < QUEEN_NUM; i--, j++) {
			if (Checkerboard[i][j] == 1)
				return false;
		}
 
		return true;
	}
 
	/**
	 * 从第n行放置皇后
	 * 
	 * @param row
	 */
	public static final void play(int row) {
		// 遍历当前行的所有单元格 以列为单元
		for (int i = 0; i < QUEEN_NUM; i++) {
			// 是否能够放置皇后
			if (check(row, i)) {
				Checkerboard[row][i] = 1;
 
				if (row == QUEEN_NUM - 1) {
					// 最后行 放置完毕 打印皇后
					show();
				} else {
					// 放置下一行
					play(row + 1);
				}
 
				//回退到当前步骤，把皇后设置为0
				Checkerboard[row][i] = 0;
			}
 
		}
	}
 
	public static void main(String[] args) {
		play(0);
	}
}





public static int[][] arry=new int[8][8];//棋盘，放皇后
public static int map=0;//存储方案结果数量

public static void main(String[] args) {
    // TODO Auto-generated method stub

    System.out.println("八皇后问题");
    findQueen(0);
    System.out.println("八皇后问题共有："+map+"种可能");
}

public static void findQueen(int i){//寻找皇后节点
    if(i>7){//八皇后的解  
        map++;
        print();//打印八皇后的解
        return;
    }
    
    for(int m=0;m<8;m++){//深度回溯,递归算法
        if(check(i,m)){//检查皇后摆放是否合适
            arry[i][m]=1;
            findQueen(i+1);
            arry[i][m]=0;//清零，以免回溯的时候出现脏数据
            }
    }   
}

public static boolean check(int k,int j){//判断节点是否合适
    for(int i=0;i<8;i++){//检查行列冲突
         if(arry[i][j]==1){
                return false;
         }
    }
    for(int i=k-1,m=j-1; i>=0 && m>=0; i--,m--){//检查左对角线
        if(arry[i][m]==1){
                return false;
        }
    }
    for(int i=k-1,m=j+1; i>=0 && m<=7; i--,m++){//检查右对角线
        if(arry[i][m]==1){
                return false;
        }
    }
    return true;
}

public static void print(){//打印结果
    System.out.print("方案"+map+":"+"\n");
    for(int i=0;i<8;i++){
        for(int m=0;m<8;m++){
            if(arry[i][m]==1){  
                //System.out.print("皇后"+(i+1)+"在第"+i+"行，第"+m+"列\t");
                System.out.print("o ");
            }
            else{
                    System.out.print("+ ");
            }
        }
        System.out.println();
    }
    System.out.println();
}



