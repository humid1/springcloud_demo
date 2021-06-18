package com.humid.springcloud;

import lombok.Data;

/**
 * @author qiujianping
 * @date Created in 2021/6/18 11:19
 */
public class Test {
    private static Boolean mgpath (int xi, int yi, int xe, int ye) {
        int mg[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };//地图

        int i,j,k,di,find;
        StType st = new StType();//定义栈st
        st.top = -1;//初始化栈顶指针
        st.top ++;//初始方块进栈
        st.getData()[st.top].i = xi;
        st.data[st.top].j = yi;
        st.data[st.top].di = -1;
        mg[xi][yi]=-1;
        while(st.top > -1)//栈不为空时循环
        {
            i=st.data[st.top].i;
            j=st.data[st.top].j;
            di=st.data[st.top].di;//取栈顶方块
            if(i==xe&&j==ye)//找到出口，输出路径
            {
                System.out.print("迷宫路径如下：\n");
                for(k=0; k<=st.top; k++)
                {
                    System.out.printf("\t(%d,%d)",st.data[k].i,st.data[k].j);
                    if ((k+1)%5==0) {
                        System.out.print("\n");
                    }
                }
                System.out.print("\n");
                for (int i1 = 0; i1 < 10; i1++) {
                    for (int i2 = 0; i2 < 10; i2++) {
                        System.out.print(mg[i1][i2] + "\t");
                    }
                    System.out.println();
                }
                return true;
            }
            find=0;
            while(di<4 && find==0)//站下一个可走方块
            {
                di++;
                switch(di)
                {
                    case 0:
                        i=st.data[st.top].i-1;
                        j=st.data[st.top].j;
                        break;
                    case 1:
                        i=st.data[st.top].i;
                        j=st.data[st.top].j+1;
                        break;
                    case 2:
                        i=st.data[st.top].i+1;
                        j=st.data[st.top].j;
                        break;
                    case 3:
                        i=st.data[st.top].i;
                        j=st.data[st.top].j-1;
                        break;
                }
                if(mg[i][j]==0) {
                    find = 1;//找下一个可走相邻方块
                }
            }
            if(find==1)//找到了下一个可走方块
            {
                st.data[st.top].di=di;//修改原栈顶元素的di值
                st.top++;//下一个可走方块进栈
                st.data[st.top].i=i;
                st.data[st.top].j=j;
                st.data[st.top].di=-1;
                mg[i][j]=-1;//避免重复走到该方块
            }
            else//没有路径可走则退栈
            {
                mg[st.data[st.top].i][st.data[st.top].j]=0;//让该位置变为其他路径可走方块
                st.top--;//将该方块退栈
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int M=8;//行数
        int N=8;//列数
        if(!mgpath(1,1,M,N)) {
            System.out.printf("无解");
        }
    }

    public static class StType {
        int top;
        Box data[] = new Box[100];

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public Box[] getData() {
            for (int i = 0; i < 100; i++) {
                data[i] = new Box();
            }
            return data;
        }

        public void setData(Box[] data) {
            this.data = data;
        }
    }

    @Data
    public static class Box {
        int i;//当前方块行号
        int j;//当前方块列号
        int di;//下一个可走的相邻方块的方位号
    }
}
