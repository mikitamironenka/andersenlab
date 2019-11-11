package by.mironenka.deepfirstsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph {

    private final int MAX_VERTICES = 20;
    private Vertex[] vertexList;
    private int nVert; // текущее количество вершин
    private int[][] adjMatrix; // матрица смежности
    private StackX theStack;

    public Graph() {
        vertexList = new Vertex[MAX_VERTICES];
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        nVert = 0;
        for (int i = 0; i < MAX_VERTICES; i++) {
            for (int j = 0; j < MAX_VERTICES; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        theStack = new StackX();
    }

    public void addVertex(String label) {
        this.vertexList[nVert++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.println(this.vertexList[v].getLabel());
    }

    public void deepFirstSearch() {

        vertexList[0].setWasVisited(true);
        displayVertex(0);
        this.theStack.push(0);
        while (!this.theStack.isEmpty()) {
            //получение непосещённой вершины, смежной к текущей
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) {
                theStack.pop();
            } else {
                vertexList[v].setWasVisited(true);
                displayVertex(v);
                theStack.push(v);
            }
        }
        //стек пуст работа закончена
        for (int i = 0; i < nVert; i++) {
            vertexList[i].setWasVisited(false); //сброс флагов
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        int result = -1;// Таких вершин нет
        for (int j = 0; j < nVert; j++)
            if (adjMatrix[v][j]==1 && vertexList[j].wasVisited() == false) {
                result = j; // Возвращает первую найденную вершину
                break;
            }
        return result;
    }
}
