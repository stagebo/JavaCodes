//package com.dyi.test;
//
//public class ttt {
//    #include<iostream>
//#include<queue>
//#include <stdio.h>
//#include<string.h>
//    using namespace std;
//#define MAXN 1000
//            #define INF 0x3f3f3f3f
//
//    int a[MAXN][MAXN];
//    int n; // 节点个数 0~n-1
//    int tmp[MAXN][MAXN];
//    bool vis[MAXN]; // 访问数组
//
//    //输入
//    void input()
//    {
//        memset(a, INF, sizeof(a)); // important
//        //输入a数组
//        //...
//        //初始化tmp数组
//        memset(tmp, 0, sizeof(tmp));
//        for(int i=0;i<n;i++)
//        {
//            for(int j=0;j<n;j++)
//            {
//                if(a[i][j] < INF) // INF代表不通
//                    tmp[i][j] = tmp[j][i] = 1;
//                else
//                    tmp[i][j] = tmp[j][i] = 0;
//            }
//            tmp[i][i] = 1;
//        }
//    }
//
//    //广度优先搜索判断连通性
//    bool BFS()
//    {
//        queue<int> q;
//        int count = 0;
//        memset(vis, 0, sizeof(vis)); // 初始化
//        q.push(0); //0节点入队列
//
//        while(!q.empty())
//        {
//            int v = q.front();
//            vis[v] = true;
//            q.pop();
//            count++;
//
//            //与联通且没有被访问过节点入队列
//            for (int i=0;i<n;i++)
//            {
//                if (tmp[v][i])
//                {
//                    if(!vis[i])
//                        q.push(i);
//                }
//            }
//        }
//
//        if (count == n) return true; // count <= n ???
//        else return false;
//
//    }
//}
//
